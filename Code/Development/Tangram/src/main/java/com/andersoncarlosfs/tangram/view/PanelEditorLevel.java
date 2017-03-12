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
import java.awt.geom.Point2D;
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

        private double angle;
        private Point point;
        private Polygon polygon;

        @Override
        public void mousePressed(MouseEvent e) {
            angle = 0;
            point = e.getPoint();
            polygon = editorLevel.getPolygon(e.getPoint());
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            transform(e);
            point = e.getPoint();
        }

        /**
         * @see
         * <a href="http://stackoverflow.com/questions/27260445/rotating-a-triangle-around-a-point-java">Rotating
         * a triangle around a point java</a>
         *
         * @param e
         */
        private void transform(MouseEvent e) {
            if (polygon != null) {

                Point2D point = new Point2D.Double(e.getX() - this.point.x, e.getY() - this.point.y);

                this.angle = -Math.toDegrees(Math.atan2(point.getX(), point.getY())) + 180;

                Point2D centroid = polygon.getCentroid();

                double x = e.getX() - centroid.getX();
                double y = e.getY() - centroid.getY();

                AffineTransform affineTransform = new AffineTransform();
                affineTransform.translate(x, y);
                affineTransform.rotate(Math.toRadians(angle), this.point.x - x, this.point.y - y);

                editorLevel.transform(polygon, affineTransform);

                panelBoard.repaint();

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
