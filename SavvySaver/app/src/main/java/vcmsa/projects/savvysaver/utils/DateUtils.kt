package vcmsa.projects.savvysaver.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {
    fun formatDate(date: Date): String {
        return SimpleDateFormat("MM/dd/yyyy", Locale.US).format(date)
    }
}