package com.wuya.studentweb.action;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.wuya.backend.criteria.share.BusinessProcessLogCriteria;
import com.wuya.backend.criteria.share.ImageCriteria;
import com.wuya.backend.criteria.share.TransportTicketCriteria;
import com.wuya.backend.po.share.Image;
import com.wuya.backend.service.IShareInfoService;
import com.wuya.base.config.FtpServerEnum;
import com.wuya.base.enumerate.HttpScopeEnum;
import com.wuya.base.enumerate.InvokeStateEnum;
import com.wuya.base.enumerate.share.ImageFormatEnum;
import com.wuya.base.enumerate.share.ImageTargetEnum;
import com.wuya.base.exception.WuYaException;
import com.wuya.base.mvc.BaseAction;
import com.wuya.base.result.EasyUiPagerResult;
import com.wuya.base.result.InvokeResult;
import com.wuya.base.util.FileUtil;
import com.wuya.base.util.FtpUtil;
import com.wuya.base.util.NumberUtil;
import com.wuya.base.util.StringUtil;
import com.wuya.studentweb.constant.FrontErrorCode;

/**
 * [公用组建－控制器]
 * 
 * @author nick
 * @version v1.0 2015-2-25
 */
public class ShareAction extends BaseAction {

	/**
	 * [上传文件]
	 */
	private File file;

	/**
	 * [文件名]
	 */
	private String fileFileName;

	private ImageCriteria imageCriteria;

	private BusinessProcessLogCriteria businessProcessLogCriteria;

	private TransportTicketCriteria transportTicketCriteria;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public ImageCriteria getImageCriteria() {
		return imageCriteria;
	}

	public void setImageCriteria(ImageCriteria imageCriteria) {
		this.imageCriteria = imageCriteria;
	}

	public BusinessProcessLogCriteria getBusinessProcessLogCriteria() {
		return businessProcessLogCriteria;
	}

	public void setBusinessProcessLogCriteria(
			BusinessProcessLogCriteria businessProcessLogCriteria) {
		this.businessProcessLogCriteria = businessProcessLogCriteria;
	}

	public TransportTicketCriteria getTransportTicketCriteria() {
		return transportTicketCriteria;
	}

	public void setTransportTicketCriteria(
			TransportTicketCriteria transportTicketCriteria) {
		this.transportTicketCriteria = transportTicketCriteria;
	}

	@Autowired
	private IShareInfoService shareInfoService;

