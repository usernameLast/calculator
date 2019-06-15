package cc.lastone.calculator.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;


/**
 * Unit test for simple App.
 */
public class OperatorWarningTest {

    @Test
    public void testGetOperator() {
        int position = 1;
        String operator = "+";
        Assert.assertThat(OperatorWarning.getWarning(position, operator), containsString("operator " + operator + " (position:" + position + "):insufficient paramters"));
    }
}
