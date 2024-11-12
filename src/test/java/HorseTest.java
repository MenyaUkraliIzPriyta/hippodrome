import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
class HorseTest {

    private Horse horse;

    @BeforeEach
    void setUp() {
        horse = new Horse("Fox", 62.34, 1000);
    }

    @Test
    void testConstructorThrowsExceptionOnNullFirstParam() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, 24.2, 400);
        });
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "'', 56.76, 1000",
            "' ', 56.76, 1000",
            "'  ', 56.76, 1000",
            "'     ', 56.76, 1000"})
    void testConstructorThrowsExceptionOnBlankFirstParam(String name, double speed, double distance) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(name, speed, distance);
        });
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void testConstructorThrowsExceptionOnNegativeSecondParam() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Fox", -24.2, 400);
        });
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void testConstructorThrowsExceptionOnNegativeThirdParam() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Fox", 24.2, -400);
        });
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getNameTest() {
        String expected = "Fox";
        String actual = horse.getName();
        assertEquals(actual, expected);
    }

    @Test
    void getSpeedTest() {
        double expected = 62.34;
        double actual = horse.getSpeed();
        assertEquals(actual, expected);
    }

    @Test
    void getDistanceTest() {
        Horse horseNullDistance = new Horse("Fury", 137.23);
        double expected1 = 1000;
        double actual1 = horse.getDistance();
        double expected2 = 0;
        double actual2 = horseNullDistance.getDistance();
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);
    }

    @Test
    void moveTest() {
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)) {
            horse.move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

}