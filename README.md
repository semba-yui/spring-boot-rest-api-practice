# spring-boot-rest-api-practice

## Build 

```shell
aws ecr-public get-login-password --region us-east-1 | docker login --username AWS --password-stdin public.ecr.aws/a8g6a9t3
```

```shell
docker build --no-cache --tag practice/spring-boot/demo-api .
```

```shell
docker tag practice/spring-boot/demo-api:latest public.ecr.aws/a8g6a9t3/practice/spring-boot/demo-api:latest
```

```shell
docker push public.ecr.aws/a8g6a9t3/practice/spring-boot/demo-api:latest
```
