package view;

import model.OrderDetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa iz koje gettersima dohvacamo vrijednosti nasih polja
 * @author Filip
 */
public class DataFields extends JPanel {

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
     * Objekt klase JList u koji spremamo kategorije bookshopa
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
     * Objekt klase JComboBox u koji spremamo sve nacine placanja
     */
    private JComboBox<WayOfPaymentStrategy> wayOfPaymentCombo;
    /**
     * Sucelje koje prati promjene koje su nastale uslijed nekog događaja na FormPanelima
     */
    private OrderDetailsFormListener orderDetailsFormListener;

    /**
     * Objekt klase OrderDetail
     */
    private OrderDetail orderDetail;

    /**
     * Konstruktor klase DataFields
     */
    public DataFields() {
        createComponents();
        activeDataFields();

    }

    /**
     * Metoda kojom inicijaliziramo objekte klase DataFields
     */
    public void createComponents(){
        customerName = new JTextField(10);
        lastName = new JTextField(10);
        address = new JTextField(10);
        email = new JTextField(10);

        wayOfPaymentCombo = new JComboBox<WayOfPaymentStrategy>();
        DefaultComboBoxModel<WayOfPaymentStrategy> wayOfPaymentComboModel = new DefaultComboBoxModel<>();
        wayOfPaymentComboModel.addElement(new CreditCardPaymentStrategy());
        wayOfPaymentComboModel.addElement(new GooglePayPaymentStrategy());
        wayOfPaymentComboModel.addElement(new PayPalPaymentStrategy());
        wayOfPaymentCombo.setModel(wayOfPaymentComboModel);
        wayOfPaymentCombo.setSelectedIndex(0);
        wayOfPaymentCombo.setRenderer((new DefaultPromptMsgRenderer("Choose way of payment")));
        wayOfPaymentCombo.setSelectedIndex(-1);

        booksInShop = new JList<>();
        coverOfBooks = new JComboBox<>();
        houseDelivery = new JCheckBox("House delivery");
        apartmentDelivery = new JCheckBox("Apartment delivery");
        officeDelivery = new JCheckBox("Office delivery ");
        normalDelivery = new JRadioButton("Normal delivery");
        expressDelivery = new JRadioButton("Express delivery");
        submitButton = new JButton("Submit");

        // Adding checkBoxItems to group
        checkboxGroup = new ButtonGroup();
        checkboxGroup.add(houseDelivery);
        checkboxGroup.add(apartmentDelivery);
        checkboxGroup.add(officeDelivery);
        houseDelivery.setActionCommand("House delivery");
        apartmentDelivery.setActionCommand("Apartment delivery");
        officeDelivery.setActionCommand("Office delivery");

        // Adding buttons to group
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(normalDelivery);
        radioButtonGroup.add(expressDelivery);
        normalDelivery.setActionCommand("Normal delivery");
        expressDelivery.setActionCommand("Express delivery");

        // Creating list and adding list items
        DefaultListModel<String> listOfBooks = new DefaultListModel<>();
        listOfBooks.add(0,"In Search of Lost Time by Marcel Proust");
        listOfBooks.add(1,"Ulysses by James Joyce");
        listOfBooks.add(2,"Don Quixote by Miguel de Cervantes");
        listOfBooks.add(3,"One Hundred Years of Solitude by Gabriel Garcia Marquez");
        listOfBooks.add(4,"The Great Gatsby by F. Scott Fitzgerald");
        listOfBooks.add(5,"War and Peace by Leo Tolstoy");
        listOfBooks.add(6,"Hamlet by William Shakespeare");
        booksInShop.setModel(listOfBooks);
        booksInShop.setBorder(BorderFactory.createEtchedBorder());
        booksInShop.setVisibleRowCount(3);
        booksInShop.setSelectedIndex(0);
        Dimension dimension = booksInShop.getPreferredSize();
        dimension.width = 100;
        booksInShop.setPreferredSize(dimension);

        //Creating comboBox and adding comboBox elements
        DefaultComboBoxModel<String> typeOfBookCover = new DefaultComboBoxModel<>();
        typeOfBookCover.addElement("Softcover");
        typeOfBookCover.addElement("Hardcover with ImageWrap");
        typeOfBookCover.addElement(" Hardcover with Dust Jacket");
        coverOfBooks.setModel(typeOfBookCover);
        coverOfBooks.setSelectedIndex(0);

        //submitButton = new JButton("Submit data");
        /*submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllData();
            }
        });*/
    }

