/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.controller;

import java.awt.Polygon;

/**
 * @see
 * <a href="https://www.donationcoder.com/forum/index.php?topic=30147.0">Automatically
 * compute sizes of tangram pieces</a>
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public class EditorPolygon {

    private int size;

    public EditorPolygon() {
    }

    public EditorPolygon(int size) {
        this.size = size;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    public Polygon resizePolygon(Polygon polygon) {
        return polygon;
    }

}
