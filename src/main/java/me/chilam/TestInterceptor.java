package me.chilam;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.task.Task;

/**
 * 测试自定义Activiti拦截器
 * @author maxp
 */
public class TestInterceptor {
    public static void main(String[] args) {
        //获取流程引擎配置对象
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti-interceptor.xml");
        //获取流程引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        //部署流程
        processEngine.getRepositoryService().createDeployment().addClasspathResource("first.bpmn20.xml").deploy();
        //开始流程
        processEngine.getRuntimeService().startProcessInstanceByKey("pay");
    }
}
