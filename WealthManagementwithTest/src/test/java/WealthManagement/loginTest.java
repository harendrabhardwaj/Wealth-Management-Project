package WealthManagement;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class loginTest extends login {
    @Test
    public void successfullloginTest() throws Exception{

        login testLog = new login();
        Boolean retLog = testLog.Login("test@ps.com", "1234568");
        assertEquals(true, retLog);


    }
    @Test
    public void unsuccessfullloginTest() throws Exception
    {
        login testLog = new login();
        Boolean newretLog = testLog.Login("kjkjk@ps.com", "sasa");
        assertEquals(false, false);
    }

}