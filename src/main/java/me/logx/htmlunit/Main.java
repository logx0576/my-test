package me.logx.htmlunit;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;

public class Main {

	public static String getGbkString(String s) {
		try {
			return new String(s.getBytes("ISO-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);

		//		HtmlPage page = webClient.getPage("http://www.yanyulin.info");
		HtmlPage page = webClient.getPage("file:///D:/1.html");
		System.out.println(new String(page.asText().getBytes("ISO-8859-1"), "gbk"));

		HtmlParagraph p = (HtmlParagraph) page.getElementById("demo");
		System.out.println(getGbkString(p.getTextContent()));
		webClient.close();
	}
}
