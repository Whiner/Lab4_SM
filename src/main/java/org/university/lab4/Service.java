package org.university.lab4;

import java.util.ArrayDeque;
import java.util.Queue;

public class Service {
    private Queue<Request> queue = new ArrayDeque<>();
    private Randomizer randomizer = new Randomizer();

    public void addToQueue(Request request) {
        System.out.println("-----------------------------");
        double requestWait = 0;
        if (!queue.isEmpty()) {
            requestWait =  randomizer.getUniformY();
            System.out.printf("Прошло %5.2f минут\n", requestWait);
            System.out.println("-----------------------------");
        }
        System.out.println(request.getName() + " подал заявку");
        queue.add(request);
        service(requestWait);
        printQueueTimeLeft();
        /*System.out.printf("Ожидание заявки: %5.1f " +
                "Время обслуживания: %5.1f " +
                "Осталось в очереди: %5d \n",
                requestWait,
                request.getServiceTime(),
                queue.size());*/
    }

    private void service(double minutes) {
        while (minutes > 0 && !queue.isEmpty()) {
            Request first = queue.peek();
            if (first == null) {
                return;
            }
            minutes -= first.getServiceTime();
            if (minutes >= 0.0) {
                Request remove = queue.remove();
                System.out.println(remove.getName() + " обслужен");
            } else {
                first.setServiceTime(Math.abs(minutes));
                //System.out.println(first.getName() + " остался в очереди");
            }
        }

    }

    public double serviceRemaining() {
        double minutes = 0;
        for (Request request : queue) {
            minutes += request.getServiceTime();
            System.out.println(request.getName() + " обслужен");
        }
        return minutes;
    }

    private void printQueueTimeLeft(){
        for (Request request : queue) {
            System.out.printf("\t%s осталось %4.2f времени для обслуживания\n", request.getName(), request.getServiceTime());
        }
    }
}
