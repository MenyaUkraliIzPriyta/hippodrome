import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.List;

class HippodromeTest {
    private List<Horse> listhorses;
    private Hippodrome hippodrome;
    @BeforeEach
    void setUp() {
        listhorses = List.of(
                new Horse("Buce", 2.5),
                new Horse("AceOfSpades", 6.5),
                new Horse("Zephy", 4.6),
                new Horse("Bla", 3.7),
                new Horse("Lobst", 7.8),
                new Horse("Pegas", 5.9),
                new Horse("Cher", 5)
        );
        hippodrome = new Hippodrome(listhorses);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testConstructorThrowsExceptionOnNull() {
        List<Horse> horseList = null;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(horseList);
        });
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void testConstructorThrowsExceptionOnBlank() {
        List<Horse> horseList = List.of();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(horseList);
        });
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses() {
        List<Horse> expected = listhorses;
        List<Horse> actual = hippodrome.getHorses();
        assertEquals(actual, expected);
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}