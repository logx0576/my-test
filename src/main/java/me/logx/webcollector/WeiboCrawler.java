package me.logx.webcollector;

import cn.edu.hfut.dmic.webcollector.crawler.DeepCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequesterImpl;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author hu
 */
public class WeiboCrawler extends DeepCrawler {

	public WeiboCrawler(String crawlPath) throws Exception {
		super(crawlPath);
		/*获取新浪微博的cookie，账号密码以明文形式传输，请使用小号*/
		String cookie = WeiboCN.getSinaCookie("微博用户名", "微博密码");
		HttpRequesterImpl myRequester = (HttpRequesterImpl) this.getHttpRequester();
		myRequester.setCookie(cookie);
	}

	@Override
	public Links visitAndGetNextLinks(Page page) {
		/*抽取微博*/
		Elements weibos = page.getDoc().select("div.c");
		for (Element weibo : weibos) {
			System.out.println(weibo.text());
		}
		/*如果要爬取评论，这里可以抽取评论页面的URL，返回*/
		return null;
	}

	public static void main(String[] args) throws Exception {
		WeiboCrawler crawler = new WeiboCrawler("/home/hu/data/weibo");
		crawler.setThreads(3);
		/*对某人微博前5页进行爬取*/
		for (int i = 0; i < 5; i++) {
			crawler.addSeed("http://weibo.cn/zhouhongyi?vt=4&page=" + i);
		}
		crawler.start(1);
	}

}
