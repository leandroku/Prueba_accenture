# Prueba_accenture
Este proyecto es una API REST desarrollada con **Spring Boot**.  
Expone endpoints para gestionar productos, sucursales y franquicias.

## Requisitos
- **java** 21
- **Maven** 3.8+
- **Base de datos:** MySQL
- **Servidor de aplicaciones:** Tomcat 
- **Dependencias principales:**
  - Spring Boot Starter Data JPA
  - Spring Boot Starter WebMVC
  - Spring Boot Starter WebFlux
  - Lombok 
  - MySQL Connector/J

  ## Configuración

El proyecto utiliza un archivo `application.properties` para definir la configuración:

```properties
spring.application.name=prueba
server.port=4000

spring.datasource.url=jdbc:mysql://<host>:3306/<database>
spring.datasource.username=<usuario>
spring.datasource.password=<contraseña>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=none
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
```
## Instalación y ejecución en local este fuera del recuadro

## Pruebas de Endpoints
Una vez que la aplicación esté corriendo en local (por defecto en el puerto **4000**), puedes probar los endpoints usando **Postman**

### - Endpoint: Crear Franquicia

**Método:** POST  
**URL:** `http://localhost:4000/franquicia`  
**Descripción:** Crea una nueva franquicia en la base de datos.  
**Raw -> JSON**
``` JSON
{
    "nombre" : "Sport Life",
    "descripcion" : "Ropa deportiva",
    "indActivo" : true
}
```

### - Endpoint: Traer todas las Franquicias

**Método:** GET  
**URL:** `http://localhost:4000/franquicias`  
**Descripción:** Trae todas las franquicias de la base de datos.

### - Endpoint: Actualiza el nombre de una franquicia

**Método:** PATCH  
**URL:** `http://localhost:4000/franquicia/{id}/nombre`  
**Descripción:** Actualiza el nombre de una franquicia segun el id.  
**Raw -> JSON**
``` JSON
    "Urban Style"
```
---

### - Endpoint: Crear Sucursal

**Método:** POST  
**URL:** `http://localhost:4000/sucursal`  
**Descripción:** Crea una nueva sucursal en la base de datos.  
**Raw -> JSON**
``` JSON
{
    "nombre" : "Sport Life Norte",
    "descripcion" : "Localidad Norte",
    "indActivo" : true,
    "idFranquicia" : 1
}
```

### - Endpoint: Traer todas las sucursales

**Método:** GET  
**URL:** `http://localhost:4000/sucursal`  
**Descripción:** Trae todas las sucursales de la base de datos.

### - Endpoint: Actualiza el nombre de una sucursal

**Método:** PATCH  
**URL:** `http://localhost:4000/sucursal/{id}/nombre`  
**Descripción:** Actualiza el nombre de una sucursal segun el id.  
**Raw -> JSON**
``` JSON
"Urban Style Centros"
```

---

### - Endpoint: Crear Producto

**Método:** POST  
**URL:** `http://localhost:4000/producto`  
**Descripción:** Crea un nuevo producto en la base de datos.  
**Raw -> JSON**
``` JSON
{
    "nombre" : "Botines trekking",
    "descripcion" : "n/a",
    "precio" : "45000",
    "stock" : "10",
    "indActivo" : true,
    "idSucursal" : 1
}
```

### - Endpoint: Traer todos los productos

**Método:** GET  
**URL:** `http://localhost:4000/producto`  
**Descripción:** Trae todos los Productos de la base de datos.

### - Endpoint: Eliminar productos

**Método:** DELETE  
**URL:** `http://localhost:4000/producto/{id}`  
**Descripción:** Elimina un Producto de la base de datos segun su id.

### - Endpoint: Actualiza stock de un Producto

**Método:** PATCH  
**URL:** `http://localhost:4000/producto/{id}/stock`  
**Descripción:** Actualiza el stock de un producto segun el id.  
**Raw -> JSON**
``` JSON
30
```

### - Endpoint: Productos con mayor stock de cada sucursal

**Método:** GET  
**URL:** `http://localhost:4000/producto/MaxStockProductoSucursal/{id}`  
**Descripción:** Traer los productos con mayor stock de cada sucursal segun el id de la franquicia.

### - Endpoint: Actualiza nombre de un producto

**Método:** PATCH  
**URL:** `http://localhost:4000/sucursal/{id}/nombre`  
**Descripción:** Actualiza el nombre de un producto segun el id.  
**Raw -> JSON**
``` JSON
"Camiseta básica blanca y negro"
```
