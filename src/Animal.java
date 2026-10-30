// Животное нельзя создать без конкретного вида: у общего животного нет собственного правила расчёта корма.
// Абстрактный класс хранит общие данные и даёт единый способ описать и сравнить животных.
// Участие в программе выделено в интерфейс, потому что выступать может и объект, который животным не является.
// Поэтому ростовая кукла реализует тот же контракт без искусственного наследования от Animal.
public abstract class Animal implements Comparable<Animal> {
    private final String name;
    private final double weightKg;

    protected Animal(String name, double weightKg) {
        if (name == null || name.isBlank() || weightKg <= 0) throw new IllegalArgumentException("Некорректные имя или вес");
        this.name = name;
        this.weightKg = weightKg;
    }

    public String getName() { return name; }
    public double getWeightKg() { return weightKg; }
    public abstract double dailyFoodKg();

    public String description() {
        return name + ", " + weightKg + " кг, корм " + dailyFoodKg() + " кг/сут";
    }

    @Override
    public int compareTo(Animal other) { return Double.compare(dailyFoodKg(), other.dailyFoodKg()); }

    @Override
    public String toString() { return name + "/" + dailyFoodKg(); }
}
