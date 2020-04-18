package com.marcos.gumballs.runable;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.marcos.gumballs.constant.CommonConstant;
import com.marcos.gumballs.entity.Gumball;

public class ApplicationRunnable implements Runnable {

    private Gumball bubble;
    private Component component;

    private static final Logger LOGGER = Logger.getLogger(ApplicationRunnable.class.getName());
    
    public ApplicationRunnable(Gumball bubble, Component component) {
        this.component = component;
        this.bubble = bubble;
    }
    
    @Override
    public void run() {
        boolean allowBubbles = true;
        while (allowBubbles) {
        try {
            bubble.move(component.getBounds());
            component.repaint();
            Thread.sleep(CommonConstant.DELAY);
        } catch (InterruptedException e) { 
            allowBubbles = false;
            LOGGER.log(Level.WARNING, "Interrupted!", e);
            Thread.currentThread().interrupt();
        }
        }
    }

}
