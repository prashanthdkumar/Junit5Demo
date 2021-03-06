import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When running MathUtils")
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all.");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        System.out.println("Initializing...!");
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + "with tags " + testInfo.getTags());
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

    @Nested
    @Tag("Math")
    @DisplayName("add method")
    class AddTest {
        @Test
        @DisplayName("when adding two positive numbers")
        void testAddPositive() {
            System.out.println("In testAddPositive.");
            assertEquals(2, mathUtils.add(1, 1), () -> "should return the right sum.");
        }

        @Test
        @DisplayName("when adding two negative numbers")
        void testAddNegative() {
            System.out.println("In testAddNegative.");
            assertEquals(-2, mathUtils.add(-1, -1), () -> "should return the right sum.");
        }
    }

    @Test
    @Tag("Math")
    @DisplayName("Testing Multiply method.")
    void testMultiply() {
        System.out.println("In testMultiply.");
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + "with tags " + testInfo.getTags());
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }

    @Test
    @Tag("Math")
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("Testing Divide method.")
    void testDivide() {
        boolean isServerUp = true;
        Assumptions.assumeTrue(isServerUp);
        System.out.println("In testDivide.");
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), () -> "The Divide by zero should throw");
    }

    @RepeatedTest(3)
    @Tag("Circle")
    @DisplayName("Testing Compute Circle Area method.")
    void testComputeCircleArea(RepetitionInfo repetitionInfo) {
        System.out.println("In testComputeCircleArea. " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10.0), () -> "Should return right circle area");
    }
}
