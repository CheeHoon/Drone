package com.dw.drone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.drone.mapper.DroneMapper;
import com.dw.drone.vo.DrivingVO;
import com.dw.drone.vo.DroneVO;
import com.dw.drone.vo.HistoryVO;

@Service
public class DroneService {

	//@Autowired : DI(의존성 주입 : 객체 생성 주입), IoC(Spring에서 객체 관리)
	@Autowired
	DroneMapper droneMapper;
	
	public List<DroneVO> getAllDrone(){
		return droneMapper.selectAllDrone();
	}
	
	public DroneVO getOneDrone(int uuid) {
		return droneMapper.selectOneDrone(uuid);
	}
	
	public List<DrivingVO> getDroneDriving(int uuid){
		return droneMapper.selectDrivingByUuid(uuid);
	}
	
	public List<HistoryVO> selectHistoryByDrivingNo(int drivingNo){
		return droneMapper.selectHistoryByDrivingNo(drivingNo);
	}
	
}
