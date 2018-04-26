package me.chilam;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

import java.util.Map;

public class BuildEngineWithProcessEngines {
    public static void main(String[] args) {
        //初始化ProcessEngines的Map
        //再加载Activiti的默认配置文件（classpath下的activit-cfg.xml）
        //如果与Spring整合，则读取classpath下的activiti-context.xml文件
        ProcessEngines.init();
        Map<String,ProcessEngine> maps = ProcessEngines.getProcessEngines();
        maps.forEach((k,v)-> System.err.println(k+"-"+v.getName()));
    }
}
