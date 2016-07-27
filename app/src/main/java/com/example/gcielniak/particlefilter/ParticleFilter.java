package com.example.gcielniak.particlefilter;

import android.util.Log;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by gcielniak on 27/07/2016.
 */
public class ParticleFilter extends Filter{

    Sample[] samples;
    Random random;

    ParticleFilter(Sample sample, int sample_count) {
        random = new Random();
        samples = new Sample[sample_count];
        for (int i = 0; i < sample_count; i++) {
            samples[i] = new Sample();
            samples[i].weight = 1.0/sample_count; //uniform distribution by default
            samples[i].weight = i;
        }
    }

    @Override
    void Predict(double dt) {

        Resample();

        Log.d("PF","SL " + samples.length);

        for (Sample s: samples) {
            s.Predict(dt);
        }
        Log.d("PF","Predict");
    }

    @Override
    void Update() {
        for (Sample s: samples) {
            s.Update();
        }
        Log.d("PF","Update");
    }

    void NormaliseWeights() {

        double sum = 0.0;

        for (Sample s: samples) {
            sum += s.weight;
        }

        for (Sample s: samples) {
            s.weight /= sum;
        }
    }

    /**
     * Multinomial resampling
     */
    void Resample() {

        NormaliseWeights();

        Arrays.sort(samples);//required for binary search

        //calculate cumulative weights
        double[] cum_weights = new double[samples.length];

        cum_weights[0] = samples[0].weight;

        for (int i = 1; i < samples.length; i++) {
            cum_weights[i] = cum_weights[i-1] + samples[i].weight;
        }

        double v = random.nextDouble();

        int ind = Arrays.binarySearch(cum_weights,v);
    }

    void Print() {
        for (Sample s: samples) {
            Log.d("PF Print","weight " + s.weight);
        }
    }

    @Override
    State GetEstimate() {
        return null;
    }
}
