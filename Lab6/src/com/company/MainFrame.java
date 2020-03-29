package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    ShapeChooser shapeChooser;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        shapeChooser = new ShapeChooser(this);
 //...TODO
        setLayout(new BorderLayout());
        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        this.configPanel.add(shapeChooser, BorderLayout.EAST);
        add(configPanel, BorderLayout.NORTH); //this is BorderLayout.CENTER
        add(controlPanel, BorderLayout.SOUTH); //this is BorderLayout.CENTER

// ...TODO

        //invoke the layout manager
        setVisible(true);
        pack(); // shit
    }
}
