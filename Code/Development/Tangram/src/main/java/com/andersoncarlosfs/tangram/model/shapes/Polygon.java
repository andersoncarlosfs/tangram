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

    protected Dimension dimension;

    public Polygon() {
        npoints = getNpoints();
    }

    public Polygon(Point point, Dimension dimension) {
        this();
        this.dimension = dimension;
        this.xpoints[0] = point.x;
        this.ypoints[0] = point.y;
        render();
    }

    /**
     *
     */
    protected abstract void render();

    /**
     *
     * @return the npoints
     */
    public abstract int getNpoints();

    /**
     *
     * @return the position
     */
    public Point getPosition() {
        return new Point(xpoints[0], ypoints[0]);
    }

    /**
     *
     * @param point the position to set
     */
    public void setPosition(Point point) {
        this.xpoints[0] = point.x;
        this.ypoints[0] = point.y;
        render();
    }

    /**
     *
     * @return the dimension
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     *
     * @param dimension the dimension to set
     */
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
        render();
    }

    /**
     *
     * @param index
     * @return the point
     */
    protected final Point getPoint(int index) {
        return new Point(xpoints[index], ypoints[index]);
    }

    /**
     *
     * @param index
     * @param point
     */
    protected final void setPoint(int index, Point point) {
        xpoints[index] = point.x;
        ypoints[index] = point.y;
    }

    /**
     *
     * @param index
     * @param x
     * @param y
     */
    protected final void setPoint(int index, int x, int y) {
        xpoints[index] = x;
        ypoints[index] = y;
    }

    /**
     *
     */
    @Override
    public void reset() {
        npoints = getNpoints();
        bounds = null;
    }

}
