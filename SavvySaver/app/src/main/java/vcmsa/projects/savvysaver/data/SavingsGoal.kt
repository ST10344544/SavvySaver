package vcmsa.projects.savvysaver.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "savings_goals")
data class SavingsGoal(
    @PrimaryKey val id: String = System.currentTimeMillis().toString(),
    val title: String,
    val targetAmount: Double,
    var currentAmount: Double = 0.0
)