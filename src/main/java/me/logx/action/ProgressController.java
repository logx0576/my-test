package me.logx.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.logx.upload.Progress;

/**
 * 
 * 创建人：fantasy <br>
 * 创建时间：2013-12-6 <br>
 * 功能描述： 获取上传文件进度controller<br>
 *
 */
@Controller
public class ProgressController {
	@RequestMapping(value = "/upload/schedule", method = RequestMethod.GET)
	public String processBar(HttpServletRequest request) {
		return "/upload/schedule";
	}

	@RequestMapping(value = "/fileStatus/upfile/progress", method = RequestMethod.POST)
	@ResponseBody
	public String initCreateInfo(HttpServletRequest request) {
		Progress status = (Progress) request.getSession().getAttribute("upload_ps");
		if (status == null) {
			return "{}";
		}
		return status.toString();
	}
}