package vcmsa.projects.savvysaver.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import vcmsa.projects.savvysaver.viewmodel.AppViewModel
import vcmsa.projects.savvysaver.R
import vcmsa.projects.savvysaver.data.Expense
import android.content.Intent
import android.widget.Button


class CategoryExpensesActivity : AppCompatActivity() {
    private lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_expenses)

        viewModel = ViewModelProvider(this).get(AppViewModel::class.java)
        val categoryId = intent.getIntExtra("CATEGORY_ID", -1)
        val expensesListView = findViewById<ListView>(R.id.expenses_list)

        if (categoryId != -1) {
            viewModel.getExpensesByCategoryId(categoryId) { expenses ->
                runOnUiThread {
                    val adapter = object : ArrayAdapter<Expense>(
                        this,
                        R.layout.expense_item,
                        expenses
                    ) {
                        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                            val itemView = convertView ?: LayoutInflater.from(context)
                                .inflate(R.layout.expense_item, parent, false)

                            val expense = getItem(position)
                            val descText = itemView.findViewById<TextView>(R.id.expense_description)
                            val dateText = itemView.findViewById<TextView>(R.id.expense_date)
                            val viewPhotoButton = itemView.findViewById<Button>(R.id.view_photo_button)

                            descText.text = "${expense?.description}: R${expense?.amount}"
                            dateText.text = "Date: ${expense?.date}"

                            viewPhotoButton.setOnClickListener {
                                if (!expense?.photoPath.isNullOrEmpty()) {
                                    val intent = Intent(context, ViewPhotoActivity::class.java)
                                    intent.putExtra("PHOTO_PATH", expense?.photoPath)
                                    context.startActivity(intent)
                                }
                            }

                            return itemView
                        }
                    }
                    expensesListView.adapter = adapter
                }
            }
        }
    }
}




