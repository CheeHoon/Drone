package com.dw.drone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dw.drone.service.DroneService;
import com.dw.drone.service.MainService;
import com.dw.drone.vo.DrivingVO;
import com.dw.drone.vo.DroneVO;
import com.dw.drone.vo.HistoryVO;
import com.dw.drone.vo.JoinVO;

//RestController는 API 주소
//Controller는 사이트 URI 주소 (링크)
@RestController
public class DroneController {
	
	@Autowired
	DroneService droneService;
	@Autowired
	MainService mainService;
	
	@GetMapping("/drones")
	public List<DroneVO> callDrone(){
		return droneService.getAllDrone();
	}
	
	@GetMapping("/api/v1/drone/{uuid}")
	public DroneVO callDroneInfo(@PathVariable int uuid) {
		return droneService.getOneDrone(uuid);
	}
	
	@GetMapping("/api/v1/drone/{uuid}/driving")
	public List<DrivingVO> callDriving(@PathVariable int uuid){
		return droneService.getDroneDriving(uuid);
	}
	
	@GetMapping("/api/v1/drone/{drivingNo}/history")
	public List<HistoryVO> callHistory(@PathVariable int drivingNo){
		return droneService.selectHistoryByDrivingNo(drivingNo);
	}
	
	@PostMapping("/api/v1/join")
	public int callJoin(@RequestBody JoinVO vo) {
		return mainService.join(vo);
	}
}
