package com.radzik.michal.shop.config;

import com.radzik.michal.shop.quartz.QuartzJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob()
                .ofType(QuartzJob.class)
                .withIdentity("sampleId")
                .withDescription(" quartz job")
                .storeDurably()
                .build();

    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetail jobDetail){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetail);
        cronTriggerFactoryBean.setName("sample Trigger");
        cronTriggerFactoryBean.setCronExpression("0/9 * * ? * * *");
        return cronTriggerFactoryBean;
    }

}
