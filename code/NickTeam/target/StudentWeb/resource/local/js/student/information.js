/**
 * [用户信息页面js]
 */

$(function() {
	//loadUserEducationList();
	//loadUserContactList();
	loadUserCertificateList();
});

/**
 * [打开－修改用户通行证－窗口]
 */
function openUpdatePassportDialog() {
	$('#update_passport_dialog').show();
	$('#update_passport_dialog').window({
		width : 600,
		height : 220,
	});
}

/**
 * [打开－修改基础信息－窗口]
 */
function openUpdateBaseInfoDialog() {
	$('#update_base_info_dialog').show();
	$('#update_base_info_dialog').window({
		width : 950,
		height : 400,
	});
	$("#u_province_city_county").html("");
	// 选择省市县的下啦菜单
	var options = {
		"provinceId" : '',
		"cityId" : '',
		"countyId" : '',
		"provinceName" : 'passport.province',
		"cityName" : 'passport.city',
		"countyName" : 'passport.county',
	};
	$("#u_province_city_county").ProvinceCity(options);
}

/**
 * [打开－创建教育经历－窗口]
 */
function openCreateEducationDialog() {
	$('#create_education_dialog').show();
	$('#create_education_dialog').window({
		width : 600,
		height : 180,
	});
	$('#create_education_form').form("reset");
}

/**
 * [打开－创建用户联系人－窗口]
 */
function openCreateContactDialog() {
	$('#create_contact_dialog').show();
	$('#create_contact_dialog').window({
		width : 600,
		height : 180,
	});
	$('#create_contact_form').form("reset");
}

/**
 * [打开－创建证件信息－窗口]
 */
function openCreateCertificateDialog() {
	$('#create_certificate_dialog').show();
	$('#create_certificate_dialog').window({
		width : 600,
		height : 230,
	});
	$('#create_certificate_form').form("reset");
}

/**
 * [创建用户联系人－异步方式提交]
 */
function doAjaxCreateContact() {
	var flag = $('#create_contact_form').form("validate");
	if (!flag) {

	} else {
		$('#create_contact_dialog').window("close");
		$('#create_contact_form').form({
			url : G_basePath + "/user/createUserContact.action",
			success : function(data) {
				var result = JSON.parse(data);
				if ("SUCCESS" == result.invokeState) {
					$.messager.alert("操作提示", "创建成功");
					$('#contact_datagrid').datagrid("reload");
				} else {
					$.messager.alert("操作提示", "创建失败");
				}
			}
		});
		$('#create_contact_form').submit();
	}
}

/**
 * [更新通行证信息－异步方式提交]
 */
function doAjaxUpdatePassport() {
	var flag = $('#update_passport_form').form("validate");
	if (!flag) {
	} else {
		$('#update_passport_dialog').window("close");
		$('#update_passport_form')
				.form(
						{
							url : G_basePath
									+ "/user/updatePassportInfo.action",
							onSubmit : function() {
								var u_passowrd1 = $("#u_password1").val();
								var u_passowrd2 = $("#u_password2").val();
								if ((!u_passowrd1 && !u_passowrd2)
										|| (u_passowrd1 && u_passowrd2 && u_passowrd1 == u_passowrd2)) {
									return true;
								} else {
									$.messager.alert("验证提示", "密码输入不正确");
									return false;
								}
							},
							success : function(data) {
								var result = JSON.parse(data);
								if ("SUCCESS" == result.invokeState) {
									location.reload();
								} else {
									$.messager.alert("操作提示", "更新失败");
								}
							}
						});
		$('#update_passport_form').submit();
	}
}

/**
 * [更新用户基础信息－异步方式提交]
 */
function doAjaxUpdateBaseInfo() {
	var flag = $('#update_base_info_form').form("validate");
	if (!flag) {
	} else {
		$('#update_base_info_dialog').window("close");
		$('#update_base_info_form').form({
			url : G_basePath + "/user/updatePassportInfo.action",
			onSubmit : function() {
			},
			success : function(data) {
				var result = JSON.parse(data);
				if ("SUCCESS" == result.invokeState) {
					location.reload();
				} else {
					$.messager.alert("操作提示", "更新失败");
				}
			}
		});
		$('#update_base_info_form').submit();
	}
}

/**
 * [创建教育经历－异步方式提交]
 */
function doAjaxCreateEducation() {
	var flag = $('#create_education_form').form("validate");
	if (!flag) {
	} else {
		$('#create_education_dialog').window("close");
		$('#create_education_form').form({
			url : G_basePath + "/user/createUserEducation.action",
			success : function(data) {
				var result = JSON.parse(data);
				if ("SUCCESS" == result.invokeState) {
					$.messager.alert("操作提示", "创建成功");
					$('#education_datagrid').datagrid("reload");
				} else {
					$.messager.alert("操作提示", "创建失败");
				}
			}
		});
		$('#create_education_form').submit();
	}
}

/**
 * [创建用户证件－异步方式提交]
 */
function doAjaxCreateCertificate() {
	var flag = $('#create_certificate_form').form("validate");
	if (!flag) {
	} else {
		$('#create_certificate_dialog').window("close");
		$('#create_certificate_form').form({
			url : G_basePath + "/user/createUserCertificate.action",
			success : function(data) {
				var result = JSON.parse(data);
				if ("SUCCESS" == result.invokeState) {
					$.messager.alert("操作提示", "创建成功");
					$('#certificate_datagrid').datagrid("reload");
				} else {
					$.messager.alert("操作提示", "创建失败");
				}
			}
		});
		$('#create_certificate_form').submit();
	}
}

/**
 * [获取用户教育经历列表]
 */
