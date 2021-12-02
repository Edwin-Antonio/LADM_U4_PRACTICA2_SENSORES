package mx.tecnm.tepic.u4_test_sensores

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(act: MainActivity) : View(act) {

    var posicionX = 600f
    var posicionY = 1100f
    var paintField = Paint()

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        c.drawColor(paintField.color)

        p.color = Color.BLACK
        p.strokeWidth = 20f
        c.drawLine(0f,600f,1200f,600f,p)
        p.style = Paint.Style.STROKE
        c.drawCircle(600f,600f,200f,p)
        /*if(posicionX<=80){
            p.color = Color.GRAY
            p.style = Paint.Style.FILL
            c.drawCircle(80f,posicionY,90f,p)
        }
        if(posicionX>=1000){
            p.color = Color.GRAY
            p.style = Paint.Style.FILL
            c.drawCircle(80f,posicionY,90f,p)
        }
        if(posicionY>=1400){
            p.color = Color.GRAY
            p.style = Paint.Style.FILL
            c.drawCircle(80f,posicionY,90f,p)
        }
        if(posiciony<=90){
            p.color = Color.GRAY
            p.style = Paint.Style.FILL
            c.drawCircle(80f,posicionY,90f,p)
        }*/
        p.color = Color.GRAY
        p.style = Paint.Style.FILL
        c.drawCircle(posicionX,posicionY,90f,p)
    }
}