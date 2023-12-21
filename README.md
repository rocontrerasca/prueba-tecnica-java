# Prueba Tecnica Java

1. implementar un servicio web que permita consumir el api de star wars
(https://swapi.dev/documentation#films),
para dicho consumo solo necesitamos implementar la operación /films/:id/ la cual retorna
una película por id.
para este punto necesitamos validar:
* si el cliente envía un id que no existe se retorne el código 204
* si el cliente envía algo diferente a un id o id demasiado largos retorne un Código 400 con
el siguiente response "error en la solicitud"
* si el api de star wars responde de forma correcta, se pide persistir la siguiente
información:
episode_id, title y release_date en una tabla en base de datos y devolver dicha
información con código 200 en formato json al cliente
2. implementar un servicio web que permita actualizar la información de un registro
almacenado en la tabla
3. implementar un servicio web que permita borrar la información de registro en la bd
4. validar la cobertura del Código sobre el 70% con pruebas unitarias (Junit - Mockito)
5. subir Código a un repo público de git hub

### Tecnologias

* [Java](https://www.java.com/en/)
* [Spring](https://spring.io/)
* [PL7/SQL](https://www.oracle.com/co/database/technologies/appdev/plsql.html)
* [JPA](https://spring.io/projects/spring-data-jpa)

## Dependencias

* Java - Version: 17
* Spring - Version: 3.1.5
* Maven - Version: 3.8.6 (Optional)

# Http routes

## consultar un registro
> GET

```/{id}```

Retun:

```json
{
    "id": 1,
    "episodeId": 4,
    "title": "A New Hope",
    "releaseDate": "1977-05-25"
}
```

## Listar todos los registros
> GET

```/```

Retun:

```json
[
    {
        "id": 1,
        "episodeId": 4,
        "title": "A New Hope",
        "releaseDate": "1977-05-25"
    },
    {
        "id": 2,
        "episodeId": 5,
        "title": "The Empire Strikes Back",
        "releaseDate": "1980-05-17"
    }
]
```

## Actualizar un registro
> PUT

Body:

```json
{
  "title": "Play with Tú",
  "description": "play with her bird",
  "completed": false
}
```

Retun:

```json
{
    "id": 1,
    "episodeId": 4,
    "title": "A New Hope 2",
    "releaseDate": "1977-05-25"
}
```

## Eliminar un registro
> DELETE

```/{id}```

Retun:

```
Status 200
```




