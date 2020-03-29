package com.company;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemChangeListenerColor implements ItemListener {
    MainFrame frame;

    ItemChangeListenerColor(MainFrame frame) {
        this.frame = frame;
    }
    @Override
    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            Object item = event.getItem();
            this.frame.canvas.setColor((String)(item));
        }
    }
}

