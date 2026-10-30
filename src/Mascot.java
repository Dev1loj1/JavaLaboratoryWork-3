public class Mascot implements Performer {
    private final String name;
    private final int durationMinutes;

    public Mascot(String name, int durationMinutes) {
        if (name == null || name.isBlank() || durationMinutes < 0) throw new IllegalArgumentException("Некорректные имя или длительность");
        this.name = name;
        this.durationMinutes = durationMinutes;
    }

    public String getName() { return name; }

    @Override
    public int durationMinutes() { return durationMinutes; }

    @Override
    public String performanceDescription() {
        return "Ростовая кукла " + name + ": " + durationMinutes + " мин без перерыва";
    }
}
