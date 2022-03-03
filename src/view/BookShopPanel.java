package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Klasa kojom gradimo BookShopPanel
 * @author Filip
 */
public class BookShopPanel extends JPanel {

    /**
     * Objekt klase JList u koji spremamo kategorije BookShopPanel
     */
    private JList<String> booksInShop;
    /**
     * Objekt klase JComboBox u koji spremamo kategorije formata knjige
     */
    private JComboBox<String> coverOfBooks;
    /**
     * Objekte klase JChekBox koji predstavlja String houseDelivery
     */
    private JCheckBox houseDelivery;
    /**
     * Objekte klase JChekBox koji predstavlja String apartmentDelivery
     */
    private JCheckBox apartmentDelivery;
    /**
     * Objekte klase JChekBox koji predstavlja String officeDelivery
     */
    private JCheckBox officeDelivery;
    /**
     * Objekt klase JRadioButton koji predstavlja String normalDelivery
     */
    private JRadioButton normalDelivery;
    /**
     * Objekt klase JRadioButton koji predstavlja String expressDelivery
     */
    private JRadioButton expressDelivery;
    /**
     * Aktivira se kad saljemo podatke
     */
    private JButton submitButton;
    /**
     * Objekte klase ButtonGroup kojim grupiram checkboxe u grupu tako da samo jedan moze bit pritisnut
     */
    private ButtonGroup checkboxGroup;
    /**
     * Objekte klase ButtonGroup kojim grupiram radio buttons u grupu tako da samo jedan moze bit pritisnut
     */
    private ButtonGroup radioButtonGroup;

    /**
     * Konstruktor klase BookShoPanel kojim inicijaliziramo polja panela
     * Potrebna nam je inicijalizacija na ovaj nacin jer sve podatke saljemo na textArea klikom na jedan gumb
     * @param booksInShop
     * @param coverOfBooks
     * @param houseDelivery
     * @param apartmentDelivery
     * @param officeDelivery
     * @param normalDelivery
     * @param expressDelivery
     * @param submitButton
     * @param checkboxGroup
     * @param radioButtonGroup
     */
    public BookShopPanel(JList<String> booksInShop, JComboBox<String> coverOfBooks, JCheckBox houseDelivery, JCheckBox apartmentDelivery, JCheckBox officeDelivery, JRadioButton normalDelivery, JRadioButton expressDelivery, JButton submitButton, ButtonGroup checkboxGroup, ButtonGroup radioButtonGroup) {
        this.booksInShop = booksInShop;
        this.coverOfBooks = coverOfBooks;
        this.houseDelivery = houseDelivery;
        this.apartmentDelivery = apartmentDelivery;
        this.officeDelivery = officeDelivery;
        this.normalDelivery = normalDelivery;
        this.expressDelivery = expressDelivery;
        this.submitButton = submitButton;
        this.checkboxGroup = checkboxGroup;
        this.radioButtonGroup = radioButtonGroup;
        setSizeOfBookShopPanel();
        setBorderOfBookShopPanel();
        layoutAllBookShopComponents();
    }

    /**
     * Metoda kojom definiramo velicinu panela
     */
    private void setSizeOfBookShopPanel(){
        Dimension dimension = new Dimension();
        dimension.width = 700;
        dimension.height = 250;
        setPreferredSize(dimension);
    }

    /**
     * Metoda setBorderOfBookShopPanel postavlja obrub panela i njegovu udaljenost od ruba forme
     * inner je objekt koji se koristi za imenovanje border
     * outer je objekt koji definira udaljenost bordera od ruba
     */
    private void setBorderOfBookShopPanel(){
        Border innerBorder = BorderFactory.createTitledBorder("Bookshop");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);

        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    }

    /**
     * Metoda kojom rasporedujemo elemente na panel preko kordinata
     */
    private void layoutAllBookShopComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,20,6,50);

        //BooksInShop List
        //First Column
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(new JLabel("List of books in shop:"),gbc);

        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JScrollPane(booksInShop,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),gbc);

        //CoverOfBooks ComboBox
        //Second Column
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose cover of book:"),gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(coverOfBooks,gbc);

        //JCheckBoxes
        //Third Column
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose delivery place"),gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(houseDelivery,gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(apartmentDelivery,gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(officeDelivery,gbc);

        //JRadioButtons
        //Forth Column
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose way of delivery:"),gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(normalDelivery,gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(expressDelivery,gbc);

        //SubmitButton
        //Fifth Column
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        add(submitButton,gbc);

    }
}
