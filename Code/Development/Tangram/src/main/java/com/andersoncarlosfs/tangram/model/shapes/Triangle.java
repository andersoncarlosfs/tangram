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
public class Triangle extends Polygon {

    public Triangle() {
        super();
    }

    /**
     *
     * @return
     */
    @Override
    public int getNpoints() {
        return 4;
    }

}
