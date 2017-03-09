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
    private JPanel boardPanel;
    //
    private EditorLevel editorLevel;

    public PanelEditorLevel() {

        super();

        editorLevel = new EditorLevel();
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
            Dimension size = getSize();
            int width = Math.min(size.width, size.height);
            int height = Math.min(size.width, size.height);
            size = new Dimension(width, height);
            boardPanel.setSize(size);
            editorLevel.setDimension(size);
        }
        super.setVisible(aFlag);
    }

    @Override
    protected void paintComponent(Graphics g) {
    }

}
