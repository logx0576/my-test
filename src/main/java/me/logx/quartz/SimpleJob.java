package me.logx.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		System.out.println("Welcome come to Quartz");
	}

}
