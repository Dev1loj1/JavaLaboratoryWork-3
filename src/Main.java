import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Elephant elephant = new Elephant("Самсон", 4000);
        Parrot parrot = new Parrot("Кеша", 0.5);
        Penguin penguin = new Penguin("Нильс", 25, 4);
        Mascot mascot = new Mascot("Тигрёнок Гоша", 3);
        Animal[] animals = {elephant, parrot, penguin};
        Performer[] performers = {elephant, parrot, mascot};

        System.out.println("Ivanov I.I., group 3821B1PR1");
        System.out.println("1) " + elephant.dailyFoodKg());
        System.out.println("2) " + parrot.dailyFoodKg());
        System.out.println("3) " + penguin.dailyFoodKg());
        System.out.println("4) " + elephant.description());
        System.out.println("5) " + parrot.description());
        double totalFood = 0;
        for (Animal animal : animals) totalFood += animal.dailyFoodKg();
        System.out.println("6) " + totalFood);
        Arrays.sort(animals);
        System.out.println("7) " + Arrays.toString(animals));
        int totalMinutes = 0;
        for (Performer performer : performers) totalMinutes += performer.durationMinutes();
        System.out.println("8) " + totalMinutes);
        System.out.println("9) " + mascot.performanceDescription());
        System.out.println("10) " + parrot.performanceDescription());
        System.out.println("11) " + (performers[2] instanceof Animal));
        System.out.println("12) " + (performers[0] instanceof Animal));
        System.out.println("13) " + animals[0]);
        System.out.println("14) " + parrot.compareTo(penguin));
    }
}
