package org.example;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.time.temporal.ChronoUnit;
enum Rarity {
    common,
    uncommon,
    rare,
    special,
    super_rare,
}

enum Hunger {
    nauseous,
    full,
    satisfied,
    hungry,
    starving,
}

class Animal{
    public String name;
    private Hunger hunger;
    private LocalDateTime lastTimeFed = LocalDateTime.now();
    Animal(String name, Hunger hunger){
        this.name = name;
        this.hunger = hunger;
    }

    @Override
    public String toString() {
        return "Greetings, my name is " + name;
    }

    public void saySomething(String message){
        System.out.println(name + " says: " + message);
    }

    public long timeSinceLastTimeFed() {
        return ChronoUnit.SECONDS.between(lastTimeFed, LocalDateTime.now());
    }

    public void changeHungerStatus() {
        long seconds = timeSinceLastTimeFed();
//        System.out.println("I await + " + seconds);

        if (seconds <= 5)
            hunger = Hunger.nauseous;
        if (seconds <= 20 && seconds > 5)
            hunger = Hunger.full;
        if (seconds < 30 && seconds > 20)
            hunger = Hunger.satisfied;

        if (seconds < 40 && seconds >= 30)
            hunger = Hunger.hungry;
        if (seconds >= 40)
            hunger = Hunger.starving;

    }

    public Hunger getHunger() {
        return this.hunger;
    }

    public void getSnack() {
        this.lastTimeFed = LocalDateTime.now();
        this.hunger = Hunger.nauseous;
        saySomething("Thanks for the snack. ");
    }

    public void setHunger(Hunger hunger) {
        this.hunger = hunger;
    }
}

class Parrot extends Animal{
    private final String color;
    private final Rarity rarity;
    private final String [] quotes = new String[]{"\"Я би щось сказав, але не можу при дітях.\"" + "© Чорней Р. К.",
            "\"Як я ненавиджу цей Гугл...\"" + "© Вознюк. Я. І.",
            "\"Мама - індукція, тато - від супротивного.\"" + "© Козеренко С. О.",
            "\"Не завжди добре, значить колись погано.\"" + "© Козеренко С. О.",
            "\"Яка різниця хто відкрив, головне - що відкрили.\"" + "© Глибовець М. М.",
            "\"Напишіть Дурову листа і спитайте чого ви такі мразі використовуєте TCP, а не UPD.\"" + "© Вознюк Я. І.",
            "\"Час плинний, C++ вічний.\"" + "© Бублик В. В.",
            "\"Математика - мова богів.\" " + "© Глибовець М.М.",
            "\"Я батька буду топити... Бо випливати погано!\"" + "© Глибовець А. М.",
            "\"Та можна і паром навчитись програмувати!\"" + "© Глибовець А. М.",
            "\"В IPv6 немає сенсу\"" + "© Вознюк Я. І.",
            "\"Не ламайте бутилку. Бутилка - то святе.\"" + "© Трохим Бабич",
            "\"Смішний цей ваш канал \"Підслухано в НаКУКМА\", адміністраторам бажаю подорослішати\"" + "© Глибовець А.М.",
            "\"Це я просто написав, щоб показати, що я вапщє не лох\"" + "© Проценко",

    };
    Parrot(String name, String color, Rarity rarity, Hunger hunger) {
        super(name, hunger);
        this.color = color;
        this.rarity = rarity;
    }

    @Override
    public String toString() {
        return super.toString() + ". " + "I'm " + color + " color" + " and I'm " + rarity + " parrot";
    }

    public void sayQuote() {
        this.changeHungerStatus();
        if (this.getHunger() != Hunger.satisfied && this.getHunger() != Hunger.full && this.getHunger() != Hunger.nauseous)
            System.out.println("Give me a snack...");
        else {
            int random = new Random().nextInt(quotes.length);
            System.out.println(name + " quotes: " + quotes[random]);
        }

    }

    public void repeatSomeone(String message){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " repeats: " + message);
    }
}

class Monkey extends Animal {
    Monkey(String name, Hunger hunger) {
        super(name, hunger);
    }

    @Override
    public String toString() {
        return super.toString() + " and I'm monkey";
    }

    public void jump() {
        int height = new Random().nextInt(13);
        System.out.println(name + " jumps at " + height + " meters");
    }


}

class Human {
    public String name;
    public int age;
    Human(String name, int age) {
        if (age < 0 || age > 150)
            throw new IllegalArgumentException("Age must be between 0 and 150");
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "I'm " + name + " and I'm " + age + " years old";
    }


}

class ZooWorker extends Human {
    public String name;
    public int age;
    private final String zooName;
    ZooWorker(String name, int age, String zooName) {
        super(name, age);
        this.zooName = zooName;
    }

    public String toString() {
        return super.toString() + ". Zoo where I'm working is called " + zooName;
    }

    public void feedAnimal(Animal animal) {
        System.out.println(name + " feeds: " + animal.name);
        animal.getSnack();
    }

