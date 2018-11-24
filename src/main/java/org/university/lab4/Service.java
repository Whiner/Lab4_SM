package org.university.lab4;

import java.util.ArrayDeque;

public class Service {
    private ArrayDeque<Request> queue = new ArrayDeque<>();
    private Randomizer randomizer = new Randomizer();

    private double requestWait = 0;
    private int requestCount = 0;
    private double serviceWait = 0;

    public void addToQueue(Request request) {
        System.out.println("-----------------------------");
        double requestWait = 0;
        if (!queue.isEmpty()) {
            requestWait = randomizer.getUniformY();
            System.out.printf("Прошло %5.2f минут\n", requestWait);
            System.out.println("-----------------------------");
        }
        System.out.println(request.getName() + " подал заявку");
        service(requestWait);
        queue.add(request);
        addLastWait();
        requestCount++;
        printQueueTimeLeft();
    }

    private void addLastWait() {
        double w = 0;
        Request lastElement = queue.peekLast();
        if (lastElement != null) {
            for (Request r : queue) {
                if (!r.equals(lastElement)) {
                    w += r.getServiceTime();
                }
            }
        }
        requestWait += w;
    }

    private void service(double minutes) {
        while (minutes > 0 && !queue.isEmpty()) {
            Request first = queue.peek();
            minutes -= first.getServiceTime();
            if (minutes >= 0.0) {
                Request remove = queue.remove();
                System.out.println(remove.getName() + " обслужен");
            } else {
                first.setServiceTime(Math.abs(minutes));
            }
        }
        if (minutes > 0) {
            serviceWait += minutes;
        }

    }

    public double serviceRemaining() {
        double minutes = 0;
        for (Request request : queue) {
            minutes += request.getServiceTime();
            System.out.println(request.getName() + " обслужен");
        }
        queue.clear();
        return minutes;
    }

    private void printQueueTimeLeft() {
        for (Request request : queue) {
            System.out.printf("\t%s осталось %4.2f времени для обслуживания\n", request.getName(), request.getServiceTime());
        }
    }

    public double averageRequestWait() {
        return requestWait / requestCount;
    }

    public double averageServiceWait() {
        return serviceWait / requestCount;
    }


}
