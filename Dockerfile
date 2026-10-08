# Etapa 1: Construcción
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
# Compilamos el proyecto (ignorando los tests para mayor rapidez)
RUN mvn clean package -DskipTests

# Etapa 2: Producción con Tomcat
FROM tomcat:10.1-jdk17
# Borramos las apps por defecto de Tomcat (opcional pero buena práctica)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiamos el WAR construido en la etapa 1 al Tomcat
# Lo renombramos a "back-intro.war" para que el path sea /back-intro
COPY --from=builder /app/infrastructure/target/infrastructure-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/back-intro.war

# Exponemos el puerto 8080
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
