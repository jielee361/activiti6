## 流程存储

### 流程文件部署

    RepositoryService负责对流程文件的部署以及流程的定义进行管理，不管是JBPM还是Activiti等工作流引擎，
    都会产生流程文件，工作流引擎需要对这些文件进行管理，这些文件包括流程描述文件，流程图等。
    
### 流程文件部署

#### org.activiti.engine.repository.Deployment 

    Deployment对象是一个接口，一个Deployment实例表示一条ACT_RE_DEPLOYMENT表的数据，
    同样，Deployment也遵循Activiti的实体命名规则，子接口为DeploymentEntityImpl。
    
#### org.activiti.engine.repository.DeploymentBuilder

[me.chilam.DeploymentBuilderDemo](./src/main/java/me/chilam/DeploymentBuilderDemo.java)

#### 流程定义权限

    对于一个用户或者用户组是否能操作(查看)某个流程定义的数据，需要进行相应的流程定义权限设置。在Activit中并没有
    对流程定义的权限进行检查，而是提供一种反向方法，让调用者去管理这些权限数据，然后提供相应的API让使用人决定哪些数据
    可以被查询。
   
- 设置流程定义的用户权限

[me.chilam.UserCandidate](./src/main/java/me/chilam/UserCandidate.java)