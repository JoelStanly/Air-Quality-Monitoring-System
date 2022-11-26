package com.awsiot.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsiot.springboot.model.Sensor;
import com.awsiot.springboot.service.SensorService;

@RestController
@RequestMapping("/api/sensor")
public class SensorController {

	private SensorService sensorservice;

	public SensorController(SensorService sensorservice) {
		super();
		this.sensorservice = sensorservice;
	}
	
	// Posting The data stream
	@PostMapping("post")
	public ResponseEntity<Sensor> saveSensor(@RequestBody Sensor sensor){
		return new ResponseEntity<Sensor>(sensorservice.saveSensor(sensor),HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Sensor> getSensorAllControl(){
		return sensorservice.getSensorDataAll();
	}
	
	@GetMapping("/find/{sensorid}")
	public Sensor getSensorUsingIdControl(@PathVariable("sensorid") long sensorid) {
		return sensorservice.getSensorDataById(sensorid);
	}
	
	@PutMapping("/update/{sensorid}")
	public Sensor updateSensorControl(@RequestBody Sensor sensor,@PathVariable("sensorid") long sensorid) {
		return sensorservice.updateSensorData(sensor, sensorid);
	}
	
	@DeleteMapping("/delete/{sensorid}")
	public void deleteSensorControl(@PathVariable long sensorid) {
		sensorservice.deleteSensorData(sensorid);
		System.out.println("Deleted the Sensor data which had an id of " + sensorid);
	}
	
}
