package vcmsa.projects.savvysaver.ui


import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import vcmsa.projects.savvysaver.R
import vcmsa.projects.savvysaver.data.Expense
import vcmsa.projects.savvysaver.utils.DateUtils
import vcmsa.projects.savvysaver.utils.ImageUtils
import vcmsa.projects.savvysaver.viewmodel.AppViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.InputStream
import java.time.LocalDate

class AddExpenseActivity : AppCompatActivity() {
    private lateinit var viewModel: AppViewModel
    private var photoPath: String? = null
    private val REQUEST_IMAGE_CAPTURE = 1
    private val CAMERA_PERMISSION_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        viewModel = ViewModelProvider(this).get(AppViewModel::class.java)

        val categorySpinner = findViewById<Spinner>(R.id.category_spinner)
        val amountEditText = findViewById<EditText>(R.id.amount)
        val dateEditText = findViewById<EditText>(R.id.date)
        val descriptionEditText = findViewById<EditText>(R.id.description)
        val uploadReceiptButton = findViewById<Button>(R.id.upload_receipt_button)
        val saveButton = findViewById<Button>(R.id.save_button)


        viewModel.getCategories { categories ->
            val categoryNames = categories.map { it.name }
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categoryNames)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            categorySpinner.adapter = adapter
        }


        dateEditText.setText(SimpleDateFormat("MM/dd/yyyy", Locale.US).format(Date()))

        uploadReceiptButton.setOnClickListener {
            Log.d("AddExpenseActivity", "Upload Receipt Button Clicked")
            val pickPhoto = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(pickPhoto, REQUEST_IMAGE_CAPTURE)
        }

        saveButton.setOnClickListener {
            val categoryName = categorySpinner.selectedItem?.toString()
            val amountText = amountEditText.text.toString()
            val date = dateEditText.text.toString()
            val description = descriptionEditText.text.toString()

            if (categoryName == null || amountText.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = amountText.toDoubleOrNull()
            if (amount == null) {
                Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.getCategoryByName(categoryName) { category ->
                if (category != null) {
                    val expense = Expense(
                        categoryId = category.id,
                        amount = amount,
                        date = date,
                        description = description,
                        photoPath = photoPath
                    )
                    viewModel.addExpense(expense) {
                        runOnUiThread {
                            Toast.makeText(this, "Expense added", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }
                }
            }
        }
    }

    private fun checkCameraPermission(): Boolean {
        return if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            true
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_REQUEST_CODE)
            false
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val selectedImageUri = data?.data
            if (selectedImageUri != null) {
                val inputStream: InputStream? = contentResolver.openInputStream(selectedImageUri)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                if (bitmap != null) {
                    photoPath = ImageUtils.saveBitmapToFile(this, bitmap)
                    Toast.makeText(this, "Receipt uploaded", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}