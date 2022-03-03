package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Klasa kojom gradimo CustomerInformationPanel i u kojoj su smjesteni osobni podaci korisnika
 * @author Filip
 */
public class CustomerInformationPanel extends JPanel {

    /**
     * Objekt klase JTextField u koji spremamo ime osobe
     */
    private JTextField customerName;
    /**
     * Objekt klase JTextField u koji spremamo ime prezime osobe
     */
    private JTextField lastName;
    /**
     * Objekt klase JTextField u koji spremamo adresu osobe
     */
    private JTextField address;
    /**
     * Objekt klase JTextField u koji spremamo email osobe
     */
    private JTextField email;

    /**
     * Konstruktor klase CustomerInformationPanel kojim inicijaliziramo polja panela
     * Potrebna nam je inicijalizacija na ovaj nacin jer sve podatke saljemo na textArea klikom na jedan gumb
     * @param customerName
     * @param lastName
     * @param address
     * @param email
     */
    public CustomerInformationPanel(JTextField customerName, JTextField lastName, JTextField address, JTextField email) {
        this.customerName = customerName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        setSizeOfCustomerInformationPanel();
        setBorderOfCustomerInformationPanel();
        layoutAllCustomerInformationComponents();
    }

    /**
     * Metoda setSizeOfCustomerInformationPanel postavlja dimenzije panela
     * dimension je objekt koji definira dimenziju panela
     */
    private void setSizeOfCustomerInformationPanel(){
        Dimension dimension = new Dimension();
        dimension.width = 250;
        dimension.height = 250;
        setPreferredSize(dimension);
    }

    /**
     * Metoda koja odreduje obrub panela , njegov naslov i udaljenost od rubova forme
     */
    private void setBorderOfCustomerInformationPanel(){

        Border innerBorder = BorderFactory.createTitledBorder("Customer information");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);

        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    }

    /**
     * Metoda kojom se elemnti rasporeduju na panelu preko kordinata
     */
    private void layoutAllCustomerInformationComponents(){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,15,0);

        //customerName field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Customer name:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(customerName,gbc);

        //lastName field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Last name:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(lastName,gbc);

        //address field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Address:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(address,gbc);

        //email field
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Email:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(email,gbc);

    }
}
