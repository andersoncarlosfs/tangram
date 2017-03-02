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
public abstract class Polygon extends java.awt.Polygon {

    private Point point;
    private Dimension dimension;

    public Polygon() {
        npoints = getNpoints();
    }

    /**
     *
     * @return the npoints
     */
    public abstract int getNpoints();

    /**
     *
     * @return the point
     */
    public Point getPoint() {
        return point;
    }

    /**
     *
     * @param point the point to set
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public void reset() {
        npoints = getNpoints();
        bounds = null;
    }

}
