/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.model.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 * @see
 * <a href="http://www.shodor.org/~jmorrell/interactivate/org/shodor/util11/PolygonUtils.java">PolygonUtils</a>
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public abstract class Polygon extends java.awt.Polygon {

    protected int size;
    private Color color;
    private Stroke stroke;

    public Polygon(int size) {
        super.npoints = getNpoints();
        this.color = Color.LIGHT_GRAY;
        this.stroke = new BasicStroke();
        this.size = size;
        init();
    }

    /**
     *
     */
    protected abstract void init();

    /**
     *
     * @return the npoints
     */
    public abstract int getNpoints();

    /**
     * @see java.awt.Polygon#reset()
     */
    @Override
    public void reset() {
        npoints = getNpoints();
        bounds = null;
    }

    /**
     *
     * @return the points
     */
    public Point[] getPoints() {
        Point[] points = new Point[super.npoints];
        for (int index = 0; index < super.npoints; index++) {
            points[index] = getPoint(index);
        }
        return points;
    }

    /**
     *
     * @return the points
     */
    public Point[] setPoints(Point[] points) {
        for (int index = 0; index < super.npoints; index++) {
            setPoint(index, points[index]);
        }
        return points;
    }

    /**
     *
     * @param index
     * @return the point
     */
    public Point getPoint(int index) {
        return new Point(super.xpoints[index], super.ypoints[index]);
    }

    /**
     *
     * @param index
     * @param point
     */
    public void setPoint(int index, Point point) {
        setPoint(index, point.x, point.y);
    }

    /**
     *
     * @param index
     * @param point
     */
    public void setPoint(int index, Point2D point) {
        setPoint(index, (int) point.getX(), (int) point.getY());
    }

    /**
     *
     * @param index
     * @param x
     * @param y
     */
    protected void setPoint(int index, int x, int y) {
        super.xpoints[index] = x;
        super.ypoints[index] = y;
        super.invalidate();
    }

    /**
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @return the stroke
     */
    public Stroke getStroke() {
        return stroke;
    }

    /**
     *
     * @param stroke the stroke to set
     */
    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    /**
     *
     * @return the signed area
     */
    private double getSignedArea() {
        int i;
        int j;

        double area = 0;

        for (i = 0; i < npoints; i++) {
            j = (i + 1) % npoints;
            area += super.xpoints[i] * super.ypoints[j];
            area -= super.xpoints[j] * super.ypoints[i];
        }

        area /= 2.0;

        return area;
    }

    /**
     *
     * @return the area
     */
    public double getArea() {
        return (Math.abs(getSignedArea()));
    }

    /**
     *
     * @return the centroid
     */
    public final Point2D getCentroid() {
        int i;
        int j;
        double factor;

        double x = 0;
        double y = 0;

        for (i = 0; i < npoints; i++) {
            j = (i + 1) % npoints;
            factor = (super.xpoints[i] * super.ypoints[j] - super.xpoints[j] * super.ypoints[i]);
            x += (super.xpoints[i] + super.xpoints[j]) * factor;
            y += (super.ypoints[i] + super.ypoints[j]) * factor;
        }

        factor = 1.0 / (6.0 * getArea());

        x *= factor;
        y *= factor;

        return new Point.Double(x, y);
    }

    /**
     * @see
     * <a href="http://stackoverflow.com/questions/11548309/guarantee-outward-direction-of-polygon-normals">Guarantee
     * outward direction of polygon normals</a>
     *
     * @see
     * <a href="http://stackoverflow.com/questions/1165647/how-to-determine-if-a-list-of-polygon-points-are-in-clockwise-order/1165943#1165943">How
     * to determine if a list of polygon points are in clockwise order?</a>
     *
     * @return
     */
    public final boolean isClockwise() {
        return getSignedArea() < 0;
    }

}
