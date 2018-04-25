package me.chilam;

import org.activiti.engine.ProcessEngineConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读取自定义配置文件
 * @author maxp
 */
public class CustomConfiguration {
    public static void main(String[] args) {
        //传入自定义配置文件路径
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activit.xml");
        //传入自定义配置文件路径和bean的名称
        ProcessEngineConfiguration processEngineConfiguration1 = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activit.xml","processBean");
        //传入输入流
        try{
            File file = new File("resource/input-stream.xml");
            InputStream is = new FileInputStream(file);
            ProcessEngineConfiguration processEngineConfiguration2 = ProcessEngineConfiguration.createProcessEngineConfigurationFromInputStream(is);
        }catch (IOException e){
        }
    }
}
