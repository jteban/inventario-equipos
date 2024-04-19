FROM adoptopenjdk/openjdk17:alpine-jre

WORKDIR /app

COPY target/inventario.jar /app

EXPOSE 8080

CMD ["java", "-jar", "inventario.jar"]