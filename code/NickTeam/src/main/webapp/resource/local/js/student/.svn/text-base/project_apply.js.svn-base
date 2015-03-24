/**
 * [项目申请页面JS]
 */

$(function() {
	initIosSlider();
	loadProjectInfoWithPage(1, 4);
});

/**
 * [初始化广告位]
 */
function initIosSlider() {
	$('.iosSlider').iosSlider({
		scrollbar : true,
		snapToChildren : true,
		desktopClickDrag : true,
		autoSlide : true,
		scrollbarLocation : 'top',
		scrollbarMargin : '10px 10px 0 10px',
		scrollbarBorderRadius : '0',
		responsiveSlideWidth : true,
		navSlideSelector : $('.iosSliderButtons .button'),
		infiniteSlider : true,
		startAtSlide : '2',
		onSlideChange : slideContentChange,
	// onSlideComplete : slideContentComplete,
	// onSliderLoaded : slideContentLoaded
	});

	function slideContentChange(args) {

		/* indicator */
		$(args.sliderObject).parent().find('.iosSliderButtons .button')
				.removeClass('selected');
		$(args.sliderObject).parent().find(
				'.iosSliderButtons .button:eq(' + (args.currentSlideNumber - 1)
						+ ')').addClass('selected');

	}

	function slideContentComplete(args) {

		if (!args.slideChanged)
			return false;

		/* animation */
		$(args.sliderObject).find('.text1, .text2').attr('style', '');

		$(args.currentSlideObject).children('.text1').animate({
			right : '100px',
			opacity : '1'
		}, 400, 'easeOutQuint');

		$(args.currentSlideObject).children('.text2').delay(200).animate({
			right : '50px',
			opacity : '1'
		}, 400, 'easeOutQuint');

	}

	function slideContentLoaded(args) {

		/* animation */
		$(args.sliderObject).find('.text1, .text2').attr('style', '');

		$(args.currentSlideObject).children('.text1').animate({
			right : '100px',
			opacity : '1'
		}, 400, 'easeOutQuint');

		$(args.currentSlideObject).children('.text2').delay(200).animate({
			right : '50px',
			opacity : '1'
		}, 400, 'easeOutQuint');

		/* indicator */
		$(args.sliderObject).parent().find('.iosSliderButtons .button')
				.removeClass('selected');
		$(args.sliderObject).parent().find(
				'.iosSliderButtons .button:eq(' + (args.currentSlideNumber - 1)
						+ ')').addClass('selected');

	}
}

/**
 * [打开申请框]
 * 
 * @param projectId
 */
function openApplyDialog(projectId) {
	if (projectId) {
		// 设定映射参数
		var subProjectId = $("#p_a_subProjectSelect_" + projectId).val();
		var holderId = $("#p_a_holderSelect_" + projectId).val();
		if (subProjectId && holderId && "no_selected" != subProjectId
				&& "no_selected" != holderId) {
			$.messager
					.confirm(
							"系统提示",
							"确定执行下单操作吗?",
							function(flag) {
								if (flag) {
									var params = {
										"projectOrder.projectId" : projectId,
										"projectOrder.subProjectId" : subProjectId,
										"projectOrder.projectHolderId" : holderId,
									};
									$
											.ajax({
												url : G_basePath
														+ "/project/createProjectOrder.action",
												type : "POST",
												data : params,
												dataType : "JSON",
												success : function(result) {
													if ("SUCCESS" == result.invokeState) {
														// $.messager
														// .alert("系统提示",
														// "恭喜您,项目订单已提交,我们将对您的订单进行审核,届时客服将通过电话联系到您,请耐心等待");
														window.location.href = G_basePath
																+ "/router/toMyProjectOrder.action";
													} else {
														$.messager.alert(
																"系统提示",
																result.result);
													}
												}
											});
								} else {

								}
							});
		} else {
			$.messager.alert("系统提示", "请选择项目分期和主办方");
		}
	} else {
		$.messager.alert("系统提示", "项目信息实效，请刷新页面");
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
		"projectInfoCriteria.needImage" : "y",
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
			/* 生成分页数据 */
			$('#project_pager').pagination({
				pageList : [ 4, 10 ],
				total : result.total,
				pageSize : params.rows,
				pageNumber : params.page,
				onSelectPage : function(pageNumber, pageSize) {
					loadProjectInfoWithPage(pageNumber, pageSize);
				}
			});
		}
	});
}

