# Test Project1

## Build and run from jar
    mvn clean package
    java -jar learn-spring/target/learn-spring.jar

## Run through maven command
```
	mvn spring-boot:run
```

## Test if your spring-boot application is running using web browser

    localhost:3194/test1
    localhost:3194/test2

## Test with curl command
```
curl -X GET 'http://localhost:3194/v1/ayon/controller/test1'
curl -X GET 'http://localhost:3194/v1/ayon/controller/test2'
curl -X GET 'http://localhost:3194/v1/ayon/controller/multiply/12'
curl -X DELETE 'http://localhost:3194/v1/ayon/controller/multiply/12/delete'
curl -X POST -H "Content-Type: application/json" -d '{"isBody":"false","id1":"xyz","someStupidId":"123321"}' 'http://localhost:3194/v1/ayon/controller/multiply/12/update'
```

## Other learning stuffs:

You have a collection of @beans that are initialized by @Autowired, values that are assigned to all the variables with @Autowired are initialized by those created @beans. To have @Value, @Beans to be seens by spring you need at least @Configutiaon/@SpringbootAppliccation/@RestController/.. on top of it

