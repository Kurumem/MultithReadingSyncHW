package com.bridge;

import java.util.Random;

public class Car extends Thread{
    public int carNumber;
    public String direction;
    public int maxBridge = 0;
    public int whoLeft = 0;
    public int whoRight = 0;

    Random random = new Random();

    public Car(int carNumber, String direction){
        this.carNumber = carNumber;
        this.direction = direction;

    }

    public synchronized void rightMove() throws InterruptedException {
        if (maxBridge == 0 && direction.equals("слева")){
            Thread.sleep(random.nextInt(1000));
            System.out.println("Автомобиль " + carNumber + " заехал на мост " + direction);
            direction = "справа";

        }
            while (maxBridge == 3 || direction.equals("слева") || whoRight > 0){
                try {
                    wait();
                    System.out.println("Автомобиль " + carNumber + "ждет");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notify();
        maxBridge++;


    }

    public synchronized void leftMove() throws InterruptedException {
        if (maxBridge == 0 && direction.equals("справа")){
            Thread.sleep(random.nextInt(1000));
            System.out.println("Автомобиль " + carNumber + " заехал на мост " + direction);
            direction = "слева";

        }
            while (maxBridge == 3 || direction.equals("справа") || whoLeft > 0){
                try {
                    System.out.println("Автомобиль " + carNumber + " ждет");
                    wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            maxBridge++;
            notify();


    }
    public synchronized void moveOut(){
        maxBridge --;
    }

    @Override
    public synchronized void  run() {
            while (true) {
                if (direction.equals("справа") && maxBridge < 3 && whoLeft == 0 ) {
                    try {
                        System.out.println("Автомобиль " + carNumber + " подъехал к мосту " + direction);
                        leftMove();
                        whoRight++;

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(random.nextInt(1000));
                        moveOut();
                        System.out.println("Автомобиль " + carNumber + " съехал с моста " + direction);
                        whoRight--;
                        Thread.sleep(random.nextInt(1000));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                else if (direction.equals("слева") && maxBridge < 3 && whoRight == 0) {
                    try {
                        System.out.println("Автомобиль " + carNumber + " подъехал к мосту " + direction);
                        rightMove();
                        whoLeft++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(random.nextInt(1000));
                        moveOut();
                        System.out.println("Автомобиль " + carNumber + " съехал с моста " + direction);
                        whoLeft--;
                        Thread.sleep(random.nextInt(1000));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                }
            }

            }
        }


