package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private JButton saveBtn = new JButton("Save");
    private JButton loadBtn = new JButton("Load");
    private JButton resetBtn = new JButton("Reset");
    private JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //add all buttons
        add(saveBtn);
        add(loadBtn);
        add(exitBtn);
        add(resetBtn);

 //...TODO

//        this.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                drawShape(e.getX(), e.getY()); repaint();
//            } //Can’t use lambdas, JavaFX does a better job in these cases
//        });

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        //...TODO
    }
    private void load(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int errorCode = fileChooser.showOpenDialog(null);
            if(errorCode == JFileChooser.APPROVE_OPTION) {
                this.frame.canvas.image = ImageIO.read(fileChooser.getSelectedFile());
            }

        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e) {
        this.frame.canvas.reset();
    }
    private void exit(ActionEvent e) {
        System.exit(0);
    }
    private void save(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("PNG file", "PNG"));
            fileChooser.setFileFilter(new FileNameExtensionFilter("JPG file", "JPG"));
            int errorCode = fileChooser.showSaveDialog(null);
            if(errorCode == JFileChooser.APPROVE_OPTION) {
                String fileFormat = "PNG";
                if(fileChooser.getSelectedFile().getAbsolutePath().endsWith("JPG"))
                {
                    // daca avem extensia JPG salvam fisierul ca JPG
                    fileFormat = "JPG";
                }
                ImageIO.write(frame.canvas.image, fileFormat,
                        new FileOutputStream(fileChooser.getSelectedFile()));
            }
        } catch (IOException ex) { System.err.println(ex); }
    }
 //...TODO
}