/*
function loadUserEducationList() {
	$('#education_datagrid')
			.datagrid(
					{
						height : 150,
						url : G_basePath + "/user/getUserEducationList.action",
						columns : [ [
								{
									field : 'id',
									title : '操作',
									width : 100,
									align : "center",
									formatter : function(value, rec) {
										return "<a href='javascript:void(0);' onclick='javascript:deleteEducation("
												+ value + ");'>删除</a>";
									}
								}, {
									field : 'schoolName',
									title : '学校名称',
									width : 100
								}, {
									field : 'startDateStr',
									title : '入学时间',
									width : 100
								}, {
									field : 'endDateStr',
									title : '毕业时间',
									width : 100
								}, {
									field : 'type',
									title : '学校类型',
									width : 100,
									formatter : function(value) {
										var str = "";
										if ("junior" == value) {
											str = "初中";
										}
										if ("high" == value) {
											str = "高中";
										}
										if ("college" == value) {
											str = "大学";
										}
										if ("training" == value) {
											str = "培训机构";
										}
										return str;
									}
								} ] ]
					});
}*/

/**
 * [获取用户联系人列表]
 */
/*
function loadUserContactList() {
	$('#contact_datagrid')
			.datagrid(
					{
						height : 150,
						url : G_basePath + "/user/getUserContactList.action",
						columns : [ [
								{
									field : 'id',
									title : '操作',
									width : 100,
									align : "center",
									formatter : function(value, rec) {
										return "<a href='javascript:void(0);' onclick='javascript:deleteContact("
												+ value + ");'>删除</a>";
									}
								}, {
									field : 'name',
									title : '联系人名',
									width : 100
								}, {
									field : 'email',
									title : '联系邮箱',
									width : 150
								}, {
									field : 'mobile',
									title : '联系手机',
									width : 120
								}, {
									field : 'type',
									title : '学校类型',
									width : 100,
									formatter : function(value) {
										var str = "";
										if ("father" == value) {
											str = "父亲";
										}
										if ("monther" == value) {
											str = "母亲";
										}
										if ("classmate" == value) {
											str = "同学";
										}
										if ("other" == value) {
											str = "其他";
										}
										return str;
									}
								} ] ]
					});
}
*/

/**
 * [获取用户证件列表]
 */
function loadUserCertificateList() {
	$('#certificate_datagrid')
			.datagrid(
					{
						height : 150,
						url : G_basePath
								+ "/user/getUserCertificateList.action",
						columns : [ [
								{
									field : 'id',
									title : '操作',
									width : 150,
									align : "center",
									formatter : function(value, rec) {
										var html = "";
										html += "<a href='javascript:void(0);' onclick='javascript:deleteCertificate("
												+ value
												+ ");'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;";
										html += "<a href='javascript:void(0);' onclick='javascript:toManagerCertificateImage("
												+ value + ");'>上传证件照</a>";
										return html;
									}
								}, {
									field : 'num',
									title : '证件号',
									width : 150
								}, {
									field : 'type',
									title : '证件类型',
									width : 100,
									formatter : function(value) {
										var str = "";
										if ("identity" == value) {
											str = "身份证";
										}
										if ("passport" == value) {
											str = "护照";
										}
										if ("hkmacao" == value) {
											str = "港澳通行证";
										}
										return str;
									}
								}, {
									field : 'startDateStr',
									title : '有效期起始',
									width : 150
								}, {
									field : 'endDateStr',
									title : '有效期终止',
									width : 120
								}, {
									field : 'description',
									title : '备注信息',
									width : 150
								} ] ]
					});
}

/**
 * [跳转到]
 * 
 * @param certificateId
 */
function toManagerCertificateImage(certificateId) {
	if (certificateId) {
		window.location.href = G_basePath
				+ "/router/toCertificateImageManager.action?certificateId="
				+ certificateId;
	}
}

/**
 * [删除用户教育经历]
 * 
 * @param id
 */
function deleteEducation(id) {
	if (id && 0 != id) {
		var params = {
			"educationId" : id
		};
		$.ajax({
			url : G_basePath + "/user/deleteUserEducation.action",
			type : "POST",
			data : params,
			dataType : "JSON",
			success : function(result) {
				if ("SUCCESS" == result.invokeState) {
					$('#education_datagrid').datagrid("reload");
				} else {
					$.messager.alert("操作提示", "删除用户教育信息失败");
				}
			}
		});
	} else {
		$.messager.alert("操作提示", "教育经历数据错误，请尝试刷新页面");
	}
}

/**
 * [删除用户联系人]
 * 
 * @param id
 */
function deleteContact(id) {
	if (id && 0 != id) {
		var params = {
			"contactId" : id
		};
		$.ajax({
			url : G_basePath + "/user/deleteUserContact.action",
			type : "POST",
			data : params,
			dataType : "JSON",
			success : function(result) {
				if ("SUCCESS" == result.invokeState) {
					$('#contact_datagrid').datagrid("reload");
				} else {
					$.messager.alert("操作提示", "删除用户联系人信息失败");
				}
			}
		});
	} else {
		$.messager.alert("操作提示", "联系人信息数据错误，请尝试刷新页面");
	}
}

/**
 * [删除用户证件]
 * 
 * @param id
 */
function deleteCertificate(id) {
	if (id && 0 != id) {
		var params = {
			"certificateId" : id
		};
		$.ajax({
			url : G_basePath + "/user/deleteUserCertificate.action",
			type : "POST",
			data : params,
			dataType : "JSON",
			success : function(result) {
				if ("SUCCESS" == result.invokeState) {
					$('#certificate_datagrid').datagrid("reload");
				} else {
					$.messager.alert("操作提示", "删除用户证件信息失败");
				}
			}
		});
	} else {
		$.messager.alert("操作提示", "用户证件信息数据错误，请尝试刷新页面");
	}
}