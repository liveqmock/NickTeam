/**
 * [我的项目订单页面JS]
 */
$(function() {
	loadMyProjectOrderWithPage(1, 3);
	// alert(G_passportId);
});

/**
 * [获取分业形式的项目订单信息]
 */
function loadMyProjectOrderWithPage(pageNumber, pageSize) {
	var params = {
		"projectOrderCriteria.requirePage" : true,
		"projectOrderCriteria.dstatus" : "normal",
		"projectOrderCriteria.needProjectInfo" : "y",
		"projectOrderCriteria.needSubProjectInfo" : "y",
		"projectOrderCriteria.needPassport" : "y",
		"projectOrderCriteria.needProjectHolder" : "y",
		"projectOrderCriteria.needProjectImage" : "y",
		"projectOrderCriteria.passportId" : G_passportId,
		"rows" : pageSize,
		"page" : pageNumber,
	};
	$.ajax({
		url : G_basePath + "/project/getProjectOrderListWithPage.action",
		type : "POST",
		data : params,
		dataType : "JSON",
		success : function(result) {
			console.log(result);
			/* 将信息填入页面 */
			showProjectOrderList(result.rows, "project_order_list");
			/* 生成分页数据 */
			$('#project_order_pager').pagination({
				pageList : [ 3, 10 ],
				total : result.total,
				pageSize : params.rows,
				pageNumber : params.page,
				onSelectPage : function(pageNumber, pageSize) {
					loadMyProjectOrderWithPage(pageNumber, pageSize);
				}
			});
		}
	});
}

/**
 * [展示项目订单列表]
 * 
 * @param list
 * @param elementId
 */
function showProjectOrderList(list, elementId) {
	if (list) {
		var html = "";
		$("#" + elementId).html(html);
		for (var i = 0; i < list.length; i++) {
			html += "<li>";
			html += "<div class='apply-project'>";
			// 左侧
			html += "<div class='apply-project-left'>";
			html += "<s class='s-cat-29'></s><div class='apply-project-one'><span>已申请项目"
					+ (i + 1) + "</span></div>";
			html += "</div>";
			// 中间内容部分
			html += "<div class='apply-project-right'>";
			html += "<div class='apply-project-content'>";
			html += "<h3 class='b-blue'>" + list[i].projectInfo.name + "</h3>";
			html += "<div class='project-right-center'>";
			// 展示图片
			if (list[i].projectImage) {
			html += "<div class='right-center-img'><a href='#'><img src='"
					+ list[i].projectImage.imagePath
					+ "' width='169px' height='134px' border='0'/></a></div>";
			} else {
				html += "<div class='right-center-img'><a href='#'><img src='"
						+ G_basePath
						+ "/resource/local/images/img-3.jpg' border='0'/></a></div>";
			}
			// 文本内容
			html += "<div class='right-center-text apply-dt'>";
			html += "<dl><dt>项目时间&nbsp;&nbsp;:&nbsp;&nbsp;"
					+ list[i].subProjectInfo.startDateStr
					+ "&nbsp;&nbsp;-&nbsp;&nbsp;"
					+ list[i].subProjectInfo.endDateStr + "</dt><dd></dd></dl>";
			html += "<dl><dt>实习公司&nbsp;&nbsp;:&nbsp;&nbsp;"
					+ list[i].projectHolder.name + "</dt><dd></dd></dl>";
			html += "<dl><dt>当前项目申请状态&nbsp;&nbsp;:&nbsp;&nbsp;</dt><dd><h5><a href='#'>"
					+ list[i].statusStr + "</a></h5></dd></dl>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
			// 按钮
			html += "<div class='project-right-btn'>";
			html += "<a href='javascript:void(0);' onclick='javascript:toMyProjectOrderDetail("
					+ list[i].id
					+ ");' class='blue-radius-btn'><s class='s-cat-30'></s>查看详情</a>";
			html += "</div>";
			// 结尾
			html += "</div>";
			html += "</div>";
			html += "<div class='gray-circle'></div>";
			html += "</li>";
		}
		$("#" + elementId).html(html);
	}
}

/**
 * [跳转到我的项目订单详细页面]
 */
function toMyProjectOrderDetail(orderId) {
	if (orderId) {
		window.location.href = G_basePath
				+ "/router/toMyProjectOrderDetail.action?orderId=" + orderId;
	}
}