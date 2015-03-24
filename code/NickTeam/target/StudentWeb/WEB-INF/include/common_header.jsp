<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<!-- Jquery -->
<script type="text/javascript" src="<%=path%>/resource/product/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/resource/product/jquery.easing/jquery.easing-1.3.js"></script>
<script type="text/javascript" src="<%=path%>/resource/product/iosslider/js/jquery.iosslider.min.js"></script>
<!-- Jquery Easyui -->
<script type="text/javascript" src="<%=path%>/resource/product/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/resource/product/easyui/easyloader.js"></script>
<script type="text/javascript" src="<%=path%>/resource/product/easyui/locale/easyui-lang-zh_CN.js"></script>
 <!-- Jquery Easyui Bootstrtp风格 -->
<link type="text/css" rel="stylesheet" href="<%=path%>/resource/product/easyui/themes/bootstrap/easyui.css"></link>
<link type="text/css" rel="stylesheet" href="<%=path%>/resource/product/easyui/themes/icon.css"></link>
<link type="text/css" rel="stylesheet" href="<%=path%>/resource/product/easyui/themes/color.css"></link>
<!-- 本地公用js -->
<script type="text/javascript" src="<%=path%>/resource/local/js/base/form_param_util.js"></script>
<script type="text/javascript" src="<%=path%>/resource/local/js/base/string_util.js"></script>
<script type="text/javascript" src="<%=path%>/resource/local/js/base/page_mask.js"></script>
<script type="text/javascript" src="<%=path%>/resource/local/js/base/area/jquery.provincesCity.js"></script>
<script type="text/javascript" src="<%=path%>/resource/local/js/base/area/provincesdata.js"></script>
<!-- 工程师css -->
<link type="text/css" rel="stylesheet" href="<%=path%>/resource/local/css/base.css"></link>
<link href="<%=path%>/resource/local/css/init-head.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/resource/local/css/init-after.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/resource/local/css/all-link.css" rel="stylesheet" type="text/css" />
<!-- 初始化访问路径 -->
<script type="text/javascript">
	var G_basePath = "<%=path%>";
	var G_passportId = "${sessionScope.PASSPORT_INFO.id}";
</script>