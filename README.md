# mutants-meli
Mutants detector by DNA sequence


Pasos para ejecutar los servicios.

1. Importar desde postman la colección:
https://github.com/jmms11/mutants-meli/blob/main/Mutants.postman_collection.json
	en la carpeta base del repositorio.
	
2. los request ya se encuentran preparados para ejecutar desde postman:

GET
https://mutants-meli-329606.uc.r.appspot.com/stats

POST
https://mutants-meli-329606.uc.r.appspot.com/mutant


Tecnologias Usadas en los servicios:

- Se usó Google Cloud Platform para la puplicación del api.
- La BD esta en MySQL 5.7 y se usó la herramient de SQL de Google Cloud Platform para su creación.
- El api se desarrolló en Java bajo el framework de spring.
