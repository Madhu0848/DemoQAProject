package QapitolKKD.TestCase;

import QapitolKKD.keyWord.KeyEngine;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoginTest {

    KeyEngine keyEngine;

   // public final static Loggerr logger = LogManager.getLogger(LoginTest.class);

    @BeforeTest
    public void setUp() {
        keyEngine = new KeyEngine();
    }

    @Test
    public void loginTest() throws IOException, IOException {
        String filePath = "C:\\Users\\Qapitol QA\\Downloads\\application (1).xlsx";
        //logger.debug("Executed login test");
        keyEngine.service(filePath);
    }

    @AfterTest
    public void afterTest() throws IOException {
        keyEngine.tearDown();
    }
}