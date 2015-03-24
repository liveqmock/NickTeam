package com.nick.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;

import com.nick.base.config.FtpServerEnum;
import com.nick.base.constant.CommonConstant;

/**
 * [FTP服务器－工具类]
 * 
 * @author nick
 * @version v1.0 2015-2-25
 */
public class FtpUtil {

	/**
	 * [上传图片文件到指定的FTP服务器]
	 * 
	 * @param uploadImagePath
	 *            [上传文件的源文件路径]
	 * @param imageName
	 *            [图片名称]
	 * @param imageFormat
	 *            [图片格式]
	 * @param ftpServer
	 *            [ftp服务器配置]
	 * @return
	 */
	public static boolean uploadImage(File image, String imageName,
			String imageFormat, FtpServerEnum ftpServer) {
		// 申明变量
		boolean flag = false;
		FTPClient ftpClient = new FTPClient();
		FileInputStream fis = null;
		Integer reply = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String directory = null;
		// 判断参数合法性
		if (null == image || StringUtil.isEmpty(imageName)
				|| StringUtil.isEmpty(imageFormat)) {
			flag = false;
		} else {
			try {
				// 进行连接
				ftpClient.connect(ftpServer.getBaseAddress(),
						ftpServer.getPort());
				// 登录ftp
				ftpClient.login(ftpServer.getUsername(),
						ftpServer.getPassword());
				// 看返回的值是不是230，如果是，表示登录成功
				reply = ftpClient.getReplyCode();
				if (230 == reply) {// 登录成功
					System.out.println("ftp服务器登录成功");
					fis = new FileInputStream(image);
					ftpClient.setBufferSize(1024);
					ftpClient.setControlEncoding(CommonConstant.UTF8_ENCODING);
					// 设定工作目录
					ftpClient.changeWorkingDirectory(CommonConstant.SLASH);
					// 获取当前日期
					directory = sdf.format(new Date());
					ftpClient.makeDirectory(directory);
					// 重新设定工作目录
					ftpClient.changeWorkingDirectory(CommonConstant.SLASH
							+ directory);
					// 设置文件类型（二进制）
					ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
					ftpClient.storeFile(imageName + CommonConstant.DOT
							+ imageFormat.toLowerCase(), fis);
					System.out.println("图片上传成功");
					flag = true;
				} else {// 登录失败
					System.out.println("ftp服务器登录失败");
					flag = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				IOUtils.closeQuietly(fis);
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
					flag = false;
				}
			}
		}
		return flag;
	}

	public static boolean deleteImage(String imageName, String imageFormat,
			String floaderName, FtpServerEnum ftpServer) {
		// 申明变量
		boolean flag = false;
		FTPClient ftpClient = new FTPClient();
		Integer reply = 0;
		boolean deleteFlag = false;
		// 判断参数合法性
		if (StringUtil.isEmpty(imageName) || StringUtil.isEmpty(imageFormat)
				|| StringUtil.isEmpty(floaderName)) {
			flag = false;
		} else {
			try {
				// 进行连接
				ftpClient.connect(ftpServer.getBaseAddress(),
						ftpServer.getPort());
				// 登录ftp
				ftpClient.login(ftpServer.getUsername(),
						ftpServer.getPassword());
				// 看返回的值是不是230，如果是，表示登录成功
				reply = ftpClient.getReplyCode();
				if (230 == reply) {// 登录成功
					System.out.println("ftp服务器登录成功");
					ftpClient.setBufferSize(1024);
					ftpClient.setControlEncoding(CommonConstant.UTF8_ENCODING);
					// 设定工作目录
					ftpClient.changeWorkingDirectory(CommonConstant.SLASH
							+ floaderName);
					deleteFlag = ftpClient.deleteFile(imageName
							+ CommonConstant.DOT + imageFormat);
					if (deleteFlag) {
						System.out.println("图片删除成功");
					} else {
						System.out.println("要删除的图片可能不存在");
					}
					flag = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
					flag = false;
				}
			}
		}
		return flag;
	}

	public static void main(String args[]) {
		FtpUtil.deleteImage("0ed965f0-1019-49c6-bc34-8e607861faf0", "jpg",
				"2015-02-25", FtpServerEnum.RECHARGE_FTP_SERVER);
	}

}
