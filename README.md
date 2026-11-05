# Tienda de Café

Proyecto final de la cursada de **Backend Java - Talento Tech**. API REST para gestionar los productos y categorías de una tienda de café. La aplicación evolucionó desde una estructura orientada a objetos en Java estándar hacia una arquitectura más robusta y escalable implementada con **Spring Boot** y persistencia en **MySQL**.

---

## Tecnologías utilizadas

* **Lenguaje:** Java 17+ (desarrollado con Java 25)
* **Framework principal:** Spring Boot 4.x
* **Persistencia:** Spring Data JPA + Hibernate
* **Base de datos:** MySQL
* **Gestión de dependencias:** Maven
* **IDE recomendado:** IntelliJ IDEA
* **Control de versiones:** Git / GitHub

---

## Estructura del proyecto

```text
src/main/java/com/techlab/api/
├── controller/   # Controladores REST / Capa de entrada
├── exception/    # Excepciones personalizadas para el manejo de errores
├── model/        # Entidades JPA (Producto, Categoria)
├── repository/   # Repositorios Spring Data JPA
├── service/      # Lógica de negocio
└── util/         # Clases de utilidad (Validador)
```

---

## Configuración

### Requisitos previos
* Java 17 o superior
* Maven
* MySQL corriendo en `localhost:3306`

### Base de datos
Crear la base de datos antes de iniciar la aplicación:

```sql
CREATE DATABASE tienda_cafe;
```

### Variables de entorno
Crear un archivo `.env` en la raíz del proyecto con las credenciales de MySQL (este archivo está en `.gitignore` y no se versiona):

```text
DB_USERNAME=tu_usuario
DB_PASSWORD=tu_contraseña
```

### Ejecutar

```bash
./mvnw spring-boot:run
```

La API queda disponible en `http://localhost:8080`.

---

## Endpoints

### Productos (`/productos`)

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/productos` | Lista todos los productos |
| GET | `/productos/{id}` | Obtiene un producto por id |
| POST | `/productos` | Crea un producto |
| PUT | `/productos/{id}` | Actualiza un producto |
| DELETE | `/productos/{id}` | Elimina un producto |

### Categorías (`/categorias`)

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/categorias` | Lista todas las categorías |
| GET | `/categorias/{id}` | Obtiene una categoría por id |
| POST | `/categorias` | Crea una categoría |
| PUT | `/categorias/{id}` | Actualiza una categoría |
| DELETE | `/categorias/{id}` | Elimina una categoría |

---

## Probar la API


Importar la colección `postman/tienda-cafe-api.postman_collection.json` en Postman para probar los endpoints.