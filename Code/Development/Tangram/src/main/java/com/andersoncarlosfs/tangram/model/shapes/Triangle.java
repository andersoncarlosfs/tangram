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
public class Triangle extends Polygon {

    private final Type type;

    public Triangle(Type type) {
        super();
        this.type = type;
    }

    public Triangle(Point point, int size, Type type) {
        super(point, size);
        this.type = type;
    }

    /**
     *
     * @return
     */
    @Override
    public int getNpoints() {
        return 3;
    }

    /**
     *
     */
    @Override
    protected void render() {

        int size = 0;

        switch (type) {
            case LARGE:
                size = super.size;
                break;
            case MEDIUM:
                size = (int) Math.sqrt(2 * Math.pow(super.size / 2, 2));
                break;
            case SMALL:
                size = (int) super.size / 2;
                break;
            default:
                size = super.size;
                break;
        }

        //setPoint(0, xpoints[0], ypoints[0]);
        setPoint(1, xpoints[0] + size, ypoints[0]);
        setPoint(2, xpoints[0] + (int) (size / 2), ypoints[0] - (int) (size / 2));

    }

    public enum Type {
        LARGE,
        MEDIUM,
        SMALL;
    }

}
