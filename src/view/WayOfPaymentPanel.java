package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Klasa kojom gradimo WayOfPaymentPanel
 * @author Filip
 */
public class WayOfPaymentPanel extends JPanel {

    /**
     * Objekt klase JComboBox koji sadrzi nacine placanja
     */
    private JComboBox<WayOfPaymentStrategy> wayOfPaymentCombo;

    /**
     * Konstruktor klase WayOfPaymentPanel
     * @param wayOfPaymentCombo
     */
    public WayOfPaymentPanel(JComboBox<WayOfPaymentStrategy> wayOfPaymentCombo) {
        this.wayOfPaymentCombo = wayOfPaymentCombo;
        setSizeOfWayOfPaymentPanel();
        setBorderOfWayOfPaymentPanel();
        layoutAllWayOfPaymentComponents();
    }

    /**
     * Metoda kojom postavljamo velicinu panela
     */
    private void setSizeOfWayOfPaymentPanel() {
        Dimension dimension = new Dimension();
        dimension.height = 160;
        dimension.width = 250;
        setPreferredSize(dimension);
    }

    /**
     * Metoda setBorder  postavlja obrub panela i njegovu udaljenost od ruba forme
     * inner je objekt koji se koristi za imenovanje border
     * outer je objekt koji definira udaljenost bordera od ruba
     */
    private void setBorderOfWayOfPaymentPanel(){
        Border innerBorder = BorderFactory.createTitledBorder("Way of payment");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    }

    /**
     * Metoda kojom rasporedujemo elemente na panel preko kordinata
     */
    private void layoutAllWayOfPaymentComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,0,20,0);

        //combo box
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose way of payment:"),gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(wayOfPaymentCombo,gbc);

    }

}
