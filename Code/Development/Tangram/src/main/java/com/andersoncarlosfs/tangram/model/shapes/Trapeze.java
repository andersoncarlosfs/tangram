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
public class Trapeze extends Polygon {

    public Trapeze() {
        super();
    }

    public Trapeze(Point point, Dimension dimension) {
        super(point, dimension);
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
        setPoint(1, xpoints[0] + dimension.width, ypoints[0] + dimension.height);
        setPoint(2, xpoints[0] + dimension.width, ypoints[0] + dimension.height * 2);
        setPoint(3, xpoints[0], ypoints[0] + dimension.height);
    }

}
