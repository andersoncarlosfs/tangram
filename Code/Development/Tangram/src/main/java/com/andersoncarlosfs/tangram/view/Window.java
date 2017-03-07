/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import com.andersoncarlosfs.tangram.model.shapes.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
@ApplicationScoped
public class Window extends JFrame {

    //
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuHelp;
    private JMenuItem menuItemAbout;
    private JMenuItem menuItemCreateLevel;
    private JMenuItem menuItemQuit;
    private JButton buttonGoToLevel;
    private JPanel panelLogo;

    private ActionListener quitActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };

    private ActionListener playLevelActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            JDialog dialogPlayLevel = new DialogPlayLevel(Window.this, button.getText());
            dialogPlayLevel.setLocationRelativeTo(button);
            dialogPlayLevel.setVisible(true);
        }
    };

    private ActionListener createLevelActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Create");
        }
    };

    static {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }

    }

    public Window() {

        panelLogo = new JPanel();
        buttonGoToLevel = new JButton();
        menuBar = new JMenuBar();
        menuFile = new JMenu();
        menuItemCreateLevel = new JMenuItem();
        menuItemQuit = new JMenuItem();
        menuHelp = new JMenu();
        menuItemAbout = new JMenuItem();

        super.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        super.setTitle("Lobby");
        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Header
        TitledBorder titledBorderLogo;
        titledBorderLogo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK));
        titledBorderLogo.setTitle("Image logo");
        titledBorderLogo.setTitleJustification(TitledBorder.CENTER);
        panelLogo.setMinimumSize(new Dimension(400, 100));
        panelLogo.setPreferredSize(new Dimension(600, 200));
        panelLogo.setMaximumSize(new Dimension(Short.MAX_VALUE, 250));
        panelLogo.setBorder(titledBorderLogo);

        buttonGoToLevel.setText("Go to level");
        buttonGoToLevel.setPreferredSize(new Dimension(200, 200));
        buttonGoToLevel.setMaximumSize(new Dimension(250, 250));
        buttonGoToLevel.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonGoToLevel.setVerticalTextPosition(AbstractButton.BOTTOM);
        buttonGoToLevel.addActionListener(playLevelActionListener);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.LINE_AXIS));
        headerPanel.add(Box.createHorizontalGlue());
        headerPanel.add(Box.createHorizontalStrut(10));
        headerPanel.add(panelLogo);
        headerPanel.add(Box.createHorizontalStrut(10));
        headerPanel.add(buttonGoToLevel);
        headerPanel.add(Box.createHorizontalStrut(10));
        headerPanel.add(Box.createHorizontalGlue());

        super.getContentPane().add(Box.createVerticalStrut(10));
        super.getContentPane().add(headerPanel);

        //Body
        JPanel bodyPanel = new JPanel();
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
            bodyPanel.add(Box.createVerticalStrut(10));
        }

        super.getContentPane().add(Box.createVerticalStrut(10));
        super.getContentPane().add(bodyPanel);

        super.getContentPane().add(Box.createVerticalGlue());

        //Menu 
        menuFile.setText("File");

        menuItemCreateLevel.setText("New level");
        menuItemCreateLevel.addActionListener(createLevelActionListener);
        menuFile.add(menuItemCreateLevel);

        menuItemQuit.setText("Quit");
        menuItemQuit.addActionListener(quitActionListener);
        menuFile.add(menuItemQuit);

        menuBar.add(menuFile);

        menuHelp.setText("Help");

        menuItemAbout.setText("About");
        menuHelp.add(menuItemAbout);

        menuBar.add(menuHelp);

        super.setJMenuBar(menuBar);

        super.pack();

    }

}
