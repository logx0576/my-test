package me.logx.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleSchedule {
	public static void main(String[] args) {
		SchedulerFactory factory = new StdSchedulerFactory();
		try {
			Scheduler scheduler = factory.getScheduler();
			scheduler.start();

			JobDetail jobDetail = new JobDetail("SimpleJob", null, SimpleJob.class);
			Trigger simplerTrigger = TriggerUtils.makeSecondlyTrigger(10);
			simplerTrigger.setName("SimpleTrigger");

			scheduler.scheduleJob(jobDetail, simplerTrigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
