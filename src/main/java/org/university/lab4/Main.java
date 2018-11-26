package org.university.lab4;

public class Main {
    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        Service service_ = new Service();
        for (int i = 0; i < 100; i++) {
            double after;
            if (i == 0) {
                after = 0;
            } else {
                after = randomizer.getUniformY();
            }
            service_.addRequest(after, randomizer.getNormalY());
        }

        System.out.println("Среднее время ожидания = " + service_.getAvgRequestTime());
        System.out.println("Среднее время простоя = " + service_.getAvgServiceTime());

    }
}
