package org.example;

interface Service {
    void repair(Vehicle car);
    void checkWheels(Vehicle car);
    void cleanWindows(Vehicle car);
    void getReceipt();
}

interface ServiceFactory {
    Service getService(String name, String location);
}

abstract class StoService implements Service {
    private double rating = 0.0;
    private final String name;
    private final String location;
    StoService(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void repair(Vehicle car) {
        car.checkVehicle();
        System.out.println("Car repaired by " + name + " at " + location);
    }

    public void checkWheels(Vehicle car) {
        car.checkWheels();
        System.out.println("Car wheels checked by " + name + " at " + location);
    }

    public void cleanWindows(Vehicle car) {
        car.checkWindows();
        System.out.println("Car windows checked by" + name + " at " + location);
    }

    protected void addRating(double rating) {
        this.rating = this.rating + rating;
    }

    protected double getRating() {
        return rating;
    }

    public void getReceipt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

class StoServiceIronMaster extends StoService implements Service{
    StoServiceIronMaster(String name, String location) {
        super(name, location);
    }

    public void getReceipt() {
        System.out.println("Iron Master receipt: 500 Grivnas");
    }

}

class StoServiceExistUa extends StoService implements Service {
    StoServiceExistUa(String name, String location) {
        super(name, location);
    }

    public void getReceipt() {
        System.out.println("ExistUa receipt: 600 Grivnas");
    }
}

class ImplementationIronMaster implements ServiceFactory {
    public Service getService(String name, String location) {
        return new StoServiceIronMaster(name, location);
    }
}

class ImplementationExistUa implements ServiceFactory {
    public Service getService(String name, String location) {
        return new StoServiceExistUa(name, location);
    }
}

public class Main {
    private static void serviceClient(ServiceFactory factory, String name, String location, Vehicle car) {
        Service service = factory.getService(name, location);
        service.repair(car);
        service.checkWheels(car);
        service.cleanWindows(car);
        service.getReceipt();
    }
    public static void main(String[] args) {
        serviceClient(new ImplementationExistUa(), "STO_EXIST_UA", "Ukraine, Kyiv", createVehicle());
        serviceClient(new ImplementationIronMaster(), "STO_IRON_MASTER", "Ukraine, Kharkiv", createSportCar());
    }

    private static Vehicle createVehicle() {
        return new Vehicle(4, 4 , 5, new Engine(200.0),
                new Door[] {new Door(true, "main"), new Door(true, "main"), new Door(true, "main"), new Door(true, "main")},
                new Wheel[] {new Wheel(true, "f.left"),
                        new Wheel(true, "f.right"),
                        new Wheel(true, "b.left"),
                        new Wheel(true, "b.right")
                },
                new Window[] {new Window("main", false), new Window("side", true), new Window("side", true) ,new Window("side", true), new Window("side", true)}
        );
    }

    private static Vehicle createSportCar() {
        return new SportCar(new Engine(300.0),
                new Door[] {},
                new Wheel[] {new Wheel(true, "f.main"),
                        new Wheel(true, "b.main"),
                },
                new Window[] {new Window("main", true)}
        );
    }
}