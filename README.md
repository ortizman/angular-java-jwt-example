# ttps-jwt
Ejemplo de como authorizar un usuario usando JWT con Java y Angular

## Clonar el repo

``` git clone git@github.com:ortizman/ttps-jwt.git ```

> Alternativamente, se pueden descargar el codigo fuente sin usar git desde [aca](https://github.com/ortizman/ttps-jwt/archive/master.zip)
## Levantar el Cliente
El cliente esta construido usando Angular 7. 

1. Ingresar a la carpeta __client__  
    ```cd client/angular-jwt-auth ```
1. Usar el __cli__ de angular para levantar el frontend  
    ```ng serve --open```
    > Pueden instalar el cli de angular usando el comando:   
    ```npm install -g @angular/cli ```

## Levantar el Server
Para poder hacer login en el frontend, es necesario que el server este levantado

**Alternatica 1**: Importar el proyecto dentro del folder __server__ en el IDE (IDEA, Eclipse, etc) y levantar el proyecto usando Tomcat o Jetty. 
> Desde el frontend se asume que el server esta escuchando en http://localhost:8080/jwt

**Alternatica 2**: 
1. Ingresar a la carpeta __server__  
    ```cd server/jwt ```
1. Compilar  
    ```./mvnw clean package```
1. Ejecutar  
    ```export SERVER_CONTEXT_PATH=/jwt && java -jar target/jwt.war```
