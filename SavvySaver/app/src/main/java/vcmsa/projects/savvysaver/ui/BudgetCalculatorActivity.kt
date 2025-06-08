package vcmsa.projects.savvysaver.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import vcmsa.projects.savvysaver.R

class BudgetCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_calculator)

        val incomeInput = findViewById<EditText>(R.id.income_input)
        val expensesInput = findViewById<EditText>(R.id.expenses_input)
        val calculateButton = findViewById<Button>(R.id.calculate_button)
        val resultText = findViewById<TextView>(R.id.result_text)

        calculateButton.setOnClickListener {
            val income = incomeInput.text.toString().toDoubleOrNull() ?: 0.0
            val expenses = expensesInput.text.toString().toDoubleOrNull() ?: 0.0
            val remaining = income - expenses

            resultText.text = if (remaining >= 0) {
                "You can save R$remaining this month."
            } else {
                "You're overspending by R${-remaining}!"
            }
        }
    }
}
