# Chef Control - Backend

Chef Control es un programa diseñado específicamente para restaurantes pequeños e informales. Su enfoque principal es llevar un control eficiente de ventas, pagos y la información esencial necesaria para la gestión de estos establecimientos.

## Detalles
Tecnologia: 

    Java 21
    Spring Boot

Dependencias:

    spring-boot-starter-data-jpa
    spring-boot-starter-web
    mysql-connector-j
    lombok
    spring-boot-starter-security
    spring-boot-starter-test
    spring-boot-maven-plugin

## Build and run

Para ejecutar un proyecto Java con Maven, sigue estos pasos:

Configuración Inicial:
Asegúrate de tener Java JDK instalado en tu máquina con una versión compatible con tu proyecto. Además, necesitarás tener Apache Maven instalado. Puedes verificar las versiones instaladas ejecutando los siguientes comandos en la terminal:

    bash
    Copy code
    java -version
    mvn -v

Asegúrate de tener al menos Java 8 y Maven 3.x.

Acceder al Proyecto: Cambia al directorio del proyecto

    bash
    Copy code
    cd nombre-del-proyecto

Compilar el Proyecto: Utiliza el siguiente comando para compilar el proyecto y construir el archivo JAR:

    bash
    Copy code
    mvn clean install

Ejecutar la Aplicación: Después de la compilación exitosa, puedes ejecutar la aplicación con el siguiente comando:

    bash
    Copy code
    java -jar target/nombre-del-proyecto.jar

Asegúrate de reemplazar "nombre-del-proyecto" con el nombre real de tu proyecto.

Visualizar la Aplicación: Abre tu navegador web y accede a la URL donde se está ejecutando tu aplicación, que suele ser http://localhost:8080 o la URL especificada en la configuración de tu aplicación.

Posibles Errores: Durante la ejecución, presta atención a cualquier mensaje de error que aparezca en la consola. Estos mensajes pueden proporcionar información útil para solucionar problemas en tu código o configuración.
