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
            StringUtils.join(
                new String[]{"A", "B", "C", "D", "E"},
                ","
            ),
            "A,B,C,D,E"
        );
    }

    @Test public void testCapitalize() {
        assertEquals(
            "Basic StringUtils.capitalize",
            StringUtils.capitalize("hello capitalized world"),
            "Hello Capitalized World"
        );
    }
}