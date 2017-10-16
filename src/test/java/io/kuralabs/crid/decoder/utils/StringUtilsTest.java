/*
 * StringUtils test class.
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import io.kuralabs.crid.decoder.utils.StringUtils;

public class StringUtilsTest {

    @Test public void testJoin() {
        assertEquals(
            "Basic StringUtils.join with ',' separator",
            "A,B,C,D,E",
            StringUtils.join(
                new String[]{"A", "B", "C", "D", "E"},
                ","
            )
        );
    }

    @Test public void testCapitalize() {
        assertEquals(
            "Basic StringUtils.capitalize",
            "Hello Capitalized World",
            StringUtils.capitalize("hello capitalized world")
        );
        assertEquals(
            "Upper case StringUtils.capitalize",
            "Hello Capitalized World",
            StringUtils.capitalize("HELLO CAPITALIZED world")
        );
    }
}