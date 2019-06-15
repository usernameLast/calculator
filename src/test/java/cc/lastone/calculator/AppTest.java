package cc.lastone.calculator;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testIsNumeric() {
        String str1 = "123";
        String str2 = "123.11";
        String str3 = "abd12";
        String str4 = "12.12.24";
        Assert.assertTrue(App.isNumeric(str1));
        Assert.assertTrue(App.isNumeric(str2));
        Assert.assertFalse(App.isNumeric(str3));
        Assert.assertFalse(App.isNumeric(str4));
    }

    @Test
    public void testPrintlnStack() {
        List<Double> list = new ArrayList<Double>();
        list.add(1.0);
        list.add(2.0);
        list.add(1.0123456789123);
        list.add(1.11);
        log.clearLog();
        App.printlnStack(list);
        Assert.assertThat(log.getLog(), containsString("1 2 1.0123456789 1.11"));
    }
}
