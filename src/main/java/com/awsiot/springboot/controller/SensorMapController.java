package com.awsiot.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsiot.springboot.model.SensorMap;
import com.awsiot.springboot.service.SensorMapService;

@RestController
@RequestMapping("/api/sensormap")
public class SensorMapController {
	
	private SensorMapService sensorMapService;

	
	
	public SensorMapController(SensorMapService sensorMapService) {
		super();
		this.sensorMapService = sensorMapService;
	}

	// Posting Sensor Mapping Data
	@PostMapping("/post")
	public SensorMap saveSensorMapControl(@RequestBody SensorMap sensorMap){
		return sensorMapService.saveSensorMap(sensorMap);
	}
	
	@GetMapping("/all")
	public List<SensorMap> getSensorMapAllControl(){
		return sensorMapService.getSensorMapAll();
	}
	
	@GetMapping("/find/{sensorid}")
	public SensorMap getSensorMapUsingIdControl(@PathVariable("sensorid") long sensorid) {
		return sensorMapService.getSensorMapById(sensorid);
	}
	
	@PutMapping("/update/{sensorid}")
	public SensorMap updateSensorMapControl(@RequestBody SensorMap sensorMap,@PathVariable("sensorid") long sensorid) {
		return sensorMapService.updateSensorMap(sensorMap, sensorid);
	}
	
	@DeleteMapping("/delete/{sensorid}")
	public void deleteSensorMapControl(@PathVariable long sensorid) {
		sensorMapService.deleteSensorMap(sensorid);
		System.out.println("Deleted the Sensor from the map which had an id of " + sensorid);
	}
	
	
}
