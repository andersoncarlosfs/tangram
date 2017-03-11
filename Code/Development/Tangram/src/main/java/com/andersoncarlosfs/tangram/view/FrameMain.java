/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.enterprise.context.ApplicationScoped;
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

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
@ApplicationScoped
public class FrameMain extends JFrame {

    //
    private JMenuBar menuBar;
    //
    private JMenu menuFile;
    private JMenu menuHelp;
    //
    private JMenuItem menuItemAbout;
    private JMenuItem menuItemCreateLevel;
    private JMenuItem menuItemCloseLevelEditor;
    private JMenuItem menuItemQuit;
    //
    private JPanel panelLobby;
    private JPanel panelEditorLevel;

    private ActionListener actionListenerQuitApplication = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };

    private ActionListener actionListenerCreateLevel = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //
            CardLayout cardLayout = (CardLayout) (FrameMain.this.getContentPane().getLayout());
            cardLayout.show(FrameMain.this.getContentPane(), panelEditorLevel.getClass().getSimpleName());
            //
            FrameMain.this.setTitle("New level");
            //
            menuItemCloseLevelEditor.setVisible(true);
        }
    };

    private ActionListener actionListenerCloseLevelEditor = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //
            CardLayout cardLayout = (CardLayout) (FrameMain.this.getContentPane().getLayout());
            cardLayout.show(FrameMain.this.getContentPane(), panelLobby.getClass().getSimpleName());
            //
            FrameMain.this.setTitle("New level");
            //
            menuItemCloseLevelEditor.setVisible(false);
        }
    };

    public FrameMain() {

        //
        panelEditorLevel = new PanelEditorLevel();
        panelLobby = new PanelLobby();
        menuBar = new JMenuBar();
        menuFile = new JMenu();
        menuItemCreateLevel = new JMenuItem();
        menuItemCloseLevelEditor = new JMenuItem();
        menuItemQuit = new JMenuItem();
        menuHelp = new JMenu();
        menuItemAbout = new JMenuItem();

        //
        super.getContentPane().setLayout(new CardLayout());
        super.getContentPane().add(panelLobby, panelLobby.getClass().getSimpleName());
        super.getContentPane().add(panelEditorLevel, panelEditorLevel.getClass().getSimpleName());

        super.setTitle("Lobby");
        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Menu 
        menuFile.setText("File");

        menuItemCreateLevel.setText("New level");
        menuItemCreateLevel.addActionListener(actionListenerCreateLevel);
        menuFile.add(menuItemCreateLevel);

        menuItemCloseLevelEditor.setText("Close");
        menuItemCloseLevelEditor.addActionListener(actionListenerCloseLevelEditor);
        menuItemCloseLevelEditor.setVisible(false);
        menuFile.add(menuItemCloseLevelEditor);

        menuItemQuit.setText("Quit");
        menuItemQuit.addActionListener(actionListenerQuitApplication);
        menuFile.add(menuItemQuit);

        menuBar.add(menuFile);

        menuHelp.setText("Help");

        menuItemAbout.setText("About");
        menuHelp.add(menuItemAbout);

        menuBar.add(menuHelp);

        super.setJMenuBar(menuBar);

        super.pack();

        super.setLocationRelativeTo(null);

    }

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });

    }

}
