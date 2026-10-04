# Proyecto Back-Intro: Migración de Bounded Contexts

## 📌 Descripción General
Este repositorio (rama `boundcontext`) alberga la arquitectura hexagonal completa y el Domain-Driven Design (DDD) del sistema `back-intro`. El hito principal de esta versión es la **generación e integración automática de 52 Bounded Contexts** que estructuran todo el esquema relacional de la base de datos PostgreSQL, garantizando simetría y coherencia de código.

## 🚀 Acciones Realizadas
Durante el desarrollo en esta rama, se llevaron a cabo los siguientes hitos:
1. **Auditoría de Esquemas SQL:** Se analizaron los scripts de migración de Flyway (`V1` a `V54`) para mapear las 52 tablas, deduciendo tipos de datos exactos, restricciones (Not Null) y relaciones de llave foránea.
   * `V1` a `V52`: Creación modular e independiente de cada una de las 52 tablas.
   * `V53`: Establecimiento de las 65 llaves foráneas de negocio para garantizar la integridad referencial global sin dependencias circulares de creación.
   * `V54`: Aplicación de restricciones de autoría hacia `professionals(id)` para trazabilidad clínica.
2. **Definición de Modelo Guía:** Se utilizó el módulo `country` como estándar de oro para heredar sus reglas de diseño arquitectónico y de persistencia.
3. **Automatización a Gran Escala:** Se diseñaron scripts de metaprogramación que orquestaron la creación paralela de **1,352 archivos Java** (26 componentes por módulo para los 52 módulos).
4. **Verificación de Integridad Espejo y Refinamiento:**
   * Sincronización exacta de tipos y restricciones entre SQL y JPA (longitudes de `varchar`, tipos `Boolean` wrapper para columnas nulables, y `@JdbcTypeCode(SqlTypes.JSON)` para campos `jsonb`).
   * Normalización de contratos de validación de entrada con Jakarta Validation (`@NotNull`, `@NotBlank`) en Request DTOs, garantizando respuestas unificadas `400 Bad Request`.
   * Corrección de codificación UTF-8 homogénea en todos los controladores de excepciones.

## ⚖️ Reglas de Integridad y Resolución de Ambigüedades
Durante el desarrollo se establecieron reglas unificadas para resolver ambigüedades arquitectónicas a lo largo de los 52 módulos:

1. **Gestión de Autoría (`created_by`, `updated_by`, etc.):**
   * Cuando la acción debe ser realizada estrictamente por personal interno de la clínica, la columna tiene una restricción de llave foránea hacia `professionals(id)` (Ej. `patients.created_by`, `encounters.updated_by`). Esto se garantizó mediante la migración de Flyway `V54`.
   * Cuando la acción puede ser ejecutada por actores externos (como pacientes en la app) o actores del sistema (como inteligencia artificial), la columna se mantiene como un identificador UUID puro sin forzar una restricción de llave.
2. **Manejo de Excepciones de Integridad Relacional y Validación:**
   * La Base de Datos es la autoridad última para la integridad referencial.
   * Todos los Request DTOs validan de forma temprana la presencia de IDs foráneos requeridos mediante `@NotNull`.
   * Todos los `*ExceptionHandler` capturan globalmente la excepción `DataIntegrityViolationException` inyectada por JPA/Hibernate.
   * Se retorna **400 Bad Request** de forma unificada ante violaciones de validación de entrada o intentos de ingresar una FK inexistente en inserción/actualización.
   * Se retorna **409 Conflict** de forma unificada si se detecta una violación de restricción única (*Unique Constraint*).

## 🧱 Estructura Hexagonal (Puertos y Adaptadores)
La arquitectura de este proyecto respeta el principio de **Inversión de Dependencias** y el patrón de **Puertos y Adaptadores**, garantizando que la lógica central del negocio sea completamente agnóstica a la base de datos o la interfaz web.

Cada uno de los 52 módulos se divide estrictamente en 3 componentes aislados:

### 1. Dominio (`/domain`) - El Núcleo Hexagonal
*El dominio no conoce a Spring Boot ni a las bases de datos. Es puro código Java.*
*   **Aggregate Roots:** Entidades modelo de negocio ricas en comportamiento (Ej. `Patient.java`).
*   **Value Objects:** Encapsulamiento robusto e inmutable de identificadores y propiedades. Destaca el uso de clases fuertemente tipadas (Ej. `PatientId`) auto-generadas vía UUID.
*   **Events & Exceptions:** Eventos de dominio disparados internamente (`Registered`, `Updated`) y excepciones puras de negocio (`AlreadyExistsException`).
*   **Ports (Puertos de Salida):** Interfaces abstractas que definen el contrato que la infraestructura debe cumplir (Ej. `PatientRepository.java`).

### 2. Aplicación (`/application`) - Casos de Uso
*Orquesta el flujo de información entre el exterior y el dominio, implementando los requerimientos del sistema.*
*   **Use Cases:** Diseño atómico modular. Cada archivo representa una única acción (Ej. `RegisterPatientUseCase.java`, `ListPatientUseCase.java`).
*   **Commands:** Records inmutables (`RegisterPatientCommand`) para transportar la intención operativa de forma segura hacia el caso de uso.
*   **Response DTOs:** Transferencia de datos de salida. Aquí se **resuelve el nombre de las FK a catálogos** mediante inyección de repositorios del dominio (Ej. Retornar el `cityName` real mapeando un `cityId`).

### 3. Infraestructura (`/infrastructure`) - Los Adaptadores
*Se encarga de los detalles técnicos, la persistencia JPA y el transporte HTTP.*
*   **REST Controllers (Adaptadores de Entrada):** Exponen rutas `/api/...` dirigiendo el tráfico HTTP hacia los Use Cases. Protegidos mediante anotaciones de validación `@Valid`.
*   **Persistence (Adaptadores de Salida):** Implementan los Puertos del Dominio. Contienen clases `@Entity` (JPA), interfaces Spring Data (`JpaRepository`), Mappers estáticos e implementaciones de adaptador (`RepositoryAdapter.java`).
*   **Dependency Injection (Beans):** Configuración explícita de Spring Boot (`PatientBeansConfig.java`) que amarra las interfaces del dominio con las implementaciones de infraestructura, logrando la *Inversión de Control*.

```text
📁 {module_name}
├── 📁 domain
│   ├── 📁 event
│   ├── 📁 exception
│   ├── 📁 model (aggregate, valueobject)
│   └── 📁 port.repository
├── 📁 application
│   ├── 📁 command
│   ├── 📁 dto
│   ├── 📁 exception
│   └── 📁 usecase
└── 📁 infrastructure
    ├── 📁 adapters.in.rest (controllers, dtos, exceptionhandlers)
    ├── 📁 adapters.out.persistence (entity, mappers, repositories)
    └── 📁 config
```

## 🛠️ Stack Tecnológico Destacado
*   **Java / Spring Boot 3** (Contenedor IoC y Exposición REST)
*   **Jakarta Persistence API / Hibernate** (Mapeo ORM)
*   **Flyway** (Migraciones y control de versiones DB)
*   **PostgreSQL** (Almacén de datos subyacente)