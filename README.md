## 流程引擎配置及创建

### 流程引擎配置对象

org.activiti.engine.ProcessEngineConfiguration

- 读取默认配置文件

[me.chilam.DefaultConfiguration](./src/main/java/me/chilam/DefaultConfiguration.java)

    Activiti默认到ClassPath下读取名为“activiti.cfg.xml”的Activiti配置文件，启动并获取名称为“processEngineConfiguration”的bean的实例
```
ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
```

- 读取自定义配置文件

[me.chilam.CustomConfiguration](./src/main/java/me/chilam/CustomConfiguration.java)

- 自建配置

[me.chilam.StandConfigutation](./src/main/java/me/chilam/StandConfigutation.java)

### 数据源配置

[me.chilam.DatasourceConfiguration](./src/main/java/me/chilam/DatasourceConfiguration.java)

### 数据库策略配置

ProcessEngineConfiguration提供了databaseSchemaUpdate属性，使用该属性可以设置流程引擎启动和关闭时数据库执行的策略。

- false：false为默认值，设置为该值后，Activiti在启动时，会对比数据库表中保存的版本，如果没有表或者版本不匹配，将在启动时抛出异常。

- true：设置为该值后，Activiti会对数据库中所有的表进行更新，如果表不存在，则Activiti会自动创建。

- create-drop：Activiti启动时，会执行数据库表的创建操作；在Activiti关闭时，执行数据库表的删除操作。

### history配置

在流程执行的过程中，会产生一些流程相关的数据，例如流程实例、流程任务和流程参数等，随着流程的进行与结束，
这些数据将会被从流程数据表中删除，为了能保存这些数据，Activiti提供了历史数据表。

- none：不保存任何的历史数据，因此，在流程执行过程中，这是最高效的。

- activity：级别高于none，保存流程实例与流程行为，其他数据不保存。

- audit：除activity级别会保存的数据外

- full:保存历史数据的最高级别，除了会保存 audit 级别的数据外，还会保存其他全部流程相关的细节数据，包括一些流程参数等。


### asyncExecutorActivate配置

asyncExecutorActivate属性主要用于配置异步执行器是否启动，true则表示Activiti在创建流程引擎时，需要启动异步执行器，
该属性默认值为false。异步执行器启动后，会启动定时。

### Activiti的命令拦截器

基于命令模式和责任链模式设计。

- 自定义拦截器类 [me.chilam.MyInterceptor](./src/main/java/me/chilam/MyInterceptor.java)

- 自定义流程引擎配置类 [me.chilam.CustomProcessEngineConfiguration](./src/main/java/me/chilam/CustomProcessEngineConfiguration.java)

- activiti配置文件 [activiti-interceptor.xml](./src/main/resources/activiti-interceptor.xml)

- 测试类  [me.chilam.TestInterceptor](./src/main/java/me/chilam/TestInterceptor.java)

- 测试结果

```
19:59:53,402  INFO DefaultActiviti5CompatibilityHandlerFactory:38 - Activiti 5 compatibility handler implementation not found or error during instantiation : org.activiti.compatibility.DefaultActiviti5CompatibilityHandler. Activiti 5 backwards compatibility disabled.
自定义拦截器 org.activiti.engine.impl.SchemaOperationsProcessEngineBuild
19:59:53,468  INFO ProcessEngineImpl:87 - ProcessEngine default created
自定义拦截器 org.activiti.engine.impl.cmd.ValidateExecutionRelatedEntityCountCfgCmd
自定义拦截器 org.activiti.engine.impl.RepositoryServiceImpl$1
自定义拦截器 org.activiti.engine.impl.cmd.DeployCmd
自定义拦截器 org.activiti.engine.impl.cmd.GetNextIdBlockCmd
自定义拦截器 org.activiti.engine.impl.cmd.GetProcessDefinitionInfoCmd
自定义拦截器 org.activiti.engine.impl.cmd.StartProcessInstanceCmd
```


















    