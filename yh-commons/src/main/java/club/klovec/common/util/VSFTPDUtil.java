package club.klovec.common.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class VSFTPDUtil {

	/**
	 * @param host
	 * 			主机地址
	 * @param port 
	 * 			端口号
	 * @param username
	 * 			用户名
	 * @param password
	 * 			密码
	 * @param basePath
	 * 			FTP服务器基础目录
	 * @param filePath
	 * 			文件的存放路径
	 * @param filename
	 * 			上传熬FTP服务器的文件名
	 * @param input
	 * 			输入流
	 * @return
	 */
	public static boolean uploadFile(String host,int port,String username,String password,String basePath,String filePath,
			String filename,InputStream input)
	{
		boolean result =false;
		FTPClient ftp= new FTPClient(); 
		try{
			int reply;
			ftp.connect(host,port);//连接Ftp服务器
			ftp.login(username, password);
			reply=ftp.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)){
				ftp.disconnect();
				return result;
			}
			if(!ftp.changeWorkingDirectory(basePath+filePath)){
				//如果不存在，创建目录，
				String [] dirs = filePath.split("/");
				String tempPath=basePath;
				for(String dir:dirs){
					if(null == dir || "".equals(dir)) continue;
					tempPath +="/" +dir;
					if(!ftp.changeWorkingDirectory(tempPath)){
						return result;
					} else {
						ftp.changeWorkingDirectory(tempPath);
					}
				}
			}
			
			//设置上传类型为二进制
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			if(!ftp.storeFile(filename, input)){
				return result;
			}
			
			input.close();
			ftp.logout();
			result = true;
			
			
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			if (ftp.isConnected())
				try{
					ftp.disconnect();
				} catch (IOException ioe){
					
				}
				
		}
		return result;
	}
}
