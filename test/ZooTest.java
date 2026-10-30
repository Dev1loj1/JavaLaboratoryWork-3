import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ZooTest {
    @Test void elephantFood() { assertEquals(200.0, new Elephant("Самсон", 4000).dailyFoodKg()); }
    @Test void parrotFood() { assertEquals(0.25, new Parrot("Кеша", 0.5).dailyFoodKg()); }
    @Test void penguinFood() { assertEquals(3.5, new Penguin("Нильс", 25, 4).dailyFoodKg()); }
    @Test void descriptionsUseCalculatedFood() {
        assertEquals("Самсон, 4000.0 кг, корм 200.0 кг/сут", new Elephant("Самсон", 4000).description());
    }
    @Test void sortedByFood() {
        Animal[] animals = {new Elephant("Самсон", 4000), new Parrot("Кеша", 0.5), new Penguin("Нильс", 25, 4)};
        Arrays.sort(animals);
        assertEquals("[Кеша/0.25, Нильс/3.5, Самсон/200.0]", Arrays.toString(animals));
    }
    @Test void defaultPerformanceDescription() {
        assertEquals("Выступает 10 мин", new Parrot("Кеша", 0.5).performanceDescription());
    }
    @Test void mascotOverridesPerformanceDescription() {
        assertEquals("Ростовая кукла Тигрёнок Гоша: 3 мин без перерыва", new Mascot("Тигрёнок Гоша", 3).performanceDescription());
    }
    @Test void unrelatedMascotSharesPerformerContract() {
        Performer[] performers = {new Elephant("Самсон", 4000), new Parrot("Кеша", 0.5), new Mascot("Тигрёнок Гоша", 3)};
        assertEquals(28, Arrays.stream(performers).mapToInt(Performer::durationMinutes).sum());
        assertFalse(performers[2] instanceof Animal);
    }
    @Test void compareDoesNotSubtractDoubles() {
        assertTrue(new Parrot("Кеша", 0.5).compareTo(new Penguin("Нильс", 25, 4)) < 0);
    }
    @Test void mainPrintsReferenceOutput() {
        PrintStream original = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            Main.main(new String[0]);
        } finally { System.setOut(original); }
        String[] lines = output.toString(StandardCharsets.UTF_8).trim().split("\\R");
        assertEquals(15, lines.length);
        assertEquals("6) 203.75", lines[6]);
        assertEquals("7) [Кеша/0.25, Нильс/3.5, Самсон/200.0]", lines[7]);
        assertEquals("8) 28", lines[8]);
        assertEquals("14) -1", lines[14]);
    }
}
