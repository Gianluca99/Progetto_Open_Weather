package it.univpm.ProgettoGoffiCorso.Controller;

import java.util.ArrayList;
import java.util.List;

public class API {
		public class coord{
			public double lat;
			public double lon;
			
			public coord(double lat, double lon) {
				this.lat = lat;
				this.lon = lon;
			}
			public double getLat() {
				return lat;
			}
			public void setLat(double lat) {
				this.lat = lat;
			}
			public double getLon() {
				return lon;
			}
			public void setLon(double lon) {
				this.lon = lon;
			}
			
		}
		public class weather{
			public int id;
			public String main;
			public String description;
			public String icon;
			
			public weather(int id, String main, String description, String icon) {
				this.id = id;
				this.main = main;
				this.description = description;
				this.icon = icon;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getMain() {
				return main;
			}
			public void setMain(String main) {
				this.main = main;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public String getIcon() {
				return icon;
			}
			public void setIcon(String icon) {
				this.icon = icon;
			}
			
		}
		public class base{
			public double temp;
	        public double feels_like;
	        public double temp_min;
	        public double temp_max;
	        public double pressure;
	        public double humidity;
			public base(double temp, double feels_like, double temp_min, double temp_max, double pressure,
					double humidity) {
				this.temp = temp;
				this.feels_like = feels_like;
				this.temp_min = temp_min;
				this.temp_max = temp_max;
				this.pressure = pressure;
				this.humidity = humidity;
			}
			public double getTemp() {
				return temp;
			}
			public void setTemp(double temp) {
				this.temp = temp;
			}
			public double getFeels_like() {
				return feels_like;
			}
			public void setFeels_like(double feels_like) {
				this.feels_like = feels_like;
			}
			public double getTemp_min() {
				return temp_min;
			}
			public void setTemp_min(double temp_min) {
				this.temp_min = temp_min;
			}
			public double getTemp_max() {
				return temp_max;
			}
			public void setTemp_max(double temp_max) {
				this.temp_max = temp_max;
			}
			public double getPressure() {
				return pressure;
			}
			public void setPressure(double pressure) {
				this.pressure = pressure;
			}
			public double getHumidity() {
				return humidity;
			}
			public void setHumidity(double humidity) {
				this.humidity = humidity;
			}
			
	        
		}
		public double visibility;
		public class wind{
			double speed;
			double deg;
			public wind(double speed, double deg) {
				this.speed = speed;
				this.deg = deg;
			}
			public double getSpeed() {
				return speed;
			}
			public void setSpeed(double speed) {
				this.speed = speed;
			}
			public double getDeg() {
				return deg;
			}
			public void setDeg(double deg) {
				this.deg = deg;
			}
		}
		public class clouds{
			public double all;

			public clouds(double all) {
				this.all = all;
			}

			public double getAll() {
				return all;
			}

			public void setAll(double all) {
				this.all = all;
			}
			
		}
		public double dt;
		public class sys{
			public int type;
	        public int id;
	        public String country;
	        public int sunrise;
	        public int sunset;
			public sys(int type, int id, String country, int sunrise, int sunset) {
				this.type = type;
				this.id = id;
				this.country = country;
				this.sunrise = sunrise;
				this.sunset = sunset;
			}
			public int getType() {
				return type;
			}
			public void setType(int type) {
				this.type = type;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public int getSunrise() {
				return sunrise;
			}
			public void setSunrise(int sunrise) {
				this.sunrise = sunrise;
			}
			public int getSunset() {
				return sunset;
			}
			public void setSunset(int sunset) {
				this.sunset = sunset;
			}
	        
		}
		 public int timezone;
		 public int id;
		 public String name;
		 public int cod;

}
