/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import com.andersoncarlosfs.tangram.model.shapes.Dimension;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.enterprise.context.ApplicationScoped;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
@ApplicationScoped
public class PanelLobby extends Panel {

    //
    private JButton buttonGoToLevel;
    private JPanel panelImageLogo;

    private ActionListener playLevelActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            JDialog dialogPlayLevel = new DialogPlayLevel((Frame) getTopLevelAncestor(), button.getText());
            dialogPlayLevel.setLocationRelativeTo(button);
            dialogPlayLevel.setVisible(true);
        }
    };

    public PanelLobby() {

        super();

        panelImageLogo = new JPanel();
        buttonGoToLevel = new JButton();

        //Header
        TitledBorder titledBorderLogo;
        titledBorderLogo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK));
        titledBorderLogo.setTitle("Image logo");
        titledBorderLogo.setTitleJustification(TitledBorder.CENTER);
        panelImageLogo.setMinimumSize(new Dimension(400, 100));
        panelImageLogo.setPreferredSize(new Dimension(600, 200));
        panelImageLogo.setMaximumSize(new Dimension(Short.MAX_VALUE, 250));
        panelImageLogo.setBorder(titledBorderLogo);

        buttonGoToLevel.setText("Go to level");
        buttonGoToLevel.setPreferredSize(new Dimension(200, 200));
        buttonGoToLevel.setMaximumSize(new Dimension(250, 250));
        buttonGoToLevel.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonGoToLevel.setVerticalTextPosition(AbstractButton.BOTTOM);
        buttonGoToLevel.addActionListener(playLevelActionListener);

        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.LINE_AXIS));
        headerPanel.add(Box.createHorizontalGlue());
        headerPanel.add(Box.createHorizontalStrut(10));
        headerPanel.add(panelImageLogo);
        headerPanel.add(Box.createHorizontalStrut(10));
        headerPanel.add(buttonGoToLevel);
        headerPanel.add(Box.createHorizontalStrut(10));
        headerPanel.add(Box.createHorizontalGlue());

        //Body
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
            if (i + 1 < 3) {
                bodyPanel.add(Box.createVerticalStrut(10));
            }
        }
        bodyPanel.add(Box.createVerticalGlue());

    }

}
