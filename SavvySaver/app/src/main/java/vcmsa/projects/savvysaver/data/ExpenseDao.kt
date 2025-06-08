package vcmsa.projects.savvysaver.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insert(expense: Expense)

    @Query("SELECT * FROM expenses WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getExpensesByPeriod(startDate: String, endDate: String): List<Expense>

    @Query("SELECT SUM(amount) FROM expenses WHERE categoryId = :categoryId AND date BETWEEN :startDate AND :endDate")
    suspend fun getTotalByCategory(categoryId: Int, startDate: String, endDate: String): Double?

    @Query("SELECT * FROM expenses WHERE categoryId = :categoryId")
    suspend fun getExpensesByCategory(categoryId: Int): List<Expense>

    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAll(): List<Expense>

    @Query("SELECT * FROM expenses")
    suspend fun getAllExpenses(): List<Expense>

    @Query("SELECT * FROM expenses WHERE categoryId = :categoryId AND substr(date, 1, 7) = :month")
    suspend fun getExpensesByCategoryAndMonth(categoryId: Int, month: String): List<Expense>

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<Category>

    @Dao
    interface ExpenseDao {
        @Query("SELECT SUM(amount) FROM expenses WHERE categoryId = :categoryId AND strftime('%Y-%m', date) = :month")
        suspend fun getSpentForCategoryInMonth(categoryId: Int, month: String): Double?
    }

}