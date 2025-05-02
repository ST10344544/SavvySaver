package vcmsa.projects.savvysaver.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vcmsa.projects.savvysaver.R
import vcmsa.projects.savvysaver.data.Budget
import vcmsa.projects.savvysaver.viewmodel.AppViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.lifecycle.ViewModelProvider

class BudgetGoalsActivity : AppCompatActivity() {
    private lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_goals)

        viewModel = ViewModelProvider(this).get(AppViewModel::class.java)

        val budgetListView = findViewById<ListView>(R.id.budget_list)
        val budgetNameEditText = findViewById<EditText>(R.id.budget_name)
        val budgetAmountEditText = findViewById<EditText>(R.id.budget_amount)
        val createBudgetButton = findViewById<Button>(R.id.create_budget_button)

        val currentMonth = SimpleDateFormat("yyyy-MM", Locale.US).format(Date())

        fun refreshBudgetList() {
            viewModel.getBudgetsByMonth(currentMonth) { budgets ->
                val budgetStrings = mutableListOf<String>()
                for (budget in budgets) {
                    viewModel.getCategoryById(budget.categoryId) { category ->
                        val displayText = "${budget.categoryId} - ${category?.name ?: "Unknown"} : R${budget.amount}"
                        budgetStrings.add(displayText)

                        if (budgetStrings.size == budgets.size) {
                            runOnUiThread {
                                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, budgetStrings)
                                budgetListView.adapter = adapter
                            }
                        }
                    }
                }
            }
        }

        refreshBudgetList()

        createBudgetButton.setOnClickListener {
            val categoryName = budgetNameEditText.text.toString()
            val amountText = budgetAmountEditText.text.toString()

            if (categoryName.isEmpty() || amountText.isEmpty()) {
                runOnUiThread {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
                return@setOnClickListener
            }

            val amount = amountText.toDoubleOrNull()
            if (amount == null) {
                runOnUiThread {
                    Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
                }
                return@setOnClickListener
            }

            viewModel.getCategoryByName(categoryName) { category ->
                if (category != null) {
                    val budget = Budget(
                        categoryId = category.id,
                        amount = amount,
                        month = currentMonth
                    )
                    viewModel.addBudget(budget) {
                        runOnUiThread {
                            Toast.makeText(this, "Budget added", Toast.LENGTH_SHORT).show()
                            budgetNameEditText.text.clear()
                            budgetAmountEditText.text.clear()
                        }

                        refreshBudgetList()
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(this, "Category not found", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

