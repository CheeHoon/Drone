package com.dw.drone.vo;

public class DrivingVO {

	private int drivingNo; //운행 아이디
	private String uuid; //드론 고유 아이디
	private String startAt; //운행 시간
	private String endAt; //운행 종료 시간
	private int distance; //운행 거리
	
	public int getDrivingNo() {
		return drivingNo;
	}
	public void setDrivingNo(int drivingNo) {
		this.drivingNo = drivingNo;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getStartAt() {
		return startAt;
	}
	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}
	public String getEndAt() {
		return endAt;
	}
	public void setEndAt(String endAt) {
		this.endAt = endAt;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
