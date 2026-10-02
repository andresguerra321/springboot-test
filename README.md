# Back-Intro (Spring Boot Multi-Módulo)

Backend desarrollado con **Spring Boot**, diseñado bajo los principios de **Arquitectura Hexagonal (Puertos y Adaptadores)** y **Domain-Driven Design (DDD)** modular por Bounded Contexts. Cuenta con una gestión robusta del esquema de base de datos relacional mediante **Flyway**.

---

## 🏛️ Arquitectura del Proyecto

El proyecto está organizado como un sistema multi-módulo de Maven para garantizar desacoplamiento total del dominio y una estricta separación de responsabilidades:

```
back-intro/
├── domain/                                  # Núcleo del negocio (puro, Java estándar, sin frameworks)
│   ├── common/                              # Clases base compartidas (AggregateRoot, DomainEvent, DomainException)
│   └── <bounded-context>/                   # Módulos de dominio (country, empresa, catalog, patient, etc.)
│       ├── event/                           # Eventos de dominio inmutables (records)
│       ├── exception/                       # Excepciones semánticas de negocio
│       ├── model/
│       │   ├── aggregate/                   # Agregado raíz (hereda de AggregateRoot)
│       │   └── valueobject/                 # Value Objects inmutables (records con invariantes)
│       └── port/
│           └── repository/                  # Interfaces de repositorio (puertos de salida de dominio)
│
├── application/                             # Casos de uso y orquestación
│   └── <bounded-context>/
│       ├── command/                         # Comandos de intención (intents/CQRS)
│       ├── dto/                             # DTOs de respuesta de aplicación
│       ├── exception/                       # Excepciones de aplicación
│       └── usecase/                         # Casos de uso desacoplados de frameworks
│
└── infrastructure/                          # Adaptadores tecnológicos y configuración de Spring Boot
    ├── src/main/java/com/backintro/infrastructure/
    │   └── <bounded-context>/
    │       ├── adapters/in/rest/            # Adaptadores primarios (Controladores REST, DTOs, Handlers)
    │       ├── adapters/out/persistence/    # Adaptadores secundarios (JPA Entities, Mappers, Repositorios)
    │       └── config/                      # Configuración de beans de Spring para los Casos de Uso
    └── src/main/resources/
        ├── application.yml
        ├── application-dev.yml
        └── db/migration/                    # Scripts SQL incrementales de Flyway (V1...V53)
```

### Reglas de Dependencia
1. **Domain**: No depende de ningún framework ni librería externa. Solo Java puro.
2. **Application**: Depende únicamente de `domain`. No conoce controladores, JPA ni detalles de infraestructura.
3. **Infrastructure**: Conoce `application` y `domain`. Implementa los puertos y orquesta frameworks (Spring Boot, Spring Data JPA, Flyway, PostgreSQL).

---

## 🔄 Estrategia de Migraciones: Flyway vs. JPA

Una de las decisiones arquitectónicas clave en este proyecto es el control explícito del ciclo de vida de la base de datos:

### ¿Por qué Flyway en lugar de `ddl-auto` de JPA/Hibernate?

| Aspecto | JPA (`hibernate.ddl-auto: update/create`) | Flyway (Elegido en este proyecto) |
| :--- | :--- | :--- |
| **Control de Cambios** | Automático e impredecible en producción. | Explícito mediante scripts SQL versionados (`V1__...sql`). |
| **Historial / Auditoría** | No existe registro de qué cambió ni cuándo. | Tabla `flyway_schema_history` con fechas, usuarios y checksums. |
| **Renombrado y Migración de Datos** | Puede duplicar columnas o perder datos al renombrar. | Permite transformaciones complejas de datos (DDL y DML). |
| **Reproducibilidad** | Depende del escaneo de entidades al arrancar. | Garantiza idéntico estado en Local, QA, Staging y Producción. |

### Configuración aplicada en `application-dev.yml`:
* **JPA en modo pasivo**:
  ```yaml
  spring:
    jpa:
      hibernate:
        ddl-auto: none   # Hibernate NO altera las tablas; delega todo a Flyway
  ```
* **Flyway como fuente de verdad**:
  ```yaml
  spring:
    flyway:
      enabled: true
      locations: classpath:db/migration
      schemas:
        - librarydb_schema
      default-schema: librarydb_schema
      table: flyway_schema_history_librarydb
  ```

---

## 🛠️ Tecnologías Utilizadas

* **Java 17**
* **Spring Boot 4.x** (Web, Validation, Data JPA)
* **PostgreSQL** (Motor relacional)
* **Flyway** (Control de versiones de base de datos)
* **MapStruct** (Mapeo eficiente de objetos)
* **SpringDoc OpenAPI (Swagger)** (Documentación interactiva de la API)
* **Maven** (Gestión de dependencias multi-módulo)

---

## 🚀 Puesta en Marcha Local

### 1. Prerrequisitos
* Java JDK 17 o superior instalado.
* Maven 3.8+ instalado.
* Instancia de PostgreSQL en ejecución (puerto `5432`).

### 2. Base de Datos
Crear la base de datos en PostgreSQL:
```sql
CREATE DATABASE librarydb;
```

*(Opcional mediante Docker)*:
```bash
docker run --name postgres-librarydb -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=librarydb -p 5432:5432 -d postgres:16
```

### 3. Compilar el Proyecto
Desde la raíz del repositorio:
```bash
mvn clean install
```

### 4. Ejecutar la Aplicación
```bash
mvn spring-boot:run -pl infrastructure
```

Al iniciar, Flyway ejecutará de forma automática y ordenada todas las migraciones SQL pendientes.

---

## 📖 Endpoints y Documentación Interactiva (Swagger UI)

Una vez iniciada la aplicación en el puerto `8081`:
* **Swagger UI:** [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
* **OpenAPI Docs:** [http://localhost:8081/v3/api-docs](http://localhost:8081/v3/api-docs)

### Endpoints Principales Disponibles:
* **Countries:** `/api/v1/countries` (`GET`, `POST`, `GET /{id}`, `GET /code/{code}`, `PUT /{id}`, `DELETE /{id}`)
* **Empresas:** `/api/v1/empresas` (`GET`, `POST`, `GET /{id}`, `PUT /{id}`, `DELETE /{id}`)