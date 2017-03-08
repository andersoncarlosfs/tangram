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
public class DialogLeaveLevel extends Dialog {

    //
    private final ActionListener yesActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Leave");
        }
    };

    public DialogLeaveLevel(Frame owner, String level) {

        super(owner, "Leave level", "Do you want leave level " + level + "?");
      
        //Footer
        buttonDoAction.addActionListener(yesActionListener);

        buttonCancelAction.addActionListener(cancelAction);

    }

}
