package vcmsa.projects.savvysaver.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import vcmsa.projects.savvysaver.data.AppDatabase
import vcmsa.projects.savvysaver.data.User
import vcmsa.projects.savvysaver.data.Category
import vcmsa.projects.savvysaver.data.Expense
import vcmsa.projects.savvysaver.data.Budget
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.coroutines.withContext


class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getDatabase(application)


    fun login(username: String, password: String, callback: (User?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = db.userDao().getUser(username, password)
            callback(user)
        }
    }

    fun register(user: User, callback: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            db.userDao().insert(user)
            callback()
        }
    }

    fun addCategory(category: Category, callback: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            db.categoryDao().insert(category)
            callback()
        }
    }

    fun getCategories(callback: (List<Category>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val categories = db.categoryDao().getAll()
            callback(categories)
        }
    }

    fun getCategoryByName(name: String, callback: (Category?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val categories = db.categoryDao().getAll()
            val category = categories.find { it.name == name }
            callback(category)
        }
    }

    fun getCategoryById(id: Int, callback: (Category?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val category = db.categoryDao().getById(id)
            callback(category)
        }
    }

    fun getExpensesByCategoryId(categoryId: Int, callback: (List<Expense>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val expenses = db.expenseDao().getExpensesByCategory(categoryId)
            callback(expenses)
        }
    }

    fun addExpense(expense: Expense, callback: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            db.expenseDao().insert(expense)
            callback()
        }
    }

    fun getAllExpenses(callback: (List<Expense>) -> Unit) {
        Thread {
            val expenses = db.expenseDao().getAll()
            callback(expenses)
        }.start()
    }


    fun addBudget(budget: Budget, callback: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            db.budgetDao().insert(budget)
            callback()
        }
    }

    fun getBudgetsByMonth(month: String, callback: (List<Budget>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val budgets = db.budgetDao().getBudgetsByMonth(month)
            callback(budgets)
        }
    }


    fun getExpensesGroupedByCategory(
        startDateStr: String,
        endDateStr: String,
        callback: (Map<Int, Double>) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.US)
            val startDate = sdf.parse(startDateStr)
            val endDate = sdf.parse(endDateStr)


            val allExpenses = db.expenseDao().getAllExpenses()


            val filteredExpenses = allExpenses.filter {
                val expenseDate = sdf.parse(it.date)
                expenseDate != null && !expenseDate.before(startDate) && !expenseDate.after(endDate)
            }


            val grouped = filteredExpenses.groupBy { it.categoryId }
                .mapValues { entry -> entry.value.sumOf { it.amount } }

            withContext(Dispatchers.Main) {
                callback(grouped)
            }
        }
    }


}


