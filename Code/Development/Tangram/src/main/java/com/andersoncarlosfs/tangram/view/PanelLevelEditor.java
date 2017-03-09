/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import com.andersoncarlosfs.tangram.controller.PolygonEditor;
import java.awt.Color;
import java.awt.Graphics;
import javax.enterprise.context.ApplicationScoped;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
@ApplicationScoped
public class PanelLevelEditor extends Panel {

    //
    private JPanel boardPanel;
    //
    private PolygonEditor polygonEditor;
    
    public PanelLevelEditor() {
        
        super();
        
        polygonEditor = new PolygonEditor();
        boardPanel = new JPanel();

        //Header
        headerPanel.setVisible(false);

        //Body
        boardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.LINE_AXIS));
        bodyPanel.add(Box.createHorizontalStrut(10));
        bodyPanel.add(boardPanel);
        bodyPanel.add(Box.createHorizontalStrut(10));
        
    }
    
    @Override
    public void setVisible(boolean aFlag) {
        if (aFlag) {
            polygonEditor.setDimension(getSize());
        }
        super.setVisible(aFlag);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    }
    
}
