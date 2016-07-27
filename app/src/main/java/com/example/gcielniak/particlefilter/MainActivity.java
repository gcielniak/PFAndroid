package com.example.gcielniak.particlefilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Sample sample = new Sample();

        ParticleFilter particleFilter = new ParticleFilter(sample, 10);

        particleFilter.Predict(1.0);

        particleFilter.Update();

        particleFilter.Print();
    }


}
