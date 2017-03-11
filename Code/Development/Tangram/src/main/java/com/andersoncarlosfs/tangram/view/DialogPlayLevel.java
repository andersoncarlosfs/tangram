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

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
@RequestScoped
public class DialogPlayLevel extends Dialog {

    //
    private final ActionListener actionListenerPlayLevel = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Play");
        }
    };

    public DialogPlayLevel(Frame owner, String level) {

        super(owner, "Play level", "Do you want play level " + level + "?");

        //Footer        
        buttonDo.addActionListener(actionListenerPlayLevel);

        buttonCancel.addActionListener(actionListenerCancel);

    }

}
