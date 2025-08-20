package com.amit.core.designpattern.d.adaptor;

public class WeatherAdapter {
	public int findTemperature(int zipCode) {
		String city = null;
		if (zipCode == 834001) {
			city = "Ranchi";
		}
		WeatherFinder finder = new WeatherFinderImpl();
		int temperature = finder.findTemprature(city);
		return temperature;
	}
}
