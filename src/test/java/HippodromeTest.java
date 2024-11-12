import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

class HippodromeTest {
    private List<Horse> listhorses;
    private Hippodrome hippodrome;
    @BeforeEach
    void setUp() {
        listhorses = List.of(
                new Horse("Buce", 2.5, 888),
                new Horse("AceOfSpades", 6.5, 670),
                new Horse("Zephy", 4.6, 676),
                new Horse("Bla", 3.7, 887),
                new Horse("Lobst", 7.8, 998),
                new Horse("Pegas", 5.9, 657),
                new Horse("Cher", 5, 789)
        );
        hippodrome = new Hippodrome(listhorses);
    }

    @Test
    void testConstructorThrowsExceptionOnNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(null);
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
    void getHorsesTest() {
        List<Horse> expected = listhorses;
        List<Horse> actual = hippodrome.getHorses();
        assertEquals(actual, expected);
    }

    @Test
    void moveTest() {
        List<Horse> horseList = new ArrayList<>();
        for(int i = 1; i != 51; i++) {
            horseList.add(Mockito.mock(Horse.class));
        }
        Hippodrome hipp = new Hippodrome(horseList);
        hipp.move();
        for(Horse h: horseList) {
            verify(h).move();
        }

    }

    @Test
    void getWinnerTest() {
        Horse expected = listhorses.get(4);
        Horse actual = hippodrome.getWinner();
        assertEquals(actual, expected);


    }
}