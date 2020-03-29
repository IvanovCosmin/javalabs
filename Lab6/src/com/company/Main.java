package com.company;

import javax.imageio.ImageIO;
import javax.rmi.CORBA.Util;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

class Utils {
    static int GetRandomInt(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }
}


public class Main {

    public static void main(String[] args) {
	    MainFrame mainFrame = new MainFrame();
        DrawingPanel drawingPanel = new DrawingPanel(mainFrame);
    }
}
