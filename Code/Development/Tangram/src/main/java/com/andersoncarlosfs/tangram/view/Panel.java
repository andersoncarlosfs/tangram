/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public class Panel extends JPanel {

    //
    protected JPanel headerPanel;
    protected JPanel bodyPanel;

    public Panel() {

        super();

        headerPanel = new JPanel();
        bodyPanel = new JPanel();

        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        super.add(Box.createVerticalStrut(10));
        super.add(headerPanel);
        super.add(Box.createVerticalStrut(10));
        super.add(bodyPanel);
        super.add(Box.createVerticalStrut(10));

    }

}
