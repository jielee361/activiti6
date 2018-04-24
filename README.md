## activiti6

### 1.Activit介绍

#### 1.1 工作流介绍

- 工作流是对工作流程及其各操作步骤之间的业务规则的抽象，概括，描述。

- 工作流建模，即将工作流程中的工作如何前后的组织在一起的逻辑和规则在计算机中以恰当的模型进行表示并对其实施计算。

- 工作流要解决的主要问题是，为实现业务目标，在多个参与者之间，利用计算机，按照某种预定的规则自动传递文档，信息和任务。

- 工作流管理系统的主要功能是通过计算机技术的支持去定义、执行和管理工作流，协调工作流执行过程中工作之间以及群体成员之间的信息交互。

#### 1.2 BPMN2.0 

- Business Process Modeling Notation

- BPMN规范的发布是为了让业务流程的全部参与人员对流程进行可视化的管理，提供一套让所有人能够理解语言和标记。

- BPMN2.0规范定义了业务流程的符号以及模型，并且为流程定义设定了转换格式，目的是为了让流程的定义实现可移植性。

- BPMN2.0元素

    - 流对象(Flow Objects)，在一个业务流程中，流对象是用于定义行为的图形元素，主要有Events,Activities,Gateways
    - 数据，主要有Data Objects,Data Inputs,Data Outputs,Data Stores
    - 连接对象，用于连接流对象，Sequence Flows,Message Flows,Association,Data Association
    - 泳道，用于组织基础的模型元素，Pools ,Lanes
    - 制品，用于为流程提供附加信息，Group和Text Annotation
    - Events,用于描述流程中发生的事件，事件会对流程产生影响，事件会被触发或者产生结果
    - Activities,活动是工作流中的一个术语，活动包括任务和子流程
    - Gateways,网关主要用于控制流程中顺序流的走向，使用网关可以控制流程进行分支和合并
    - Sequence Flow,显示流程将会执行哪个活动
    - Message Flows,主要用于显示消息在流程参与者之间的传递
    - Associations,主要用于连接流程元素与其制品之间的关系
    - Pool,存放道的容器
    - Lane,用于区分流程参与人的职能范围
    - Data Objects,主要表示活动需要的或者产生的信息
    - Message,主要用于描述流程参与者之间的沟通内容
    - Group,主要用于存放一些流程信息，包括流程文档，流程分析等信息
    - Text Annotation,主要为阅读流程图的人提供附加的文字信息

### 2.安装与运行Activiti

#### 2.1下载与安装

-  [activiti6.0下载](https://github.com/CasperMXP/Activiti/releases/tag/activiti-6.0.0)

- 下载解压后得到activiti-6.0.0目录，该目录下有3个子目录：database,libs,wars.

    - database，用于存放Activiti数据库建模初始化脚本，create,drop,upgrade
    - libs,存放本版本activiti所发布的jar包，也包含相应的源码
    - wars,activiti-app.war,activiti-admin.war,activiti-rest.war
 
#### 2.2关于activiti-app.war和activiti-admin.war使用

##### 部署activiti-app.war和activiti-admin.war

[](./doc/activiti-01.png)   

##### 访问activiti-app路径(http://192.168.17.18:8080/activiti-app/#/login), 用户名/密码(admin/test)
 
[](./doc/act-02.png)

[](./doc/act-03.png)

- Kickstart App,主要用于流程模型管理，表单管理以及应用管理，一个应用可以包含多个流程模型，应用可发布给其他用户使用。

- Task App，用于管理整个activiti-app的任务，该功能里面也可以启动流程

- Identity management，身份信息管理，可管理用户，用户组等数组





    