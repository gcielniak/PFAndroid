package com.example.gcielniak.particlefilter;

/**
 * Created by gcielniak on 27/07/2016.
 */
public abstract class Filter {

    abstract void Predict(double dt);

    abstract void Update();

    abstract State GetEstimate();
}
