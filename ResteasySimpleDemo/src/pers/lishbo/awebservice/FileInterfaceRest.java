package pers.lishbo.awebservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.stereotype.Controller;

import pers.lishbo.aservice.UserService;

/**
 * @author 
 *
 */
@Controller
@Path("/file")
public class FileInterfaceRest {

	private Logger logger = Logger.getLogger(FileInterfaceRest.class.getName());
	@Context  
    HttpServletRequest request;  
	@Resource
	private UserService userservice;
	
	/**
	 * 文件上传至本地服务器（restful风格）--文件名不为中文
	 * @return
	 */
	@POST
	@Path("/upload.do")
    @Consumes("multipart/form-data")
	 public Response uploadFile(MultipartFormDataInput input) {
        String fileName = "";
        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get("file_upload");
        for (InputPart inputPart : inputParts) {
         try {
            MultivaluedMap<String, String> header = inputPart.getHeaders();
            fileName = getFileName(header);
            //convert the uploaded file to inputstream
            InputStream inputStream = inputPart.getBody(InputStream.class,null);
            byte [] bytes = IOUtils.toByteArray(inputStream);
            //constructs upload file path
            String UPLOADED_FILE_PATH =request.getSession().getServletContext().getRealPath("/")+"WEB-INF"
            +File.separator+"mould"+File.separator;
            fileName = UPLOADED_FILE_PATH + fileName;
            logger.debug(fileName);
            writeFile(bytes,fileName);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        return Response.status(200)
            .entity("uploadFile is called, Uploaded file name : " + fileName).build();
    }
 
    private String getFileName(MultivaluedMap<String, String> header) throws UnsupportedEncodingException {
        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {
                String[] name = filename.split("=");
//                String finalFileName =name[1].trim().replaceAll("\"", "");
                String finalFileName =new String ( name[1].trim().replaceAll("\"", "").getBytes("GB2312"),"utf-8");
                return finalFileName;
            }
        }
        return "unknown";
    }
 
    //save to somewhere
    private void writeFile(byte[] content, String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fop = new FileOutputStream(file);
        fop.write(content);
        fop.flush();
        fop.close();
    }

}
