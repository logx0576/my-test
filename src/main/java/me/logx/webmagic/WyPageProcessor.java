package me.logx.webmagic;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class WyPageProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	public void printLinks(Selectable links) {
		System.out.println("----------------------------------------");
		List<String> list = links.regex("(http://war\\.163\\.com/[^\"]+)").all();
		for (int i = 0; i < list.size(); i++) {
			String link = list.get(i);
			System.out.println(link);
		}
	}

	@Override
	public void process(Page page) {
		Selectable links = page.getHtml().links();
		printLinks(links);
		System.out.println(page.getHtml());
		page.addTargetRequests(links.all());
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
//		Spider.create(new WyPageProcessor()).addUrl("http://war.163.com/").thread(1).run();
		Spider.create(new WyPageProcessor()).addUrl("http://logx.com:8088/test.jsp").thread(1).run();
	}

}
