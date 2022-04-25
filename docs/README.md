```shell
cd HIS-master
git pull
mvn package
mvn clean package

sudo yum install rabbitmq-server
sudo systemctl start rabbitmq-server
sudo systemctl enable rabbitmq-server
sudo systemctl status rabbitmq-server
rabbitmq-plugins enable rabbitmq_management
rabbitmqctl list_users
user:guest
pwd:guest
#rabbitmqctl add_user 用户名 密码  
sudo rabbitmqctl add_user his his

sudo rabbitmqctl set_user_tags his administrator
sudo rabbitmqctl set_permissions -p / his '.*' '.*' '.*'
sudo rabbitmqctl add_vhost /his
sudo rabbitmqctl set_permissions -p /his his '.*' '.*' '.*'

sudo vim /etc/redis.conf
requirepass 123456
sudo systemctl restart redis
Password123@redis

java -jar HIS-api/target/HIS-api-1.0-SNAPSHOT.jar

http://49.232.6.131:8073/

cd HIS-web
cnpm install
cnpm install core-js@2
npm run dev
npm run build:prod

mysql -h127.0.0.1 -uroot -p
create database his default character set utf8mb4 collate utf8mb4_unicode_ci;
use his;
create user 'his'@'127.0.0.1' identified by 'his123456';
grant all privileges on his.* to 'his'@'127.0.0.1';
create user 'his'@'%' identified by 'his123456';
grant all privileges on his.* to 'his'@'%';
flush privileges;

mysql -h127.0.0.1 -uroot -p his < document/mysql/his.sql
```

```shell
centos rabbitmq
rabbitmq add host
```

```
his-cloud-api-app/target/his-cloud-api-app-1.0.0-SNAPSHOT.jar          his-cloud-service-dms/target/his-cloud-service-dms-1.0.0-SNAPSHOT.jar
his-cloud-api-pc/target/his-cloud-api-pc-1.0.0-SNAPSHOT.jar            his-cloud-service-pms/target/his-cloud-service-pms-1.0.0-SNAPSHOT.jar
his-cloud-config/target/his-cloud-config-1.0.0-SNAPSHOT.jar            his-cloud-service-sms/target/his-cloud-service-sms-1.0.0-SNAPSHOT.jar
his-cloud-eureka/target/his-cloud-eureka-1.0.0-SNAPSHOT.jar            his-cloud-zipkin/target/his-cloud-zipkin-1.0.0-SNAPSHOT.jar
his-cloud-monitor/target/his-cloud-monitor-1.0.0-SNAPSHOT.jar          his-cloud-zuul/target/his-cloud-zuul-1.0.0-SNAPSHOT.jar
his-cloud-service-bms/target/his-cloud-service-bms-1.0.0-SNAPSHOT.jar
```