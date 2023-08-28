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
- 2023年8月14日
  - 修改了AddLogServiceImpl的方法saveAddLog的入参
  - 修改MenuServiceImpl中getMenuTreeByUserId方法中获取全部菜单条件
  - 修改了MenuServiceImpl中findChildMenu方法更名为setChildMenu
  - 修改了PermsServiceImpl中addPerms方法的返回数据格式为Result
  - 注释了PermsServiceImpl中getExceptionMessage方法
- 2023年8月17日
  - 上传了JavaPractice，java基础练习
- 2023年8月21日

  - 增加了包exception
  - 在包exception下增加了自定义异常枚举类ErrorEnum，自定义异常处理类DefinitionException
  - 在配置包config下增加了全局异常处理器GlobalExceptionHandle
  - 增加了实体类Fileslog和对应的mapper，service和serviceimpl
  - 在IFileslogService下创建方法saveFilesLog，记录文件的信息，并在FileslogServiceImpl实现
  - 在control包下创建了filecontroler，新增用户文件上传下载功能
  - 增加FileService接口，增加FileServiceImpl实现用户文件上传下载功能，并在Fileslog中记录文件信息
- 2023年8月25日
  - 增加了数据传输对象AddlogDTO
  - 修改了AddlogMapper
  - 增加了控制层EchartsController，新增用户统计图表请求，并返回集合
  - 增加了服务层LogStatsService即对应LogStatsServiceImpl
  - LogStatsService下创建方法operatorStats，统计log表数据，并在LogStatsServiceImpl实现
