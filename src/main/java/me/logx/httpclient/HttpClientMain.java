package me.logx.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class HttpClientMain {

	public static String getUtf8ToGbk(String u) {
//		if (true) {
//			return u;
//		}
//		try {
//			String s = new String(u.getBytes("utf-8"), "gbk");
//			return new String(s.getBytes("gbk"), "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			u = new String(u.getBytes("ISO-8859-1"), "gbk");
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		try {
//			String chinese = "中文";//java内部编码
//			String gbkChinese = new String(chinese.getBytes("GBK"), "ISO-8859-1");//转换成gbk编码
//			String unicodeChinese = new String(gbkChinese.getBytes("ISO-8859-1"), "GBK");//java内部编码
//			System.out.println(unicodeChinese);//中文
//			String utf8Chinese = new String(unicodeChinese.getBytes("UTF-8"), "ISO-8859-1");//utf--8编码
//			System.out.println(utf8Chinese);//乱码
//			unicodeChinese = new String(utf8Chinese.getBytes("ISO-8859-1"), "UTF-8");//java内部编码
//			System.out.println(unicodeChinese);//中文
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return u;
	}

	public static void main(String[] args) {
		//创建HttpClientBuilder  
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		//HttpClient  
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

//		HttpGet httpGet = new HttpGet("http://www.gxnu.edu.cn/default.html");
		HttpGet httpGet = new HttpGet("http://logx.com:8088/test.jsp");
		System.out.println(httpGet.getRequestLine());
		try {
			//执行get请求  
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
			//获取响应消息实体  
			HttpEntity entity = httpResponse.getEntity();
			//响应状态  
			System.out.println("status:" + httpResponse.getStatusLine());
			//判断响应实体是否为空  
			if (entity != null) {
				System.out.println("contentEncoding:" + entity.getContentEncoding());
				System.out.println("response content:" + getUtf8ToGbk(EntityUtils.toString(entity)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { //关闭流并释放资源  
				closeableHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
