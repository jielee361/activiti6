package me.chilam;

import org.activiti.engine.*;
import org.activiti.engine.task.Task;

/**
 * @author chilam
 */
public class FirstActiviti {
    public static void main(String[] args) {
        //创建流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //获取流程存储服务组件
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //获取运行时服务组件
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //获取流程任务组件
        TaskService taskService = processEngine.getTaskService();
        //部署流程文件
        repositoryService.createDeployment().addClasspathResource("first.bpmn20.xml").deploy();
        //启动流程
        runtimeService.startProcessInstanceByKey("pay");
        //查询第一个任务
        Task task = taskService.createTaskQuery().singleResult();
        System.err.println("第一个任务，当前任务名称: " +task.getName());
        //完成一个任务
        taskService.complete(task.getId());
        //查询第二个任务
        task = taskService.createTaskQuery().singleResult();
        System.err.println("第二个任务，当前任务名称：" + task.getName());
        //完成第二个任务(流程结束)
        taskService.complete(task.getId());
        task = taskService.createTaskQuery().singleResult();
        System.err.println("流程结束后，查找任务: " + task);
        //退出
        System.exit(0);
    }
}
