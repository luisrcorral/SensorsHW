package mx.tec.sensorshw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;


//Sensor Event Listener
public class gyroscope extends AppCompatActivity implements SensorEventListener {
    public Sensor gyroscopeSensor;
    public SensorManager sensorManager;

    public float roll;
    public float pitch;
    public float yaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        // Review if we have this hardware available in device
        if(gyroscopeSensor == null) {
            // To-do code to manage when specified sensor is not available
        }
        else {
            // Register it, specifying the polling interval in microseconds
            sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);

        }

    }


    @Override
    public void onSensorChanged (SensorEvent sensorEvent) {
        //output the Roll [2], Pitch [1] and Yawn [0] values
        roll = sensorEvent.values[2];
        pitch = sensorEvent.values[1];
        yaw = sensorEvent.values[0];

        TextView xValues =  findViewById(R.id.valueX);
        TextView yValues =  findViewById(R.id.valueY);
        TextView zValues =  findViewById(R.id.valueZ);

        xValues.setText("" + roll);
        yValues.setText("" + pitch);
        zValues.setText("" + yaw);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}