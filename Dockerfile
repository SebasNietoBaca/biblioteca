# Usa una imagen oficial de Java 17
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Maven al contenedor
COPY target/biblioteca-app-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
