/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.model.shapes;

import java.awt.Point;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public class Parallelogram extends Polygon {

    public Parallelogram() {
        super();
    }

    public Parallelogram(Point point, int size) {
        super(point, size);
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
    protected void render() {
        //setPoint(0, xpoints[0], ypoints[0]);
        setPoint(1, xpoints[0] + size, ypoints[0] + size);
        setPoint(2, xpoints[0] + size, ypoints[0] + size * 2);
        setPoint(3, xpoints[0], ypoints[0] + size);
    }

}
