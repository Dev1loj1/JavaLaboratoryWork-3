public class Penguin extends Animal {
    private final int fishPerDay;

    public Penguin(String name, double weightKg, int fishPerDay) {
        super(name, weightKg);
        if (fishPerDay < 0) throw new IllegalArgumentException("Количество рыб не может быть отрицательным");
        this.fishPerDay = fishPerDay;
    }

    public int getFishPerDay() { return fishPerDay; }

    @Override
    public double dailyFoodKg() { return 1.5 + 0.5 * fishPerDay; }
}
