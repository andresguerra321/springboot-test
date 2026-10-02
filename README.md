# Proyecto Back-Intro: Migración de Bounded Contexts

## 📌 Descripción General
Este repositorio (rama `boundcontext`) alberga la arquitectura hexagonal completa y el Domain-Driven Design (DDD) del sistema `back-intro`. El hito principal de esta versión es la **generación e integración automática de 52 Bounded Contexts** que estructuran todo el esquema relacional de la base de datos PostgreSQL, garantizando simetría y coherencia de código.

## 🚀 Acciones Realizadas
Durante el desarrollo en esta rama, se llevaron a cabo los siguientes hitos:
1. **Auditoría de Esquemas SQL:** Se analizaron los scripts de migración de Flyway (`V1` a `V26`) para mapear 52 tablas, deduciendo tipos de datos exactos, restricciones (Not Null) y relaciones de llave foránea.
2. **Definición de Modelo Guía:** Se utilizó el módulo `country` como estándar de oro para heredar sus reglas de diseño arquitectónico y de persistencia.
3. **Automatización a Gran Escala:** Se diseñaron scripts de metaprogramación que orquestaron la creación paralela de **1,352 archivos Java** (26 componentes por módulo).
4. **Verificación de Integridad Espejo:** Se corrió una auditoría algorítmica para validar que las clases Java fuesen un reflejo 1 a 1 de la base de datos Flyway. Durante este proceso se rectificaron relaciones de llaves y mapeos de columnas de auditoría (`created_by`, `updated_by`).

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
*   **Response DTOs:** Transferencia de datos de salida. Aquí se **resuelven activamente las llaves foráneas** mediante inyección de repositorios del dominio (Ej. Retornar el `cityName` real mapeando un `cityId`).

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