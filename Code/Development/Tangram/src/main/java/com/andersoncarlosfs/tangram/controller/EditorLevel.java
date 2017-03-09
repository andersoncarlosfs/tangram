/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.controller;

import com.andersoncarlosfs.tangram.model.shapes.Triangle;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public class EditorLevel extends EditorPolygon {

    private final Polygon polygons[];

    public EditorLevel() {

        super();

        polygons = new Polygon[2];

        //Large triangles
        polygons[0] = new Triangle();
        polygons[1] = new Triangle();
        /*        
        //Medium triangle
        polygons[] = new Triangle());

        //Small triangles
        polygons[] = new Triangle());
        polygons[] = new Triangle());

        //Parallelogram
        polygons[] = new Parallelogram());

        //Square
        polygons[] = new Square());
         */
    }

    /**
     * @return the center point
     */
    public Point getCenterPoint() {
        return new Point(getSize(), getSize());
    }

    /**
     * @return the polygons
     */
    public Polygon[] getPolygons() {

        Triangle triangle;
        Point point;
        
        point = getCenterPoint();

        //Large triangles
        triangle = (Triangle) polygons[0];
        triangle.setSize(getSize());
        triangle.setPosition(new Point(point.x / 2, point.y / 2));
        
        point = triangle.getPosition();
        
        triangle = (Triangle) polygons[1];
        triangle.setSize(getSize());
        triangle.setPosition(new Point(point.x / 2, point.y / 2));

        return polygons;

    }

}
