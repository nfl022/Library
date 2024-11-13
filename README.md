📚 Proyecto Biblioteca
Esta aplicación permite buscar, ver y gestionar libros y autores con la integración de una API, almacenamiento en base de datos y comandos fáciles de usar. 🧑‍💻
Se integra con la API de Gutendex para recuperar una lista de libros y sus metadatos, incluyendo detalles sobre autores, categorías, temas e idiomas. El sistema también proporciona la capacidad de almacenar libros y autores en una base de datos PostgreSQL.
Este proyecto se desarrollo como parte del desafio LiterAlura Oracle Next One
⚡ Características
Buscar Libros 📖: Busca libros por título y explora sus detalles.
Gestión de Autores ✍️: Ver autores, filtrar por fecha de nacimiento/muerte y consultar los libros por autor.
Buscar por Idioma 🌍: Filtra libros por idioma.
Integración API 🌐: Obtén datos de libros utilizando la API de Gutendex.
Almacenar en la Base de Datos 💾: Guarda libros y autores en PostgreSQL con relaciones.
🛠️ Tecnologías Utilizadas
Java 17 ☕
Spring Boot 🚀
Maven ⚙️
Jackson (para manejar JSON) 🧩
JPA (Java Persistence API) 🗄️
JPQL (Java Persistence Query Language) 🔍
PostgreSQL 🗃️
Consumo de API RESTful 🌐

🖥️ Cómo Ejecutar la Aplicación
Clona el repositorio:
bash
git clone https://github.com/nfl022/library.git

Construye el proyecto:
mvn clean install

Configura tu base de datos PostgreSQL

Crea una base de datos library.
Ejecuta migraciones para crear las tablas de libros, autores y relaciones.
Configura tu application.properties con tus credenciales de base de datos.

Ejecuta la aplicación:
bash
mvn spring-boot:run

📱 Cómo Usar
Opciones del Menú:
Buscar libros: Busca libros por título 📖.
Buscar libro por título: Busca un libro por su título 🏷️.
Mostrar libros buscados: Ver todos los libros que has buscado 📚.
Mostrar autores buscados: Ver autores con sus libros ✍️.
Buscar por autores vivos en cierto periodo: Buscar autores vivos durante un periodo específico 🔎.
Buscar por idioma: Filtrar libros por idioma 🌍.
Ejemplo:
Para buscar un libro, escribe el título del libro.
Para encontrar un autor, selecciona desde el menú y explora los autores por sus obras y su tiempo de vida.
✨ Mejoras Futuras
🌟 Integrar más APIs de libros para una mayor cobertura.
🧑‍💻 Mejorar la interfaz de usuario con un frontend web (React o Angular).
🛠️ Añadir pruebas unitarias e integradas para una mayor fiabilidad.
