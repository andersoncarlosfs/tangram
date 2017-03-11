/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Dialog extends JDialog {

    //
    protected JLabel labelMessage;
    protected JButton buttonDo;
    protected JButton buttonCancel;

    //
    protected final ActionListener actionListenerCancel = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };

    public Dialog(Frame owner, String title, String message) {

        super(owner, true);

        labelMessage = new JLabel();
        buttonDo = new JButton();
        buttonCancel = new JButton();

        super.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        super.setResizable(false);

        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Header
        labelMessage.setText(message);

        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(Box.createHorizontalGlue());
        panelHeader.add(Box.createHorizontalStrut(10));
        panelHeader.add(labelMessage);
        panelHeader.add(Box.createHorizontalStrut(10));
        panelHeader.add(Box.createHorizontalGlue());

        super.getContentPane().add(Box.createVerticalStrut(10));
        super.getContentPane().add(panelHeader);

        //Footer
        buttonDo.setText("Yes");

        buttonCancel.setText("No");

        JPanel panelAction = new JPanel();
        panelAction.setLayout(new BoxLayout(panelAction, BoxLayout.LINE_AXIS));
        panelAction.add(Box.createHorizontalStrut(10));
        panelAction.add(buttonDo);
        panelAction.add(Box.createHorizontalGlue());
        panelAction.add(buttonCancel);
        panelAction.add(Box.createHorizontalStrut(10));

        JPanel panelFooter = new JPanel();
        panelFooter.setLayout(new BoxLayout(panelFooter, BoxLayout.PAGE_AXIS));
        panelFooter.add(Box.createVerticalStrut(10));
        panelFooter.add(new JSeparator(JSeparator.HORIZONTAL));
        panelFooter.add(Box.createVerticalStrut(10));
        panelFooter.add(panelAction);

        //super.getContentPane().add(Box.createVerticalStrut(10));
        super.getContentPane().add(panelFooter);
        super.getContentPane().add(Box.createVerticalStrut(10));

        super.getContentPane().add(Box.createVerticalGlue());

        super.pack();

    }

}
