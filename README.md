## 功能列表
1. 包括了自动生成代码的generator
2. 导入了lombok、mysql+jdbc+mybatis、redis、aop、fastjson、auth0、redis包
3. 全局异常捕捉
4. 自定义异常类
5. 基础的异常情况枚举
6. 所有Controller的AOP，打印请求入参和出参 
7. 登陆态（TokenUtils）
8. redis缓存整合 && 使用redis缓存设置分布式锁
## 使用说明/步骤
1. 现在数据库建立对应的是实体类用于生成DAL
2. 将com.hanxun.demo修改为对应的包名
3. 将所有 todo 修改为对应的是数据
4. 使用mybatis-generator:generate 生成代码
5. **生成代码后，需要自己在Mapper类上加上@Mapper注解**
6。在Mapper文件上都加上@Mapper注解
7. 开始 happy CURD
## 推荐辅助工具
可以使用：https://www.uiofield.top  来直接生成SQL创表命令
## 注意事项(踩坑记录)
1. 分多次生成DAL文件可能会导致报错，建议每次都直接所有表都生成一遍


