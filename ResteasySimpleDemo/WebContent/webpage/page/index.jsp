<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <form action="../../file/upload.do"
         method="post" enctype="multipart/form-data">
         <input type="file" name="file_upload"> <input type="submit"
             value="本地文件提交">
 </form>
 <form action="../../serverfile/serverupload.do"
         method="post" enctype="multipart/form-data">
         <input type="file" name="file_upload"> <input type="submit"
             value="远程文件提交">
 </form>
</body>
</html>