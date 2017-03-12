/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.model.shapes;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public class Parallelogram extends Polygon {

    public Parallelogram(int size) {
        super(size);
    }

    /**
     *
     * @return
     */
    @Override
    public int getNpoints() {
        return 4;
    }

    /**
     *
     */
    @Override
    protected void init() {

        int width = (int) super.size / 2;
        int height = (int) Math.sqrt(2 * Math.pow(width, 2)) / 2;

        //setPoint(0, xpoints[0], ypoints[0]);
        setPoint(1, xpoints[0] + width, ypoints[0]);
        setPoint(3, xpoints[0] + height, ypoints[0] + height);
        setPoint(2, xpoints[0] + width + height, ypoints[0] + height);

    }

}
