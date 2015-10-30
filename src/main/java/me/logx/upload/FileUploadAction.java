package me.logx.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.hundsun.network.melody.common.util.ShortUUIDGenerator;

/**
 * 
 * @author peter.su
 * @version $Id: FileUploadAction.java,v 0.1 2011-12-6 上午11:00:15 peter.su Exp $
 */
@Controller
public class FileUploadAction {
    private static final long serialVersionUID = 6748857432950840322L;
    //    private static final String DESTINATION_DIR_PATH = "files";
    @Value("${upload.root}")
    private String            uploadRoot;

    @Value("${upload.root.licence.url.path}")
    private String            uploadUrl;

    @RequestMapping(value = "ajaxFileUpload/upload")
    public @ResponseBody
    HashMap<String, Object> upload(HttpServletRequest request) throws IOException {

        //        PrintWriter writer = null;
        InputStream is = null;
        FileOutputStream fos = null;
        HashMap<String, Object> returnMap = new HashMap<String, Object>();

        String filename = request.getHeader("X-File-Name");
        String imgExt = filename.substring(filename.lastIndexOf(".") + 1);
        String pathPart = DateUtil.formatDate(new Date(), "/yyyy/MM/dd/");
//        String fileName = ShortUUIDGenerator.randomUUID() + "." + imgExt;
        String fileName = "uploadfile" + "." + imgExt;
        
        StringBuffer imgPath = new StringBuffer();
        StringBuffer contextPath = new StringBuffer();
        imgPath.append(uploadRoot);
        contextPath.append(uploadUrl);
        imgPath.append(pathPart);
        contextPath.append(pathPart);
        FileUtil.mkdir(imgPath.toString());
        imgPath.append(fileName);
        contextPath.append(fileName);
        try {
            is = request.getInputStream();
            fos = new FileOutputStream(new File(imgPath.toString()));
            IOUtils.copy(is, fos);
            returnMap.put("success", "true");
            returnMap.put("backUrl", contextPath);
            //            response.setStatus(response.SC_OK);
            //            writer.print("{success: false}");
        } catch (FileNotFoundException ex) {
            //            response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
            //            writer.print("{success: false}");
            returnMap.put("success", "false");
            returnMap.put("backUrl", contextPath);
            //            log(FileUploadAction.class.getName() + "has thrown an exception: " + ex.getMessage());
        } catch (IOException ex) {
            returnMap.put("success", "false");
            returnMap.put("backUrl", contextPath);
            //            response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
            //            writer.print("{success: false}");
            //            log(FileUploadAction.class.getName() + "has thrown an exception: " + ex.getMessage());
        } finally {
            try {
                fos.close();
                is.close();
            } catch (IOException ignored) {
            }
        }
        return returnMap;
        //        writer.flush();
        //        writer.close();
        //        return "1";
    }

    /**保存文件  
     * @param stream  
     * @param path  
     * @param filename  
     * @throws IOException  
     */
    public void SaveFileFromInputStream(InputStream stream, String path, String filename)
                                                                                         throws IOException {
        FileOutputStream fs = new FileOutputStream(path + "/" + filename);
        byte[] buffer = new byte[1024 * 1024];
        int bytesum = 0;
        int byteread = 0;
        while ((byteread = stream.read(buffer)) != -1) {
            bytesum += byteread;
            fs.write(buffer, 0, byteread);
            fs.flush();
        }
        fs.close();
        stream.close();
    }
}
