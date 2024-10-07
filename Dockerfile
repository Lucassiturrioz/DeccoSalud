# Usa una imagen base de OpenJDK
FROM openjdk:11-jdk-slim

# Define el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado al contenedor
COPY target/DeccoSalud-1.0-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
