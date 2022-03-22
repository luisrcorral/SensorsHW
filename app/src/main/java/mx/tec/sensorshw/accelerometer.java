package mx.tec.sensorshw;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//Sensor Event Listener

public class accelerometer extends AppCompatActivity implements SensorEventListener {

    public SensorManager sensorManager;
    public Sensor accelerometerSensor;
    public float ax;
    public float ay;
    public float az;   // these are the acceleration in x,y and z axis

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Review if we have this hardware available in device
        if (accelerometerSensor == null) {
            // To-do code to manage when specified sensor is not available
        } else {
            // Register it, specifying the polling interval in microseconds
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

   @Override
   public void onSensorChanged(SensorEvent event) {

        ax = event.values[0];
        ay = event.values[1];
        az = event.values[2];

        TextView xValues = findViewById(R.id.valueX);
        TextView yValues = findViewById(R.id.valueY);
        TextView zValues = findViewById(R.id.valueZ);

        xValues.setText("" + ax);
        yValues.setText("" + ay);
        zValues.setText("" + az);

   }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}





