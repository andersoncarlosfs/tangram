/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.enterprise.context.ApplicationScoped;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
    private JButton buttonPreviousPage;
    private JButton buttonNextPage;
    private JButton buttonGoToLevel;
    private JPanel panelImageLogo;

    //
    private ActionListener actionListenerPlayLevel = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            JDialog dialogPlayLevel = new DialogPlayLevel((Frame) getTopLevelAncestor(), button.getText());
            dialogPlayLevel.setLocationRelativeTo(button);
            dialogPlayLevel.setVisible(true);
        }
    };
    //
    private ActionListener actionListenerPreviousLevels = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Previous");
        }
    };
    //
    private ActionListener actionListenerNextLevels = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Next");
        }
    };
    
    public PanelLobby() {
        
        super();
        
        panelImageLogo = new JPanel();
        buttonGoToLevel = new JButton();
        buttonNextPage = new JButton();
        buttonPreviousPage = new JButton();

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
        buttonGoToLevel.addActionListener(actionListenerPlayLevel);
        
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(Box.createHorizontalGlue());
        panelHeader.add(Box.createHorizontalStrut(10));
        panelHeader.add(panelImageLogo);
        panelHeader.add(Box.createHorizontalStrut(10));
        panelHeader.add(buttonGoToLevel);
        panelHeader.add(Box.createHorizontalStrut(10));
        panelHeader.add(Box.createHorizontalGlue());

        //Body
        buttonPreviousPage.setText("<");
        buttonPreviousPage.setMaximumSize(new Dimension(0, Short.MAX_VALUE));
        buttonPreviousPage.addActionListener(actionListenerPreviousLevels);
        
        buttonNextPage.setText(">");
        buttonNextPage.setMaximumSize(new Dimension(0, Short.MAX_VALUE));
        buttonNextPage.addActionListener(actionListenerNextLevels);
        
        JPanel panelNavigator = new JPanel();
        JPanel panelLevel = new JPanel();
        
        panelLevel.setLayout(new BoxLayout(panelLevel, BoxLayout.PAGE_AXIS));
        
        for (int i = 0; i < 3; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
            for (int j = 0; j < 3; j++) {
                JButton b = new JButton("Level " + i + j);
                b.setPreferredSize(new Dimension(150, 150));
                b.setMaximumSize(new Dimension(200, 200));
                b.addActionListener(actionListenerPlayLevel);
                panel.add(b);
                if (j + 1 < 3) {
                    panel.add(Box.createHorizontalStrut(10));
                }
            }
            panelLevel.add(panel);
            if (i + 1 < 3) {
                panelLevel.add(Box.createVerticalStrut(10));
            }
        }
        
        panelNavigator.setLayout(new BoxLayout(panelNavigator, BoxLayout.LINE_AXIS));
        panelNavigator.add(Box.createHorizontalGlue());
        panelNavigator.add(Box.createHorizontalStrut(10));
        panelNavigator.add(buttonPreviousPage);
        panelNavigator.add(Box.createHorizontalStrut(10));
        panelNavigator.add(panelLevel);
        panelNavigator.add(Box.createHorizontalStrut(10));
        panelNavigator.add(buttonNextPage);
        panelNavigator.add(Box.createHorizontalStrut(10));
        panelNavigator.add(Box.createHorizontalGlue());
        
        panelBody.setLayout(new BoxLayout(panelBody, BoxLayout.PAGE_AXIS));
        panelBody.add(panelNavigator);
        panelBody.add(Box.createVerticalGlue());
        
    }
    
}
