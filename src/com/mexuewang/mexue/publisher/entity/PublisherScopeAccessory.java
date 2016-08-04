package com.mexuewang.mexue.publisher.entity;

public class PublisherScopeAccessory extends Accessory {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2894847728618556744L;
	private String isPrivate;
	private String classIds;
	private String medalType;
	public String getIsPrivate() {
		return isPrivate;
	}
	public void setIsPrivate(String isPrivate) {
		this.isPrivate = isPrivate;
	}
	public String getClassIds() {
		return classIds;
	}
	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}
	public String getMedalType() {
		return medalType;
	}
	public void setMedalType(String medalType) {
		this.medalType = medalType;
	}
}
