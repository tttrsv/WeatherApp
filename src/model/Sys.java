package model;

/**
 * Created by Nastya on 18.04.2017.
 */

public class Sys {
    private int type;
    private int id;
    private double message;
    private String country;
    private String name;
    private double sunrise;
    private double sunset;

    public Sys(int type, int id, double message, String country, String name, double sunrise, double sunset) {
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.name = name;
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

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSunrise() {
        return sunrise;
    }

    public void setSunrise(double sunrise) {
        this.sunrise = sunrise;
    }

    public double getSunset() {
        return sunset;
    }

    public void setSunset(double sunset) {
        this.sunset = sunset;
    }

   
}

