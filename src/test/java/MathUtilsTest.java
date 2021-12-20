import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

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
        System.out.println("In testAdd.");
        assertEquals(expected, actual, "The Add method should add two numbers.");
    }

    @Test
    @DisplayName("Testing Multiply method.")
    void testMultiply() {
        System.out.println("In testMultiply.");
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("Testing Divide method.")
    void testDivide() {
        boolean isServerUp = true;
        Assumptions.assumeTrue(isServerUp);
        System.out.println("In testDivide.");
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "The Divide by zero should throw");
    }

    @Test
    @Disabled
    @DisplayName("Testing Compute Circle Area method.")
    void testComputeCircleArea() {
        System.out.println("In testComputeCircleArea.");
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10.0), "Should return right circle area");
    }
}
