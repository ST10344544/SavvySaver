package vcmsa.projects.savvysaver.data

import androidx.room.*
import vcmsa.projects.savvysaver.data.SavingsGoal

@Dao
interface SavingsGoalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(goal: SavingsGoal)

    @Query("SELECT * FROM savings_goals")
    suspend fun getAllGoals(): List<SavingsGoal>

    @Update
    suspend fun updateGoal(goal: SavingsGoal)

    @Delete
    suspend fun deleteGoal(goal: SavingsGoal)
}
