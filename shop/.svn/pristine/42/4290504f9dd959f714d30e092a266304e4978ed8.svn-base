package com.up.utils;
import java.io.File;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
public class FileUtil{
	   /**
	    * <p>multipartFileUploadToLocalhost: 文件上传到本地服务器上</p>
	    * 更新时间: 21:00 2019/9/4
	    * @方法名 multipartFileUploadToLocalhost
	    */
	public static String  multipartFileUploadToLocalhost(HttpServletRequest request,MultipartFile multipartFile,String upload ){
		String realPath ="";

		if(!multipartFile.isEmpty()){
			//获取原文件名
			String fileMultipartFileName = multipartFile.getOriginalFilename();
			//获取文件路后缀名
			String substring = fileMultipartFileName.substring(fileMultipartFileName.lastIndexOf("."));
			////拼接一个新的文件名，并用uuid防止重复
			String fileName = UUID.randomUUID().toString()+substring;
			//获取一个相对路径
			realPath = upload+"/"+fileName;
			//创建一个新文件夹
			File file = new File(request.getRealPath(upload));
			if(!file.exists()){
				file.mkdirs();
			}
			//上传文件
			File tfile = new File(request.getRealPath(upload),fileName);
			try{
				//将文件上传到本地服务器
				multipartFile.transferTo(tfile);
				realPath=tfile.getAbsolutePath();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
			}
		}
		return realPath;
	}

}
