package me.chilam;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;

/**
 * 注册和取消的engine
 */
public class BuildEngineWithRegister {
    public static void main(String[] args) {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("register.xml");
        //创建流程引擎对象,其实就相当于注册了流程引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        java.util.Map<String,ProcessEngine> maps = ProcessEngines.getProcessEngines();
        maps.forEach((k,v) -> System.err.println(k + "--" + v.getName()));
        //取消注册的流程引擎
        ProcessEngines.unregister(processEngine);
        maps.forEach((k,v) -> System.err.println(k + "--" + v.getName()));
    }
}
