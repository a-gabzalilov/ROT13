package com.company;

public  class Rot {

    private static final int rotation = 13;

    static void ROT(byte[] inputline)
    {
        for (int i = 0; i < inputline.length; i++) {
            if       (inputline[i] >= 'a' && inputline[i] <= 'm') inputline[i] += rotation;
            else if  (inputline[i] >= 'A' && inputline[i] <= 'M') inputline[i] += rotation;
            else if  (inputline[i] >= 'n' && inputline[i] <= 'z') inputline[i] -= rotation;
            else if  (inputline[i] >= 'N' && inputline[i] <= 'Z') inputline[i] -= rotation;
        }
    }
}