# Proyecto Back-Intro: Migración de Bounded Contexts

## 📌 Descripción General
Este repositorio (rama `boundcontext`) alberga la arquitectura hexagonal completa y el Domain-Driven Design (DDD) del sistema `back-intro`. El hito principal de esta versión es la **generación e integración automática de 52 Bounded Contexts** que estructuran todo el esquema relacional de la base de datos PostgreSQL, garantizando simetría y coherencia de código.

## 🚀 Acciones Realizadas
Durante el desarrollo en esta rama, se llevaron a cabo los siguientes hitos:
1. **Auditoría de Esquemas SQL:** Se analizaron los scripts de migración de Flyway (`V1` a `V26`) para mapear 52 tablas, deduciendo tipos de datos exactos, restricciones (Not Null) y relaciones de llave foránea.
2. **Definición de Modelo Guía:** Se utilizó el módulo `country` como estándar de oro para heredar sus reglas de diseño arquitectónico y de persistencia.
3. **Automatización a Gran Escala:** Se diseñaron scripts de metaprogramación que orquestaron la creación paralela de **1,352 archivos Java** (26 componentes por módulo).
4. **Verificación de Integridad Espejo:** Se corrió una auditoría algorítmica para validar que las clases Java fuesen un reflejo 1 a 1 de la base de datos Flyway. Durante este proceso se rectificaron relaciones de llaves y mapeos de columnas de auditoría (`created_by`, `updated_by`).

## 🧱 Estructura de Capas (Arquitectura Hexagonal)
Cada uno de los 52 módulos implementados posee un acoplamiento flojo mediante las siguientes 3 capas:

### 1. Domain (`/domain`)
*   **Aggregate Roots:** Entidades puras y desconectadas de frameworks.
*   **Value Objects:** Encapsulamiento robusto de identificadores (ej. `PatientId`) auto-generados vía UUID.
*   **Events & Exceptions:** Disparo de eventos de dominio (`Registered`, `Updated`) y excepciones controladas por reglas de negocio.
*   **Ports:** Interfaces abstractas de los repositorios.

### 2. Application (`/application`)
*   **Use Cases:** Diseño atómico (1 Caso de Uso = 1 Archivo Java) cubriendo operaciones Register, List, GetById, Update, Delete.
*   **Commands:** Records inmutables para transportar intención operativa.
*   **Response DTOs:** Transferencia de datos, la cual **resuelve de forma activa las llaves foráneas** mediante inyección de repositorios (Ej. Retornar el `cityName` real y no solo el ID numérico).

### 3. Infrastructure (`/infrastructure`)
*   **REST Controllers:** Interfaces web (`@RestController`) que dirigen tráfico HTTP y lo delegan a los Use Cases. Protegidos mediante *Jakarta Validation*.
*   **Persistence (JPA):** Clases `@Entity` fuertemente acopladas a la sintaxis `jakarta.persistence.*`, Mappers estáticos y repositorios de Spring Data.
*   **Dependency Injection:** Inversión de control declarada localmente en clases `*BeansConfig.java`.

## 🛠️ Stack Tecnológico Destacado
*   **Java / Spring Boot 3** (Contenedor IoC y Exposición REST)
*   **Jakarta Persistence API / Hibernate** (Mapeo ORM)
*   **Flyway** (Migraciones y control de versiones DB)
*   **PostgreSQL** (Almacén de datos subyacente)