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


