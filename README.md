# workdemo

## 笔记.md

- 2023年8月1日

  在springboot下添加了笔记：拦截器Interceptor

## springdemo

- 2023年8月1日上传
  - 增加了拦截器LoginCheckInterceptor
  - 增加了配置类WebConfig
  - 移除了UserController中的userId，deptId
  - 在LoginController中获取userId，deptId生成token
- 2023年8月5日
  - 增加了接口LoginService，MenuService，PermsSerice和对应的Impl
  - 增加了实体类UserMenu，Menu以及对应的Mapper
  - 重命名了UserController为UserInfoController，并修改为接收信息查询请求并返回
  - LoginServiceImpl验证用户名和密码，并将权限信息封装进token返回
  - PermsSericeImpl获取token并解析出typeId
  - MenuServiceImpl获取typeid，匹配UserMenu表，并返回用户权限的菜单目录

- 2023年8月12日
  - 增加了实体类Log，Addlog以及对应的Mapper
  - 增加了实体类MenuDTO获取存储子菜单并传回Menu根节点（需改进）
  - 增加了接口ILogService，IAddlogSerice和对应的Impl
  - 增加了自定义接口@Log（未使用）
  - 增加了AOP方法LogAspect（未使用）
  - IAddLogServiceImpl获取方法状态并传输到数据库存储
  - 在PermsSericeImpl的AddPerms方法增加了try...catch...finally...并在其中捕获方法异常类型和方法运行结果传回AddLog表中
