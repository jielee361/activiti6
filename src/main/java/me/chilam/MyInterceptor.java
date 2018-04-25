package me.chilam;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandConfig;
import org.activiti.engine.impl.interceptor.CommandInterceptor;

/**
 * 自定义拦截器
 */
public class MyInterceptor implements CommandInterceptor {

    private CommandInterceptor next;

    @Override
    public <T> T execute(CommandConfig config, Command<T> command) {
        System.err.println("自定义拦截器 " + command.getClass().getName());
        //然后让责任链中的下一请求处理者处理命令
        return getNext().execute(config,command);
    }

    @Override
    public CommandInterceptor getNext() {
        return this.next;
    }

    @Override
    public void setNext(CommandInterceptor next) {
        this.next = next;
    }
}
