package com.marcos.gumballs.util;

import java.util.Random;

public class RandomUtil {
    private RandomUtil() { }
    
    public static int randomInt(int min, int max) {
        return new Random().nextInt(max - min + 1); 
    }
}
