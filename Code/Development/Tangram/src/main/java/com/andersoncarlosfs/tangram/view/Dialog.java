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
public class Dialog extends JDialog {

    //
    protected JLabel labelMessage;
    protected JButton buttonDoAction;
    protected JButton buttonCancelAction;

    //
    protected final ActionListener cancelAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };

    public Dialog(Frame owner, String title, String message) {

        super(owner, true);

        labelMessage = new JLabel();
        buttonDoAction = new JButton();
        buttonCancelAction = new JButton();

        super.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        
        super.setResizable(false);
        
        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Header
        labelMessage.setText(message);
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.LINE_AXIS));
        headerPanel.add(Box.createHorizontalGlue());
        headerPanel.add(Box.createHorizontalStrut(10));
        headerPanel.add(labelMessage);
        headerPanel.add(Box.createHorizontalStrut(10));
        headerPanel.add(Box.createHorizontalGlue());

        super.getContentPane().add(Box.createVerticalStrut(10));
        super.getContentPane().add(headerPanel);

        //Footer
        buttonDoAction.setText("Yes");

        buttonCancelAction.setText("No");

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.LINE_AXIS));
        optionPanel.add(Box.createHorizontalStrut(10));
        optionPanel.add(buttonDoAction);
        optionPanel.add(Box.createHorizontalGlue());
        optionPanel.add(buttonCancelAction);
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
