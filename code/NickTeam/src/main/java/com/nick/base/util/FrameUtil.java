package com.nick.base.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

/**
 * 框架工具类(如下载文件，向客户端输出信息，获取资源文件信息等，需要了解请看详细信息)
 * 
 * @author Ready 2012-10-17
 */
public class FrameUtil {

	/**
	 * 下载文件
	 * 
	 * @param response
	 * @param fileName
	 *            文件名
	 * @param bs
	 *            文件数据
	 * @throws IOException
	 */
	public static void downLoadFile(HttpServletResponse response,
			String fileName, byte[] bs) throws IOException {
		response.reset();
		response.setContentType("application/octet-stream");

		response.setHeader("Content-Disposition", "attachment; filename="
				+ fileName);
		if (bs != null) {
			response.getOutputStream().write(bs);
		}
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	/**
	 * 向客户端输出数据
	 * 
	 * @param message
	 * @throws Exception
	 */
	public static void outputMessage(HttpServletResponse response,
			String message) throws Exception {
		System.out.println(message);
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(message);
	}

	/**
	 * 将一个对象以json格式输出到客户端
	 * 
	 * @param object
	 * @throws Exception
	 */
	public static void outputJsonMessage(HttpServletResponse response,
			Object object) throws Exception {
		outputMessage(response, JSONSerializer.toJSON(object).toString());
	}

}
