## 4.Activiti数据库

    在流程的产生，执行以及结束等周期，都会产生各种与流程相关的数据，Activiti提供了一整套的数据表来保存这些数据。

### 通用数据表

    通用数据表存放通用数据，不关心的有特定的流程或者业务，只用于存放资源。

- 资源表(ACT_GE_BYTEARRAY) 

```
create table act_ge_bytearray
(
  ID_            varchar(64)  not null primary key,
  REV_           int          null comment '数据版本',
  NAME_          varchar(255) null comment '资源名称',
  DEPLOYMENT_ID_ varchar(64)  null comment '流程部署id',
  BYTES_         longblob     null comment '资源内容',
  GENERATED_     tinyint      null comment '是否由Activiti自动生成',
  constraint ACT_FK_BYTEARR_DEPL
  foreign key (DEPLOYMENT_ID_) references act_re_deployment (ID_)
)
  comment '资源表'
  engine = InnoDB
  collate = utf8_bin;
```

- 属性表（ACT_GE_PROPERTY）

将全部的属性抽象key-value对，每个属性都有名称和值

### 流程存储数据表

    流程引擎使用仓储表来保存流程定义和部署信息这类数据
    
- 部署数据表（ACT_RE_DEPLOYMENT）

- 流程定义表（ACT_RE_PROCDEF）

```
create table act_re_procdef
(
  ID_                     varchar(64)             not null  primary key,
  REV_                    int                     null,
  CATEGORY_               varchar(255)            null comment '流程定义的分类',
  NAME_                   varchar(255)            null comment '流程定义的名字',
  KEY_                    varchar(255)            not null comment '流程定义的KEY',
  VERSION_                int                     not null,
  DEPLOYMENT_ID_          varchar(64)             null comment '流程定义对应的部署数据ID',
  RESOURCE_NAME_          varchar(4000)           null comment '流程定义对应的资源名称，一般为流程文件的相对路径',
  DGRM_RESOURCE_NAME_     varchar(4000)           null comment '流程定义对应的流程图资源名称',
  DESCRIPTION_            varchar(4000)           null,
  HAS_START_FORM_KEY_     tinyint                 null,
  HAS_GRAPHICAL_NOTATION_ tinyint                 null,
  SUSPENSION_STATE_       int                     null comment '流程定义的状态',
  TENANT_ID_              varchar(255) default '' null,
  ENGINE_VERSION_         varchar(255)            null,
  constraint ACT_UNIQ_PROCDEF
  unique (KEY_, VERSION_, TENANT_ID_)
)
  comment '流程定义表'
  engine = InnoDB
  collate = utf8_bin;
```

### 身份数据表

- ACT_ID_INFO

- ACT_ID_GROUP

- ACT_ID_MEMBERSHIP

### 运行时数据表

    运行时数据表用来保存流程在运行过程中所产生的数据，例如流程实例、执行流、任务等。运行时数据表的名称以ACT_RU开头，
    “RU”是单词runtime的缩写。

- 流程实例表ACT_RU_EXECUTION

    流程启动后，会产生一个流程实例，同时会产生相应的执行流，流程实例和执行流数据均被保存

- 流程任务表 ACT_RU_TASK

    流程在运行过程中所产生的任务数据保存
    
- 流程参数表 ACT_RU_VARIABLE

    参数包括流程实例参数、执行流参数和任务参数，参数有可能会有多种类型，因此该表使用多个字段来存放参数值。
 
- 流程与身份关系表 ACT_RU_IDENTITYLINK

    用户或者用户组与流程数据之间的关系
    
- 工作数据表

    在流程执行的过程中，会有一些工作需要定时或者重复执行，这类工作数据被保存到工作表中，
Activiti提供了四个工作表用于保存不同的工作数据。

    - ACT_RU_JOB：一般工作表。

    - ACT_RU_DEADLETTER_JOB：无法执行工作表，用于存放无法执行的工作。

    - ACT_RU_SUSPENDED_JOB：中断工作表，中断工作产生后，会将工作
    
    - ACT_RU_TIMER_JOB：定时器工作表，用于存放定时器工作。
    
- 事件描述表 ACT_RU_EVENT_SUBSCR

如果流程到达某类事件节点，Activiti会往ACT_RU_EVENT_SUBSCR表中加入事件描述数据，这些事件描述数据将会决定流程事件的触发。

### 历史数据表

- 流程实例表ACT_HI_PROCINST

    流程实例的历史数据

- 流程明细表 （ACT_HI_DETAIL）
    
    记录流程执行过程中的参数或者表单数据，由于在流程执行过程中，会产生大量这类数据，因此默认情况下，
    Activiti不会保存流程明细数据，除非将流程引擎的历史数据（history）配置为full。

- 历史任务表和历史行为表 （ACT_HI_TASKINST）

    当流程到达某个任务节点时，就会向历史任务表（ACT_HI_TASKINST）中写入历史任务数据，该表与运行时的任务表类似。
    历史行为表（ACT_HI_ACTINST）会记录每一个流程活动的实例，一个流程活动将会被记录为一条数据，
    根据该表可以追踪最完整的流程信息。   

- 附件表和评论表

    使用任务服务（TaskService）的API，可以添加附件和评论，
    这些附件和评论的数据将会被保存到ACT_HI_ATTACHMENT和ACT_HI_COMMENT表中。

### DMN规则引擎数据表

- 决策部署表ACT_DMN_DEPLOYMENT，保存决策数据

- 决策表ACT_DMN_DECISION_TABLE

- 部署资源表ACT_DMN_DEPLOYMENT_RESOURCE，规则引擎相关的资源

  