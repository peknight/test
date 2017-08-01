namespace java com.peknight.test.thrift.service

enum ActionStatus {
    Success = 0,
    Fail = 1
}

struct ActionResult {
    1:ActionStatus status,
    2:string message,
    3:string value
}

struct BeanInfo {
    1:string type,
    2:string beanName
}

struct ConstructorInfo {
    1:list<ObjectInfo> paramList
}

struct ObjectInfo {
    1:string type,
    2:string value,
    3:list<ConstructorInfo> constructorList
}

struct MethodInfo {
    1:string methodName,
    2:list<ObjectInfo> paramList
}

service SystemService {

    /**
     * 列出所有的bean
     */
    list<BeanInfo> listBeans(),

    /**
     * 列出所有bean方法
     */
    list<MethodInfo> listBeanMethods(1:BeanInfo beanInfo),

    /**
     * 创建一个对象
     */
    ObjectInfo createObject(1:string className),

    /**
     * 列出所有对象方法
     */
    list<MethodInfo> listObjectMethods(1:ObjectInfo objectInfo),

    /**
     * 列出所有类方法
     */
    list<MethodInfo> listClassMethods(1:string className),

    /**
     * 执行bean方法
     */
    ActionResult invokeBeanMethod(1:BeanInfo beanInfo, 2:MethodInfo methodInfo),

    /**
     * 执行对象方法
     */
    ActionResult invokeObjectMethod(1:ObjectInfo objectInfo, 2:MethodInfo methodInfo),

    /**
     * 执行类方法
     */
    ActionResult invokeClassMethod(1:string className, 2:MethodInfo methodInfo),

    /**
     * 一定时间后开启服务
     */
    ActionResult startService(1:string serviceName),

    /**
     * 一定时间后暂停服务
     */
    ActionResult pauseService(1:string serviceName),

    /**
     * 一定时间后重启服务
     */
    ActionResult restartService(1:string serviceName),

    /**
     * 一定时间后终止服务
     */
    ActionResult shutService(1:string serviceName),

    /**
     * 初始化环境
     */
    ActionResult initEnvironment(),

    /**
     * 初始化开发环境
     */
    ActionResult initDevEnvironment(),

    /**
     * 初始化环境
     */
    ActionResult restoreEnvironment(),

    /**
     * 初始化开发环境
     */
    ActionResult restoreDevEnvironment(),

    /**
     * 一定时间后关闭程序
     */
    ActionResult shutdown()
}