	/**
	 * [上传充值图片]
	 */
	public void uploadRechargeImage() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		System.out.println(this.file);
		// 申明变量
		InvokeResult result = null;
		Integer detailId = null;
		boolean uploadFlag = false;
		boolean createImageInfoFlag = false;
		Image image = null;
		String fileName = null;
		// 获取请求参数
		detailId = Integer.parseInt((String) this.getParameterFromScope(
				"detailId",
				com.wuya.base.enumerate.HttpScopeEnum.REQUEST.getCode()));
		// 判断参数合法性
		if (null == this.file
				|| NumberUtil.isEmptyOrZero(detailId)
				|| StringUtil.isEmpty(this.fileFileName)
				|| !ImageFormatEnum.isInEnumByCode(FileUtil
						.getFileFormat(this.fileFileName))) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
					FrontErrorCode.E0017);
		} else {
			try {
				// 将文件上传到ftp服务器
				fileName = UUID.randomUUID().toString();
				uploadFlag = FtpUtil.uploadImage(this.file, fileName,
						FileUtil.getFileFormat(this.fileFileName),
						FtpServerEnum.RECHARGE_FTP_SERVER);
				if (uploadFlag) {// 上传成功
					// 生成图片对象-并配置数据
					image = new Image();
					image.setFileName(fileName);
					image.setFileFormat(FileUtil
							.getFileFormat(this.fileFileName));
					image.setServerCode(FtpServerEnum.RECHARGE_FTP_SERVER
							.getCode());
					image.setTargetId(detailId);
					image.setTargetType(ImageTargetEnum.RECHARGE_DETAIL
							.getCode());
					// 创建图片信息
					createImageInfoFlag = this.shareInfoService
							.createImage(image);
					if (createImageInfoFlag) {
						result = new InvokeResult(
								InvokeStateEnum.SUCCESS.getCode(), null);
					} else {
						result = new InvokeResult(
								InvokeStateEnum.ERROR.getCode(),
								FrontErrorCode.E0018);
					}
				} else { // 上传失败
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							FrontErrorCode.E0018);
				}
			} catch (Exception e) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0018);
			} finally {
				// 删除图片
				this.file.delete();
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [上传证件图片]
	 */
	public void uploadCertificateImage() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		System.out.println(this.file);
		// 申明变量
		InvokeResult result = null;
		Integer certificateId = null;
		boolean uploadFlag = false;
		boolean createImageInfoFlag = false;
		Image image = null;
		String fileName = null;
		// 获取请求参数
		certificateId = Integer.parseInt((String) this.getParameterFromScope(
				"certificateId",
				com.wuya.base.enumerate.HttpScopeEnum.REQUEST.getCode()));
		// 判断参数合法性
		if (null == this.file
				|| NumberUtil.isEmptyOrZero(certificateId)
				|| StringUtil.isEmpty(this.fileFileName)
				|| !ImageFormatEnum.isInEnumByCode(FileUtil
						.getFileFormat(this.fileFileName))) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
					FrontErrorCode.E0017);
		} else {
			try {
				// 将文件上传到ftp服务器
				fileName = UUID.randomUUID().toString();
				uploadFlag = FtpUtil.uploadImage(this.file, fileName,
						FileUtil.getFileFormat(this.fileFileName),
						FtpServerEnum.CERTIFICATE_FTP_SERVER);
				if (uploadFlag) {// 上传成功
					// 生成图片对象-并配置数据
					image = new Image();
					image.setFileName(fileName);
					image.setFileFormat(FileUtil
							.getFileFormat(this.fileFileName));
					image.setServerCode(FtpServerEnum.CERTIFICATE_FTP_SERVER
							.getCode());
					image.setTargetId(certificateId);
					image.setTargetType(ImageTargetEnum.CERTIFICATE.getCode());
					// 创建图片信息
					createImageInfoFlag = this.shareInfoService
							.createImage(image);
					if (createImageInfoFlag) {
						result = new InvokeResult(
								InvokeStateEnum.SUCCESS.getCode(), null);
					} else {
						result = new InvokeResult(
								InvokeStateEnum.ERROR.getCode(),
								FrontErrorCode.E0018);
					}
				} else { // 上传失败
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							FrontErrorCode.E0018);
				}
			} catch (Exception e) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
						FrontErrorCode.E0018);
			} finally {
				// 删除图片
				this.file.delete();
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [获取图片列表－支持分页]
	 * 
	 * @throws Exception
	 */
	public void getImageListWithPage() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		Integer rows = 0;
		Integer page = 0;
		EasyUiPagerResult result = null;
		// 判断参数合法性
		if (null == this.imageCriteria) {
			result = null;
		} else {
			if (this.imageCriteria.isRequirePage()) {
				rows = Integer.parseInt((String) this.getParameterFromScope(
						"rows", HttpScopeEnum.REQUEST.getCode()));
				page = Integer.parseInt((String) this.getParameterFromScope(
						"page", HttpScopeEnum.REQUEST.getCode()));
				if (0 == rows || 0 == page) {
					result = null;
				} else {
					this.imageCriteria.setRequirePage(true);
					this.imageCriteria.setRows(rows);
					this.imageCriteria.setPage(page);
				}
			}
			result = this.shareInfoService
					.getImageListWithPage(this.imageCriteria);
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [删除图片]
	 * 
	 * @throws Exception
	 */
	public void deleteImage() throws Exception {
		// 申明变量
		InvokeResult result = null;
		Integer imageId;
		boolean flag = false;
		// 获取请求参数
		imageId = Integer.parseInt((String) this.getParameterFromScope(
				"imageId",
				com.wuya.base.enumerate.HttpScopeEnum.REQUEST.getCode()));
		// 判断参数合法性
		if (NumberUtil.isEmptyOrZero(imageId)) {
			result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
		} else {
			try {
				flag = this.shareInfoService.deleteImage(imageId);
			} catch (Exception e) {
				if (e instanceof WuYaException) {
					result = new InvokeResult(InvokeStateEnum.ERROR.getCode(),
							((WuYaException) e).getMsg());
				}
			}
		}
		if (flag) {
			result = new InvokeResult(InvokeStateEnum.SUCCESS.getCode(), null);
		} else {
			if (null == result) {
				result = new InvokeResult(InvokeStateEnum.ERROR.getCode(), null);
			}
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [获取业务处理日志列表-支持分页]
	 * 
	 * @throws Exception
	 */
	public void getBusinessProcessLogListWithPage() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		Integer rows = 0;
		Integer page = 0;
		EasyUiPagerResult result = null;
		// 判断参数合法性
		if (null == this.businessProcessLogCriteria) {
			result = null;
		} else {
			if (this.businessProcessLogCriteria.isRequirePage()) {
				rows = Integer.parseInt((String) this.getParameterFromScope(
						"rows", HttpScopeEnum.REQUEST.getCode()));
				page = Integer.parseInt((String) this.getParameterFromScope(
						"page", HttpScopeEnum.REQUEST.getCode()));
				if (0 == rows || 0 == page) {
					result = null;
				} else {
					this.businessProcessLogCriteria.setRequirePage(true);
					this.businessProcessLogCriteria.setRows(rows);
					this.businessProcessLogCriteria.setPage(page);
				}
			}
			result = this.shareInfoService
					.getBusinessProcessLogListWithPage(this.businessProcessLogCriteria);
		}
		this.outputJsonMessage(result);
	}

	/**
	 * [获取交通票务列表－支持分页]
	 * 
	 * @throws Exception
	 */
	public void getTransportTicketListWithPage() throws Exception {
		System.out.println(this.getParameterMapFromRequest());
		// 申明变量
		Integer rows = 0;
		Integer page = 0;
		EasyUiPagerResult result = null;
		// 判断参数合法性
		if (null == this.transportTicketCriteria) {
			result = null;
		} else {
			if (this.transportTicketCriteria.isRequirePage()) {
				rows = Integer.parseInt((String) this.getParameterFromScope(
						"rows", HttpScopeEnum.REQUEST.getCode()));
				page = Integer.parseInt((String) this.getParameterFromScope(
						"page", HttpScopeEnum.REQUEST.getCode()));
				if (0 == rows || 0 == page) {
					result = null;
				} else {
					this.transportTicketCriteria.setRequirePage(true);
					this.transportTicketCriteria.setRows(rows);
					this.transportTicketCriteria.setPage(page);
				}
			}
			result = this.shareInfoService
					.getTransportTicketListWithPage(this.transportTicketCriteria);
		}
		this.outputJsonMessage(result);
	}

}
