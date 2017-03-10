/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.controller;

import com.andersoncarlosfs.tangram.model.shapes.Parallelogram;
import com.andersoncarlosfs.tangram.model.shapes.Triangle;
import com.andersoncarlosfs.tangram.model.shapes.Polygon;
import com.andersoncarlosfs.tangram.model.shapes.Square;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public class EditorLevel extends EditorPolygon {

    private final Polygon polygons[];

    public EditorLevel() {

        super();

        polygons = new Polygon[7];

        //Large triangles
        polygons[0] = new Triangle.Large();
        polygons[1] = new Triangle.Large();

        //Medium triangle
        polygons[2] = new Triangle.Medium();

        //Small triangles
        polygons[3] = new Triangle.Small();
        polygons[4] = new Triangle.Small();

        //Parallelogram
        polygons[5] = new Parallelogram();

        //Square
        polygons[6] = new Square();

    }

    /**
     * @return the polygons
     */
    public Polygon[] getPolygons() {
        int size = getSize();
        for (Polygon polygon : polygons) {
            polygon.setSize(size);
        }
        return polygons;
    }

}
