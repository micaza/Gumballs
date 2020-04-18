package com.marcos.gumballs;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.marcos.gumballs.frame.ApplicationFrame;

public class Application {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ApplicationFrame();
            frame.setTitle("Gumballs!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}
