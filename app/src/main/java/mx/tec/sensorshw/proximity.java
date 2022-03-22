package mx.tec.sensorshw;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


//Sensor Event Listener

public class proximity extends AppCompatActivity  implements SensorEventListener {

    public SensorManager sensorManager;
    public Sensor proximitySensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        // Review if we have this hardware available in device
        if(proximitySensor == null) {
            // To-do code to manage when specified sensor is not available
        }
        else {
            // Register it, specifying the polling interval in microseconds
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[0] < proximitySensor.getMaximumRange()) {
            // Detected something nearby
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        } else {
            // Nothing is nearby
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
