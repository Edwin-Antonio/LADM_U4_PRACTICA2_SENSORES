package mx.tecnm.tepic.u4_test_sensores

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var sensorManager: SensorManager
    lateinit var lienzo: Lienzo
    //var dirY = true
    //var dirX = true
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lienzo = Lienzo(this)
        lienzo.paintField.color = Color.GREEN
        setContentView(lienzo)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent) {
        when(event.sensor.type){
            //Cambio de colores
            Sensor.TYPE_PROXIMITY -> {
                if (event.values[0] == 0f) {
                    lienzo.paintField.color = Color.BLACK
                } else {
                    lienzo.paintField.color = Color.BLUE
                }
            }
            //Moviminto del canvas
            Sensor.TYPE_ACCELEROMETER ->{
                if(event.values[0] < 0){
                    lienzo.posicionX += 4
                }else{
                    lienzo.posicionX -= 4
                }
                if (event.values[1] < 0){
                    lienzo.posicionY += 4
                }else{
                    lienzo.posicionY -= 4
                }
                println("X ${lienzo.posicionX}, Y: ${lienzo.posicionY}")
            }
        }
        lienzo.postInvalidate() //Repintamos lienzo
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}