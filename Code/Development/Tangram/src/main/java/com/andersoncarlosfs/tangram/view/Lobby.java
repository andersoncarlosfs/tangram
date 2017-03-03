/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.view;

import com.andersoncarlosfs.tangram.model.shapes.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class Lobby extends JFrame {

    private final static Dimension SizeButton = new Dimension(100, 100);

    private final static Dimension BoxFiller = new Dimension(10, 120);

    private final JMenuBar menuBar;
    private final JMenu menuFile;
    private final JMenu menuHelp;
    private final JMenuItem menuItemAbout;
    private final JMenuItem menuItemQuit;
    private final JButton buttonGoToLevel;
    private final JLabel labelLogo;

    private final ActionListener quitActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };

    static {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
            exception.printStackTrace();
        }

    }

    public Lobby() {
        labelLogo = new JLabel();
        buttonGoToLevel = new JButton();
        menuBar = new JMenuBar();
        menuFile = new JMenu();
        menuItemQuit = new JMenuItem();
        menuHelp = new JMenu();
        menuItemAbout = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lobby");
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));

        labelLogo.setText("Logo");

        buttonGoToLevel.setText("Go to level");
        buttonGoToLevel.setMinimumSize(SizeButton);
        buttonGoToLevel.setPreferredSize(SizeButton);
        buttonGoToLevel.setMaximumSize(SizeButton);
        buttonGoToLevel.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonGoToLevel.setVerticalTextPosition(AbstractButton.BOTTOM);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.LINE_AXIS));
        headerPanel.add(Box.createHorizontalGlue());
        headerPanel.add(labelLogo);
        headerPanel.add(new Box.Filler(BoxFiller, BoxFiller, BoxFiller));
        headerPanel.add(buttonGoToLevel);
        headerPanel.add(Box.createHorizontalGlue());

        add(headerPanel, BorderLayout.NORTH);

        menuFile.setText("File");

        menuItemQuit.setText("Quit");
        menuItemQuit.addActionListener(quitActionListener);
        menuFile.add(menuItemQuit);

        menuBar.add(menuFile);

        menuHelp.setText("Help");

        menuItemAbout.setText("About");
        menuHelp.add(menuItemAbout);

        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        pack();
    }

    /**
     *
     * @param event
     * @param parameters
     * @see JFrame#setVisible(boolean)
     */
    public void setVisible(@Observes ContainerInitialized event, @Parameters List<String> parameters) {
        super.setVisible(true);
    }

}
