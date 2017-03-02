/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.model.shapes;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public class Dimension extends java.awt.Dimension {

    private int maxWidth;
    private int minWidth;
    private int maxHeight;
    private int minHeight;

    public Dimension() {
        this(0, 0, 0, 0, 0, 0);
    }

    public Dimension(Dimension d) {
        this(d.width, d.height, d.maxWidth, d.minWidth, d.maxHeight, d.minHeight);
    }

    public Dimension(int width, int height, int maxWidth, int minWidth, int maxHeight, int minHeight) {
        super(width, height);
        this.maxWidth = maxWidth;
        this.minWidth = minWidth;
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
    }

    /**
     * 
     * @return the maxWidth
     */
    public int getMaxWidth() {
        return maxWidth;
    }

    /**
     * 
     * @param maxWidth the maxWidth to set
     */
    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * 
     * @return the minWidth
     */
    public int getMinWidth() {
        return minWidth;
    }

    /**
     * 
     * @param minWidth the minWidth to set
     */
    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    /**
     * 
     * @return the maxHeight
     */
    public int getMaxHeight() {
        return maxHeight;
    }

    /**
     * 
     * @param maxHeight the maxHeight to set
     */
    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     * 
     * @return the minHeight
     */
    public int getMinHeight() {
        return minHeight;
    }

    /**
     * 
     * @param minHeight the minHeight to set
     */
    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

}
