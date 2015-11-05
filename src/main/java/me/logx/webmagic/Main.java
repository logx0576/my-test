package me.logx.webmagic;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;
import us.codecraft.webmagic.scheduler.RedisScheduler;

public class Main {
	public static void main(String[] args) {
		Spider.create(new GithubRepoPageProcessor())
				//��https://github.com/code4craft��ʼץ    
				.addUrl("https://github.com/code4craft")
				//����Scheduler��ʹ��Redis������URL����
				.setScheduler(new RedisScheduler("localhost"))
				//����Pipeline���������json��ʽ���浽�ļ�
				.addPipeline(new JsonFilePipeline("D:\\data\\webmagic"))
				//����5���߳�ͬʱִ��
				.thread(5)
				//��������
				.run();
	}
}
