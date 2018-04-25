package me.chilam;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.CommandInterceptor;

import java.util.ArrayList;

/**
 * 自定义流程引擎配置类
 */
public class CustomProcessEngineConfiguration extends ProcessEngineConfigurationImpl {

    @Override
    public CommandInterceptor createTransactionInterceptor() {
        return null;
    }

    @Override
    public void initCommandInterceptors() {
        //为父类的命令集合添加拦截器
        customPostCommandInterceptors = new ArrayList<>();
        //将拦截器加入集合
        customPostCommandInterceptors.add(new MyInterceptor());
        //再调用父类的初始化方法
        super.initCommandInterceptors();
    }
}
