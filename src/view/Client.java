package view;

import javax.swing.*;

/**
 * Aplikacija koja omogucava kupnju knjige
 * @author Filip
 */

public class Client {

    /**
     * Glavna metoda za pokretanje aplikacije
     * @param args
     */

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
