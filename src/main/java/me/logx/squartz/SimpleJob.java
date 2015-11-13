package me.logx.squartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SimpleJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// System.out.println("spring quartz job...");
		String message = context.getJobDetail().getJobDataMap().getString("message");
		System.out.println(message);
	}

}
