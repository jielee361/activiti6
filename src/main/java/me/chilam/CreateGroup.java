package me.chilam;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

import java.util.List;
import java.util.UUID;

/**
 * 用户组创建
 */
public class CreateGroup {
    public static void main(String[] args) {
        //创建默认的流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //获取到身份服务组件
        IdentityService identityService = processEngine.getIdentityService();
        //创建组
        Group group = identityService.newGroup(UUID.randomUUID().toString());
        group.setName("成都");
        group.setType("chengdu");
        identityService.saveGroup(group);
        //查询用户组
        List<Group> groupList = identityService.createGroupQuery().list();
        groupList.forEach(g-> System.err.println(g.getId()+","+g.getName()+","+g.getType()));
        //删除所有的用户
        groupList.forEach(g-> identityService.deleteGroup(g.getId()));
        System.err.println("--------------------------------------------------------");
        identityService
                .createGroupQuery()
                .list()
                .forEach(g -> System.err.println(g.getId()+","+g.getName()+","+g.getType()));
    }
}
