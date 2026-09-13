package System;

import System.presentation.view.View;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        JFrame gui = new JFrame("...");
        gui.setSize(800,600);
        gui.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        gui.setVisible(true);
    }
}
