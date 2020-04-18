package com.marcos.gumballs.entity;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import com.marcos.gumballs.constant.CommonConstant;
import com.marcos.gumballs.util.RandomUtil;

public class Gumball implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2676201199958413861L;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private double x = RandomUtil.randomInt(0, CommonConstant.DEFAULT_WIDTH);
    private double y = RandomUtil.randomInt(0, CommonConstant.DEFAULT_HEIGHT);
    private double dx = 1;
    private double dy = 1;
    
    public void move(Rectangle2D bounds) {

        x += dx;
        y += dy;

        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    public Ellipse2D getShape() {
       
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }

}
