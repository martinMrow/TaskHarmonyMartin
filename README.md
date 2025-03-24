# TaskHarmony

## Descripción
TaskHarmony es una aplicación desarrollada en Java que permite la gestión eficiente de tareas y proyectos. Utiliza una base de datos para almacenar información y varias librerías para optimizar su funcionamiento.

## Características
- Creación, edición y eliminación de tareas.
- Gestión de proyectos con múltiples tareas asociadas.
- Integración con bases de datos.
- Interfaz intuitiva y fácil de usar.

## Tecnologías utilizadas
- **Lenguaje**: Java
- **Base de datos**: MySQL / SQLite (según configuración)
- **Librerías**:
  - Hibernate (para la persistencia de datos)
  - JavaFX (para la interfaz gráfica)
  - Lombok (para reducir la cantidad de código repetitivo)
  - Maven (para la gestión de dependencias)

## Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/martinMrow/TaskHarmonyMartin.git
   ```
2. Accede al directorio del proyecto:
   ```bash
   cd TaskHarmony
   ```
3. Configura la base de datos en el archivo `config.properties`.
4. Compila y ejecuta el proyecto con Maven:
   ```bash
   mvn clean install
   mvn exec:java
   ```

## Uso
- Inicia la aplicación y crea un nuevo proyecto.
- Añade tareas con descripciones, fechas de vencimiento y prioridades.
- Administra las tareas según su estado de finalización.

## Contribución
Si deseas contribuir, sigue estos pasos:
1. Haz un fork del repositorio.
2. Crea una nueva rama con una mejora o corrección:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza los cambios y haz commit:
   ```bash
   git commit -m "Añadida nueva funcionalidad"
   ```
4. Sube los cambios a tu fork y crea un pull request.

## Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## Contacto
- **Autor**: Martín Mrow
- **Repositorio**: [GitHub](https://github.com/martinMrow/TaskHarmonyMartin)

