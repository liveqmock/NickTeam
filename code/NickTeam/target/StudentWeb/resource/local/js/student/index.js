/**
 * [个人主页页面JS]
 */

$(function() {
	loadFinanceAccount(G_passportId);
	loadMyOperateablePorjectOrderCount();
	loadProjectInfoWithPage(1,3);
});

/**
 * [获取分业形式的项目信息]
 */
function loadProjectInfoWithPage(pageNumber, pageSize) {
	var params = {
		"projectInfoCriteria.dstatus" : "normal",
		"projectInfoCriteria.isOnline" : "y",
		"projectInfoCriteria.level" : "1",
		"projectInfoCriteria.needSubProject" : "y",
		"projectInfoCriteria.needCost" : "y",
		"rows" : pageSize,
		"page" : pageNumber,
	};
	$.ajax({
		url : G_basePath + "/project/getProjectInfoListWithPage.action",
		type : "POST",
		data : params,
		dataType : "JSON",
		success : function(result) {
			/* 将信息填入页面 */
			showProjectList(result.rows, "projectList");
		}
	});
}

/**
 * [展示项目列表]
 */
function showProjectList(list, elementId) {
	console.log(list);
	var html = "";
	$("#" + elementId).html(html);
	for (var i = 0; i < list.length; i++) {
		html += "<li>";
		html += "<h5 style='padding-left: 0;'>" + list[i].name +"</h5>";
		html += "<p><b class='font-28'>" + (100 + list[i].applyCount) + "</b> 人已申请</p>";
		html += "<div class='progress-bar'><s class='bar-red'></s></div>";
		html += "<div class='bar-text'>";
		html += "<span><b class='b-red'>" + list[i].shortName + "</span>";
		html += "<a href='" + G_basePath + "/router/toProjectApply.action' class='b-red'>我要申请></a>";
		html += "</div>";
		html += "<div class='line'></div>";
		html += "<li>";
	}
	$("#" + elementId).html(html);
}

/**
 * [获取财富账户]
 * 
 * @param passportId
 */
function loadFinanceAccount(passportId) {
	if (passportId) {
		var params = {
			"financeAccountCriteria.dstatus" : "normal",
			"financeAccountCriteria.requirePage" : false,
			"financeAccountCriteria.passportId" : passportId,
			"rows" : 1,
			"page" : 1
		};
		$.ajax({
			url : G_basePath + "/finance/getFinanceAccountWithPage.action",
			type : "POST",
			data : params,
			dataType : "JSON",
			success : function(result) {
				if (result) {
					var object = result.rows[0];
					$("#page_accountId").val(object.id);
					$("#v_canUseMoney").html("￥" + object.canUseMoneyStr);
					$("#v_frozenMoney").html("￥" + object.frozenMoneyStr);
				}
			}
		});
	} else {

	}
}

/**
 * [获取我当前正在申请的项目]
 */
function loadMyOperateablePorjectOrderCount() {
	$
			.ajax({
				url : G_basePath
						+ "/project/getMyOperateablePorjectOrderCount.action",
				type : "POST",
				data : {},
				dataType : "JSON",
				success : function(result) {
					console.log(result);
					if (result) {
						if ("SUCCESS" == result.invokeState) {
							if (0 < result.result) {
								$(".project_in_apply_num").html(
										"申请中项目有" + result.result + "个");
								$("#quick_nav_img")
										.attr(
												"href",
												G_basePath
														+ "/router/toMyProjectOrder.action");
								var starHTML = "";
								$("#star_num").html(starHTML);
								for (var i = 0; i < result.result; i++) {
									starHTML += "<s class='s-cat-12'></s>";
								}
								$("#star_num").html(starHTML);
							} else {
								$(".project_in_apply_num").html("申请中项目有0个");
								$("#quick_nav_img")
										.attr(
												"href",
												G_basePath
														+ "/router/toProjectApply.action");
							}
						} else {

						}
					}
				}
			});
}