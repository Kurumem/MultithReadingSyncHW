package com.bridge;

public class Bridge {
    public Bridge(){

    }

    public void driveBridge() {
        Thread c1 = new Car(1,"справа");
        Thread c2 = new Car(2,"справа");
        Thread c3 = new Car(3,"справа");
        Thread c4 = new Car(4,"слева");
        Thread c5 = new Car(5,"слева");
        Thread c6 = new Car(6,"слева");
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();


    }
}
