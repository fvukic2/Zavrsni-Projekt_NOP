package controller;

/**
 * Sucelje koje sadrzi metode koje kasnije koristimo u menuBaru
 * @author Filip
 */
public interface AllCommands {

    /**
     * Metoda koji sluzi za rezanje teksta sa textArea
     */
    void cut();
    /**
     * Metoda koji sluzi za kopiranje teksta sa textArea
     */
    void copy();
    /**
     * Metoda koji sluzi za ljepljenje teksta sa textArea
     */
    void paste();
    /**
     * Metoda koji sluzi za oznacavanje teksta sa textArea
     */
    void selectAll();

}
