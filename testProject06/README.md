# Test Project6

This project is about unit tests in spring, its an extension of project 5 with some jpa realated tests with it.



## Things to notice in tests

1.  There is a separate application.yml only for configuring test H2 inmenory database
2.  schema.sql, data.sql is something that is by default used for initialize the test H2 database
3.  Inside `application.yml`
    ```
       username: sa
       passowrd: <nothing>
    ```   
    This is h2's default username and passowrd

3.  PersonRepositoryTest: @SpringBootTest

    This will load entire spring context thats why it will take some time to start
    Also every @Test method will use the same instance of the H2    
    
4.  PersonRepositoryTest2: @DataJpaTest

    Load only the jpa classes necesary for this test
   
