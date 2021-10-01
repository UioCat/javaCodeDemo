# 打包上传脚本
mvn clean install -Dmaven.test.skip=true
mv ./target/xxxxx.war ./target/xxxx.war
scp ./target/xxxx.war root@116.62.4.111:/usr/java/apache-tomcat-9.0.33/webapps