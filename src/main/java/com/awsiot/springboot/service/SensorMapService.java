package com.awsiot.springboot.service;

import java.util.List;

import com.awsiot.springboot.model.SensorMap;

public interface SensorMapService {
	
	SensorMap saveSensorMap(SensorMap sensorMap);
	List<SensorMap> getSensorMapAll();
	SensorMap getSensorMapById(long sensorid);
	SensorMap updateSensorMap(SensorMap sensorMap,long sensorid);
	void deleteSensorMap(long id);
}
