public interface Performer {
    int durationMinutes();

    default String performanceDescription() {
        return "Выступает " + durationMinutes() + " мин";
    }
}
