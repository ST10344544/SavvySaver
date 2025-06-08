package vcmsa.projects.savvysaver.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BudgetDao {
    @Insert
    suspend fun insert(budget: Budget)



    @Query("SELECT * FROM budgets WHERE month = :month")
    suspend fun getBudgetsByMonth(month: String): List<Budget>
}