/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
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
import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

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
    private JPanel panelLevelEditor;

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
            JDialog dialogPlayLevel = new DialogPlayLevel(FrameMain.this, button.getText());
            dialogPlayLevel.setLocationRelativeTo(button);
            dialogPlayLevel.setVisible(true);
        }
    };

    private ActionListener createLevelActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //
            CardLayout cardLayout = (CardLayout) (FrameMain.this.getContentPane().getLayout());
            cardLayout.show(FrameMain.this.getContentPane(), panelLevelEditor.getClass().getSimpleName());
            //
            FrameMain.this.setTitle("New level");
            //
            menuItemCloseLevelEditor.setVisible(true);
        }
    };

    private ActionListener closelevelEditorActionListener = new ActionListener() {
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

    static {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }

    }

    public FrameMain() {

        //
        panelLevelEditor = new PanelLevelEditor();
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
        super.getContentPane().add(panelLevelEditor, panelLevelEditor.getClass().getSimpleName());

        super.setTitle("Lobby");
        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Menu 
        menuFile.setText("File");

        menuItemCreateLevel.setText("New level");
        menuItemCreateLevel.addActionListener(createLevelActionListener);
        menuFile.add(menuItemCreateLevel);

        menuItemCloseLevelEditor.setText("Close");
        menuItemCloseLevelEditor.addActionListener(closelevelEditorActionListener);
        menuItemCloseLevelEditor.setVisible(false);
        menuFile.add(menuItemCloseLevelEditor);

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

    /**
     *
     * @param event
     * @param parameters
     * @see JFrame#setVisible(boolean)
     */
    public void main(@Observes ContainerInitialized event, @Parameters List<String> parameters) {
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

}
