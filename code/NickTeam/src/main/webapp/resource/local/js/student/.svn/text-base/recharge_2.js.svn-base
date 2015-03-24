/**
 * [充值－步骤2页面JS]
 */

$(function() {
	loadImageByDetial();
});

/**
 * [跳转结束充值页面]
 */
function toFinishRecharge() {
	var detailId = $("#page_detailId").val();
	if (detailId) {
		window.location.href = G_basePath
				+ "/router/toFinishRecharge.action?detailId=" + detailId;
	}
}

/**
 * [执行上传图片工作-异步提交]
 */
function doAjaxUploadRechargeImage() {
	$('#recharge_image_upload_form').form({
		url : G_basePath + "/share/uploadRechargeImage.action",
		onSubmit : function() {
			var flag = $('#recharge_image_upload_form').form("validate");
			if (flag) {
				MaskUtil.mask();
			} else {

			}
			return flag;
		},
		success : function(data) {
			MaskUtil.unmask();
			var result = JSON.parse(data);
			if ("SUCCESS" == result.invokeState) {
				$('#recharge_image_upload_form').form("reset");
				loadImageByDetial();
				$.messager.alert("操作结果:", "图片上传成功");
			} else {
				$.messager.alert("操作结果:", result.result);
			}
		}
	});
	$('#recharge_image_upload_form').form('submit');
}

/**
 * [根据详细信息获取图片信息]
 */
function loadImageByDetial() {
	var detailId = $("#page_detailId").val();
	if (detailId) {
		var params = {};
		params["imageCriteria.dstatus"] = "normal";
		params["imageCriteria.targetId"] = detailId;
		params["imageCriteria.targetType"] = "rechargeDetail";
		params["imageCriteria.requirePage"] = false;
		params["rows"] = "1";
		params["page"] = "1";
		$
				.ajax({
					url : G_basePath + "/share/getImageListWithPage.action",
					type : "POST",
					data : params,
					dataType : "JSON",
					success : function(result) {
						if (result) {
							var images = result.rows;
							var html = "";
							for (var i = 0; i < images.length; i++) {
								html += "<div style='height:150px;width:120px;text-align:center;float:left;'>";
								html += "<img onclick='javascript:toShow("
										+ images[i].id
										+ ","
										+ JSON.stringify(images[i].imagePath)
										+ ");' style='width:100px;height:100px;margin:10px 15px;' src='"
										+ images[i].imagePath + "' />";
								html += "<span onclick='javascript:deleteImage("
										+ images[i].id
										+ ");' class='t_c_red handable t_bolder'>删除</span>";
								html += "</div>";
							}
							$("#recharge_detail_images").html(html);
						}
					}
				});
	}
}

/**
 * [删除图片]
 * 
 * @param imageId
 */
function deleteImage(imageId) {
	$.messager.confirm("系统提示", "确定执行操作吗?", function(flag) {
		if (flag) {
			MaskUtil.mask();
			var params = {
				"imageId" : imageId
			};
			$.ajax({
				url : G_basePath + "/share/deleteImage.action",
				type : "POST",
				data : params,
				dataType : "JSON",
				success : function(result) {
					MaskUtil.unmask();
					if ("SUCCESS" == result.invokeState) {
						loadImageByDetial();
					} else {
						$.messager.alert("操作结果:", result.result);
					}
				}
			});
		}
	});
}

/**
 * [显示图片]
 * 
 * @param imagePath
 */
function toShow(imageId, imagePath) {
	$('#image_to_show_dialog').show();
	$('#image_to_show_dialog').window({
		width : 1100,
		height : 650,
	});
	$("#image_to_show").attr("src", imagePath);
}