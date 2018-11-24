package org.university.lab4;

public class Main {
    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        Service service = new Service();

        for (int i = 0; i < 100; i++) {
            Request request = new Request(randomizer.getNormalY(), "Клиент№" + (i + 1));
            service.addToQueue(request);
        }
        System.out.println("-----------------------");
        System.out.println("Приём заявок завершён");
        double remaining = service.serviceRemaining();
        System.out.printf("Оставшиеся клиенты обслужены. Потребовалось %4.2f минут\n", remaining);
        System.out.println("Среднее время ожидания = " + service.averageRequestWait());
        System.out.println("Среднее время простоя = " + service.averageServiceWait());
    }
}
