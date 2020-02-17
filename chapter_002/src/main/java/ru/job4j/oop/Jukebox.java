package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
            System.out.println("Пешеходы по лужам...");
        } else if (position == 2) {
            System.out.println("Баю-баюшик-баю");
            System.out.println("Не ложись на краю...");
        } else {
            System.out.println("Песня не найдена.");
        }
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        System.out.println();
        jukebox.music(2);
        System.out.println();
        jukebox.music(3);
    }
}
