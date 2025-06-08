package vcmsa.projects.savvysaver.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import vcmsa.projects.savvysaver.R
import vcmsa.projects.savvysaver.data.AppDatabase
import vcmsa.projects.savvysaver.data.SavingsGoal
import kotlinx.coroutines.launch

class SavingsGoalsActivity : AppCompatActivity() {

    private lateinit var container: LinearLayout
    private lateinit var db: AppDatabase
    private lateinit var goals: MutableList<SavingsGoal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savings_goals)

        container = findViewById(R.id.container)
        db = AppDatabase.getDatabase(this)

        val addButton = findViewById<Button>(R.id.add_goal_button)
        addButton.setOnClickListener {
            showAddGoalDialog()
        }

        loadGoals()
    }

    private fun loadGoals() {
        lifecycleScope.launch {
            goals = db.savingsGoalDao().getAllGoals().toMutableList()
            renderGoals()
        }
    }

    private fun renderGoals() {
        container.removeViews(1, container.childCount - 1)

        goals.forEach { goal ->
            val textView = TextView(this).apply {
                text = "${goal.title}: R${goal.currentAmount.toInt()} / R${goal.targetAmount.toInt()}"
                textSize = 18f
                setPadding(8, 16, 8, 16)
                setOnClickListener {
                    showAddAmountDialog(goal)
                }
            }
            container.addView(textView)
        }
    }

    private fun showAddGoalDialog() {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 16, 16, 16)
        }

        val titleInput = EditText(this).apply { hint = "Goal Title" }
        val amountInput = EditText(this).apply {
            hint = "Target Amount"
            inputType = android.text.InputType.TYPE_CLASS_NUMBER
        }

        layout.addView(titleInput)
        layout.addView(amountInput)

        AlertDialog.Builder(this)
            .setTitle("New Savings Goal")
            .setView(layout)
            .setPositiveButton("Add") { _, _ ->
                val title = titleInput.text.toString()
                val amount = amountInput.text.toString().toDoubleOrNull() ?: 0.0
                val newGoal = SavingsGoal(title = title, targetAmount = amount)

                lifecycleScope.launch {
                    db.savingsGoalDao().insert(newGoal)
                    goals.add(newGoal)
                    renderGoals()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showAddAmountDialog(goal: SavingsGoal) {
        val input = EditText(this).apply {
            hint = "Amount to Add"
            inputType = android.text.InputType.TYPE_CLASS_NUMBER
        }

        AlertDialog.Builder(this)
            .setTitle("Add to ${goal.title}")
            .setView(input)
            .setPositiveButton("Add") { _, _ ->
                val addAmount = input.text.toString().toDoubleOrNull() ?: 0.0
                goal.currentAmount += addAmount

                lifecycleScope.launch {
                    db.savingsGoalDao().updateGoal(goal)
                    renderGoals()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
