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
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public class EditorLevel {

    private Polygon polygons[];

    public EditorLevel(int size) {

        super();

        polygons = new Polygon[7];

        //Large triangles
        polygons[0] = new Triangle.Large(size);
        polygons[1] = new Triangle.Large(size);

        //Medium triangle
        polygons[2] = new Triangle.Medium(size);

        //Small triangles
        polygons[3] = new Triangle.Small(size);
        polygons[4] = new Triangle.Small(size);

        //Parallelogram
        polygons[5] = new Parallelogram(size);

        //Square
        polygons[6] = new Square(size);

    }

    /**
     * @return the polygons
     */
    public Polygon[] getPolygons() {
        return polygons;
    }

    /**
     * @return the polygon
     */
    public Polygon getPolygon(Point p) {
        for (int i = polygons.length - 1; i >= 0; i--) {
            if (polygons[i].contains(p)) {
                return polygons[i];
            }
        }
        return null;
    }

    /**
     *
     * @param polygon
     * @param affineTransform
     */
    public void transform(Polygon polygon, AffineTransform affineTransform) {
        for (int index = 0; index < polygon.getNpoints(); index++) {
            Point2D point = polygon.getPoint(index);
            point = affineTransform.transform(point, null);
            polygon.setPoint(index, point);
        }
    }

}
