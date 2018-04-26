package me.chilam;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.IdentityLink;

import java.util.List;
import java.util.UUID;

public class UserCandidate {
    public static void main(String[] args) {
        //创建流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        IdentityService identityService = processEngine.getIdentityService();
        //部署流程
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("first.bpmn20.xml")
                .deploy();
        //查询流程定义实体
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();
        //写入用户数据
        String userId = UUID.randomUUID().toString();
        User user = identityService.newUser(userId);
        user.setPassword("xxxx");
        user.setLastName("sssss");
        user.setLastName("xxxx");
        identityService.saveUser(user);
        //设置用户与流程定义的权限
        repositoryService.addCandidateStarterUser(processDefinition.getId(),user.getId());
        //根据用户查询有权限的流程定义
        List<ProcessDefinition> processDefinitionList = repositoryService
                .createProcessDefinitionQuery()
                .startableByUser(userId)
                .list();
        processDefinitionList.forEach(pd -> System.err.println(pd.getName()));
        //根据流程查询用户数据
        List<User> userList = identityService
                .createUserQuery()
                .potentialStarter(processDefinition.getId())
                .list();
        userList.forEach(u -> System.err.println(u.getId()));
        //根据流程定义查询全部IdentityLink
        List<IdentityLink> links = repositoryService
                .getIdentityLinksForProcessDefinition(processDefinition.getId());
        links.forEach(il -> System.err.println(il.getUserId()+"--"+il.getProcessDefinitionId()));
    }
}
