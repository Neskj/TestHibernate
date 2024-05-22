package neskj.TestHibernate.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountTest {

    private Account testAcount;

    @BeforeEach
    public void init() {

        testAcount = new Account();
        testAcount.setId(100);
        testAcount.setMessage("Hell ow im fine");
    }

    @Test
    public void createAccountNotNull() {

        assertNotNull(testAcount);
    }

    @Test
    public void gettersTestHappyFlow() {

        assertEquals(100, testAcount.getId());
        assertEquals("Hell ow im fine", testAcount.getMessage());
    }

    @Test
    public void settersTestHappyFlow() {

        testAcount.setId(1000);
        testAcount.setMessage("Hell ow im vine");

        assertEquals(1000, testAcount.getId());
        assertEquals("Hell ow im vine", testAcount.getMessage());
    }

    @Test
    public void testReturnStringSuccess() {

        assertEquals("\nAccount: \nId: " + 100 + "\nMessage: " + "Hell ow im fine" + "\n", testAcount.toString());
    }
}
