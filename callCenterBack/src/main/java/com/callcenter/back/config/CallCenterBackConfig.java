package com.callcenter.back.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * <h1>Clase CallCenterBackConfig</h1>
 * Clase que configura como servicio el call center
 *
 * @author  <a href="mailto:cadolop@gmail.com">Carlos Adolfo Lopez</a>
 * @version 1.0
 * @since 20/07/2019
 * @project CallCenterBack
 */
@EnableAsync
@EnableScheduling
@Configuration
public class CallCenterBackConfig extends AsyncConfigurerSupport {
	@Value("${api.cfg.corepoolsize}")
	private int corePoolSize;

	@Value("${api.cfg.maxpoolsize}")
	private int maxPoolSize;

	@Value("${api.cfg.queuecapacity}")
	private int queueCapacity;

	public CallCenterBackConfig(){
    }
 
    public Executor getAsyncExecutor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("CallNumber-");
        executor.initialize();
        return executor;
    }
}
