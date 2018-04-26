package me.chilam;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

import java.util.UUID;

public class UserManagement {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        IdentityService identityService = processEngine.getIdentityService();
        String genId = UUID.randomUUID().toString();
        User user = identityService.newUser(genId);
        user.setFirstName("casper");
        user.setLastName("chilam");
        user.setEmail("514644743@qq.com");
        user.setPassword("xxxx");
        //保存用户
        identityService.saveUser(user);
        identityService.createUserQuery().list().forEach(u-> System.err.println(u.getEmail()));
        identityService.setAuthenticatedUserId("");
    }
}
