#tomcat
docker build -t myboot .
docker run -d -p 8888:8080 myboot

#mysql
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=passwd -e MYSQL_DATABASE=test hub.c.163.com/library/mysql:latest