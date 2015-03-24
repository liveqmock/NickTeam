<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>项目申请</title>
<jsp:include page="../include/common_header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="<%=path%>/resource/local/css/advert/project/project_advert.css"></link>
<script type="text/javascript" src="<%=path%>/resource/local/js/student/project_apply.js"></script>
</head>
<body>
	<div id="index-bg">
		<div class="content">
			<div class="logo"></div>
			<div class="center apply-pages" style="background: #f6f6f6;">
				<jsp:include page="../include/student/left_menu.jsp"></jsp:include>
				<div class="right-content">
					<div class="right-content-top">
						<div class="icon-info">
							<ul>
								<li class="pages-apply">
									<h5>
										<b class="b-red"><s class="s-cat-21"></s>项目申请</b>&nbsp;&nbsp;&nbsp;<span
											class="font-12">Project Application</span>
									</h5>
								</li>
							</ul>
							<ul style="float: right; margin-right: 20px;">
								<!-- <li><a href="#" target="_blank"><s class="s-cat-09"></s></a></li> -->
								<li><a href="<%=path%>/router/exist.action"> <s class="s-cat-10 current"></s> <i class="s-cat-11">Log out</i>
								</a></li>
							</ul>
						</div>
					</div>
					<!-- 页面内容部分 -->
					<div class="right-content-main">
						<div class = 'iosSlider'>
							<div class = 'slider'>
								<div class = 'item' id = 'item1'>
									<div class = 'text1'><span>Touch Me.</span></div>
									<div class = 'text2'><span>Hardware accelerated using<br />CSS3 for supported iOS,<br />Android and WebKit</span></div>
								</div>
								<div class = 'item' id = 'item2'>
									<div class = 'text1'><span>Responsive.</span></div>
									<div class = 'text2'><span>Respond to change in browser<br />width and adjust automatically</span></div>
								</div>
								<div class = 'item' id = 'item3'>
									<div class = 'text1'><span>Flexible.</span></div>
									<div class = 'text2'><span>Run multiple sliders on<br />the same web page</span></div>
								</div>
								<div class = 'item' id = 'item4'>
									<div class = 'text1'><span>Customize.</span></div>
									<div class = 'text2'><span>Set momentum, elasticity,<br />scrollbars and more...</span></div>
								</div>
							</div>
							<div class = 'iosSliderButtons'>
								<div class = 'button'></div>
								<div class = 'button'></div>
								<div class = 'button'></div>
								<div class = 'button'></div>
							</div>
						</div>
						<div class="clear"
							style="height: 30px; border-top: 1px solid #fff;"></div>
						<!-- 项目列表部分 -->
						<div class="apply-item">
							<ul id="projectList">
							</ul>
						</div>
					</div>
					<div class="clear" style="height: 50px;"></div>
					<div id="project_pager" style="border: 1px solid #ccc; width: 100%;"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>