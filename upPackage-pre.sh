#!/bin/bash
# 服务器密码
PASSWORD=
# war包名
PACKAGE_NAME=
# IP数组
IP_ARRAY="{}"

mvn clean install -Dmaven.test.skip=true -D profile.active=pre
mv ./target/*.war ./target/$PACKAGE_NAME

/usr/bin/expect <<EOF

foreach IP $IP_ARRAY {
  spawn scp ./target/$PACKAGE_NAME root@\$IP:/usr/java/apache-tomcat-9.0.33/webapps
  set timeout -1
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