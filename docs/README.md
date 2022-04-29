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
bind 0.0.0.0
port 6381
#requirepass 123456
sudo systemctl restart redis
sudo systemctl stop redis
Password123@redis
file

java -jar HIS-api/target/HIS-api-1.0-SNAPSHOT.jar
nohup java -jar HIS-api/target/HIS-api-1.0-SNAPSHOT.jar &

http://49.232.6.131:8073/

cd HIS-web
cnpm install
cnpm install core-js@2
npm run dev
npm run build:prod
cnpm install --save @vue/composition-api

https://pelican.7otech.com/login/oauth/authorize?client_id=a07d0ddd8eaee128d94c&response_type=code&redirect_uri=http%3A%2F%2Flocalhost%3A1024https%3A%2F%2Fhis.7otech.com%2Fprod-api%2Fcallback&scope=read&state=application_his
http://localhost:1024/callback?code=cb82a3b6978fdb318207&state=application_his#/login?redirect=%2Findex

mysql -h127.0.0.1 -uroot -p
create database his default character set utf8mb4 collate utf8mb4_unicode_ci;
use his;
create user 'his'@'127.0.0.1' identified by 'his123456';
grant all privileges on his.* to 'his'@'127.0.0.1';
create user 'his'@'%' identified by 'his123456';
grant all privileges on his.* to 'his'@'%';
flush privileges;

mysql -h127.0.0.1 -uroot -p his < document/mysql/his.sql

mysql -h127.0.0.1 -uroot -p
use his
select * from sms_staff;
select * from pms_patient;

http://49.232.6.131:8073/appRegistration/listDeptDoctor?deptId=1
select id, username, password, status, create_time, gender, skd_flag, title, name, dept_id, role_id, registration_rank_id from sms_staff WHERE ( dept_id = 1 and registration_rank_id = 2 and status = 1 );
select * from sms_staff WHERE ( dept_id = 1 );
select * from sms_staff WHERE ( dept_id = 1 and registration_rank_id = 2 and status = 1 );
update sms_staff set registration_rank_id=2;

https://his.7otech.com/
演示用户
test

https://his.7otech.com/prod-api

https://his.7otech.com/h5
120165199006291010
2019060618171000

git checkout -b dromara-main main
git pull git@github.com:dromara/MaxKey.git main

LATEST-RELEASE=curl xxx
docker run -p 8000:8000 casbin/casdoor-all-in-one:$LATEST-RELEASE

sudo docker run -p 8091:8000 casbin/casdoor-all-in-one
http://49.232.6.131:8091/
http://172.21.16.11:8091/
admin
123

https://his.7otech.com/prod-api/callback
```

```shell
centos rabbitmq
rabbitmq add host

https://ext.dcloud.net.cn/plugin?name=compile-node-sass

spring ldap
https://juejin.cn/post/6844903581410131981
https://www.jianshu.com/p/3aeb49a9befd

casbin

casdoor
https://www.cnblogs.com/casbin/p/16136664.html
https://github.com/casdoor/casdoor-java-sdk
https://github.com/casdoor/casdoor-spring-boot-starter

casdoor jwt-public-key
https://www.bookstack.cn/read/casdoor-1.12-zh/d26ecc986ea325dd.md
```

```
his-cloud-api-app/target/his-cloud-api-app-1.0.0-SNAPSHOT.jar          his-cloud-service-dms/target/his-cloud-service-dms-1.0.0-SNAPSHOT.jar
his-cloud-api-pc/target/his-cloud-api-pc-1.0.0-SNAPSHOT.jar            his-cloud-service-pms/target/his-cloud-service-pms-1.0.0-SNAPSHOT.jar
his-cloud-config/target/his-cloud-config-1.0.0-SNAPSHOT.jar            his-cloud-service-sms/target/his-cloud-service-sms-1.0.0-SNAPSHOT.jar
his-cloud-eureka/target/his-cloud-eureka-1.0.0-SNAPSHOT.jar            his-cloud-zipkin/target/his-cloud-zipkin-1.0.0-SNAPSHOT.jar
his-cloud-monitor/target/his-cloud-monitor-1.0.0-SNAPSHOT.jar          his-cloud-zuul/target/his-cloud-zuul-1.0.0-SNAPSHOT.jar
his-cloud-service-bms/target/his-cloud-service-bms-1.0.0-SNAPSHOT.jar
```