# springBootRedisBlock
Example of the issue I was having with spring async Redis client blocking if nested

# Steps to reproduce
1. Start local redis on port 6379
2. Insert to redis `redis-cli SET /value1 "some value"`   
3. Start the spring-boot app: `./mvnw spring-boot:run`
4. Make request to `http://localhost:8080/simple` to check all is OK. You should get the `some value` back.
5. Make request to `http://localhost:8080/nested`

Step #5 will result in command timed out error.

# Why is this failing
Why are we not getting any value from the nested Redis call?

Code found at [RedisRestController.java](src/main/java/com/nakoradio/puuhamaa/springbootredisblock/RedisRestController.java)

