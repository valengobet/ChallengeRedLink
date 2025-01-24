# ChallengeRedLink
![image](https://github.com/user-attachments/assets/d44b1f80-e99c-4e39-98f5-ee0f3214717d)
Este repositorio contiene el desarrollo del MVP solicitado por el banco TuPlataCrece. El objetivo es implementar una API que permita:
	1.	Gestionar el acceso de empleados mediante un login con número de DNI.
	2.	Consultar el monto del préstamo disponible para los usuarios logueados.
	3.	Generar un reporte diario de los usuarios que visualizaron el préstamo disponible.

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



