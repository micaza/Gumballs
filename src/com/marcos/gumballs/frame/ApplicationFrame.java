package com.marcos.gumballs.frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.marcos.gumballs.component.ApplicationComponent;
import com.marcos.gumballs.entity.Gumball;
import com.marcos.gumballs.runable.ApplicationRunnable;

public class ApplicationFrame extends JFrame implements Serializable{
    
    /**
     * Application frame. This is where balls get added and where the buttons get set
     */
    private static final long serialVersionUID = -4851478998548382166L;
    private ApplicationComponent gumballComponent;

    public ApplicationFrame() {
        gumballComponent = new ApplicationComponent();
        add(gumballComponent, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Create Gumball!", e -> addGumball());
        addButton(buttonPanel, "Exit", e -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
    /**
     * Add a thread for each individual gumball
     */
    public void addGumball() {
        Gumball gumball = new Gumball();
        gumballComponent.add(gumball);
        Runnable runnable = new ApplicationRunnable(gumball, gumballComponent);
        Thread thread = new Thread(runnable);
        thread.start();
    }
    /**
     * Add a button to the UI frame
     * @param container
     * @param title
     * @param listener
     */
    public void addButton(Container container, String title, ActionListener listener) {
        JButton button = new JButton(title);
        container.add(button);
        button.addActionListener(listener);
    }   

}
