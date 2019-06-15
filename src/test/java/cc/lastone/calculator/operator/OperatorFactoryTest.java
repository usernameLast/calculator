package cc.lastone.calculator.operator;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;


/**
 * Unit test for simple App.
 */
public class OperatorFactoryTest {

    @Test
    public void testGetOperator() {
        try {
            Assert.assertNotNull(OperatorFactory.getOperator("+"));
            Assert.assertNotNull(OperatorFactory.getOperator("-"));
            Assert.assertNotNull(OperatorFactory.getOperator("*"));
            Assert.assertNotNull(OperatorFactory.getOperator("/"));
            Assert.assertNotNull(OperatorFactory.getOperator("sqrt"));
            Assert.assertNotNull(OperatorFactory.getOperator("undo"));
            Assert.assertNotNull(OperatorFactory.getOperator("clear"));
            Assert.assertNotNull(OperatorFactory.getOperator("clear1"));
        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), containsString("Illegal operators"));
        }
    }
}