    public void checkAnimalHunger(Animal animal) {
        System.out.println(name + " checks: " + animal.name + ". " + animal.name + " is " + animal.getHunger());
    }

}

class ZooVisitor extends Human {
    public String name;
    public int age;
    ZooVisitor(String name, int age) {
        super(name, age);
    }

    public void petAnimal(Animal animal) {
        System.out.println(name + " pets " + animal.name);
        animal.setHunger(Hunger.satisfied);
    }

}

class RepresentZooDay {
    Parrot parrot = new Parrot("Kiwi", "green", Rarity.super_rare, Hunger.satisfied);
    Monkey monkey = new Monkey("s1mple", Hunger.hungry);
    ZooVisitor zooVisitor = new ZooVisitor("ZooVisitor", 19);
    ZooWorker zooWorker = new ZooWorker("ZooWorker", 20, "Florida");
//    String [] parrotActions = new String[]{"Say quote", "to String", "repeat someone", "say something"};
//    String [] monkeyActions = new String[]{"to String", "jump", "say something"};
//    String [] workerActions = new String[]{"feed animal", "check Animal Hunger"};
//    String [] visitorActions = new String[]{"feed animal", "pet Animal", "check Animal Hunger"};

    public void createAnimals() throws IOException {
        {
            System.out.println("Create a parrot: ");
            String name = DataInput.getString("Input parrot's name: ");
            String color = DataInput.getString("Input parrot's color: ");

            String hunger1 = DataInput.getString("Input hunger: ");
            Hunger hunger = Hunger.valueOf(hunger1);

            String rarity1 = DataInput.getString("Input rarity: ");
            Rarity rarity = Rarity.valueOf(rarity1);
            parrot = new Parrot(name, color, rarity, hunger);
        }

        {
            System.out.println("Create a monkey: ");
            String name = DataInput.getString("Input monkey's name: ");

            String hunger1 = DataInput.getString("Input hunger: ");
            Hunger hunger = Hunger.valueOf(hunger1);

            monkey = new Monkey(name, hunger);
        }




    }

    public void createZooVisitor() throws IOException {
        System.out.println("Create visitor: ");
        String name = DataInput.getString("Input visitor's name: ");
        int age = DataInput.getNotNegativeInt("Input visitor's age: ");
        zooVisitor = new ZooVisitor(name, age);

    }

    public void createZooWorker() throws IOException {
        System.out.println("Create worker: ");
        String name = DataInput.getString("Input worker's name: ");
        int age = DataInput.getNotNegativeInt("Input worker's age: ");
        String zooName = DataInput.getString("Input zoo name: ");
        zooWorker = new ZooWorker(name, age, zooName);

    }

    private void parrotActions(int action) throws IOException {
        switch (action) {
            case 1:
                parrot.sayQuote();
                break;
            case 2:
                System.out.println(parrot);
                break;
            case 3:
                String text = DataInput.getString("Say something");
                parrot.repeatSomeone(text);
                break;
            case 4:
                String speech = DataInput.getString("Say something");
                parrot.saySomething(speech);
                break;
            case 5:
                parrot.getSnack();
            default:
                System.out.println(parrot.name + " " +  parrot.getHunger());
                break;
        }
    }

    private void monkeyActions(int action) throws IOException {
        switch (action) {
            case 1:
                System.out.println(monkey);
                break;
            case 2:
                monkey.jump();
                break;
            case 3:
                String speech = DataInput.getString("Say something: ");
                monkey.saySomething(speech);
                break;
            default:
                System.out.println(monkey.name + " " +  monkey.getHunger());
                break;
        }
    }

    public void action() throws IOException {
        while (true) {
            int creature = DataInput.getInt("Input 1 - for worker, 2 - for visitor: ");
            switch (creature) {
                case 1:
                    System.out.println(zooWorker.toString() + ". I'm doing a job...");
                    {
                        int animal = DataInput.getInt("Input 1 - for parrot or 2 - for monkey: ");
                        int action = DataInput.getInt("Input action: ");
                        if (animal == 1) {
                            parrotActions(action);
                        } else if (animal == 2) {
                            monkeyActions(action);
                        } else
                            throw new IllegalArgumentException("Wrong input");
                    }
                    break;
                case 2:
                    System.out.println(zooVisitor.toString() + ". I'm doing a job...");
                    {
                        int animal = DataInput.getInt("Input 1 - for parrot or 2 - for monkey: ");
                        int action = DataInput.getInt("Input action: ");
                        if (animal == 1) {
                            parrotActions(action);
                        } else if (animal == 2) {
                            monkeyActions(action);
                        } else
                            throw new IllegalArgumentException("Wrong input");

                    }
                    break;
                default:
                    throw new IllegalArgumentException("Wrong action");

            }
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        RepresentZooDay zooDay = new RepresentZooDay();
//        zooDay.createAnimals();
//        zooDay.createZooWorker();
//        zooDay.createZooVisitor();
        zooDay.action();
    }

}