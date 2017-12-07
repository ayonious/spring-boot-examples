Create Docker image:
```
docker run --name booking-mysql --env MYSQL_ALLOW_EMPTY_PASSWORD="yes" -p 3306:3306 -d mysql:5.7
```

Enter the docker image:
```
docker exec -it booking-mysql /bin/bash
mysql
```

Create database and users:
```
CREATE USER 'ayon'@'%' IDENTIFIED BY 'ayon123pass'; 
GRANT ALL ON *.* TO 'ayon'@'%';
CREATE DATABASE ayondb DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
```