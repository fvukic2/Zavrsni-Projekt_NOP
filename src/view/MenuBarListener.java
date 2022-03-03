package view;

/**
 * Sucelje koji sadrzi metode koje nas MenuBar implementira
 * @author Filip
 */
public interface MenuBarListener {

    /**
     * Metoda kojom citamo objekt
     * @param content
     */
    void readObjectTooPanel(String content);

    /**
     * Metoda kojom spremamo objekt
     * @return
     */
    String saveObjectTooFile();

}
