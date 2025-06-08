package vcmsa.projects.savvysaver.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import vcmsa.projects.savvysaver.R
import vcmsa.projects.savvysaver.data.Budget
import vcmsa.projects.savvysaver.data.Category
import vcmsa.projects.savvysaver.viewmodel.AppViewModel
import java.text.SimpleDateFormat
import java.util.*
import android.content.Intent


class BudgetGoalsActivity : AppCompatActivity() {
    private lateinit var viewModel: AppViewModel
    private lateinit var categorySpinner: Spinner
    private lateinit var budgetListView: ListView
    private lateinit var budgetAmountEditText: EditText
    private lateinit var createBudgetButton: Button
    private lateinit var budgetStatusTextView: TextView


    private val currentMonth = SimpleDateFormat("yyyy-MM", Locale.US).format(Date())
    private var categories: List<Category> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_goals)

        viewModel = ViewModelProvider(this).get(AppViewModel::class.java)

        categorySpinner = findViewById(R.id.category_spinner)
        budgetListView = findViewById(R.id.budget_list)
        budgetAmountEditText = findViewById(R.id.budget_amount)
        createBudgetButton = findViewById(R.id.create_budget_button)
        budgetStatusTextView = findViewById(R.id.budget_status_text)


        setupCategorySpinner()
        refreshBudgetList()

        createBudgetButton.setOnClickListener {
            val selectedPosition = categorySpinner.selectedItemPosition
            if (selectedPosition == AdapterView.INVALID_POSITION) {
                Toast.makeText(this, "Please select a category", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedCategory = categories[selectedPosition]
            val amountText = budgetAmountEditText.text.toString()
            if (amountText.isEmpty()) {
                Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = amountText.toDoubleOrNull()
            if (amount == null) {
                Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newBudget = Budget(
                categoryId = selectedCategory.id,
                amount = amount,
                month = currentMonth
            )

            viewModel.addBudget(newBudget) {
                runOnUiThread {
                    Toast.makeText(this, "Budget added", Toast.LENGTH_SHORT).show()
                    budgetAmountEditText.text.clear()
                }
                refreshBudgetList()
            }
        }

        val savingsGoalsButton = findViewById<Button>(R.id.savings_goals_button)
        savingsGoalsButton.setOnClickListener {
            startActivity(Intent(this, SavingsGoalsActivity::class.java))
        }

    }

    private fun setupCategorySpinner() {
        viewModel.getCategories { categoryList ->
            categories = categoryList
            val categoryNames = categories.map { it.name }

            runOnUiThread {
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    categoryNames
                )
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                categorySpinner.adapter = adapter
            }
        }
    }

    private fun refreshBudgetList() {
        viewModel.getBudgetsByMonth(currentMonth) { budgets ->
            val budgetStrings = mutableListOf<String>()
            val exceededCategories = mutableListOf<String>()

            if (budgets.isEmpty()) {
                runOnUiThread {
                    budgetListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOf("No budgets found"))
                    budgetStatusTextView.text = ""
                }
                return@getBudgetsByMonth
            }

            val startDate = "06/01/2025"
            val endDate = "08/30/2025"

            viewModel.getExpensesGroupedByCategory(startDate, endDate) { groupedExpenses ->
                val budgetStrings = mutableListOf<String>()
                var processed = 0

                for (budget in budgets) {
                    viewModel.getCategoryById(budget.categoryId) { category ->
                        val categoryName = category?.name ?: "Unknown"
                        val spent = groupedExpenses[budget.categoryId] ?: 0.0

                        val displayText = "$categoryName : R$spent / R${budget.amount}"
                        synchronized(budgetStrings) {
                            budgetStrings.add(displayText)
                        }

                        processed++
                        if (processed == budgets.size) {
                            runOnUiThread {
                                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, budgetStrings)
                                budgetListView.adapter = adapter

                                if (exceededCategories.isEmpty()) {
                                    budgetStatusTextView.text = "You are within all current budgets."
                                    budgetStatusTextView.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                                } else {
                                    val exceededList = exceededCategories.joinToString(", ")
                                    budgetStatusTextView.text = "You are exceeding the budget for: $exceededList"
                                    budgetStatusTextView.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}


