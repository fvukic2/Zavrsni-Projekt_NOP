package view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

/**
 * Klasa kojom postavljamo String poruku na nas wayOfPaymentComboBox
 * @author Filip
 */
public class DefaultPromptMsgRenderer extends BasicComboBoxRenderer {

    /**
     * Poruka koju prosljedujemo konstruktorom klase DefaultPromptMsgRenderer
     */
    private String msg;

    /**
     * Konstruktor klase DefaultPromptMsgRenderer
     */
    public DefaultPromptMsgRenderer(String msg){
        this.msg = msg;
    }

    /**
     * Metoda koja vraca komponentu koja je konfigurirana za prikaz navedene vrijednosti
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     * @return
     */
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value == null){
            setText(msg);
        }
        return this;
    }

}
