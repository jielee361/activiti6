package me.chilam;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 读取默认的配置文件
 * @author chilam
 */
public class DefaultConfiguration {
    public static void main(String[] args) {
        //Activiti默认到ClassPath下读取名为“activiti.cfg.xml”的Activiti配置文件，启动并获取名称为“processEngineConfiguration”的bean的实例
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
    }
}
