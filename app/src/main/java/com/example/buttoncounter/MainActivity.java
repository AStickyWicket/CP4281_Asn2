package com.example.buttoncounter;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // Declare variables
    private int mCounter = 0;
    private int plusPresses = 0;
    private int minusPresses = 0;
    Button btnPlus;
    Button btnMinus;
    TextView txv;
    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlus = findViewById(R.id.btnPlusOne);
        btnMinus = findViewById(R.id.btnSubtractOne);
        txv = findViewById(R.id.txtCounterView);


        // Create listeners for buttons
        btnPlus.setOnClickListener(view -> {
            mCounter++;
            plusPresses++;
            txv.setText(String.format(java.util.Locale.US,"%d", mCounter));
        });
        btnMinus.setOnClickListener(view -> {
            mCounter--;
            minusPresses++;
            txv.setText(String.format(java.util.Locale.US,"%d", mCounter));
        });

        // Create a timer that counts down from 10 seconds to 0 seconds
        new CountDownTimer(10000, 1000) {
            // Update the timer text view every second
            public void onTick(long millisUntilFinished) {
                timer = findViewById(R.id.timer);
                timer.setText(String.format(java.util.Locale.US,"Time Remaining: %d", millisUntilFinished / 1000));
            }
            public void onFinish() {
                // When the timer finishes, display a toast message
                timer.setText("Time Expired");

                Toast.makeText(getApplicationContext(),"Plus one pressed: " + plusPresses +
                        "\nMinus one pressed: " + minusPresses +
                        "\nTotal pressed: " + (plusPresses + minusPresses), Toast.LENGTH_LONG).show();
            }
        }.start();
    }
}