package org.example;

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
    protected double speed = 0.0;
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
    public void boostEngine() {
        this.speedUp();
        System.out.println("Boosting speed once : " + speed);
    }

    public void pitStop() {
        System.out.println("Pit stop started");
        checkVehicle();
        System.out.println("It will take forever...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Your vehicle is ready to go!");
    }
}


class MotorBike extends Vehicle {

    private Engine engine;
    MotorBike(Engine engine, Door [] doors, Wheel [] wheels, Window [] windows) {
        super(0,2,1, engine, doors, wheels, windows);

    }

    public void boostEngine() {
        this.speedUp();
        this.speedUp();
        this.speedUp();
        this.speedUp();
        System.out.println("Boosting speed four times: " + speed);
        this.slowDown();
        this.slowDown();
        this.slowDown();
        this.slowDown();
        this.slowDown();
        System.out.println("Slowing down five times: " + speed);
    }

    public void pitStop() {
        System.out.println("Pit stop started");
        checkVehicle();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Your motorbike is ready to go!");
    }
}

class SportCar extends Vehicle {

    SportCar(Engine engine, Door [] doors, Wheel [] wheels, Window [] windows) {
        super(0, 4, 1, engine, doors, wheels, windows);
        for (int i = 0; i <= 5; i++)
            engine.upgradeEngine();
    }

    public void boostEngine() {
        this.speedUp();
        this.speedUp();
        this.speedUp();
        this.speedUp();
        System.out.println("Boosting speed four time: " + speed);
    }

    public void isFasterThanMaxVerstappen() {
        if (this.getSpeed() > 300) {
            System.out.println("~~~ WE ARE THE CHAMPIONS!! ~~~");
        } else {
            System.out.println("~~~MAX MAX MAX SUPER MAX MAX SUPER MAX MAX MAX~~~");
        }
    }

    public void pitStop() {
        System.out.println("Pit stop started");
        checkVehicle();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Your SportCAr is ready to go!");
    }
}


class FerrariSuperCar extends SportCar {
    private String racerName;
    FerrariSuperCar(String racerName, Engine engine, Door [] doors, Wheel [] wheels, Window [] windows) {
        super( engine, doors, wheels, windows);
        for (int i = 0; i <= 6; i++)
            engine.upgradeEngine();
        this.racerName = racerName;
    }

    public void pitStop() {
        System.out.println("Pit stop started");
        checkVehicle();
        try {
            Thread.sleep(2800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(racerName + " car is ready to go!");
    }

}

class RedBullTeamSuperCar extends SportCar {
    private String racerName;
    RedBullTeamSuperCar(String racerName, Engine engine, Door [] doors, Wheel [] wheels, Window [] windows) {
        super( engine, doors, wheels, windows);
        for (int i = 0; i <= 7; i++)
            engine.upgradeEngine();
        this.racerName = racerName;
    }

    public void pitStop() {
        System.out.println("Pit stop started");
        checkVehicle();
        try {
            Thread.sleep(2470);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(racerName + " car is ready to go!");
    }
}


public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(4, 4 , 5, new Engine(200.0),
                new Door[] {new Door(true, "main"), new Door(true, "main"), new Door(true, "main"), new Door(true, "main")},
                new Wheel[] {new Wheel(true, "f.left"),
                        new Wheel(true, "f.right"),
                        new Wheel(true, "b.left"),
                        new Wheel(true, "b.right")
                },
                new Window[] {new Window("main", false), new Window("side", true), new Window("side", true) ,new Window("side", true), new Window("side", true)}
        );
        MotorBike swiftStreak = new MotorBike(new Engine(300.0),
                new Door[] {},
                new Wheel[] {new Wheel(true, "f.main"),
                        new Wheel(true, "b.main"),
                },
                new Window[] {new Window("main", true)}
        );
        SportCar sportCar = new SportCar(new Engine(250.0), new Door[] {new Door(true, "main")},
                new Wheel[] {new Wheel(true, "f.left"),
                        new Wheel(true, "f.right"),
                        new Wheel(true, "b.left"),
                        new Wheel(true, "b.right")
                },
                new Window[] {new Window("main", false)}
        );
        FerrariSuperCar ferrariSuperCar = new FerrariSuperCar("Charles Leclerc", new Engine(300.0), new Door[] {new Door(true, "main")},
                new Wheel[] {new Wheel(true, "f.left"),
                        new Wheel(true, "f.right"),
                        new Wheel(true, "b.left"),
                        new Wheel(true, "b.right")
                },
                new Window[] {new Window("main", false)}
        );
        RedBullTeamSuperCar redBullTeamSuperCar = new RedBullTeamSuperCar("Max Verstappen", new Engine(300.0), new Door[] {new Door(true, "main")},
                new Wheel[] {new Wheel(true, "f.left"),
                        new Wheel(true, "f.right"),
                        new Wheel(true, "b.left"),
                        new Wheel(true, "b.right")
                },
                new Window[] {new Window("main", false)}
        );


        infoAboutVehicle(vehicle);
        infoAboutVehicle(swiftStreak);
        infoAboutVehicle(sportCar);
        infoAboutVehicle(ferrariSuperCar);
        infoAboutVehicle(redBullTeamSuperCar);


    }

    private static void infoAboutVehicle(Vehicle vehicle) {
        System.out.println(vehicle.getClass() + " info:");
        vehicle.startVehicle();
        vehicle.pitStop();
        vehicle.boostEngine();
        System.out.println(vehicle);
    }
}