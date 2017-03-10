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

    public Triangle() {
        super();
    }

    public Triangle(Point point, int size) {
        super(point, size);
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
        //setPoint(0, xpoints[0], ypoints[0]);
        setPoint(1, xpoints[0] + size, ypoints[0]);
        setPoint(2, xpoints[0] + (int) (size / 2), ypoints[0] - (int) (size / 2));

    }

    public static class Large extends Triangle {

        @Override
        protected void render() {
            //int size = super.size;
            super.render();
            //super.size = size;
        }

    }

    public static class Medium extends Triangle {

        @Override
        protected void render() {
            int size = super.size;
            super.size = (int) Math.sqrt(2 * Math.pow(super.size / 2, 2));
            super.render();
            super.size = size;
        }

    }

    public static class Small extends Triangle {

        @Override
        protected void render() {
            int size = super.size;
            super.size = (int) super.size / 2;
            super.render();
            super.size = size;
        }

    }

}
