# ChallengeRedLink
![image](https://github.com/user-attachments/assets/d44b1f80-e99c-4e39-98f5-ee0f3214717d)
Este repositorio contiene el desarrollo del MVP solicitado por el banco TuPlataCrece. El objetivo es implementar una API que permita:
	1.	Gestionar el acceso de empleados mediante un login con número de DNI.
	2.	Consultar el monto del préstamo disponible para los usuarios logueados.
	3.	Incorporar y procesar diariamente los datos enviados por el banco en un archivo con la relación DNI - Importe.
	4.	Generar un reporte diario de los usuarios que visualizaron el préstamo disponible.

Casos de uso principales:
	•	Si el DNI no es reconocido, el usuario no podrá acceder al sistema.
	•	Si el DNI es válido pero no tiene un préstamo asociado, se mostrará un mensaje indicando la falta de un crédito disponible.
	•	Si el DNI es válido y tiene un préstamo disponible, se mostrará el importe correspondiente.

Instrucciones para levantar el proyecto
	1.	Clonar el repositorio:

git clone <URL_DEL_REPOSITORIO>
cd <NOMBRE_DEL_REPOSITORIO>


	2.	Requisitos previos:
	•	Java 17 o superior
	•	Maven 3.8+
	•	(Opcional) Docker si se desea usar contenedores
	3.	Configuración del proyecto:
El proyecto utiliza una base de datos en memoria H2 para simplificar el desarrollo. No se requiere configuración adicional.
	4.	Compilar y ejecutar el proyecto:
	•	Para compilar el proyecto:

mvn clean install


	•	Para ejecutarlo:

mvn spring-boot:run


	5.	Acceso a la aplicación:
	•	La API estará disponible en http://localhost:8080.
	•	La consola de H2 Database puede accederse desde http://localhost:8080/h2-console.
	•	JDBC URL: jdbc:h2:mem:testdb
	•	Usuario: sa
	•	Contraseña: (vacío)
	6.	Puntos principales de la API:
	•	POST /login: Recibe un número de DNI y genera un token de sesión.
	•	GET /loans: Devuelve el monto del préstamo disponible para el usuario logueado.
	•	POST /data/upload: Permite subir el archivo con la relación DNI-Importe.
	•	GET /data/report: Genera un reporte de los usuarios que consultaron sus préstamos.
	7.	Ejecución de pruebas:
Para ejecutar las pruebas unitarias, usa:

mvn test

