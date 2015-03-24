/**
 * [个人主页页面JS]
 */

$(function() {
	loadFinanceAccount(G_passportId);
	loadMyOperateablePorjectOrderCount();
	loadProjectInfoWithPage(1, 3);
	loadMyRunningProjectOrderWithPage(1, 1);
	newsanmi();
});

/**
 * [新闻动画]
 */
function newsanmi() {
	var speed = 30;
	var colee2 = document.getElementById("colee2");
	var colee1 = document.getElementById("colee1");
	var colee = document.getElementById("colee");
	colee2.innerHTML = colee1.innerHTML; // 克隆colee1为colee2
	function Marquee1() {
		// 当滚动至colee1与colee2交界时
		if (colee2.offsetTop - colee.scrollTop < 0) {
			colee.scrollTop -= colee.offsetHeight; // colee跳到最顶端
		} else {
			colee.scrollTop++;
		}
	}
	var MyMar1 = setInterval(Marquee1, speed);// 设置定时器
	// 鼠标移上时清除定时器达到滚动停止的目的
	colee.onmouseover = function() {
		clearInterval(MyMar1);
	}
	// 鼠标移开时重设定时器
	colee.onmouseout = function() {
		MyMar1 = setInterval(Marquee1, speed);
	}
}

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
	// console.log(list);
	var html = "";
	$("#" + elementId).html(html);
	for (var i = 0; i < list.length; i++) {
		html += "<li>";
		html += "<h5 style='padding-left: 0;'>" + list[i].name + "</h5>";
		console.log(list[i].applyCount);
		html += "<p><b class='font-28'>" + (100 + list[i].applyCount)
				+ "</b> 人已申请</p>";
		html += "<div class='progress-bar'><s class='bar-red'></s></div>";
		html += "<div class='bar-text'>";
		html += "<span><b class='b-red'>" + list[i].shortName + "</b></span>";
		html += "<a href='" + G_basePath
				+ "/router/toProjectApply.action' class='b-red'>我要申请></a>";
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
					// console.log(result);
					if (result) {
						if ("SUCCESS" == result.invokeState) {
							if (0 < result.result) {
								$(".project_in_apply_num").html(
										"申请中项目有" + result.result + "个");
								$("#quick_nav_a")
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
								$("#quick_nav_a")
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

/**
 * [获取我的第一张正在运行的订单]
 */
function loadMyRunningProjectOrderWithPage(pageNumber, pageSize) {
	var params = {
		"projectOrderCriteria.requirePage" : true,
		"projectOrderCriteria.dstatus" : "normal",
		"projectOrderCriteria.needProjectInfo" : "n",
		"projectOrderCriteria.needSubProjectInfo" : "n",
		"projectOrderCriteria.needPassport" : "n",
		"projectOrderCriteria.needProjectHolder" : "n",
		"projectOrderCriteria.needProjectImage" : "n",
		"projectOrderCriteria.passportId" : G_passportId,
		"rows" : pageSize,
		"page" : pageNumber,
	};
	$.ajax({
		url : G_basePath
				+ "/project/getMyRunningPorjectOrderListWithPage.action",
		type : "POST",
		data : params,
		dataType : "JSON",
		success : function(result) {
			if (result) {
				if (0 < result.total) {
					showMyFirstProjectOrderStatus(JSON
							.stringify(result.rows[0]));
				}
			}
		}
	});
}

/**
 * [展示我的第一个订单信息]
 * 
 * @param order
 */
function showMyFirstProjectOrderStatus(orderStr) {
	var order = JSON.parse(orderStr);
	if ("waitJudgement" == order.status) {// 待审核
		$("#quick_nav_img").attr("src",
				G_basePath + "/resource/local/images/progress_03.png");
	} else if ("judgementError" == order.status) { // 审核失败
		$("#quick_nav_img").attr("src",
				G_basePath + "/resource/local/images/progress_01.png");
	} else if ("waitSignPay" == order.status) {// 等待支付报名费
		$("#quick_nav_img").attr("src",
				G_basePath + "/resource/local/images/progress_08.png");
	} else if ("waitInterview" == order.status) {// 待分配面试
		$("#quick_nav_img").attr("src",
				G_basePath + "/resource/local/images/progress_10.png");
	} else if ("interViewSigned" == order.status) {// 待面试
		$("#quick_nav_img").attr("src",
				G_basePath + "/resource/local/images/progress_15.png");
	} else if ("interViewFailed" == order.status) {// 面试失败
		$("#quick_nav_img").attr("src",
				G_basePath + "/resource/local/images/progress_05.png");
	} else if ("waitProjectPay" == order.status) {// 待支付项目费用
		$("#quick_nav_img").attr("src",
				G_basePath + "/resource/local/images/progress_17.png");
	} else {
		$("#quick_nav_img").attr("src",
				G_basePath + "/resource/local/images/img-2.jpg");
	}
}