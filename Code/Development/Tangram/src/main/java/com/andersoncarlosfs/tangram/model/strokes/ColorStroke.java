/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.model.strokes;

import java.awt.BasicStroke;
import java.awt.Color;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public class ColorStroke extends BasicStroke {

    private Color color;

    public ColorStroke() {
    }

    public ColorStroke(Color color) {
        this.color = color;
    }

    public ColorStroke(Color color, float width, int cap, int join) {
        super(width, cap, join);
        this.color = color;
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

}
