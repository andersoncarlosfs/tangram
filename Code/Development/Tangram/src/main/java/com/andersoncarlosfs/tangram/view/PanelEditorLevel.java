/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import com.andersoncarlosfs.tangram.controller.EditorLevel;
import com.andersoncarlosfs.tangram.model.shapes.Polygon;
import com.andersoncarlosfs.tangram.model.strokes.ColorStroke;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
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

        private boolean rotate;
        private double angle;
        private Point point;
        private Polygon polygon;

        @Override
        public void mousePressed(MouseEvent e) {

            point = e.getPoint();

            polygon = editorLevel.getPolygon(e.getPoint());

            if (polygon != null) {
                Stroke stroke = new ColorStroke(Color.RED, 2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                polygon.setStroke(stroke);

                angle = 0;

                Point2D centroid = polygon.getCentroid();

                double radius = polygon.getShortestDistance(point);
                double x = centroid.getX() - radius / 2;
                double y = centroid.getY() - radius / 2;

                rotate = new Ellipse2D.Double(x, y, radius, radius).contains(point);
            }

        }

        @Override
        public void mouseDragged(MouseEvent e) {

            if (polygon != null) {

                this.angle = -Math.toDegrees(Math.atan2(e.getY(), e.getX())) + 45;

                Point2D centroid = polygon.getCentroid();

                double x = e.getX() - centroid.getX();
                double y = e.getY() - centroid.getY();

                AffineTransform affineTransform = new AffineTransform();
                affineTransform.translate(x, y);

                if (!rotate) {
                    affineTransform.rotate(Math.toRadians(angle), centroid.getX(), centroid.getY());
                }

                editorLevel.transform(polygon, affineTransform);

                panelBoard.repaint();

            }

            this.point = e.getPoint();

        }

        /**
         * @see
         * <a href="http://stackoverflow.com/questions/27260445/rotating-a-triangle-around-a-point-java">Rotating
         * a triangle around a point java</a>
         *
         * @param e
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            if (this.polygon != null) {
                polygon.setStroke(new ColorStroke(Color.BLACK));
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

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                    RenderingHints.VALUE_STROKE_PURE);

            for (Polygon polygon : editorLevel.getPolygons()) {
                g2d.setColor(polygon.getColor());
                g2d.fill(polygon);
                g2d.setColor(((ColorStroke) polygon.getStroke()).getColor());
                g2d.draw(polygon);
            }
            g2d.dispose();

        }

    }

}
