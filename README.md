### [ ES ] ![Static Badge](https://img.shields.io/badge/Technology-java-spring) ![Static Badge](https://img.shields.io/badge/Technology-git-hub) ![Static Badge](https://img.shields.io/badge/Technology-spring-api) ![Static Badge](https://img.shields.io/badge/DBA-SQL-3?style=flat&logo=SQL&logoColor=gold&color=%23B79623) ![Static Badge](https://img.shields.io/badge/Spring-Security-web) ![Static Badge](https://img.shields.io/badge/DBA-Flayway-web)



<p align="center"> <h1 align="center">Alura Foro Hub Challenge</h1>
Foro Hub es una aplicación de foro backend desarrollada como proyecto desafío para el curso Oracle Next One Education. Permite a los usuarios crear tópicos similares a un Foro.

## Requisitos Previos
Antes de comenzar, asegúrate de tener instalado lo siguiente:

* Java 17 JDK
* Maven
* Spring Boot
* Spring Security con JWT
* Spring JavaDoc Swagger
* Base de datos MySQL (nombre del esquema: forohub)
* Herramientas de desarrollo (se recomienda IntelliJ IDEA)
* Opcional: Insomnia u otra herramienta similar para pruebas de API
* Opcional: MySQL Workbench para gestión de bases de datos

## Instalación
Para instalar y ejecutar Foro Hub:

Clona el repositorio desde GitHub:

_bash_
``` 
git clone https://github.com/your-username/foro-hub.git
``` 
**Abre el proyecto en tu IDE preferido (por ejemplo, IntelliJ IDEA).**

Compila y ejecuta la aplicación desde tu IDE.

## Uso
Foro Hub es una aplicación backend. Después de ejecutar la aplicación localmente, puedes acceder a la documentación de Swagger UI en http://localhost:8080/swagger-ui/index.html#/. Esta interfaz proporciona detalles sobre los endpoints de la API disponibles.

## Endpoints

### Controlador de Tópico (Tema)
GET /topico: Obtiene una lista de tópicos por pagina.

GET /topico/{id}: Obtiene los datos del Tópico de ID.

POST /topico: Crea un nuevo tema proporcionando título, mensaje, estado, ID de usuario y curso. {
"titulo": "Titulo del Curso",
"mensaje": "contenido de mensaje del topico", "idAutor":"2", "curso": "HTTP programacion"
}

DELETE /topico/{id}: Elimina un tópico de manera lógica por ID.

DELETE /topico/delete/{id}: Elimina un tópico de manera física por ID.

### Controlador de Autenticación

 POST /login: Autentica el inicio de sesión del usuario con Spring Security y JWT.
Para acceder a la mayoría de los endpoints, necesitas autenticarte con un token Bearer obtenido del endpoint /authenticate.
 {
 "login": "String",
 "clave": "String"
 }

## Configuración
> [!IMPORTANT]
> Asegúrate de tener MySQL instalado y crea una base de datos llamada foro_hub. Configura los detalles de conexión a la base de datos en application.properties o application.yml.
> 
![variables_entorno](https://github.com/DjB112/foro-hub/assets/131042234/868ea6dc-bd7b-4968-9afa-0cdf5d0d6a3e)


## Funcionalidades
> - Registro y autenticación de usuarios utilizando Spring Security y JWT.
> - Operaciones CRUD para usuarios, temas y respuestas.
> - Documentación de API con Swagger para exploración sencilla de los endpoints.
> - Desarrollado Con
> - Java 17
> - Maven
> - Spring Boot
> - Spring Security con JWT
> - Spring JavaDoc Swagger
> - MySQL con Spring Data JPA y Flyway para gestión de bases de datos
> - Insomnia u otra herramienta similar para pruebas de API
> - MySQL Workbench para visualización y gestión de bases de datos

## Documentación
> [!TIP]
> Explora la API utilizando Spring JavaDoc Swagger en http://localhost:8080/swagger-ui/index.html#/.
<p>  Swagger Map para Spring JavaDoc </p>

![swagger-ui](https://github.com/DjB112/foro-hub/assets/131042234/75fafbf5-8cc5-4cb2-86ec-5f4e50c22013)

## Contribución
> [!CAUTION]
> ¡Las contribuciones a Foro Hub son bienvenidas! Por favor, sigue nuestras Directrices de Contribución.


