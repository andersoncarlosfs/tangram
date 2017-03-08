/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import com.andersoncarlosfs.tangram.controller.PolygonEditor;
import com.andersoncarlosfs.tangram.model.shapes.Dimension;
import java.awt.Graphics;
import javax.enterprise.context.ApplicationScoped;
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
    private PolygonEditor polygonEditor;

    public PanelLevelEditor() {
        
        super.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.PAGE_AXIS));
        for (int i = 0; i < 3; i++) {
            JPanel levelPanel = new JPanel();
            levelPanel.setLayout(new BoxLayout(levelPanel, BoxLayout.LINE_AXIS));
            levelPanel.add(Box.createHorizontalGlue());
            levelPanel.add(Box.createHorizontalStrut(10));
            for (int j = 0; j < 3; j++) {
                JButton b = new JButton("Level " + i + j);
                b.setPreferredSize(new Dimension(150, 150));
                b.setMaximumSize(new Dimension(200, 200));
                b.addActionListener(playLevelActionListener);
                levelPanel.add(b);
                levelPanel.add(Box.createHorizontalStrut(10));
            }
            levelPanel.add(Box.createHorizontalGlue());
            bodyPanel.add(levelPanel);
            bodyPanel.add(Box.createVerticalStrut(10));
        }

        super.add(Box.createVerticalStrut(10));
        super.add(bodyPanel);
        super.add(Box.createHorizontalStrut(10));
        super.add(Box.createVerticalGlue());

    }

    @Override
    protected void paintComponent(Graphics g) {

    }

}
