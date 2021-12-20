import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all.");
    }

    @BeforeEach
    void init() {
        System.out.println("Initializing...!");
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...!");
    }

    @AfterAll
    static void afterAllCleanUp() {
        System.out.println("This needs to run after all.");
    }

    @Test
    @DisplayName("Testing Add method.")
    void testAdd() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual, "The Add method should add two numbers.");
    }

    @Test
    @DisplayName("Testing Divide method.")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "The Divide by zero should throw");
    }

    @Test
    @Disabled
    @DisplayName("Testing Compute Circle Area method.")
    void testComputeCircleArea() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10.0), "Should return right circle area");
    }
}
