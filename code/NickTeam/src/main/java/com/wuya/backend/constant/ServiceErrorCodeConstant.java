package com.wuya.backend.constant;

/**
 * [错误信息－常量]
 * 
 * @author nick
 * @version v1.0 2015-1-24
 */
public interface ServiceErrorCodeConstant {

	public static final String E0000 = "提交参数不合法";
	public static final String E0001 = "提交的通行证信息有误";
	public static final String E0002 = "用户名已存在";
	public static final String E0003 = "手机号已存在";
	public static final String E0004 = "邮箱地址已存在";
	public static final String E0005 = "提交的验证信息出错";
	public static final String E0006 = "提交的学生教育经历信息有误";
	public static final String E0007 = "提交的通行证标识为空";
	public static final String E0008 = "提交的教育经历标识为空";
	public static final String E0009 = "提交的联系人信息标识为空";
	public static final String E0010 = "提交的用户证件信息有误";
	public static final String E0011 = "提交的通行证查询封装信息错误";
	public static final String E0012 = "提交的项目信息有误";
	public static final String E0013 = "相同项目已存在";
	public static final String E0014 = "提交的项目标识不合法";
	public static final String E0015 = "提交的项目主办方信息不合法";
	public static final String E0016 = "目标项目下，已存在同样的主办方";
	public static final String E0017 = "提交的主办方标识为空";
	public static final String E0018 = "同类费用已存在";
	public static final String E0019 = "提交的费用信息不合法";
	public static final String E0020 = "提交费用查询信息错误";
	public static final String E0021 = "提交的费用信息标识有误";
	public static final String E0022 = "项目或项目分期已上线";
	public static final String E0023 = "项目或项目分期不存在";
	public static final String E0024 = "提交的项目订单查询封装信息错误";
	public static final String E0025 = "提交的项目订单信息不合法";
	public static final String E0026 = "您已经提交过相同的订单了";
	public static final String E0027 = "提交的客户跟进信息不合法";
	public static final String E0028 = "您已经跟进了该客户信息";
	public static final String E0029 = "提交的项目订单跟进信息不合法";
	public static final String E0030 = "该客服已经跟进了该项目订单";
	public static final String E0031 = "该项目订单已经是目标状态";
	public static final String E0032 = "提交的业务流程日志信息不合法";
	public static final String E0033 = "订单状态不符合迁移标准,请检查当前状态";
	public static final String E0034 = "目标项目订单不存在";
	public static final String E0035 = "提交的财富账户信息有误";
	public static final String E0036 = "该用户的财富账户已经存在";
	public static final String E0037 = "提交的财富账户查询条件不合法";
	public static final String E0038 = "提交的财富账户明细信息不合法";
	public static final String E0039 = "提交的财富账户变更信息不合法";
	public static final String E0040 = "提交的图片信息不合法";
	public static final String E0041 = "提交的图片查询条件不合法";
	public static final String E0042 = "提交的财富账户明细查询条件不合法";
	public static final String E0043 = "提交的图片标识不合法";
	public static final String E0044 = "提交的充值审核信息不合法";
	public static final String E0045 = "提交的业务处理日志查询条件不合法";
	public static final String E0046 = "当前订单状态不能回退到待审核状态";
	public static final String E0047 = "提交的订单报名费支付类型更改信息不合法";
	public static final String E0048 = "当前订单状态不允许更改报名费支付类型";
	public static final String E0049 = "报名费支付类型已是目标状态,无需修改";
	public static final String E0050 = "订单报名费加载失败";
	public static final String E0051 = "提交的金额判断信息不合法";
	public static final String E0052 = "获取用户财富账户信息失败";
	public static final String E0053 = "您没有足够的可用资金完成支付";
	public static final String E0054 = "报名费已支付,请不要重复支付";
	public static final String E0055 = "提交的分配面试信息有误";
	public static final String E0056 = "该面试官面试时间冲突";
	public static final String E0057 = "提交的面试结果信息不合法";
	public static final String E0058 = "面试尚未结束无法提交结果";
	public static final String E0059 = "当前面试结果不合法,无法提交结果";
	public static final String E0060 = "当前状态不能重新申请面试";
	public static final String E0061 = "已经超过最大面试次数,不可重新申请";
	public static final String E0062 = "找不到对应的费用信息";
	public static final String E0063 = "订单支付状态不合法无法付款";
	public static final String E0064 = "提交的交通票务信息有误";
	public static final String E0065 = "提交的交通票务信息已存在";
	public static final String E0066 = "提交的交通票务查询信息不合法";
	public static final String E0067 = "对应的交通票务信息不是机票信息";
	public static final String E0068 = "当前订单状态不支持本操作";
	public static final String E0069 = "提交的用户证件查询信息不合法";
	public static final String E0070 = "提交的订单价格修改信息不合法";
	public static final String E0071 = "订单已经支付完成或作废,无法修改价格";
	public static final String E0072 = "此价格不是订单价格";
	public static final String E0073 = "订单状态不正确,无法进行价格更改";
	public static final String E0074 = "费用已经支付,不可修改";
	public static final String E0075 = "订单已经支付完成或作废,无法增加价格";
	public static final String E0076 = "订单已经完成,无法作废";
	public static final String E0077 = "提交的支付日志信息有误";
	public static final String E0078 = "提交的支付日志查询信息有误";
	public static final String E0079 = "订单已经支付完成或作废,无法删除价格";
	public static final String E0080 = "提交的订单备注信息有误";
	public static final String E0081 = "报名费仅在待审核和待支付报名费时可删除";
	public static final String E0082 = "此费用只能在待交项目费时删除";
	public static final String E0083 = "报名费仅在待审核和待支付报名费时可创建";
	public static final String E0084 = "此费用只能在待交项目费时创建";
	public static final String E0085 = "报名费仅在待审核和待支付报名费时可更改";
	public static final String E0086 = "此费用只能在待交项目费时更改";
	public static final String E0087 = "提交的项目更新信息有误";
	public static final String E0088 = "项目图片已经存在";
	public static final String E0089 = "提现金额不可大于目前可用金额";
	public static final String E0090 = "非原始跟踪客服,无法放弃跟进";
	public static final String E0091 = "两次输入的密码不一致";

}
