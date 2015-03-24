<%@page import="com.wuya.base.enumerate.user.StudentGradeEnum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.wuya.base.enumerate.user.SchoolTypeEnum" %>
<%@ page import="com.wuya.base.enumerate.user.ContactTypeEnum" %>
<%@ page import="com.wuya.base.enumerate.user.SexEnum" %>
<%@ page import="com.wuya.base.enumerate.user.CertificateTypeEnum" %>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的信息</title>
<jsp:include page="../include/common_header.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/resource/local/js/student/information.js"></script>
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
										<b class="b-red"><s class="s-cat-21"></s>基础资料</b>&nbsp;&nbsp;&nbsp;<span
											class="font-12">Biography</span>
									</h5>
								</li>
							</ul>
							<ul style="float: right; margin-right: 20px;">
								<!-- <li><a href="#" target="_blank"><s class="s-cat-09"></s></a></li> -->
								<li><a href="<%=path%>/router/exist.action"><s class="s-cat-10 current"></s> <i class="s-cat-11">Log out</i>
								</a></li>
							</ul>
						</div>
					</div>
					<div class="clear" style="height: 20px;"></div>
					<div class="record password">
						<div>
							<p style="float: left;" class="b-blue">账户信息</p>
							<div style="float: right; margin-left: 10px;">
								<a href="javascript:void(0);" onclick="javascript:openUpdatePassportDialog();" class="easyui-linkbutton">修改及重置密码</a>
							</div>
						</div>
						<div class="clear" style="height: 20px;"></div>
						<dl>
							<dt>
								<b class="b-red" style="display: none;">*</b> <span>用户名</span>
								<input class="input-300" disabled="disabled" value="${sessionScope.PASSPORT_INFO.username }">
							</dt>
						</dl>
						<dl>
							<dt>
								<b class="b-red" style="display: none;">*</b> <span>电子邮箱</span>
								<input class="input-300" disabled="disabled" value="${sessionScope.PASSPORT_INFO.email }">
							</dt>
							<dt>
								<b class="b-red" style="display: none;">*</b> <span>手机号码</span>
								<input class="input-300" disabled="disabled" value="${sessionScope.PASSPORT_INFO.mobile }">
							</dt>
						</dl>
						<div class="clear"></div>
					</div>
					<div class="password">
						<div class="dashed-gray"></div>
					</div>
					<div class="record-one record-two">
						<div>
							<p style="float: left;" class="b-blue">基础信息</p>
							<a style="float: right;" href="javascript:void(0);" onclick="javascript:openUpdateBaseInfoDialog();" class="easyui-linkbutton">修改基础信息</a>
						</div>
						<div class="clear"></div>
						<table cellspacing="10">
							<tr>
								<td width="10%;" style="text-align: right;">真实姓名</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.trueName }">
								</td>
								<td width="10%;" style="text-align: right;">中文拼音</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.pinyin }">
								</td>
								<td width="10%;" style="text-align: right;">性别</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.sexStr }" />
								</td>
							</tr>
							<tr>
								<td width="10%;" style="text-align: right;">QQ账号</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.qqAcount }" />
								</td>
								<td width="10%;" style="text-align: right;">微信账号</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.weixinAccount }" />
								</td>
								<td width="10%;" style="text-align: right;">出生日期</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.birthdayStr }" />
								</td>
							</tr>
							<tr>
								<td width="10%;" style="text-align: right;">就读高中</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.highSchoolName }" />
								</td>
								<td width="10%;" style="text-align: right;">曾读初中</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.juniorSchoolName }" />
								</td>
								<td width="10%;" style="text-align: right;">所在年级</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.gradeStr }" />
								</td>
							</tr>
							<tr>
								<td width="10%;" style="text-align: right;">毕业时间</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.graduateTimeStr }" />
								</td>
								<td width="10%;" style="text-align: right;"></td>
								<td width="10%;" style="text-align: left;">
								</td>
								<td width="10%;" style="text-align: right;"></td>
								<td width="10%;" style="text-align: left;"></td>
							</tr>
							<tr>
								<td width="10%;" style="text-align: right;">所在省</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.province }" />
								</td>
								<td width="10%;" style="text-align: right;">所在市</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.city }" />
								</td>
								<td width="10%;" style="text-align: right;">所在区县</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.county }" />
								</td>
							</tr>
							<tr>
								<td width="10%;" style="text-align: right;">详细地址</td>
								<td width="10%;" style="text-align: left;" colspan="5">
									<input type="text" class="easyui-validatebox input-825" disabled="disabled" value="${sessionScope.PASSPORT_INFO.address }" />
								</td>
							</tr>
							<tr>
								<td width="10%;" style="text-align: right;">父亲姓名</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.fatherName }" />
								</td>
								<td width="10%;" style="text-align: right;">父亲联系邮箱</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.fatherEmail }" />
								</td>
								<td width="10%;" style="text-align: right;">父亲联系手机</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.fatherMobile }" />
								</td>
							</tr>
							<tr>
								<td width="10%;" style="text-align: right;">母亲姓名</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.motherName }" />
								</td>
								<td width="10%;" style="text-align: right;">母亲联系邮箱</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.motherEmail }" />
								</td>
								<td width="10%;" style="text-align: right;">母亲联系手机</td>
								<td width="10%;" style="text-align: left;">
									<input type="text" class="easyui-validatebox input-175" disabled="disabled" value="${sessionScope.PASSPORT_INFO.motherMobile }" />
								</td>
							</tr>
						</table>
					</div>
					<div class="password">
						<div class="dashed-gray"></div>
					</div>
					<!-- 
					<div class="record-one record-two">
						<div>
							<p class="b-blue" style="float: left;">教育经历</p>
							<a style="float: right;" href="javascript:void(0);" onclick="javascript:openCreateEducationDialog();" class="easyui-linkbutton">添加教育信息</a>
						</div>
						<div class="clear"></div>
						<table id="education_datagrid">
						</table>
					</div>
					<div class="password">
						<div class="dashed-gray"></div>
					</div>
					<div class="record-one record-two">
						<div>
							<p class="b-blue" style="float: left;">联系人</p>
							<a style="float: right;" href="javascript:void(0);" onclick="javascript:openCreateContactDialog();" class="easyui-linkbutton">添加联系人</a>
						</div>
						<div class="clear"></div>
						<table id="contact_datagrid"></table>
						<div class="clear"></div>
						<div class="dashed-gray"></div>
					</div>
					 -->
					<div class="record-one record-two">
						<div>
							<p class="b-blue" style="float: left;">相关证件</p>
							<a style="float: right;" href="javascript:void(0);" onclick="javascript:openCreateCertificateDialog();" class="easyui-linkbutton">添加用户证件</a>
						</div>
						<div class="clear"></div>
						<table id="certificate_datagrid"></table>
						<div class="clear"></div>
						<div class="dashed-gray"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 弹出框 开始 -->
	<!-- 更新通行证 -->
	<div id="update_passport_dialog" style="display: none;" title="更新账户信息">
		<form id="update_passport_form" action="#" method="post">
			<input type="hidden" name="passport.id" value="${sessionScope.PASSPORT_INFO.id }"/>
			<input type="hidden" name="passport.domain" value="${sessionScope.PASSPORT_INFO.domain }"/>
			<table style="padding: 10px"  cellspacing="10">
				<tr>
					<td width="25%" style="text-align: right;">邮箱地址:</td>
					<td width="25%" style="text-align: left;">
						<input name="passport.email" type="text" class="easyui-validatebox width_175" required="required" value="${sessionScope.PASSPORT_INFO.email }" />
					</td>
					<td width="25%" style="text-align: right;">用户名:</td>
					<td width="25%" style="text-align: left;">
						<input name="passport.username" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.username }" />
					</td>
				</tr>
				<tr>
					<td width="25%" style="text-align: right;">手机号码:</td>
					<td width="25%" style="text-align: left;">
						<input name="passport.mobile" type="text" class="easyui-validatebox width_175"  value="${sessionScope.PASSPORT_INFO.mobile }" />
					</td>
				</tr>
				<tr>
					<td width="25%" style="text-align: right;">重设密码:</td>
					<td width="25%" style="text-align: left;">
						<input id="u_password1" name="passport.password" type="password" class="easyui-validatebox width_175"/>
					</td>
					<td width="25%" style="text-align: right;">确认密码:</td>
					<td width="25%" style="text-align: left;">
						<input id="u_password2" type="password" class="easyui-validatebox width_175"/>
					</td>
				</tr>
			</table>
			<div class="t_center">
				<a href="javascript:void(0);" onclick="javascript:doAjaxUpdatePassport();" class="easyui-linkbutton t_center">保存账户信息修改</a>
			</div>
		</form>
	</div>
	
	<!-- 更新基础信息 -->
	<div id="update_base_info_dialog" style="display: none;" title="更新基础信息">
		<form id="update_base_info_form" action="#" method="post">
			<input type="hidden" name="passport.id" value="${sessionScope.PASSPORT_INFO.id }"/>
			<input type="hidden" name="passport.domain" value="${sessionScope.PASSPORT_INFO.domain }"/>
			<table style="padding: 10px"  cellspacing="10">
				<tr>
					<td width="16%" style="text-align: right;">真实姓名:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.trueName" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.trueName }" />
					</td>
					<td width="16%" style="text-align: right;">中文拼音:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.pinyin" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.pinyin }" />
					</td>
					<td width="16%" style="text-align: right;">性别:</td>
					<td width="16%" style="text-align: left;">
						<select name="passport.sex" class="easyui-combobox width_175">
							<%=SexEnum.getAsDropDownOption() %>
						</select>
					</td>
				</tr>
				<tr>
					<td width="16%" style="text-align: right;">QQ账号:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.qqAcount" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.qqAcount }"/>
					</td>
					<td width="16%" style="text-align: right;">微信账号:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.weixinAccount" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.weixinAccount }"/>
					</td>
					<td width="16%" style="text-align: right;">出生日期:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.birthday" type="text" class="easyui-datebox width_175"/>
					</td>
				</tr>
				<tr>
					<td width="16%" style="text-align: right;">就读高中:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.highSchoolName" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.highSchoolName }"/>
					</td>
					<td width="16%" style="text-align: right;">曾读初中:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.juniorSchoolName" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.juniorSchoolName }"/>
					</td>
					<td width="16%" style="text-align: right;">所在年级:</td>
					<td width="16%" style="text-align: left;">
						<select name="passport.grade" class="easyui-combobox width_175">
							<%=StudentGradeEnum.getAsDropDownOption() %>
						</select>
					</td>
				</tr>
				<tr>
					<td width="16%" style="text-align: right;">毕业时间:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.graduateTime" type="text" class="easyui-datebox width_175"/>
					</td>
					<td width="16%" style="text-align: right;"></td>
					<td width="16%" style="text-align: left;">
					</td>
					<td width="16%" style="text-align: right;"></td>
					<td width="16%" style="text-align: left;">
					</td>
				</tr>
				<tr>
					<td width="16%" style="text-align: right;">选择地区:</td>
					<td width="16%" style="text-align: left;" colspan="5">
						<div id="u_province_city_county"></div>
					</td>
				</tr>
				<tr>
					<td width="16%" style="text-align: right;">具体地址:</td>
					<td width="16%" style="text-align: left;" colspan="5">
						<input name="passport.address" type="text" class="easyui-validatebox width_800" value="${sessionScope.PASSPORT_INFO.address }"/>
					</td>
				</tr>
				<tr>
					<td width="16%" style="text-align: right;">父亲姓名:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.fatherName" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.fatherName }"/>
					</td>
					<td width="16%" style="text-align: right;">父亲邮箱地址:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.fatherEmail" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.fatherEmail }"/>
					</td>
					<td width="16%" style="text-align: right;">父亲联系电话:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.fatherMobile" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.fatherMobile }"/>
					</td>
				</tr>
				<tr>
					<td width="16%" style="text-align: right;">母亲姓名:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.motherName" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.motherName }"/>
					</td>
					<td width="16%" style="text-align: right;">母亲邮箱地址:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.motherEmail" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.motherEmail }"/>
					</td>
					<td width="16%" style="text-align: right;">母亲联系电话:</td>
					<td width="16%" style="text-align: left;">
						<input name="passport.motherMobile" type="text" class="easyui-validatebox width_175" value="${sessionScope.PASSPORT_INFO.motherMobile }"/>
					</td>
				</tr>
			</table>
			<div class="t_center">
				<a href="javascript:void(0);" onclick="javascript:doAjaxUpdateBaseInfo();" class="easyui-linkbutton t_center">保存基础信息修改</a>
			</div>
		</form>
	</div>
	
	<!-- 创建教育经历 -->
	<div id="create_education_dialog" style="display: none;" title="创建教育经历">
		<form id="create_education_form" action="#" method="post">
			<table style="padding: 10px"  cellspacing="10">
				<tr>
					<td width="25%" style="text-align: right;">学校名称:</td>
					<td width="25%" style="text-align: left;">
						<input name="userEducation.schoolName" type="text" class="easyui-validatebox width_175" required="required" />
					</td>
					<td width="25%" style="text-align: right;">学校类型:</td>
					<td width="25%" style="text-align: left;">
						<select name="userEducation.type" type="text" class="easyui-combobox width_175">
							<%=SchoolTypeEnum.getAsDropDownOption() %>
						</select>
					</td>
				</tr>
				<tr>
					<td width="25%" style="text-align: right;">开始时间:</td>
					<td width="25%" style="text-align: left;">
						<input name="userEducation.startDate" type="text" class="easyui-datebox width_175" required="required" />
					</td>
					<td width="25%" style="text-align: right;">结束时间:</td>
					<td width="25%" style="text-align: left;">
						<input name="userEducation.endDate" type="text" class="easyui-datebox width_175" required="required"/>
					</td>
				</tr>
			</table>
			<div class="t_center">
				<a href="javascript:void(0);" onclick="javascript:doAjaxCreateEducation();" class="easyui-linkbutton t_center">添加教育经历</a>
			</div>
		</form>
	</div>
	
	<!-- 创建联系人经历 -->
	<div id="create_contact_dialog" style="display: none;" title="创建联系人">
		<form id="create_contact_form" action="#" method="post">
			<table style="padding: 10px"  cellspacing="10">
				<tr>
					<td width="25%" style="text-align: right;">联系人名称:</td>
					<td width="25%" style="text-align: left;">
						<input name="userContact.name" type="text" class="easyui-validatebox width_175" required="required" />
					</td>
					<td width="25%" style="text-align: right;">联系人类型:</td>
					<td width="25%" style="text-align: left;">
						<select name="userContact.type" type="text" class="easyui-combobox width_175">
							<%=ContactTypeEnum.getAsDropDownOption() %>
						</select>
					</td>
				</tr>
				<tr>
					<td width="25%" style="text-align: right;">联系人手机:</td>
					<td width="25%" style="text-align: left;">
						<input name="userContact.mobile" type="text" class="easyui-validatebox width_175" required="required" />
					</td>
					<td width="25%" style="text-align: right;">联系人邮箱:</td>
					<td width="25%" style="text-align: left;">
						<input name="userContact.email" type="text" class="easyui-validatebox width_175"/>
					</td>
				</tr>
			</table>
			<div class="t_center">
				<a href="javascript:void(0);" onclick="javascript:doAjaxCreateContact();" class="easyui-linkbutton t_center">添加教育经历</a>
			</div>
		</form>
	</div>
	
	<!-- 创建证件 -->
	<div id="create_certificate_dialog" style="display: none;" title="创建证件">
		<form id="create_certificate_form" action="#" method="post">
			<table style="padding: 10px"  cellspacing="10">
				<tr>
					<td width="25%" style="text-align: right;">证件号:</td>
					<td width="25%" style="text-align: left;">
						<input name="userCertificate.num" class="easyui-validatebox width_175" data-options="required:true"/>
					</td>
					<td width="25%" style="text-align: right;">证件类型:</td>
					<td width="25%" style="text-align: left;">
						<select name="userCertificate.type" class="easyui-combobox width_175">
							<%=CertificateTypeEnum.getAsDropDownOption() %>
						</select>
					</td>
				</tr>
				<tr>
					<td width="25%" style="text-align: right;">有效期起始:</td>
					<td width="25%" style="text-align: left;">
						<input name="userCertificate.startDate" type="text" class="easyui-datebox width_175" required="true" missingMessage="日期必须填写" editable="false" />
					</td>
					<td width="25%" style="text-align: right;">有效期终止:</td>
					<td width="25%" style="text-align: left;">
						<input name="userCertificate.endDate" type="text" class="easyui-datebox width_175" required="true" missingMessage="日期必须填写" editable="false"/>
					</td>
				</tr>
				<tr>
					<td width="25%" style="text-align: right;">备注</td>
					<td width="25%" style="text-align: left;">
						<input name="userCertificate.description" type="text" class="easyui-validatebox width_175" />
					</td>
				</tr>
			</table>
			<div class="t_center">
				<a onclick="javascript:doAjaxCreateCertificate();" class="easyui-linkbutton">添加证件信息</a>
			</div>
		</form>
	</div>
	
	<!-- 弹出框 结束 -->
</body>