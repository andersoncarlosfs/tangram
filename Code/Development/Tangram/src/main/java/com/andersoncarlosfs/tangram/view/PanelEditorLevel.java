/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import com.andersoncarlosfs.tangram.controller.EditorLevel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.enterprise.context.ApplicationScoped;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
@ApplicationScoped
public class PanelEditorLevel extends Panel {

    //
    private JPanel panelBoard;
    //
    private EditorLevel editorLevel;

    public PanelEditorLevel() {

        super();

        editorLevel = new EditorLevel();
        panelBoard = new PanelBoard();

        //Header
        headerPanel.setVisible(false);

        //Body
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.LINE_AXIS));
        bodyPanel.add(Box.createHorizontalStrut(10));
        bodyPanel.add(panelBoard);
        bodyPanel.add(Box.createHorizontalStrut(10));

    }

    @Override
    public void setVisible(boolean aFlag) {
        if (aFlag) {
            int size = Math.min(getWidth(), getHeight());
            panelBoard.setSize(new Dimension(size, size));
            editorLevel.setSize((int) (size * 0.5));
        }
        super.setVisible(aFlag);
    }

    private class PanelBoard extends JPanel {

        public PanelBoard() {

            super();

            super.setBackground(Color.WHITE);
            super.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            for (Polygon polygon : editorLevel.getPolygons()) {
                g.drawPolygon(polygon);
            }

        }

    }

}
