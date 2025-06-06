_**TaskHarmony - Proyecto TFG**_

TaskHarmony es una aplicación de gestión de tareas familiares, desarrollada como Trabajo de Fin de Grado. Está programada en Java usando Maven, JPA y una base de datos MySQL.

**Tecnologías utilizadas**
  - Java 17
  - Maven
  - JPA (Jakarta Persistence API)
  - MySQL 8+
  - EclipseLink como proveedor JPA
  - NetBeans (IDE usado en desarrollo)

**¿Cómo ejecutar el proyecto?**

  1. Clonar el repositorio
  
    git clone https://github.com/martinMrow/TaskHarmonyMartin.git
    cd TaskHarmonyMartin/mavenproject4
  
  2. Importar el proyecto en tu IDE
    <br>Puedes usar NetBeans, IntelliJ IDEA, Eclipse u otro IDE que soporte Maven. Importa el proyecto como un proyecto Maven existente.
  
  3. Crear la base de datos
    <br>Asegúrate de tener MySQL en funcionamiento.
    - Crea una base de datos vacía llamada tfg4.
    - Ejecuta el script SQL para crear las tablas: ```mysql -u root -p tfg4 < tfg4.sql``` ( Nota: El archivo tfg4_clean.sql se encuentra en la raíz del repositorio y solo contiene la estructura, sin datos preinsertados.)
  
  4. Configurar credenciales de MySQL
   <br>Revisa el archivo src/main/resources/META-INF/persistence.xml y asegúrate de que los datos de acceso a tu base de datos sean correctos:
    ```<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/tfg4"/>```
    ```<property name="javax.persistence.jdbc.user" value="root"/>```
    ```<property name="javax.persistence.jdbc.password" value=""/>```

  5. Ejecutar la aplicación
  <br>Ejecuta Mavenproject4.java 

**Estructura del proyecto**

    mavenproject4/
    ├── src/main/java/com/mycompany/mavenproject4/
    │   ├── Usuario.java
    │   ├── Familia.java
    │   ├── ...
    ├── src/main/resources/META-INF/
    │   └── persistence.xml
    ├── pom.xml
    └── tfg4.sql
    
**Martín MVAR**
Este proyecto fue desarrollado como parte del TFG en el ciclo superior de Desarrollo de Aplicaciones Multiplataforma. Posteriormente calificado con un 9/10.
