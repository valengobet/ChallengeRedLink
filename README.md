# ChallengeRedLink
### Descripcion
Este repositorio contiene el desarrollo del MVP cuyo objetivo es implementar una API que permita:

    - Gestionar el acceso de empleados mediante un login con número de DNI.
    - Consultar el monto del préstamo disponible para los usuarios logueados.
    - Generar un reporte diario de los usuarios que visualizaron el préstamo disponible.

### Casos de uso principales:
	- Si el DNI no es reconocido, el usuario no podrá acceder al sistema.
	- Si el DNI es válido pero no tiene un préstamo asociado, se mostrará un mensaje indicando la falta de un crédito disponible.
	- Si el DNI es válido y tiene un préstamo disponible, se mostrará el importe correspondiente.

### Instrucciones para levantar el proyecto
	1.	Clonar el repositorio:

	2.	Requisitos previos:
	- Java 17 o superior
	- Maven 3.8+

	3.	Configuración del proyecto:
    - El proyecto utiliza una base de datos en memoria H2 para simplificar el desarrollo. No se requiere configuración adicional.

### Diagrama
![image](https://github.com/user-attachments/assets/d44b1f80-e99c-4e39-98f5-ee0f3214717d)

### Import para Postman
```
{
	"info": {
		"_postman_id": "e2560ef9-82c7-4fcd-86e2-638a118dbcae",
		"name": "Challenge Red Link",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "41265628"
	},
	"item": [
		{
			"name": "tienePrestamo",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:4000/prestamos/login?dni=1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "4000",
					"path": [
						"prestamos",
						"login"
					],
					"query": [
						{
							"key": "dni",
							"value": "1"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "noTienePrestamo",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:4000/prestamos/login?dni=3",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "4000",
					"path": [
						"prestamos",
						"login"
					],
					"query": [
						{
							"key": "dni",
							"value": "3"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "noEncontrado",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:4000/prestamos/login?dni=4",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "4000",
					"path": [
						"prestamos",
						"login"
					],
					"query": [
						{
							"key": "dni",
							"value": "4"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "verVistas",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:4000/prestamos/view",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "4000",
					"path": [
						"prestamos",
						"view"
					]
				}
			},
			"response": []
		}
	]
}
```



