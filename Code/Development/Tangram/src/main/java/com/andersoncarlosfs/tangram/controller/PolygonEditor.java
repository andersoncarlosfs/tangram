/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.controller;

import com.andersoncarlosfs.tangram.model.shapes.Dimension;
import java.awt.Polygon;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
//https://www.donationcoder.com/forum/index.php?topic=30147.0
public class PolygonEditor {

    private Dimension dimension;

    public PolygonEditor(Dimension dimension) {
        this.dimension = dimension;
    }

    public Polygon resizePolygon(Polygon polygon) {
        return polygon;
    }

}
