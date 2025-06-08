package vcmsa.projects.savvysaver.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import vcmsa.projects.savvysaver.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val notificationsSwitch = findViewById<Switch>(R.id.notifications_switch)
        val darkModeSwitch = findViewById<Switch>(R.id.dark_mode_switch)
        val logoutButton = findViewById<Button>(R.id.logout_button)

        val calculatorButton = findViewById<Button>(R.id.budget_calculator_button)
        calculatorButton.setOnClickListener {
            startActivity(Intent(this, BudgetCalculatorActivity::class.java))
        }


        notificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            // TODO: Handle notifications toggle
        }

        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            // TODO: Handle dark mode toggle
        }

        logoutButton.setOnClickListener {
            startActivity(Intent(this, LogoutActivity::class.java))
        }
    }
}