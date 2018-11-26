package org.university.lab4;

public class Service {
    private double channel = 0;
    private double reception = 0;
    private double requestWaitTime = 0;
    private double serviceWaitTime = 0;
    private int requestCount = 0;

    public void addRequest(double after, double serviceTime) {
        reception += after;
        if (channel <= reception) {
            serviceWaitTime += (reception - channel);
            channel = reception + serviceTime;
        } else {
            requestWaitTime += (channel - reception);
            channel += serviceTime;
        }
        requestCount++;
    }

    public double getAvgRequestTime() {
        return requestWaitTime / requestCount;
    }

    public double getAvgServiceTime() {
        return serviceWaitTime / requestCount;
    }
}
