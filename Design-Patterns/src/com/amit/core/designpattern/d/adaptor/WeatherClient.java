package com.amit.core.designpattern.d.adaptor;

public class WeatherClient {
	public static void main(String[] args) {
		WeatherUI ui = new WeatherUI();
		ui.showTemperature(834001);
	}
}
