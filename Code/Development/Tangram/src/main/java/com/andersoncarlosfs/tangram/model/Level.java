/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.model;

import com.andersoncarlosfs.tangram.model.shapes.Polygon;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public class Level {

    private Polygon[] polygons;
    private boolean complete;

    public Level() {
    }

    public Level(Polygon[] polygons, boolean complete) {
        this.polygons = polygons;
        this.complete = complete;
    }

    /**
     *
     * @return the polygons
     */
    public Polygon[] getPolygons() {
        return polygons;
    }

    /**
     *
     * @param polygons the polygons to set
     */
    public void setPolygons(Polygon[] polygons) {
        this.polygons = polygons;
    }

    /**
     *
     * @return the complete
     */
    public boolean isComplete() {
        return complete;
    }

    /**
     *
     * @param complete the complete to set
     */
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

}
