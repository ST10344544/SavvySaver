package vcmsa.projects.savvysaver.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vcmsa.projects.savvysaver.viewmodel.AppViewModel
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.util.*
import vcmsa.projects.savvysaver.R
import android.app.DatePickerDialog
import java.util.Calendar
import java.util.Locale

class SpendingGraphActivity : AppCompatActivity() {

    private lateinit var startDateEditText: EditText
    private lateinit var endDateEditText: EditText
    private lateinit var loadGraphButton: Button
    private lateinit var simpleBarGraphView: SimpleBarGraphView
    private lateinit var viewModel: AppViewModel

    private val dateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
    private lateinit var categoryIdToNameMap: Map<Int, String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spending_graph)

        startDateEditText = findViewById(R.id.startDateEditText)
        endDateEditText = findViewById(R.id.endDateEditText)
        loadGraphButton = findViewById(R.id.loadGraphButton)
        simpleBarGraphView = findViewById(R.id.simpleBarGraphView)

        viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        startDateEditText.setOnClickListener {
            showDatePickerDialog(startDateEditText, dateFormat)
        }

        endDateEditText.setOnClickListener {
            showDatePickerDialog(endDateEditText, dateFormat)
        }

        loadGraphButton.setOnClickListener {
            loadCategoriesAndGraph()
        }
    }

    private fun showDatePickerDialog(editText: EditText, dateFormat: SimpleDateFormat) {
        val calendar = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            editText.setText(dateFormat.format(calendar.time))
        }

        DatePickerDialog(
            this,
            dateSetListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }


    private fun loadCategoriesAndGraph() {
        viewModel.getCategories { categories ->
            categoryIdToNameMap = categories.associate { it.id to it.name }
            loadGraph()
        }
    }



    private fun loadGraph() {

        if (categoryIdToNameMap.isEmpty()) {
            Toast.makeText(this, "Categories not loaded yet", Toast.LENGTH_SHORT).show()
            return
        }

        val startDateStr = startDateEditText.text.toString()
        val endDateStr = endDateEditText.text.toString()

        val startDate = try { dateFormat.parse(startDateStr) } catch (e: Exception) { null }
        val endDate = try { dateFormat.parse(endDateStr) } catch (e: Exception) { null }

        if (startDate == null || endDate == null) {
            Toast.makeText(this, "Please enter valid dates in MM/dd/yyyy format", Toast.LENGTH_SHORT).show()
            return
        }


        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.US)
        val formattedStartDate = sdf.format(startDate)
        val formattedEndDate = sdf.format(endDate)

        viewModel.getExpensesGroupedByCategory(startDateStr, endDateStr) { groupedExpenses ->
            runOnUiThread {

                val groupedByCategoryName = groupedExpenses.mapKeys { categoryIdToNameMap[it.key] ?: "Unknown" }
                simpleBarGraphView.setData(groupedByCategoryName)
            }
        }

    }

}
