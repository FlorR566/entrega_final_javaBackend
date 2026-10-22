# Entrega Final

Proyecto desarrollado para la cursada de **Backend Java - Talento Tech**. La aplicación evoluciona desde una estructura orientada a objetos en Java estándar hacia una arquitectura más robusta y escalable implementada con **Spring Boot**.

---

## Tecnologías Utilizadas

* **Lenguaje:** Java (Versión 17+)
* **Framework Principal:** Spring Boot 3.x
* **Gestión de Dependencias:** Maven
* **IDE Recomendado:** IntelliJ IDEA
* **Control de Versiones:** Git / GitHub

---

## Estructura del Proyecto

El código fuente está organizado en los siguientes paquetes principales:

```text
src/main/java/
├── config/       # Configuraciones generales de la aplicación y beans
├── controller/   # Controladores REST / Capa de entrada
├── exception/    # Excepciones personalizadas para el manejo de errores
├── model/        # Entidades del dominio y modelos de datos
├── repository/   # Capa de acceso a datos y persistencia
├── service/      # Lógica de negocio e inyección de dependencias
├── ui/           # Interfaz de usuario / Menú de interacción
└── util/         # Clases de utilidad y helpers
```