public class Parrot extends Animal implements Performer {
    public Parrot(String name, double weightKg) { super(name, weightKg); }

    @Override
    public double dailyFoodKg() { return 0.25; }

    @Override
    public int durationMinutes() { return 10; }
}
