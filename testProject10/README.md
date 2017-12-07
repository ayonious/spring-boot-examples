# Test Project9

This project is about adding Excecption Handling in Controller.
You can control for which exception caught in controller level what to return and response

## Create mysql container
Create mysql docker image and run it as mentioned in folder mysql-docker-image-running

## Running instructions
```
mvn spring-boot:run
```
Now open the browser in
```
http://localhost:3194/swagger-ui.html
```

## Things to notice in this project

1. exceptions folder that contains all the exceptions
2. Look at all user-error-path.feature to understand how the exceptions are supposed to output