/**
 * [展示项目列表]
 * 
 * @param list
 * @param elementId
 */
function showProjectList(list, elementId) {
	if (list) {
		var html = "";
		$("#" + elementId).html(html);
		for (var i = 0; i < list.length; i++) {
			html += "<li>";
			html += "<div class='apply-project'>";
			// 左侧
			html += "<div class='apply-project-left'>";
			html += "<s class='s-cat-29'></s><div class='apply-project-one'><span>项目"
					+ (i + 1) + "</span></div>";
			html += "</div>";
			// 中间内容部分
			html += "<div class='apply-project-right'>";
			html += "<div class='apply-project-content'>";
			html += "<h3 class='b-blue'>" + list[i].name + "-"
					+ list[i].shortName + "</h3>";
			html += "<div class='project-right-center'>";
			// 展示图片
			if (list[i].image) {
				html += "<div class='right-center-img'><a href='#'><img src='"
						+ list[i].image.imagePath + "' width='169px' height='134px' border='0'/></a></div>";
			} else {
				html += "<div class='right-center-img'><a href='#'><img width='169px' height='134px' src='"
						+ G_basePath
						+ "/resource/local/images/img-3.jpg' border='0'/></a></div>";
			}
			// 文本内容
			html += "<div class='right-center-text'>";
			// 项目时间
			html += "<dl><dt>选择您合适的时间：</dt><dd><select id='p_a_subProjectSelect_"
					+ list[i].id
					+ "' onchange='javascript:onSubProjectSelected("
					+ list[i].id
					+ ",this);'><option value='no_selected'>请选择项目时间</option>";
			for (var j = 0; j < list[i].subProjects.length; j++) {
				html += "<option value='" + list[i].subProjects[j].id + "'>"
						+ list[i].subProjects[j].startDateStr + "-"
						+ list[i].subProjects[j].endDateStr + "</option>";
			}
			html += "</select></dd></dl>";
			// 实习公司
			html += "<dl><dt>选择您满意的主办方：</dt><dd><select id='p_a_holderSelect_"
					+ list[i].id
					+ "' ><option value='no_selected'>请选择主办方</option></select></dd></dl>";
			// 项目费用
			html += "<dl>";
			for (var j = 0; j < list[i].costs.length; j++) {
				html += "<dt><span>" + list[i].costs[j].typeStr
						+ ":</span>";
				html += "<span>" + list[i].costs[j].cost + "</span>";
				html += "<span>" + list[i].costs[j].currencyStr
						+ "</span><span>&nbsp;&nbsp;</span></dt>";
			}
			html += "</dl>";
			html += "<dl><a href='" + list[i].msgAddress
					+ "' target='_blank'>点击查看项目详细信息</a></dl>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
			// 按钮
			html += "<div class='project-right-btn'>";
			html += "<a href='javascript:void(0);' onclick='javascript:openApplyDialog("
					+ list[i].id
					+ ");' class='blue-radius-btn'><s class='s-cat-30'></s>立即申请</a>";
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
 * [监听子项目选择框选择事件]
 */
function onSubProjectSelected(projectId, element) {
	if (projectId && element && $(element).val()) {
		var selectVal = $(element).val();
		var holderSelect = $(element).parent().parent().next().children()
				.next().children();
		var defaultOption = "<option value='no_selected'>请选择主办方</option>";
		if ("no_selected" == selectVal) {
			// 不去加载，并重置主办方选择板块
			holderSelect.html(defaultOption);
		} else {
			// 去加载主办方
			var params = {
				"projectHolderCriteria.projectId" : selectVal,
				"projectHolderCriteria.requirePage" : false,
				"rows" : 1,
				"page" : 1,

			};
			$.ajax({
				url : G_basePath
						+ "/project/getProjectHolderListWithPage.action",
				type : "POST",
				data : params,
				dataType : "JSON",
				success : function(result) {
					if (result.rows) {
						var list = result.rows;
						var option = defaultOption;
						for (var i = 0; i < list.length; i++) {
							option += "<option value='" + list[i].id + "'>"
									+ list[i].name + "</option>";
						}
						holderSelect.html(option);
					} else {
						holderSelect.html(defaultOption);
					}
				}
			});
		}
	}
}
