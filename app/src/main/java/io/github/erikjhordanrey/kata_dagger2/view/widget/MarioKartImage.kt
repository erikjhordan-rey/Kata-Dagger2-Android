package io.github.erikjhordanrey.kata_dagger2.view.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.sqrt

class MarioKartImage @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        AppCompatImageView(context, attrs, defStyleAttr) {

    private var hexagonPath: Path? = null
    private var hexagonBorderPath: Path? = null
    private var mBorderPaint: Paint? = null

    init {
        init()
    }

    private fun init() {
        this.hexagonPath = Path()
        this.hexagonBorderPath = Path()

        this.mBorderPaint = Paint().apply {
            color = Color.WHITE
            strokeCap = Paint.Cap.ROUND
            strokeWidth = 20f
            style = Paint.Style.STROKE
        }
    }

    public override fun onDraw(canvas: Canvas) {
        if (hexagonBorderPath != null && mBorderPaint != null) canvas.drawPath(hexagonBorderPath!!, mBorderPaint!!)
        hexagonPath?.run { canvas.clipPath(this) }
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
        super.onDraw(canvas)
    }

    public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)
        calculatePath((width / 2f).coerceAtMost(height / 2f) - 10f)
    }

    fun setRadius(radius: Float) {
        calculatePath(radius)
    }

    fun setBorderColor(color: Int) {
        this.mBorderPaint!!.color = color
        invalidate()
    }

    private fun calculatePath(radius: Float) {
        val halfRadius = radius / 2f
        val triangleHeight = (sqrt(3.0) * halfRadius).toFloat()
        val centerX = measuredWidth / 2f
        val centerY = measuredHeight / 2f

        this.hexagonPath?.apply {
            reset()
            moveTo(centerX, centerY + radius)
            lineTo(centerX - triangleHeight, centerY + halfRadius)
            lineTo(centerX - triangleHeight, centerY - halfRadius)
            lineTo(centerX, centerY - radius)
            lineTo(centerX + triangleHeight, centerY - halfRadius)
            lineTo(centerX + triangleHeight, centerY + halfRadius)
            close()
        }

        val radiusBorder = radius - 5f
        val halfRadiusBorder = radiusBorder / 2f
        val triangleBorderHeight = (sqrt(3.0) * halfRadiusBorder).toFloat()

        this.hexagonBorderPath?.apply {
            reset()
            moveTo(centerX, centerY + radiusBorder)
            lineTo(centerX - triangleBorderHeight, centerY + halfRadiusBorder)
            lineTo(centerX - triangleBorderHeight, centerY - halfRadiusBorder)
            lineTo(centerX, centerY - radiusBorder)
            lineTo(centerX + triangleBorderHeight, centerY - halfRadiusBorder)
            lineTo(centerX + triangleBorderHeight, centerY + halfRadiusBorder)
            close()
        }
        invalidate()
    }
}
