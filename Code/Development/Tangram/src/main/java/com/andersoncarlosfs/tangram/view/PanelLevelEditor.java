/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import com.andersoncarlosfs.tangram.controller.PolygonEditor;
import com.andersoncarlosfs.tangram.model.shapes.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import javax.enterprise.context.ApplicationScoped;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
@ApplicationScoped
public class PanelLevelEditor extends JPanel {

    //
    private JPanel boardPanel;
    //
    private PolygonEditor polygonEditor;

    public PanelLevelEditor() {

        polygonEditor = new PolygonEditor();
        boardPanel = new JPanel();

        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //Body
        boardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.LINE_AXIS));
        bodyPanel.add(Box.createHorizontalStrut(10));
        bodyPanel.add(boardPanel);
        bodyPanel.add(Box.createHorizontalStrut(10));

        super.add(Box.createVerticalStrut(10));
        super.add(bodyPanel);
        super.add(Box.createVerticalStrut(10));

    }

    @Override
    public void setVisible(boolean aFlag) {
        if (aFlag) {
            polygonEditor.setDimension(getSize());
            System.out.println("a");
        }
        super.setVisible(aFlag);        
    }

    @Override
    protected void paintComponent(Graphics g) {
System.out.println("b");
    }

}
