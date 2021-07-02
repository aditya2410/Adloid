# Spring_boot_redis_web_app

This is web application which performs following basic tasks:<p>
1) Register a user and collects following information:<p>
  1.1) Email ID<p>
  1.2) Name<p>
  1.3) Age<p>
  1.4) Occupation<p>
2) Let a user search for his registered information using his email ID as key.<p>


Web Famework used: Spring Boot (v2.4.3)<p>
in-memory Data Cache technology used : Redis<p>

Dependencies:
1) spring-boot-starter-web
2) spring-boot-starter-data-redis
3) spring-boot-starter-thymeleaf
4) Java Redis Client Library: Jedis (v3.3.0)


How to Run->
1) Download and start Redis Docker image <p>
CMD: docker pull redis <p>
CMD: docker run --rm -p 4025:6379 -d --name redis-1 redis redis-server<p>

2) Dowload docker image for this app <p>
CMD: docker pull aditya2410/adloidapp <p>

3) Create Docker Network for communication between 2 dockers <p>
CMD: docker network create spring-redis-network <p>

4) Add redis-1 to network <p>
CMD: docker network connect spring-redis-network redis-1 <p>

5) Run the app and add it to spring-redis-network as wel <p>
CMD: docker run --net spring-redis-network -p 8080:8080 aditya2410/adloidapp <p>

Note: make sure there is no other redis-server running on the host machine else HostName for redis server (running in redis-1) may change <p>

After following the above process, you can launch the website on your system by using below URL.
URL: http://localhost:8080/
