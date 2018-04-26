package me.chilam;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class BuildEngine {
    public static void main(String[] args) {
        //读取配置
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("build-engine.xml");
        //创建processEngine
        ProcessEngine processEngine = configuration.buildProcessEngine();
    }
}
