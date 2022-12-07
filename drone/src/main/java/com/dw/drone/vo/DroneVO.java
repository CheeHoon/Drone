package com.dw.drone.vo;

public class DroneVO extends Gps{
	
	private String uuid;
	private String modelName;
	private int battery;
	private String loc;
	private boolean isMessage;
	private boolean isUse;
	private String createAt;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public boolean isMessage() {
		return isMessage;
	}
	public void setMessage(boolean isMessage) {
		this.isMessage = isMessage;
	}
	public boolean isUse() {
		return isUse;
	}
	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	
}