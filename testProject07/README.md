# Test Project7

This project is about adding swagger support in spring-boot


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

1. There is an extra file SwaggerConfiguration that defines some basic things about swagger in this project
2. Also anohter file swagger.properties that contains some other things
3. Take a look at the banner I generated that, all you need to do is put a file named `banner.txt` in resource folder, spring does the rest



## What is swagger-ui:

Its a tool that helps you to have a really nice documentation of all your apis
Supposer you have a GET method it will show you whats the url and also show you some examples, also you can call the GET method from the swaggers webinterface (http://localhost:3194/swagger-ui.html) using proper param values.

Here is a good swagger example page:
http://petstore.swagger.io/
Explore it and have fun:D