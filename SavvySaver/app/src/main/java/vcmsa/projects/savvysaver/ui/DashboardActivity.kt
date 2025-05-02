package vcmsa.projects.savvysaver.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import vcmsa.projects.savvysaver.R
import vcmsa.projects.savvysaver.viewmodel.AppViewModel
import android.widget.ListView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider

class DashboardActivity : AppCompatActivity() {

    private lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        val recentExpensesListView = findViewById<ListView>(R.id.recent_expenses_list)
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]


        viewModel.getAllExpenses { expenses ->
            runOnUiThread {
                val sortedExpenses = expenses.sortedByDescending { it.date }
                val topFive = sortedExpenses.take(5)
                val formattedList = topFive.map {
                    "${it.description} - R${it.amount} on ${it.date}"
                }
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, formattedList)
                recentExpensesListView.adapter = adapter
            }
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true // You are already on home
                R.id.nav_categories -> {
                    startActivity(Intent(this, CategoriesActivity::class.java))
                    true
                }
                R.id.nav_add_expense -> {
                    startActivity(Intent(this, AddExpenseActivity::class.java))
                    true
                }
                R.id.nav_budget_goals -> {
                    startActivity(Intent(this, BudgetGoalsActivity::class.java))
                    true
                }
                R.id.nav_settings -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

}
