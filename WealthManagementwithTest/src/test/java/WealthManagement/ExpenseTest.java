package WealthManagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest extends Expense {
    @Test
    public void expenseTest() throws Exception{
        Expense testExpense = new Expense();

        String retExp = testExpense.insertexpenseDetails("aaditya@ps.com", 102,  205, "2022-03-24", "Burger");
        assertEquals(retExp, "Error");

    }

}