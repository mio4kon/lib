package com.mio.volleydemo.javabean;


import org.json.JSONObject;


public class WeatherInfo {
	
    private String cityid;
    private String ptime;
    private String img1;
    private String temp1;
    private String city;
    private String img2;
    private String weather;
    private String temp2;
    
    
    
    public String getCityid() {
        return this.cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getPtime() {
        return this.ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getImg1() {
        return this.img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getTemp1() {
        return this.temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImg2() {
        return this.img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getWeather() {
        return this.weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp2() {
        return this.temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }


    
}