    private void activeDataFields(){
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (orderDetailsFormListener != null){
                    orderDetail = new OrderDetail(customerName.getText(),lastName.getText(),address.getText(),email.getText(),booksInShop.getSelectedValue(), (String) coverOfBooks.getSelectedItem(),checkboxGroup.getSelection().getActionCommand(),radioButtonGroup.getSelection().getActionCommand(),wayOfPaymentCombo.getSelectedItem().toString());
                    OrderDetailEvent ordEv = new OrderDetailEvent(DataFields.this,orderDetail);
                    orderDetailsFormListener.orderDetailsEventOccurred(ordEv);
                    //Promini
                    //orderDetail.info();

                }
                resetAllData();
            }
        });
    }

    /**
     * Metoda koja prima formlistener
     * Ovom metodom dodajemo formListener na form panele i pratimo da li dogodio dogadaj
     * Ova metoda takoder dohvaca String vrijednost masih Swing komponenti
     */
    public void getAllData(){
        /*String cstName = customerName.getText();
        String cstLastName = lastName.getText();
        String cstAddress = address.getText();
        String cstEmail = email.getText();
        String bksInShp = booksInShop.getSelectedValue();
        String typeOfBkCvr = (String) coverOfBooks.getSelectedItem();
        String placeOfDel = checkboxGroup.getSelection().getActionCommand();
        String del = radioButtonGroup.getSelection().getActionCommand();
        WayOfPaymentStrategy wayOfPaymentStrategy = (WayOfPaymentStrategy) wayOfPaymentCombo.getSelectedItem();
        String res = wayOfPaymentCombo.getSelectedItem().toString();*/

        /*if (orderDetailsFormListener != null){
            orderDetail = new OrderDetail(customerName.getText(),lastName.getText(),address.getText(),email.getText(),booksInShop.getSelectedValue(), (String) coverOfBooks.getSelectedItem(),checkboxGroup.getSelection().getActionCommand(),radioButtonGroup.getSelection().getActionCommand(),wayOfPaymentCombo.getSelectedItem().toString());
            OrderDetailEvent ordEv = new OrderDetailEvent(DataFields.this,orderDetail);
            orderDetailsFormListener.orderDetailsEventOccurred(ordEv);
            //Promini
            //orderDetail.info();

        }
        resetAllData();*/
    }

    /**
     * Metoda kojom reseteriamo sva polja na defaultne vrijednosti
     */
    public void resetAllData(){
        customerName.setText("");
        lastName.setText("");
        address.setText("");
        email.setText("");
        booksInShop.setSelectedIndex(0);
        coverOfBooks.setSelectedIndex(0);
        normalDelivery.setSelected(true);
        houseDelivery.setSelected(true);
        wayOfPaymentCombo.setSelectedIndex(-1);
    }

    /**
     * Getters za customerNameField
     * @return customerName
     */
    public JTextField getCustomerName() {
        return customerName;
    }

    /**
     * Getters za lastNameField
     * @return lastName
     */
    public JTextField getLastName() {
        return lastName;
    }

    /**
     * Getters za addressField
     * @return address
     */
    public JTextField getAddress() {
        return address;
    }

    /**
     * Getters za emailField
     * @return email
     */
    public JTextField getEmail() {
        return email;
    }

    /**
     * Getters za booksInShop
     * @return booksInShop
     */
    public JList<String> getBooksInShop() {
        return booksInShop;
    }

    /**
     * Getters za coverOFBooks
     * @return coverOfBooks
     */
    public JComboBox<String> getCoverOfBooks() {
        return coverOfBooks;
    }

    /**
     * Getters za houseDelivery
     * @return houseDelivery
     */
    public JCheckBox getHouseDelivery() {
        return houseDelivery;
    }

    /**
     * Getters za apartmentDelivery
     * @return apartmentDelivery
     */
    public JCheckBox getApartmentDelivery() {
        return apartmentDelivery;
    }

    /**
     * Getters za officeDelivery
     * @return officeDelivery
     */
    public JCheckBox getOfficeDelivery() {
        return officeDelivery;
    }

    /**
     * Getters za normalDelivery
     * @return normalDelivery
     */
    public JRadioButton getNormalDelivery() {
        return normalDelivery;
    }

    /**
     * Getters za expressDelivery
     * @return expressDelivery
     */
    public JRadioButton getExpressDelivery() {
        return expressDelivery;
    }

    /**
     * Getters za submitButton
     * @return submitButton
     */
    public JButton getSubmitButton() {
        return submitButton;
    }

    /**
     * Getters za checkboxGroup
     * @return checkboxGroup
     */
    public ButtonGroup getCheckboxGroup() {
        return checkboxGroup;
    }

    /**
     * Getters za redioButtonGroup
     * @return radioButtonGroup
     */
    public ButtonGroup getRadioButtonGroup() {
        return radioButtonGroup;
    }

    /**
     * Getters za wayOfPaymentCombo
     * @return wayOfPaymentCombo
     */
    public JComboBox<WayOfPaymentStrategy> getWayOfPaymentCombo() {
        return wayOfPaymentCombo;
    }

    /**
     * Getters za orderDetails
     * @return orderDetail
     */
    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    /**
     * Metoda koja prima ordList
     * Ovom metodom dodajemo formListener na form panele
     * @param ordList
     */
    public void setOrderDetailsFormListener(OrderDetailsFormListener ordList) {
        this.orderDetailsFormListener = ordList;
    }

}
