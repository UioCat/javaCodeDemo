#!/bin/bash
# 服务器密码
PASSWORD=

mvn clean install -Dmaven.test.skip=true
mv ./target/*.war ./target/demo.war

/usr/bin/expect <<EOF
set IP_ARRAY {192.168.31.102 192.168.31.103}
foreach IP \$IP_ARRAY {
  spawn scp ./target/monitor.war root@\$IP:/usr/java/apache-tomcat-9.0.33/webapps
  expect {
   "(yes/no)?" {
     send "yes\n"
     expect "*assword:" { send "$PASSWORD\r"}
    }
    "*assword:" {
     send "$PASSWORD\r"
    }
  }
  expect 100%
  expect eof
}
EOF