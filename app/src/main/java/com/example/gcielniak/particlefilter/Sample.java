package com.example.gcielniak.particlefilter;

import android.util.Log;

/**
 * Created by gcielniak on 27/07/2016.
 */
public class Sample implements Comparable<Sample> {
    State state;
    double weight;

    Sample() {
        state = new State();
    }

    public void Predict(double dt) {
        Log.d("Sample","Predict");
    }

    public void Update() {
        Log.d("Sample","Update");
    }

    @Override
    /**
     * Sort by weights in descending order.
     */
    public int compareTo(Sample s) {
        int result = 0;

        if (this.weight < s.weight) {
            result = 1;
        } else if (this.weight > s.weight) {
            result = -1;
        }

        return result;
    }
}
