package vcmsa.projects.savvysaver.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import vcmsa.projects.savvysaver.R
import vcmsa.projects.savvysaver.data.Category
import vcmsa.projects.savvysaver.viewmodel.AppViewModel
import android.content.Intent

class CategoriesActivity : AppCompatActivity() {
    private lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        val categoryListView = findViewById<ListView>(R.id.category_list)
        val addCategoryEditText = findViewById<EditText>(R.id.add_category_input)
        val addCategoryButton = findViewById<Button>(R.id.add_category_button)

        viewModel.getCategories { categories ->
            runOnUiThread {
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    categories.map { it.name }
                )
                categoryListView.adapter = adapter

                categoryListView.setOnItemClickListener { _, _, position, _ ->
                    val selectedCategory = categories[position]

                    val intent = Intent(this, CategoryExpensesActivity::class.java)
                    intent.putExtra("CATEGORY_ID", selectedCategory.id)
                    startActivity(intent)
                }
            }
        }

        addCategoryButton.setOnClickListener {
            val categoryName = addCategoryEditText.text.toString()
            if (categoryName.isEmpty()) {
                Toast.makeText(this, "Please enter a category name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val category = Category(name = categoryName)
            viewModel.addCategory(category) {
                runOnUiThread {
                    Toast.makeText(this, "Category added", Toast.LENGTH_SHORT).show()
                    addCategoryEditText.text.clear()
                }

                viewModel.getCategories { categories ->
                    runOnUiThread {
                        val adapter = ArrayAdapter(
                            this,
                            android.R.layout.simple_list_item_1,
                            categories.map { it.name }
                        )
                        categoryListView.adapter = adapter
                    }
                }
            }
        }
    }
}

