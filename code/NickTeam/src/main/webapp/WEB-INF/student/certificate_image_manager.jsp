<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>证件图片管理</title>
<jsp:include page="../include/common_header.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/resource/local/js/student/certificate_image_manager.js"></script>
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
										<b class="b-red"><s class="s-cat-21"></s>证件图片管理</b>&nbsp;&nbsp;&nbsp;<span class="font-12">Certificate Image</span>
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
					
						<div class="recharge-step">
							<form id="certificate_image_upload_form" action="#" method="post" enctype="multipart/form-data">
								<input name="certificateId" type="hidden" value=${certificateId } />
		                    	<div class="clear" style="height:20px;"></div>
		                    	<h5>证件照管理</h5>
		                        <div class="recharge-input">
		                        	<label>上传证件照：&nbsp;&nbsp;<input name="file" class="easyui-filebox" style="width:300px"></label>
		                        	<div class="clear"></div>
		                        </div>
		                        <div class="recharge-submit">
		                        	<div class="clear" style="height:16px;"></div>
		                        	<a href="javascript:void(0);" onclick="javascript:doAjaxUploadRechargeImage();" class="x-small a-blue">上传</a>
		                        	<a href="javascript:void(0);" onclick="javascript:toFinish();" class="x-small a-red" style="float:right;">完成上传</a>
		                        </div>
	                        </form>
                        </div>
                        
						<div class="recharge-step">
	                        <!-- 图片显示区域 -->
	                        <div id="certificate_images"></div>
	                   		<div class="clear"></div>
                        </div>
                        
	                	<div class="recharge-warm">
	                   		<div class="recharge-text">
	                        	<p class="b-red">温馨提示</p>
	                        	<br />
	                        	<h4><span>Question:什么能到账?</span><br />
	                        		<span>答：用户提交充值凭证后的三个工作日内，充值平台的预存金在退出充值平台后会解冻，成功退出后三个工作日内，预存金款项自然解冻。届时请到您的账户中查询确认。充值平台的预存金不支持部分解冻。</span><br />
	                        		<span>Question:什么能到账?</span>
								<br />
									<span>答：用户提交充值凭证后的三个工作日内，充值平台的预存金在退出充值平台后会解冻，成功退出后三个工作日内，预存金款项自然解冻。届时请到您的账户中查询确认。充值平台的预存金不支持部分解冻。</span></h4>
	                        </div>
	                   </div>
	                   <div class="clear" style="height:50px;"></div>
					
                    </div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 弹框区域 开始 -->
	<div id="image_to_show_dialog" title="显示大图" style="display: none;">
		<img id="image_to_show" src="" />
	</div>
	<!-- 弹框区域 结束 -->
	
	<!-- 隐藏域 -->
	<input id="page_certificateId" type="hidden" value="${certificateId }" />
</body>
</html>