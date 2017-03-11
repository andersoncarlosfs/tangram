/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import com.andersoncarlosfs.tangram.controller.EditorLevel;
import com.andersoncarlosfs.tangram.model.shapes.Polygon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.enterprise.context.ApplicationScoped;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

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

    //
    private MouseInputAdapter mouseInputAdapterMoveShape = new MouseInputAdapter() {

        private Polygon polygon;

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e); //To change body of generated methods, choose Tools | Templates.
        }

    };

    public PanelEditorLevel() {

        super();

        editorLevel = new EditorLevel();
        panelBoard = new PanelBoard();

        //Header
        panelHeader.setVisible(false);

        //Body
        panelBoard.addMouseListener(mouseInputAdapterMoveShape);
        panelBoard.addMouseMotionListener(mouseInputAdapterMoveShape);

        panelBody.setLayout(new BoxLayout(panelBody, BoxLayout.LINE_AXIS));
        panelBody.add(Box.createHorizontalStrut(10));
        panelBody.add(panelBoard);
        panelBody.add(Box.createHorizontalStrut(10));

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

            Graphics2D g2d;

            for (Polygon polygon : editorLevel.getPolygons()) {
                g2d = (Graphics2D) g.create();
                g2d.setColor(polygon.getColor());
                g2d.fill(polygon);
                g2d.setColor(Color.BLACK);
                g2d.draw(polygon);
                g2d.dispose();
            }

        }

    }

}
