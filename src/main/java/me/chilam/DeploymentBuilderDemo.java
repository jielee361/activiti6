package me.chilam;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;

public class DeploymentBuilderDemo {
    public static void main(String[] args) {
        //获取的默认流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //获取流程存储定义
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //获取流程部署器实例
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        //部署流程
        Deployment deployment = deploymentBuilder.addClasspathResource("first.bpmn20.xml").deploy();

    }
}
