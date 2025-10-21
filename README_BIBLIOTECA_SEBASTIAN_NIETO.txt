🧾 PROYECTO BIBLIOTECA - MÓDULO 60 - SEBASTIÁN NIETO

📚 DESCRIPCIÓN GENERAL
El proyecto Biblioteca implementa un sistema de gestión para autores, libros y usuarios,
con operaciones CRUD completas y persistencia de datos utilizando JPA/Hibernate.
Es una extensión del proyecto 1, ahora con persistencia real en base de datos,
patrones de diseño y pruebas unitarias con JUnit 5.

🎯 OBJETIVOS
- Implementar CRUD para las entidades Author, Book, User y Library.
- Usar Hibernate/JPA para persistir datos.
- Aplicar al menos dos patrones de diseño.
- Escribir pruebas unitarias con JUnit.
- Integrar persistencia con la aplicación.

🧠 PATRONES DE DISEÑO UTILIZADOS
1️⃣ DAO / Repository Pattern
   Toda la lógica de acceso a datos se maneja desde Library.java.

2️⃣ Singleton Pattern
   Se aplica al EntityManagerFactory, asegurando una sola conexión activa.



🧱 TECNOLOGÍAS
- Java 17
- Maven
- Hibernate 6.3.0.Final
- JUnit 5
- H2 Database (base en memoria)
- SLF4J

⚙️ CONFIGURACIÓN H2
(persistence.xml)
jdbc:h2:mem:biblioteca;DB_CLOSE_DELAY=-1

🧪 PRUEBAS UNITARIAS
Se validan relaciones entre entidades, inserciones, eliminaciones y persistencia general.
Ejecutar con: mvn test

🚀 EJECUCIÓN
Ejecutar com.biblioteca.main.Main desde IntelliJ IDEA.
Se muestran logs de Hibernate y acciones CRUD.

💾 CAMBIAR A MYSQL (opcional)
Modificar persistence.xml con driver y URL de MySQL.

✅ CONCLUSIÓN
Este proyecto cumple con los requisitos del módulo 60:
✔ Patrones de diseño (DAO y Singleton)
✔ Persistencia con JPA/Hibernate
✔ CRUD completo
✔ Pruebas unitarias con JUnit 5
✔ Base de datos funcional (H2 o MySQL)
