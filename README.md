## 流程引擎对象

### 流程引擎对象的创建

- ProcessEngineConfiguration的buildProcessEngine方法

[me.chilam.BuildEngine](./src/main/java/me/chilam/BuildEngine.java) 

- ProcessEngines对象

init方法与getDefaultProcessEngine方法

[me.chilam.BuildEngineWithProcessEngines](./src/main/java/me/chilam/BuildEngineWithProcessEngines.java)

registerProcessEngine方法和unregister方法

[me.chilam.BuildEngineWithRegister](./src/main/java/me/chilam/BuildEngineWithRegister.java)

### org.activiti.engine.ProcessEngine

在Activiti中，一个ProcessEngine实例代表一个流程引擎，ProcessEngine中保存着各个服务组件的实例，根据这些服务组件，
可以操作流程实例、任务、系统角色等数据。

#### 服务组件

- org.activiti.engine.RepositoryService,管理流程定义和流程部署的API

- org.activiti.engine.RuntimeService,在流程运行时对流程实例进行管理和控制

- org.activiti.engine.TaskService,对流程任务进行管理，例如任务提醒，任务完成和创建任务

- org.activiti.engine.IdentityService,提供对流程角色数据进行管理的API,这些角色数据包括用户组，用户以及他们之间的关系

- org.activiti.engine.ManagementService,提供对流程引擎进行管理和维护的服务

- org.activiti.engine.HistoryService,对流程的历史数据进行操作，包括查询，删除这些历史数据等

- org.activiti.engine.DynamicBpmnService,使用该服务，可以不用重新部署流程模型，就可以实现对流程模型的部分修改



    