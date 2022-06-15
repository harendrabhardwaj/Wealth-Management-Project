package WealthManagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest extends Category {
    @Test
    public void catgTest() throws Exception{
        Category testCategory = new Category();

        String retCatg = testCategory.insertCategory(109,"Apparels");
        assertEquals(retCatg, "Category Id Already Exist.");
    }

}