mv ../maku-cloud-gateway/target/*.jar ./maku-cloud-gateway.jar
mv ../maku-cloud-system/target/*.jar ./maku-cloud-system.jar
mv ../app-user/target/*.jar ./app-user.jar
mv ../app-iot/target/*.jar ./app-iot.jar
mv ../maku-cloud-new/target/*.jar ./maku-cloud-new.jar

docker-compose down
docker-compose build
docker-compose up -d