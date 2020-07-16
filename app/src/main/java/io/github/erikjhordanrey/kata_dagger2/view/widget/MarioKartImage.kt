package io.github.erikjhordanrey.kata_dagger2.view.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView

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

    this.mBorderPaint = Paint()
    this.mBorderPaint!!.color = Color.WHITE
    this.mBorderPaint!!.strokeCap = Paint.Cap.ROUND
    this.mBorderPaint!!.strokeWidth = 20f
    this.mBorderPaint!!.style = Paint.Style.STROKE
  }

  private fun calculatePath(radius: Float) {
    val halfRadius = radius / 2f
    val triangleHeight = (Math.sqrt(3.0) * halfRadius).toFloat()
    val centerX = measuredWidth / 2f
    val centerY = measuredHeight / 2f

    this.hexagonPath!!.reset()
    this.hexagonPath!!.moveTo(centerX, centerY + radius)
    this.hexagonPath!!.lineTo(centerX - triangleHeight, centerY + halfRadius)
    this.hexagonPath!!.lineTo(centerX - triangleHeight, centerY - halfRadius)
    this.hexagonPath!!.lineTo(centerX, centerY - radius)
    this.hexagonPath!!.lineTo(centerX + triangleHeight, centerY - halfRadius)
    this.hexagonPath!!.lineTo(centerX + triangleHeight, centerY + halfRadius)
    this.hexagonPath!!.close()

    val radiusBorder = radius - 5f
    val halfRadiusBorder = radiusBorder / 2f
    val triangleBorderHeight = (Math.sqrt(3.0) * halfRadiusBorder).toFloat()

    this.hexagonBorderPath!!.reset()
    this.hexagonBorderPath!!.moveTo(centerX, centerY + radiusBorder)
    this.hexagonBorderPath!!.lineTo(centerX - triangleBorderHeight, centerY + halfRadiusBorder)
    this.hexagonBorderPath!!.lineTo(centerX - triangleBorderHeight, centerY - halfRadiusBorder)
    this.hexagonBorderPath!!.lineTo(centerX, centerY - radiusBorder)
    this.hexagonBorderPath!!.lineTo(centerX + triangleBorderHeight, centerY - halfRadiusBorder)
    this.hexagonBorderPath!!.lineTo(centerX + triangleBorderHeight, centerY + halfRadiusBorder)
    this.hexagonBorderPath!!.close()
    invalidate()
  }

  public override fun onDraw(c: Canvas) {
    c.drawPath(hexagonBorderPath!!, mBorderPaint!!)
    c.clipPath(hexagonPath!!)
    c.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
    super.onDraw(c)
  }

  public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    val width = View.MeasureSpec.getSize(widthMeasureSpec)
    val height = View.MeasureSpec.getSize(heightMeasureSpec)
    setMeasuredDimension(width, height)
    calculatePath(Math.min(width / 2f, height / 2f) - 10f)
  }

  fun setRadius(radius: Float) {
    calculatePath(radius)
  }

  fun setBorderColor(color: Int) {
    this.mBorderPaint!!.color = color
    invalidate()
  }
}
