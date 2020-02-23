package ru.job4j.poly;

public class Bus implements Transport {
    int fuel = 0;
    int passengers = 0;

    @Override
    public void go() {
        if (fuel > 0) {
            System.out.println("Wheels of the bus go round and round...");
            System.out.println("There are " + passengers + " in bus!");
            System.out.println("There are " + fuel + " in tank.");
            fuel--;
        } else {
            System.out.println("No fuel. Refill and go!");
        }
    }

    @Override
    public void passengers(int passengersCount) {
        this.passengers = passengersCount;
    }

    @Override
    public double refuel(int liters) {
        double price = 9.99;
        fuel += liters;
        return price * liters;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.go();
        bus.passengers(10);
        System.out.println("Paid " + bus.refuel(3) + "$ for 3 liters.");
        bus.go();
        bus.go();
        bus.go();
        bus.go();
    }
}
