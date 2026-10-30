public class Elephant extends Animal implements Performer {
    public Elephant(String name, double weightKg) { super(name, weightKg); }

    @Override
    public double dailyFoodKg() { return getWeightKg() / 20; }

    @Override
    public int durationMinutes() { return 15; }
}
