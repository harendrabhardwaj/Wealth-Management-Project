package WealthManagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationTest extends Registration {
    @Test
    public void RegTest() throws Exception{
        Registration reg = new Registration();

        String testreg = reg.Register("test@ps.com", "1234568", "Test", "Register");
        assertEquals(testreg, "Error");
    }
}