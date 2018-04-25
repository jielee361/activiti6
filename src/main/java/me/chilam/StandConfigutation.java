package me.chilam;

import org.activiti.engine.ProcessEngineConfiguration;

public class StandConfigutation {
    public static void main(String[] args) {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration();
        System.err.println(processEngineConfiguration.getDatabaseSchemaUpdate());//create-drop
        System.err.println(processEngineConfiguration.getJdbcUrl());//jdbc:h2:mem:activiti

        ProcessEngineConfiguration processEngineConfiguration1 = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        System.err.println(processEngineConfiguration1.getDatabaseSchemaUpdate());//false
        System.err.println(processEngineConfiguration1.getJdbcUrl());//jdbc:h2:tcp://localhost/~/activiti
    }
}
