package club.klovec.manage.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import club.klovec.common.util.IDUtil;
import club.klovec.common.util.VSFTPDUtil;
import club.klovec.manage.service.PicService;

@Service
public class PicServiceImpl implements PicService {
	
	@Value("${ftpclient.host}")
	String host;
	@Value("${ftpclient.port}")
	int port;
	@Value("${ftpclient.username}")
	String username;
	@Value("${ftpclient.password}")
	String password;
	@Value("${ftpclient.basePath}")
	String basePath;
	@Value("${ftpclient.filePath}")
	String filePath;
	
	
	@Override
	public Map<String,Object> upload(MultipartFile file) throws IOException {
		String filename=IDUtil.genImageName()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		boolean result = VSFTPDUtil.uploadFile(host, port, username, password, basePath, filePath, filename, file.getInputStream());
		Map<String,Object> map = new HashMap<String, Object>();
		if(result){
			map.put("error", 0);
			map.put("url","http://"+ host+"/"+filename);
		}else{
			map.put("error", 1);
			map.put("message", "图片上传失败");
		}
		
		return map;
		
		
	}

}
