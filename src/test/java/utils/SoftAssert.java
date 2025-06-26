package utils;

import org.assertj.core.api.SoftAssertions;

public class SoftAssert {
    private static SoftAssertions softAssertions = new SoftAssertions();

    public static SoftAssertions getSoftAssert() {
        return softAssertions;
    }

    public static void assertAll() {
        softAssertions.assertAll();
        softAssertions = new SoftAssertions();
    }
}
