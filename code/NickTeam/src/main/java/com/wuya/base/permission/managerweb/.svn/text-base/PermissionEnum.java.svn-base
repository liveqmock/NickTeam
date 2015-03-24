package com.wuya.base.permission.managerweb;

import java.util.ArrayList;
import java.util.List;

/**
 * [权限-枚举]
 * 
 * @author nick
 * @version v1.0 2015-3-14
 */
public enum PermissionEnum {

	MANAGER_MANAGER("manager_manger", "管理员管理"), PROJECT_MANAGER(
			"project_manager", "项目管理"), SIGN_MANAGER("sign_manager", "跟进指派"), MY_FOLLOW_MANAGER(
			"my_follow_manager", "我的跟进"), MY_INTERVIEW_MANAGER(
			"my_interview_manager", "我的面试"), FINANCE_JUDGEMENT(
			"finance_judgement", "财务审核"), TICKET_MANAGER("ticket_manager",
			"票务管理"), STUDENT_MANAGER("student_manager", "学生管理"), ;

	private String code;

	private String name;

	private PermissionEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	/**
	 * [以java.util.list方式获取]
	 * 
	 * @return
	 */
	public static List<PermissionDto> getByList() {
		List<PermissionDto> list = new ArrayList<PermissionDto>();
		for (PermissionEnum p : PermissionEnum.values()) {
			PermissionDto dto = new PermissionDto();
			dto.setCode(p.getCode());
			dto.setName(p.getName());
			list.add(dto);
		}
		return list;
	}

}
