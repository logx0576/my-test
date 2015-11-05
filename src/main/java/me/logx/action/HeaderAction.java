package me.logx.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderAction {
	@RequestMapping(value = "/disposition")
	@ResponseBody
	public void ContentDisposition(HttpServletRequest request, HttpServletResponse response) {
		try {
			File file = new File("D:/20151022.xls");
//			File file = new File("D:/ITextTest.pdf");
			FileInputStream fis = new FileInputStream(file);
			
			response.reset();
			response.setContentLength((int) file.length());
//			response.setContentType("application/x-msdownload"); // application/octet-stream ?
//			response.setContentType("application/octet-stream"); // application/octet-stream ?
//			response.setContentType("application/pdf");
//			response.setContentType("application/x-xls");
			response.setContentType("application/vnd.ms-excel");
			
//			response.setHeader("Content-Disposition", "attachment;filename=a.xls"); //下载
//			response.setHeader("Content-Disposition", "inline;filename=a.pdf");
			response.setHeader("Content-Disposition", "inline;filename=a.xls");
			

			//response头文件设置 需要在输入流之前
			
			OutputStream os = response.getOutputStream();
			byte[] line = new byte[2048];
			int len = -1;
			while ((len = fis.read(line)) != -1) {
				os.write(line, 0, len);
			}

			fis.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
