#README

## 功能列表
1. 包括了自动生成代码的generator
2. 导入了lombok、mysql+jdbc+mybatis、redis、aop、fastjson、auth0、redis包
3. 全局异常捕捉
4. 自定义异常类
5. 基础的异常情况枚举
6. 所有Controller的AOP，打印请求入参和出参 
7. 登陆态（TokenUtils）
8. redis缓存整合 && 使用redis缓存设置分布式锁
9. pageHelper分页查询插件
10. 自动打包推送到服务器的Tomcat上
## demo
分支origin/typical_example为demo分支，基本可做到直接运行，查看如何使用
## 使用说明/步骤
1. 现在数据库建立对应的是实体类用于生成DAL
2. 将com.hanxun.demo修改为对应的包名
3. 将所有 todo 修改为对应的是数据
4. 使用mybatis-generator:generate 生成代码
5. **生成代码后，需要自己在Mapper类上加上@Mapper注解**
6. 在Mapper文件上都加上@Mapper注解
7. 开始 happy CURD
8. 运行时加入环境参数允许 `-Dspring.profiles.active=pre`
## 推荐辅助工具
可以使用：https://www.uiofield.top  来直接生成SQL创表命令
## 注意事项(踩坑记录)
1. 分多次生成DAL文件可能会导致报错，建议每次先删除xml文件，再全部重新生成
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
4. 数据库有字段为`TEXT`字段时，查询需要使用`selectByExampleWithBLOBs`方法，否则TEXT格式字段查询结果会为 null
5. 启动时报错：`Error parsing Mapper XML`，删掉所有XML文件重新生成DAL文件
6. 生成DAL文件后，Mapper类上需要加上@Mapper注解

