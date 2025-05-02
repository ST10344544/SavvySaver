package vcmsa.projects.savvysaver.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import vcmsa.projects.savvysaver.R

class ViewPhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_photo)

        val imageView = findViewById<ImageView>(R.id.photo_image_view)
        val photoPath = intent.getStringExtra("PHOTO_PATH")

        if (photoPath != null) {
            val bitmap = BitmapFactory.decodeFile(photoPath)
            imageView.setImageBitmap(bitmap)
        }
    }
}


