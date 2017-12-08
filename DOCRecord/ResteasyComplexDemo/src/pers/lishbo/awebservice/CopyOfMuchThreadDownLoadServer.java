package pers.lishbo.awebservice;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import pers.lishbo.util.GetMiMETypeUtil;

/**
 * 
 * @author lishengbo
 * @Time 2017年12月7日下午4:52:50
 */
@Controller
@Path("/MuchThreadDownLoadServer")
public class CopyOfMuchThreadDownLoadServer {
	
	private Logger log = Logger.getLogger(CopyOfMuchThreadDownLoadServer.class.getName());
	/**
	 * 下载文件(支持单点续传下载)
	 * @param request
	 * @param fileId
	 * @throws IOException
	 */
	@POST
	@Path("/test.rest")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public String SSTDataReq(HttpServletRequest request, HttpServletResponse response, @PathVariable("fileId") int fileId) {
		boolean isTest = false;
	    if (isTest) {
	        Enumeration<String> enums = request.getHeaderNames();
	        while (enums.hasMoreElements()) {
	            String names = enums.nextElement();
	            if (isTest) {
	                System.out.println(names + ":[" + request.getHeader(names) + "]");
	            }
	        }
	    }
//	    CmnTmpFile cmnTmpFile = cmnTmpFileSrvc.getCmnTmpFileByKeyId(fileId);
//	    if (cmnTmpFile == null) {
//	        return "无此资源";
//	    }

	    try {
	        if (isTest) {
	            log.info("请求下载的连接地址为：[" + request.getRequestURL() + "]?[" + request.getQueryString() + "]");
	        }
	    } catch (IllegalArgumentException e) {
	        log.error("请求下载的文件名参数为空！");
	        return "请求下载的文件名参数为空！";
	    }

	    File downloadFile = new File("C:\\Users\\cjh\\Desktop\\TaskServer\\ReadMe.txt");
//	    File downloadFile = new File(cmnTmpFile.getFilePath());
	    if (downloadFile.exists()) {
	        if (downloadFile.isFile()) {
	            if (downloadFile.length() > 0) {
	            } else {
	                log.info("请求下载的文件是一个空文件");
	                return "请求下载的文件是一个空文件";
	            }
	            if (!downloadFile.canRead()) {
	                log.info("请求下载的文件不是一个可读的文件");
	                return "请求下载的文件不是一个可读的文件";
	            } else {
	            }
	        } else {
	            log.info("请求下载的文件是一个文件夹");
	            return "请求下载的文件是一个文件夹";
	        }
	    } else {
	        log.info("请求下载的文件不存在！");
	        return "请求下载的文件不存在！";
	    }
	    // 记录文件大小
	    long fileLength = downloadFile.length();
	    // 记录已下载文件大小
	    long pastLength = 0;
	    // 0：从头开始的全文下载；
	    // 1：从某字节开始的下载（bytes=1000-）；
	    // 2：从某字节开始到某字节结束的下载（bytes=1000-2000）
	    int rangeSwitch = 0;
	    // 记录客户端需要下载的字节段的最后一个字节偏移量（比如bytes=1000-2000，则这个值是为2000）
	    long toLength = 0;
	    // 客户端请求的字节总量
	    long contentLength = 0;
	    // 记录客户端传来的形如“bytes=1000-”或者“bytes=1000-2000”的内容
	    String rangeBytes = "";
	    // 负责读取数据
	    RandomAccessFile raf = null;
	    // 写出数据
	    OutputStream os = null;
	    // 缓冲
	    OutputStream out = null;
	    // 暂存容器
	    byte b[] = new byte[1024];

	    if (request.getHeader("Range") != null) {
	        // 客户端请求的下载的文件块的开始字节
	        response.setStatus(javax.servlet.http.HttpServletResponse.SC_PARTIAL_CONTENT);
	        if (isTest) {
	            log.info("request.getHeader(\"Range\")=" + request.getHeader("Range"));
	        }
	        rangeBytes = request.getHeader("Range").replaceAll("bytes=", "");
	        if (rangeBytes.indexOf('-') == rangeBytes.length() - 1) {
	            // 如：bytes=1000-
	            rangeSwitch = 1;
	            rangeBytes = rangeBytes.substring(0, rangeBytes.indexOf('-'));
	            pastLength = Long.parseLong(rangeBytes.trim());
	            // 客户端请求的是 1000之后的字节
	            contentLength = fileLength - pastLength;
	        } else {
	            // 如：bytes=1000-2000
	            rangeSwitch = 2;
	            String temp0 = rangeBytes.substring(0, rangeBytes.indexOf('-'));
	            String temp2 = rangeBytes.substring(rangeBytes.indexOf('-') + 1, rangeBytes.length());
	            // bytes=1000-2000，从第1000个字节开始下载
	            pastLength = Long.parseLong(temp0.trim());
	            // bytes=1000-2000，到第2000个字节结束
	            toLength = Long.parseLong(temp2);
	            // 客户端请求的是1000-2000之间的字节
	            contentLength = toLength - pastLength;
	        }
	    } else {
	        // 从开始进行下载,客户端要求全文下载
	        contentLength = fileLength;
	    }

	    /**
	     * 如果设设置了Content -Length，则客户端会自动进行多线程下载。如果不希望支持多线程，则不要设置这个参数。 响应的格式是:
	     * Content - Length: [文件的总大小] - [客户端请求的下载的文件块的开始字节]
	     * ServletActionContext.getResponse().setHeader("Content- Length", new
	     * Long(file.length() - p).toString());
	     */
	    response.reset();
	    // 告诉客户端允许断点续传多线程连接下载,响应的格式是:Accept-Ranges: bytes
	    response.setHeader("Accept-Ranges", "bytes");
	    // 如果是第一次下,还没有断点续传,状态是默认的 200,无需显式设置;响应的格式是:HTTP/1.1 200 OK

	    if (pastLength != 0) {
	        // 不是从最开始下载,响应的格式是:
	        // Content-Range: bytes [文件块的开始字节]-[文件的总大小 - 1]/[文件的总大小]
	        if (isTest) {
	            log.info("---------不是从开始进行下载！服务器即将开始断点续传...");
	        }
	        String contentRange = "";
	        switch (rangeSwitch) {
	        case 1:
	            // 针对 bytes=1000- 的请求
	            contentRange = new StringBuffer("bytes ").append(new Long(pastLength).toString()).append("-")
	                    .append(new Long(fileLength - 1).toString()).append("/").append(new Long(fileLength).toString())
	                    .toString();
	            response.setHeader("Content-Range", contentRange);
	            break;
	        case 2:
	            // 针对 bytes=1000-2000 的请求
	            contentRange = rangeBytes + "/" + new Long(fileLength).toString();
	            response.setHeader("Content-Range", contentRange);
	            break;
	        default:
	            break;
	        }
	    } else {
	        // 是从开始下载
	        if (isTest) {
	            log.info("---------是从开始进行下载！");
	        }
	    }

	    try {
	        response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadFile.getName() + "\"");
	        // 设置 MIME 类型.
	        response.setContentType(GetMiMETypeUtil.getMiMeType(downloadFile.getName()));
	        response.addHeader("Content-Length", String.valueOf(contentLength));
	        os = response.getOutputStream();
	        out = new BufferedOutputStream(os);
	        raf = new RandomAccessFile(downloadFile, "r");

	        int readNum = 0;
	        long readLength = 0;
	        try {
	            switch (rangeSwitch) {
	            case 0:
	                // 普通下载，或者从头开始的下载，同1
	            case 1:
	                // 针对 bytes=1000- 的请求
	                // 形如 bytes=1000- 的客户端请求，跳过 1000 个字节
	                raf.seek(pastLength);
	                readNum = 0;
	                while ((readNum = raf.read(b, 0, 1024)) != -1) {
	                    out.write(b, 0, readNum);
	                }
	                break;
	            case 2:
	                // 针对 bytes=2000-3000 的请求
	                // 形如 bytes=2000-3000 的客户端请求，找到第 2000 个字节
	                raf.seek(pastLength);
	                readNum = 0;
	                readLength = 0; // 记录已读字节数
	                while (readLength <= contentLength - 1024) {
	                    // 大部分字节在这里读取
	                    readNum = raf.read(b, 0, 1024);
	                    readLength += 1024;
	                    out.write(b, 0, readNum);
	                }
	                if (readLength <= contentLength) {
	                    // 余下的不足 1024 个字节在这里读取
	                    readNum = raf.read(b, 0, (int) (contentLength - readLength));
	                    out.write(b, 0, readNum);
	                }
	                break;
	            default:
	                break;
	            }
	            out.flush();
	            if (isTest) {
	                log.info("-----------下载结束");
	            }
	        } catch (IOException ie) {
	            /**
	             * 在写数据的时候， 对于 ClientAbortException 之类的异常，
	             * 是因为客户端取消了下载，而服务器端继续向浏览器写入数据时，抛出这个异常，这个是正常的。
	             */
	            if (isTest) {
	                log.info("向客户端传输时出现IO异常，但此异常是允许的，有可能是客户端取消了下载，导致此异常");
	            }
	        }
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	    } finally {
	        if (out != null) {
	            try {
	                out.close();
	            } catch (IOException e) {
	                // 远程主机或者本机强制关闭
	                // log.error(e.getMessage(), e);
	            } finally {
	                out = null;
	            }
	        }
	        if (raf != null) {
	            try {
	                raf.close();
	            } catch (IOException e) {
	                log.error(e.getMessage(), e);
	            } finally {
	                raf = null;
	            }
	        }
	    }
		return rangeBytes;
		
	}
	
}
