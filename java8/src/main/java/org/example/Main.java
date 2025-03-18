package org.example;

enum TypeOfPlane {
    CIVIL,
    MILITARY
}

interface Plane {
    String name();
    TypeOfPlane type();
    void fly();
    void land();
    void takeOff();
}

abstract class MilitaryPlane implements Plane {
    private final String name;
    private final TypeOfPlane type;
    private double maxSpeed;

    MilitaryPlane(String name, double speed) {
        this.name = name;
        this.type = TypeOfPlane.MILITARY;
        this.maxSpeed = speed;
    }

    public String toString() {
        return "This is military plane " + name + " with max speed: " + maxSpeed;
    }

    public String name() {
        return "I'm an military plane: " + name;
    }

    public TypeOfPlane type() {
        return type;
    }

    public void fly() {
        System.out.println(name + " is flying at speed " + maxSpeed * 0.9);
    }

    public void land() {
        System.out.println(name + " is landing at speed " + maxSpeed * 0.1);
    }

    public void takeOff() {
        System.out.println(name + "is taking off at speed " + maxSpeed * 0.2);
    }

    protected void speedUp() {
        maxSpeed *= 1.1;
    }
    abstract public void interestingFactAboutMe();

}

class F16 extends MilitaryPlane {
    F16(String name, double speed) {
        super(name, speed);
    }

    public void interestingFactAboutMe() {
        System.out.println("The F-16 was also one of the first aircraft that could withstand more G-forces " +
                "than its pilot could–a full 9 G's with a max load of internal fuel aboard.");
    }
}

class F15 extends MilitaryPlane {
    F15(String name, double speed) {
        super(name, speed);
    }

    public void interestingFactAboutMe() {
        System.out.println("1. This plane shot down soviet helicopter Mi-24 using air-to-ground bomb\n" +
                "2. This is the only plane that landed with one wing");
    }
}

class Su27 extends MilitaryPlane {
    Su27(String name, double speed) {
        super(name, speed);
    }
    public void interestingFactAboutMe() {
        System.out.println("I was built as an answer of American F-15 Eagle fighter");
    }
}

abstract class CivilPlane implements Plane {
    private final String name;
    private final TypeOfPlane type;
    private double maxSpeed;
    private String yearOfProduction;
    private int planesCreated = 0;
    CivilPlane(String name, double speed) {
        this.name = name;
        this.type = TypeOfPlane.CIVIL;
        this.maxSpeed = speed;
        this.yearOfProduction = "";
    }

    public String toString() {
        return "This is civil plane " + name + " with max speed: " + maxSpeed;
    }

    abstract void setPlanesCreated(int planesCreated);

    abstract void addPlanesCreatedInYear(int planesCreated);

    public String name() {
        return "I'm an civil plane: " + name;
    }

    public TypeOfPlane type() {
        return type;
    }

    public void fly() {
        System.out.println(name + " is flying at speed " + maxSpeed * 0.7);
    }

    public void land() {
        System.out.println(name + " is landing at speed " + maxSpeed * 0.1);
    }

    public void takeOff() {
        System.out.println(name + "is taking off at speed " + maxSpeed * 0.3);
    }

}

class Boeing777 extends CivilPlane {
    private int planesCreated;
    Boeing777(String name, double speed, int planesCreated) {
        super(name, speed);
        setPlanesCreated(planesCreated);
    }

    void setPlanesCreated(int planesCreated) {
        this.planesCreated = planesCreated;
    }

    void addPlanesCreatedInYear(int planesCreated) {
        this.planesCreated += planesCreated;
    }
}

class AirbusA220  extends CivilPlane {
    private int planesCreated;
    AirbusA220 (String name, double speed, int planesCreated) {
        super(name, speed);
        setPlanesCreated(planesCreated);
    }

    void setPlanesCreated(int planesCreated) {
        this.planesCreated = planesCreated;
    }

    void addPlanesCreatedInYear(int planesCreated) {
        this.planesCreated += planesCreated;
    }
}


public class Main {
    static F15 f15 = new F15("F15 Eagle-E", 1500);
    static F16 f16 = new F16("F16 Viper", 1300);
    static Su27 su27 = new Su27("Su-27 Ghost of Kyiv", 1450);
    static Boeing777 boeing777 = new Boeing777("Boeing 777", 600, 1788);
    static AirbusA220 airbusA220 = new AirbusA220("Airbus A220", 800, 735);

    public static void main(String[] args) {
        infoAboutMilitaryPlane(f15);
        infoAboutMilitaryPlane(f16);
        infoAboutMilitaryPlane(su27);
        infoAboutCivilPlane(boeing777, "1977", 15);
        infoAboutCivilPlane(airbusA220, "1989", 20);
    }

    private static void infoAboutPlane(Plane plane) {
        System.out.println(plane);
        plane.takeOff();
        plane.fly();
        plane.land();
    }

    private static void infoAboutMilitaryPlane(MilitaryPlane plane) {
        infoAboutPlane(plane);
        plane.interestingFactAboutMe();
    }

    private static void infoAboutCivilPlane(CivilPlane plane, String data, int amount) {
        infoAboutPlane(plane);
        plane.addPlanesCreatedInYear(amount);
        plane.addPlanesCreatedInYear(amount);
    }

}