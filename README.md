# API REST - Microservicio Operador de ordenes de Compra

Diseñaremos una API REST para gestionar las ordenes de compra de libros, estará enfocada en las validaciones necesarias para verificar que haya stock de ese libro y que se encuentre visible. Adicionalmente, esta API permite consultar el historial de órdenes.

---
El API incluye las siguientes funcionalidades:
## Registro de la orden de compra
-**Crear orden de compra:** Un endpoint que permita a un usuario crear una orden de compra proporcionando el ID del libro, la cantidad, el precio y el subtotal. Adicionalmente, se debe validar que existan las unidades solicitadas en el stock y que el libro se encuentre visble. Se utilizará cuando el usuario quiera pagar su carrito de compra. 

## Consulta de Pedidos
-**Obtener orden de compra**: Un endpoint que permita al usuario consultar el acuse de que la compra que ha realizado usando el ID de la orden. 

-**Obtener historial de ordenes de compra**: Un endpoint que permita al usuario consultar todas sus ordenes de compra. 

## Recursos disponibles

- **Crear orden (`/ordenes`)**: Representa una operación de compra de uno o varios libros.
- **Obtener orden (`/ordenes/{ordenId}`)**: Devuelve el acuse o factura de una compra específica.
- **Obtener historial de ordenes de compra (`/ordenes`)**: Devuelve todas las ordenes registradas.

---

## Tabla de Endpoints

| Método HTTP | URI               | Query Params | Cuerpo de la Petición                                                                                          | Cuerpo de la Respuesta                                                                                                                 | Códigos de Respuesta                               |
|-------------|-------------------|--------------|---------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------|
| POST        | /ordenes           | N/A          | `[ "libros": { "libroId": 1, "cantidad": 2, "precio": 12.500, "subtotal": 25.000 }]`                                          | `HTTP/1.1 200 OK { "ordenId": 1001, "fecha": "2023-08-0", "estado": "CONFIRMADA", "total": 74.980}`<br><br> `HTTP/1.1 400 BAD_REQUEST {"code": "invalid_body", "detailed": "No hay existencias o no está visible."}` <br><br>  `{ "code": "invalid_body", "detailed": "El libro no existe" }`                                       | 201 Created, <br>400 Bad Request, <br>500 Internal Server Error |
| GET         | /ordenes/{ordenId} | N/A          | N/A                                                                                                           | `{ "ordenId": 1001, "fecha": "2023-08-0", "estado": "CONFIRMADA", "total": 74.980, "libros": [{ "LibroId": 1,  "cantidad": 2, "precio": 12.500, "subtotal": 25.000 } ]}`                                           | 200 OK, <br>404 Not Found, <br>500 Internal Server Error |
| GET         | /ordenes           | N/A          | N/A                                                                                                           | `[ { "ordenId": 1001, "fecha": "2023-08-0", "estado": "CONFIRMADA", "total": "25.000", "libros": [...] }, { "ordenId": 1002, ... } ]`                                                      | 200 OK,  <br>404 Not Found, <br>500 Internal Server Error |

---
