package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Shape {
    private Color color;
    private int x;
    private int y;
    private int shape;
    private int radius;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public int getShape() {
        return shape;
    }

    public Shape(Color color, int x, int y, int radius, int shape) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.shape = shape;
        this.radius = radius;
    }
}

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    public BufferedImage image; //the offscreen image
    private Graphics2D graphics; //the "tools" needed to draw in the image
    private String selectedColor;
    private int sides;

    private List<Shape> shapeList;

    public void setSides(int sides) {
        this.sides = sides;
    }

    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
        this.selectedColor = "BLACK";
        this.shapeList = new ArrayList<>();
        sides = 6;
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Color color = new Color(0, 0, 0, 255);
                if (selectedColor.equals("RANDOM")) {
                    color = new Color(Utils.GetRandomInt(255), Utils.GetRandomInt(255), Utils.GetRandomInt(255), Utils.GetRandomInt(200) + 50);
                    drawShape(e.getX(), e.getY(), color, sides, Utils.GetRandomInt(50));
                    repaint();
                } else if (selectedColor.equals("BLACK")) {
                    color = new Color(0, 0, 0, 255);
                    drawShape(e.getX(), e.getY(), color, sides, Utils.GetRandomInt(50));
                    repaint();
                } else if (selectedColor.equals("DELETE")) {
                    color = color.WHITE;
                    List<Shape> concurrentSafeList = new ArrayList<>(shapeList);
                    Iterator<Shape> shapeIterator = concurrentSafeList.iterator();
                    while(shapeIterator.hasNext()) {
                        Shape shape = shapeIterator.next();
                        if (Math.abs(e.getX() - shape.getX()) <= shape.getRadius() && Math.abs(e.getY() - shape.getY()) <= shape.getRadius()) {
                            concurrentSafeList.remove(shape);
                            break;
                        }
                    }
                    reset();
                    for (Shape shape:
                            concurrentSafeList
                         ) {
                        drawShape(shape.getX(),shape.getY(),shape.getColor(),shape.getShape(), shape.getRadius());
                    }
                    shapeList = concurrentSafeList;

                }

            }
        });
    }
    private void drawShape(int x, int y, Color color, int sides, int radius){
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
        this.shapeList.add(new Shape(color, x, y, radius, sides));
    }
    public void reset() {
        this.createOffscreenImage();
        this.update(this.graphics);
    }
    public void setColor(String color) {
        this.selectedColor = color;
    }
    public  void setShape(String shape) {
        if(shape.equals("Circle")) {
            this.sides = 5000;
            this.frame.configPanel.sidesField.setValue(5000);
        }
        else if(shape.equals("Triangle")) {
            this.sides = 3;
            this.frame.configPanel.sidesField.setValue(3);
        }
    }
    @Override
    public void update(Graphics g) {} //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
