# Back-Intro (Spring Boot Multi-Módulo)

Backend desarrollado con **Spring Boot**, diseñado bajo los principios de **Arquitectura Hexagonal (Puertos y Adaptadores)** y **Domain-Driven Design (DDD)**. Cuenta con una gestión robusta del esquema de base de datos relacional mediante **Flyway**.

---

## 🏛️ Arquitectura del Proyecto

El proyecto está estructurado como un proyecto multi-módulo de Maven para garantizar una estricta separación de responsabilidades y bajo acoplamiento:

```
back-intro/
├── domain/                  # Núcleo del negocio (puro, sin frameworks)
│   ├── aggregate/           # Agregados y entidades de dominio
│   ├── model/               # Modelos y Value Objects
│   ├── port/                # Interfaces de entrada y salida (Puertos)
│   └── exception/           # Excepciones de negocio
│
├── application/             # Casos de uso y orquestación
│   ├── usecase/             # Lógica de aplicación
│   ├── command/             # Comandos (CQRS/intenciones)
│   ├── query/               # Consultas
│   └── dto/                 # Data Transfer Objects
│
└── infrastructure/          # Adaptadores tecnológicos y configuración
    ├── src/main/java/com/backintro/infrastructure/
    │   ├── .../adapters/in/ # Adaptadores de entrada (Controladores REST)
    │   ├── .../adapters/out/# Adaptadores de salida (JPA Repositories, DB)
    │   └── config/          # Configuraciones de Spring, CORS, etc.
    └── src/main/resources/
        ├── application.yml
        ├── application-dev.yml
        └── db/migration/    # Scripts SQL versionados de Flyway (V1...V53)
```

### Reglas de Dependencia
1. **Domain**: No depende de ningún framework (ni Spring ni Hibernate). Solo Java estándar.
2. **Application**: Conoce el dominio pero no los detalles técnicos de infraestructura.
3. **Infrastructure**: Implementa los puertos definidos en el dominio y orquesta los frameworks (Spring Boot, JPA, Flyway, PostgreSQL, etc.).

---

## 🔄 Estrategia de Migraciones: Flyway vs. JPA

Una de las decisiones arquitectónicas clave en este proyecto es el manejo del ciclo de vida de la base de datos:

### ¿Por qué Flyway en lugar del `ddl-auto` de JPA/Hibernate?

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

Los scripts de migración se encuentran en:
`infrastructure/src/main/resources/db/migration/` y se ejecutan secuencialmente de manera automática al iniciar la aplicación.

---

## 🛠️ Tecnologías Utilizadas

* **Java 17**
* **Spring Boot 4.x** (Web, Validation, Data JPA)
* **PostgreSQL** (Motor de base de datos)
* **Flyway** (Control de versiones de base de datos)
* **MapStruct** (Mapeo eficiente de objetos/DTOs)
* **SpringDoc OpenAPI (Swagger)** (Documentación interactiva de la API)
* **Maven** (Gestor de dependencias multi-módulo)

---

## 🚀 Puesta en Marcha Local

### 1. Prerrequisitos
* Java JDK 17 o superior instalado.
* Maven 3.8+ instalado.
* Instancia de PostgreSQL en ejecución.

### 2. Base de Datos
Crear la base de datos en PostgreSQL:
```sql
CREATE DATABASE librarydb;
```

*(Opcional con Docker)*:
```bash
docker run --name postgres-librarydb -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=librarydb -p 5432:5432 -d postgres:16
```

### 3. Compilar el Proyecto
Desde la raíz del repositorio:
```bash
mvn clean install
```

### 4. Ejecutar la Aplicación
Puedes iniciar el backend desde tu IDE ejecutando `BackIntroApplication` o mediante terminal:
```bash
mvn spring-boot:run -pl infrastructure
```

Al iniciar, Flyway aplicará automáticamente todos los scripts pendientes en el esquema `librarydb_schema`.

---

## 📖 Documentación de la API (Swagger UI)

Una vez iniciada la aplicación en el puerto `8081`:
* **Swagger UI:** [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
* **OpenAPI Docs:** [http://localhost:8081/v3/api-docs](http://localhost:8081/v3/api-docs)