package com.marcos.gumballs.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import com.marcos.gumballs.constant.CommonConstant;
import com.marcos.gumballs.entity.Gumball;
import com.marcos.gumballs.util.RandomUtil;

public class ApplicationComponent extends JPanel implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3941884196692182439L;
    private Map<Gumball, Color> gumballs;
  
    
    public ApplicationComponent() {
        gumballs = new HashMap<>();
    }
    
    public void add(Gumball gumball) {
        int min = 0;
        int max = 255;
        Color color = new Color(RandomUtil.randomInt(min, max), RandomUtil.randomInt(min, max), RandomUtil.randomInt(min, max));
        gumballs.put(gumball, color);
    }
    
    @Override
    public void paintComponent(Graphics g) {
  
        Graphics2D graphic2d = (Graphics2D) g;
        for (Map.Entry<Gumball, Color> b : gumballs.entrySet()) {
            g.setColor(b.getValue());
            graphic2d.fill(b.getKey().getShape());
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(CommonConstant.DEFAULT_WIDTH, CommonConstant.DEFAULT_HEIGHT);
    }
}
