<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的项目订单</title>
<jsp:include page="../include/common_header.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/resource/local/js/student/my_project_order.js"></script>
</head>
<body>
	<div id="index-bg">
		<div class="content">
			<div class="logo"></div>
			<div class="center apply-pages">
				<jsp:include page="../include/student/left_menu.jsp"></jsp:include>
				<div class="right-content">
					<!-- 右侧头部内容部分 -->
					<div class="right-content-top">
						<div class="icon-info">
							<ul>
								<li class="pages-apply">
									<h5>
										<b class="b-red"><s class="s-cat-21"></s>我的项目订单</b>&nbsp;&nbsp;&nbsp;<span class="font-12">Project Order</span>
									</h5>
								</li>
							</ul>
							<ul style="float: right; margin-right: 20px;">
								<!-- <li><a href="#" target="_blank"><s class="s-cat-09"></s></a></li> -->
								<li><a href="<%=path%>/router/exist.action"><s class="s-cat-10 current"></s><i class="s-cat-11">Log out</i></a></li>
							</ul>
						</div>
					</div>
					<!-- 页面内容部分 -->
					<div class="right-content-main">
						<div class="clear" style="height: 30px; border-top: 1px solid #fff;"></div>
	                    <div class="apply-item">
	                        <!-- 项目订单列表部分 -->
	                        <ul id="project_order_list"></ul>
	                    </div>
	                    <div class="clear" style="height:50px;"></div>
                    </div>
					<div id="project_order_pager" style="border: 1px solid #ccc; width: 100%;"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>