package vcmsa.projects.savvysaver.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SimpleBarGraphView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private var data: Map<String, Double> = emptyMap()

    private val barPaint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.FILL
    }

    private val textPaint = Paint().apply {
        color = Color.BLACK
        textSize = 36f
        textAlign = Paint.Align.CENTER
    }

    fun setData(newData: Map<String, Double>) {
        data = newData
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (data.isEmpty()) {

            canvas.drawText("No data to display", width / 2f, height / 2f, textPaint)
            return
        }

        val maxAmount = data.values.maxOrNull() ?: 0.0
        if (maxAmount == 0.0) {
            canvas.drawText("All amounts are zero", width / 2f, height / 2f, textPaint)
            return
        }

        val barWidth = width / (data.size * 2f)

        var xPos = barWidth / 2f

        data.forEach { (category, amount) ->
            val barHeight = (amount / maxAmount * (height * 0.6)).toFloat()
            val top = height - barHeight - 100f


            canvas.drawRect(xPos, top, xPos + barWidth, height - 100f, barPaint)


            canvas.drawText(category, xPos + barWidth / 2, height - 40f, textPaint)


            canvas.drawText(String.format("%.2f", amount), xPos + barWidth / 2, top - 10f, textPaint)

            xPos += barWidth * 2
        }
    }
}
