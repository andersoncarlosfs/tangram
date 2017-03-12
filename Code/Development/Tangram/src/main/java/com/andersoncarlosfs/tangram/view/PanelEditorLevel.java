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
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import static java.awt.image.ImageObserver.WIDTH;
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

        private Point point;
        private Polygon polygon, p;

        @Override
        public void mousePressed(MouseEvent e) {
            point = e.getPoint();
            polygon = editorLevel.getPolygon(e.getPoint());
            System.out.println(polygon);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            transform(e);
            point = e.getPoint();
        }

        private void transform(MouseEvent e) {
            AffineTransform affineTransform = AffineTransform.getTranslateInstance(e.getX() - point.getX(), e.getY() - point.getY());
            if (polygon != null) {
                editorLevel.transform(polygon, affineTransform);
                panelBoard.repaint();
                //System.out.println(polygon.getPoint(0) + " " + polygon.getPoint(1) + " " + polygon.getPoint(2));
                p = polygon;
                //System.out.println(p + " " +p.getCentroid());
            } else {
                
                    System.out.println(p + " " +p.getCentroid());
                
            }
        }

    };

    public PanelEditorLevel() {

        super();

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

            editorLevel = new EditorLevel((int) (size * 0.5));

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

            Graphics2D g2d = (Graphics2D) g.create();
            for (Polygon polygon : editorLevel.getPolygons()) {
                g2d.setColor(polygon.getColor());
                g2d.fill(polygon);
                g2d.setColor(Color.BLACK);
                g2d.draw(polygon);
            }
            g2d.dispose();

        }

    }

}
