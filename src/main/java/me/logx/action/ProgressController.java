package me.logx.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.logx.upload.JsonUtil;
import me.logx.upload.Progress;
import me.logx.upload.StringUtil;

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
			System.out.println("@@ status is null");
			return "{}";
		}
		System.out.println("@@" + status.toString());
		return status.toString();
	}

	/**
	 * 上传文件
	 */
	@RequestMapping(value = "/userFile/upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String folder = "";
		try {
			folder = getFolder(request, response, result);
		} catch (Exception ex) {
			//result.put("message", "获取folder失败");
			//return ajaxHtml(JsonUtil.getJsonString4JavaPOJO(result), response);
		}
		//		if (StringUtil.isEmpty(folder)) {// step-1 获得文件夹
		//			response.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		//			if (!result.containsKey("message")) {
		//				result.put("message", "处理失败");
		//			}
		//			return ajaxJson(JsonUtil.getJsonString4JavaPOJO(result), response);
		//		}
		if (handler(request, response, result, folder)) {
			result.put("status", "success");
			result.put("message", "上传成功");
		}
		return ajaxHtml(JsonUtil.getJsonString4JavaPOJO(result), response);
	}

	/**
	 * 获取上传路径
	 */
	public String getFolder(MultipartHttpServletRequest request, HttpServletResponse response,
			Map<String, Object> result) {
		if (StringUtil.isEmpty(Constants.UPLOAD_FILE_PATH)) {
			System.out.println("real path: " + request.getSession().getServletContext().getRealPath("/"));
			return request.getSession().getServletContext().getRealPath("/");
		}
		return Constants.UPLOAD_FILE_PATH;
	}

	/**
	 * 处理文件上传
	 */
	public boolean handler(MultipartHttpServletRequest request, HttpServletResponse response,
			Map<String, Object> result, String folder) throws IOException {
		Date baseDate = new Date();
		//		String fileName = DateTime.toDate("yyyyMMddHHmmss", baseDate);
		String fileName = "D:/fileName";
		MultipartFile file = request.getFile("file");
		if (file == null) {// step-2 判断file
			//			return getError("文件内容为空", HttpStatus.UNPROCESSABLE_ENTITY, result, response, null);
		}
		String orgFileName = file.getOriginalFilename();
		orgFileName = (orgFileName == null) ? "" : orgFileName;
		Pattern p = Pattern.compile("\\s|\t|\r|\n");
		Matcher m = p.matcher(orgFileName);
		orgFileName = m.replaceAll("_");
		String realFilePath = folder + File.separator + "admin" + File.separator;
		if (!(new File(realFilePath).exists())) {
			new File(realFilePath).mkdirs();
		}
		//		String bigRealFilePath = realFilePath + File.separator + FilenameUtils.getBaseName(orgFileName).concat(".")
		//				+ fileName.concat(".").concat(FilenameUtils.getExtension(orgFileName).toLowerCase());
		String bigRealFilePath = fileName.concat(".").concat(FilenameUtils.getExtension(orgFileName).toLowerCase());
		if (file.getSize() > 0) {
			File targetFile = new File(bigRealFilePath);
			file.transferTo(targetFile);//写入目标文件
		}
		//保存user file
		//		UserFileDTO fileDTO = new UserFileDTO(1, new Date(), IpTool.getClientAddress(request), orgFileName,
		//				bigRealFilePath, 1);
		//		fileDTO.setFileSize(String.valueOf(NumUtil.divideNumber(file.getSize(), 1024 * 1024)));
		//		userFileService.save(fileDTO);
		return true;
	}
	
	public String ajax(String content, String type, HttpServletResponse response) {
        try {
            response.setContentType(type + ";charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
//            LOG.error("ajax", e);
        }
        return null;
    }
	
	/**AJAX输出HTML，返回null**/
    public String ajaxHtml(String html, HttpServletResponse response) {
        return ajax(html, "text/html", response);
    }
}
