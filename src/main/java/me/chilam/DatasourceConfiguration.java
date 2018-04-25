package me.chilam;

import org.activiti.engine.ProcessEngineConfiguration;

import javax.sql.DataSource;

/**
 * @author maxp
 * 数据原对象配置
 */
public class DatasourceConfiguration  {
    public static void main(String[] args) {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti-datasource.xml");
        DataSource dataSource = processEngineConfiguration.getDataSource();
        try{
            System.err.println(dataSource.getConnection().getMetaData().getDatabaseProductVersion());
        }catch (Exception e){

        }
    }
}
