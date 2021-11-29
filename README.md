## 功能列表
1. 包括了自动生成代码的generator
2. 导入了lombok、mysql+jdbc+mybatis、redis、aop、fastjson、auth0、redis包
3. 全局异常捕捉
4. 自定义异常类
5. 基础的异常情况枚举
6. 所有Controller的AOP，打印请求入参和出参 
7. 登陆态（TokenUtils）
8. redis缓存整合 && 使用redis缓存设置分布式锁
9. pageHelper分页查询
## 使用说明/步骤
1. 在MySQL中创建demo_tes库，并将demo_test.sql导入数据库
2. 将数据库密码设置成123456,. 或 将项目中两处数据库密码对应修改
3. 将Redis密码设置称123456,. 或 将项目中一处Redis密码对应修改
4. 即可运行项目
## 推荐辅助工具
可以使用：https://www.uiofield.top  来直接生成SQL创表命令
## 注意事项(踩坑记录)
1. 分多次生成DAL文件可能会导致报错，建议每次都直接所有表都生成一遍
2. 在使用mybatis-generator插件时，可能会提示格式错误，在最后加一行，再试试
```
<!--
<table tableName="department" domainObjectName="Department" enableCountByExample="false"  enableDeleteByExample="false" enableSelectByExample="false" enableUpdateByExample="false"/>
-->
```
3. 可能在启动项目时，直接finish，注释掉，在启动试试
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-tomcat</artifactId>
	<scope>provided</scope>
</dependency>
```

