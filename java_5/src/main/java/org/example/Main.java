package org.example;
import java.lang.reflect.Method;
class Engine {
    private double power;
    private boolean running;
    Engine(double power) {
        if (power < 0) {
            throw new IllegalArgumentException("Power must be a positive number");
        }
        this.power = power;
    }

    public void upgradeEngine() {
        power *= 1.1;
    }

    public void downgradeEngine() {
        power /= 1.1;
    }

    public void startEngine() {
        running = true;
        System.out.println("Starting engine");
    }

    public void stopEngine() {
        running = false;
        System.out.println("Stopping engine");
    }

    public double getPower() {
        return power;
    }

}

class Wheel {
    private boolean mainWheel;
    private String position;
    Wheel(boolean mainWheel, String position) {
        this.mainWheel = mainWheel;
        this.position = position;
    }
    public String toString() {
        return "Main Wheel: " + mainWheel + " Position: " + position;
    }

    public boolean isMainWheel() {
        return mainWheel;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setMainWheel(boolean mainWheel) {
        this.mainWheel = mainWheel;
    }

}

class Window {
    private String position;
    private boolean isBlurred;
    Window(String position, boolean isBlurred) {
        this.position = position;
        this.isBlurred = isBlurred;
    }
    public String toString() {
        return "This window is located " + position + " and it's blurred state is: " + isBlurred;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public boolean isBlurred() {
        return isBlurred;
    }
    public void setBlurred(boolean blurred) {
        isBlurred = blurred;
    }
}

class Door {
    private boolean mainDoor;
    private String position;
    Door(boolean mainDoor, String position) {
        this.mainDoor = mainDoor;
        this.position = position;
    }
    public String toString() {
        return "This wheel is located " + position + " and this door is " + mainDoor;
    }
    public boolean isMainDoor() {
        return mainDoor;
    }
    public String getPosition() {
        return position;
    }
    public void setMainDoor(boolean mainDoor) {
        this.mainDoor = mainDoor;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}

class Vehicle {

    private int amountOfDoors;
    private int amountOfWheels;
    private int amountOfWindows;
    private Door [] doors;
    private Wheel [] wheels;
    private Window [] windows;
    private Engine engine;
    private double speed = 0.0;
    private final double speedMultiplier = 1.5;
    Vehicle(int amountOfDoors, int amountOfWheels, int amountOfWindows,
            Engine engine, Door [] doors, Wheel [] wheels, Window [] windows) {
        this.amountOfDoors = amountOfDoors;
        this.amountOfWheels = amountOfWheels;
        this.amountOfWindows = amountOfWindows;
        this.doors = doors;
        this.wheels = wheels;
        this.windows = windows;
        this.engine = engine;
    }

    public String toString() {
        return "This vehicle has: " + amountOfDoors + " doors, " +
                "" + amountOfWheels + " wheels, " + amountOfWindows +
                " windows" + " with speed: " +
                speed + " and engine power: " + engine.getPower();
    }
    public void startVehicle() {
        engine.startEngine();
        System.out.println("Starting vehicle");
        speed = engine.getPower() / 10;
    }

    public void stopVehicle() {
        engine.stopEngine();
        System.out.println("Stopping vehicle");
        speed = 0;
    }

    public void speedUp() {
        speed *= speedMultiplier;
    }

    public void slowDown() {
        speed /= speedMultiplier;
        if (speed <= engine.getPower() / 100) {
            stopVehicle();
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void updateEngine() {
        engine.upgradeEngine();
        System.out.println("Upgrading engine now its power: " + engine.getPower());
    }

    private void  checkWindows() {
        for (Window window : windows) {
            System.out.println("Checking window: " + window);
        }
    }

    private void  checkDoors() {
        for (Door door : doors) {
            System.out.println("Checking door: " + door);
        }
    }

    private void checkWheels() {
        for (Wheel wheel : wheels) {
            System.out.println("Checking wheel: " + wheel);
        }
    }

    public void checkVehicle() {
        checkWindows();
        checkDoors();
        checkWheels();
    }

}


class MotorBike extends Vehicle {

    private Engine engine;
    MotorBike(Engine engine, Door [] doors, Wheel [] wheels, Window [] windows) {
        super(0,2,1, engine, doors, wheels, windows);

    }

    public void boostEngine() {
        engine.upgradeEngine();
        engine.upgradeEngine();
        engine.upgradeEngine();
        System.out.println("Boosting engine now its power: " + engine.getPower());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        engine.downgradeEngine();
        engine.downgradeEngine();
        engine.upgradeEngine();
    }
}

class Ferrari extends Vehicle {

    Ferrari(Engine engine, Door [] doors, Wheel [] wheels, Window [] windows) {
        super(0, 3, 1, engine, doors, wheels, windows);
        for (int i = 0; i <= 5; i++)
            engine.upgradeEngine();
    }
    public void isFasterThanMaxVerstappen() {
        if (this.getSpeed() > 300) {
            System.out.println("~~~ WE ARE THE CHAMPIONS!! ~~~");
        } else {
            System.out.println("~~~MAX MAX MAX SUPER MAX MAX SUPER MAX MAX MAX~~~");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Ferrari f1 = new Ferrari(new Engine(400.0),
                new Door[] {new Door(true, "main")},
                new Wheel[] {new Wheel(true, "f.left"),
                        new Wheel(true, "f.right"),
                        new Wheel(true, "b.left"),
                        new Wheel(true, "b.right")
                },
                new Window[] {new Window("main", false)}
                );
//        Method [] methods = f1.getClass().getMethods();
//
//        for (Method method : methods) {
//            System.out.println("Method name: " + method.getName());
//        }
        f1.updateEngine();
        f1.updateEngine();
        f1.startVehicle();
        f1.speedUp();
        f1.speedUp();
        f1.speedUp();
        f1.speedUp();

        System.out.println(f1.getSpeed());
        f1.isFasterThanMaxVerstappen();
        f1.slowDown();
        System.out.println(f1.getSpeed());
        f1.isFasterThanMaxVerstappen();


        MotorBike swiftStreak = new MotorBike(new Engine(300.0),
                new Door[] {},
                new Wheel[] {new Wheel(true, "f.main"),
                        new Wheel(true, "b.main"),
                },
                new Window[] {new Window("main", true)}
        );
        System.out.println(swiftStreak);
        swiftStreak.updateEngine();
        swiftStreak.updateEngine();
        swiftStreak.checkVehicle();
        swiftStreak.startVehicle();
        swiftStreak.speedUp();
        System.out.println(swiftStreak);
        swiftStreak.speedUp();
        swiftStreak.updateEngine();
        System.out.println(swiftStreak);

    }
}