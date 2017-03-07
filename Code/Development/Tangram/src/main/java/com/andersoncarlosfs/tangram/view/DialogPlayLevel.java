/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.enterprise.context.RequestScoped;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
@RequestScoped
public class DialogPlayLevel extends JDialog {

    //
    private JLabel labelMessage;
    private JButton buttonPlay;
    private JButton buttonLeave;

    private final ActionListener leaveActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };

    private final ActionListener playActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Play");
        }
    };

    public DialogPlayLevel(Frame owner, String level) {

        super(owner, true);

        labelMessage = new JLabel();
        buttonPlay = new JButton();
        buttonLeave = new JButton();

        super.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        super.setTitle("Play level");
        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Header
        labelMessage.setText("Do you want play level ?");

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.LINE_AXIS));
        headerPanel.add(Box.createHorizontalGlue());
        headerPanel.add(Box.createHorizontalStrut(10));
        headerPanel.add(labelMessage);
        headerPanel.add(Box.createHorizontalStrut(10));
        headerPanel.add(Box.createHorizontalGlue());

        super.getContentPane().add(Box.createVerticalStrut(10));
        super.getContentPane().add(headerPanel);

        //Body
        //JPanel bodyPanel = new JPanel();
        //bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.LINE_AXIS));
        
        //super.getContentPane().add(Box.createVerticalStrut(10));
        //super.getContentPane().add(bodyPanel);
        
        //Footer
        buttonPlay.setText("Play");
        buttonPlay.addActionListener(playActionListener);

        buttonLeave.setText("Leave");
        buttonLeave.addActionListener(leaveActionListener);

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.LINE_AXIS));
        optionPanel.add(Box.createHorizontalStrut(10));
        optionPanel.add(buttonPlay);
        optionPanel.add(Box.createHorizontalGlue());
        optionPanel.add(buttonLeave);
        optionPanel.add(Box.createHorizontalStrut(10));

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.PAGE_AXIS));
        footerPanel.add(Box.createVerticalStrut(10));
        footerPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        footerPanel.add(Box.createVerticalStrut(10));
        footerPanel.add(optionPanel);

        //super.getContentPane().add(Box.createVerticalStrut(10));
        super.getContentPane().add(footerPanel);
        super.getContentPane().add(Box.createVerticalStrut(10));

        super.getContentPane().add(Box.createVerticalGlue());

        super.pack();

    }

}
