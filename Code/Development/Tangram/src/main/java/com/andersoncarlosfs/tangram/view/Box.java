/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import com.andersoncarlosfs.tangram.model.shapes.Dimension;
import java.awt.Component;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
@RequestScoped
public class Box extends javax.swing.Box {

    public Box(int axis) {
        super(axis);
    }

    public static Component createHorizontalStrut(int width) {
        return new javax.swing.Box.Filler(new Dimension(width, 0), new Dimension(width, 0),
                new Dimension(width, 0));
    }

    public static Component createVerticalStrut(int height) {
        return new javax.swing.Box.Filler(new Dimension(0, height), new Dimension(0, height),
                new Dimension(0, height));
    }

}
