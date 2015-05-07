package com.company;

/**
 * Created by ZhdankiFam on 01.05.2015.
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        ViewCalculatior cal = new ViewCalculatior(model);
        cal.duildGUI();
    }
}
