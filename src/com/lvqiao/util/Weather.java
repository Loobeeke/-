package com.lvqiao.util;

import java.util.List;

import java.util.Scanner;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;

public class Weather {
	static List<String> string;
	public String site0;
	public String time;
	public String real_wea;
	public String detail;
	public String day_1;
	public String day_1_T;
	public String day_1_P;
	public String day_2;
	public String day_2_T;
	public String day_2_P;
	public String day_3;
	public String day_3_T;
	public String day_3_P;
	public String day_4;
	public String day_4_T;
	public String day_4_P;
	public String day_5;
	public String day_5_T;
	public String day_5_P;
	
	public static void main(String[] args) {
			WeatherWS weatherWs = new WeatherWS();
			WeatherWSSoap soup = weatherWs.getWeatherWSSoap();
			Scanner sc = new Scanner(System.in);
			String i = sc.next();
			ArrayOfString weather = soup.getWeather(i, "");
			List<String> string = weather.getString();
			System.out.println(string.get(1));
			System.out.println(string.get(2));
			System.out.println(string.get(3));
			System.out.println(string.get(4));
			System.out.println(string.get(6));
			System.out.println(string.get(7));
			System.out.println(string.get(8));
			for(String str:string){
				System.out.println(str);
			}
		}
	public List<String> weather(String site1){
		WeatherWS weatherWs = new WeatherWS();
		ArrayOfString weather;
		WeatherWSSoap soup = weatherWs.getWeatherWSSoap();
		
			//如果无法使用请把id改为null
			weather = soup.getWeather(site1, 
					"");
		
		string = weather.getString();
		for(String str:string){
			//System.out.println(str);
		} 
		
		site0 = string.get(1);
		time = string.get(3);
		real_wea = string.get(4);
		detail = string.get(6);
		day_1 = string.get(7);
		day_1_T = string.get(8);
		day_1_P = string.get(10);
		day_2 = string.get(12);
		day_2_T = string.get(13);
		day_2_P = string.get(15);
		day_3 = string.get(17);
		day_3_T = string.get(18);
		day_3_P = string.get(20);
		day_4 = string.get(22);
		day_4_T = string.get(23);
		day_4_P = string.get(25);
		day_5 = string.get(27);
		day_5_T = string.get(28);
		day_5_P = string.get(30);
		return string ;
	}
}

