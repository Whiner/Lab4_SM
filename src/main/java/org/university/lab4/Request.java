package org.university.lab4;

import java.time.LocalTime;

public class Request {
    private double serviceTime;
    private String name;

    public Request(double serviceTime, String name) {
        this.serviceTime = serviceTime;
        this.name = name;
    }

    public Request() {
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(double serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
