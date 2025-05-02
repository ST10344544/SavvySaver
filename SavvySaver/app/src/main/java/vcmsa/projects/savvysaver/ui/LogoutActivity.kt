package vcmsa.projects.savvysaver.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import vcmsa.projects.savvysaver.R

class LogoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)

        val yesButton = findViewById<Button>(R.id.yes_logout_button)
        val cancelButton = findViewById<Button>(R.id.cancel_button)

        yesButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity()
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }
}