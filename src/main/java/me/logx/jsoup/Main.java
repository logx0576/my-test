package me.logx.jsoup;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.activemq.protobuf.BufferInputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mysql.jdbc.Buffer;

public class Main {
	public static String getHtml() {
		
		//		FileInputStream fis = new FileInputStream(file);
		try {
			File file = new File("D:/1.html");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			StringBuffer buffer = new StringBuffer();
			int len = -1;
			String line = null;
			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}
			br.close();
			return buffer.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

	public static void main(String[] args) {
//		String html = "<html><head><title>First parse</title></head>"
//				+ "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(getHtml());
		Elements es = doc.getElementsByTag("p");
		System.out.println(es.size());
		for (Element e : es) {
			System.out.println(e.text());
		}
		System.out.println("over");
	}
}
