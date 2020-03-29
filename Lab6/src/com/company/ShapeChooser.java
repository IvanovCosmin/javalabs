package com.company;

import javax.swing.*;

public class ShapeChooser extends JPanel {
    final MainFrame mainFrame;
    JLabel shapePickerLabel;
    JComboBox shapePicker;

    public  ShapeChooser(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        shapePickerLabel = new JLabel("Pick a shape");
        String[] shapesList = {"Circle", "Triangle"};
        shapePicker = new JComboBox(shapesList);
        init();
    }
    private void init() {
        shapePicker.addItemListener(new ItemChangeListenerShape(mainFrame));
        add(shapePickerLabel);
        add(shapePicker);
    }
}
