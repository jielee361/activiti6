package me.chilam;

import org.activiti.engine.*;

/**
 * 流程引擎组件服务
 */
public class ProcessEngineService {
    public static void main(String[] args) {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        //创建流程引擎的对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        //获取各个业务组件
        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        IdentityService identityService = processEngine.getIdentityService();
        ManagementService managementService = processEngine.getManagementService();
        HistoryService historyService = processEngine.getHistoryService();
        DynamicBpmnService dynamicBpmnService = processEngine.getDynamicBpmnService();
    }
}
