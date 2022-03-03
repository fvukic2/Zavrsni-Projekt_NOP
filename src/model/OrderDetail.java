package model;

import view.WayOfPaymentStrategy;

import java.io.Serializable;

/**
 * Klasa u kojoj se spremaju svi podaci koji se kasnije ispisuju
 * @author Filip
 */
public class OrderDetail implements Serializable {

    /**
     * Varijabla u koju spremamo id
     */
    private int id;
    /**
     * Varijabla u koju spremamo counter
     */
    private static int counter = 1;
    /**
     * Varijable u koju se sprema name
     */
    private String cstName;
    /**
     * Varijable u koju se sprema lastName
     */
    private String cstLastName;
    /**
     * Varijable u koju se sprema address
     */
    private String cstAddress;
    /**
     * Varijable u koju se sprema email
     */
    private String cstEmail;
    /**
     * Varijable u koju se sprema bookInShopName
     */
    private String bookInShopName;
    /**
     * Varijable u koju se sprema typeOfBookCover
     */
    private String typeOfBookCover;
    /**
     * Varijable u koju se sprema placeOfDelivery
     */
    private String placeOfDelivery;
    /**
     * Varijable u koju se sprema deliveryType
     */
    private String deliveryType;
    /**
     * Varijable u koju se sprema wayOfPaymentStrategy
     */
    private WayOfPaymentStrategy wayOfPaymentStrategy;
    /**
     * Varijable u koju se sprema paymentStrategy
     */
    private String paymentStrategy;

    /**
     * Konstruktor klase OrderDetail
     */
    public OrderDetail() {
    }

    /**
     * Konstruktor klase OrderDetail
     * @param cstName
     * @param cstLastName
     * @param cstAddress
     * @param cstEmail
     * @param bookInShopName
     * @param typeOfBookCover
     * @param placeOfDelivery
     * @param deliveryType
     * @param paymentStrategy
     */
    public OrderDetail(String cstName, String cstLastName, String cstAddress, String cstEmail, String bookInShopName, String typeOfBookCover, String placeOfDelivery, String deliveryType, String paymentStrategy) {
        this.id = counter;
        counter++;
        this.cstName = cstName;
        this.cstLastName = cstLastName;
        this.cstAddress = cstAddress;
        this.cstEmail = cstEmail;
        this.bookInShopName = bookInShopName;
        this.typeOfBookCover = typeOfBookCover;
        this.placeOfDelivery = placeOfDelivery;
        this.deliveryType = deliveryType;
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Konstruktor klase OrderDetail
     * @param id
     * @param cstName
     * @param cstLastName
     * @param cstAddress
     * @param cstEmail
     * @param bookInShopName
     * @param typeOfBookCover
     * @param placeOfDelivery
     * @param deliveryType
     * @param paymentStrategy
     */
    public OrderDetail(int id, String cstName, String cstLastName, String cstAddress, String cstEmail, String bookInShopName, String typeOfBookCover, String placeOfDelivery, String deliveryType, String paymentStrategy) {
        this.id = id;
        this.cstName = cstName;
        this.cstLastName = cstLastName;
        this.cstAddress = cstAddress;
        this.cstEmail = cstEmail;
        this.bookInShopName = bookInShopName;
        this.typeOfBookCover = typeOfBookCover;
        this.placeOfDelivery = placeOfDelivery;
        this.deliveryType = deliveryType;
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Getter za name
     * @return cstName
     */
    public String getCstName() {
        return cstName;
    }

    /**
     * Setter za name
     * @param cstName
     */
    public void setCstName(String cstName) {
        this.cstName = cstName;
    }

    /**
     * Getter za lastName
     * @return cstLastName
     */
    public String getCstLastName() {
        return cstLastName;
    }

    /**
     * Setter za lastName
     * @param cstLastName
     */
    public void setCstLastName(String cstLastName) {
        this.cstLastName = cstLastName;
    }

    /**
     * Getter za address
     * @return cstAddress
     */
    public String getCstAddress() {
        return cstAddress;
    }

    /**
     * Setter za address
     * @param cstAddress
     */
    public void setCstAddress(String cstAddress) {
        this.cstAddress = cstAddress;
    }

    /**
     * Getter za email
     * @return cstEmail
     */
    public String getCstEmail() {
        return cstEmail;
    }

    /**
     * Setter za email
     * @param cstEmail
     */
    public void setCstEmail(String cstEmail) {
        this.cstEmail = cstEmail;
    }

    /**
     * Getter za id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter za id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter za bookInShopName
     * @return bookInShopName
     */
    public String getBookInShopName() {
        return bookInShopName;
    }

    /**
     * Setter za bookInShopName
     * @param bookInShopName
     */
    public void setBookInShopName(String bookInShopName) {
        this.bookInShopName = bookInShopName;
    }

    /**
     * Getter za typeOfBookCover
     * @return typeOfBookCover
     */
    public String getTypeOfBookCover() {
        return typeOfBookCover;
    }

    /**
     * Setter za typeOfBookCover
     * @param typeOfBookCover
     */
    public void setTypeOfBookCover(String typeOfBookCover) {
        this.typeOfBookCover = typeOfBookCover;
    }

    /**
     * Getter za placeOfDelivery
     * @return placeOfDelivery
     */
    public String getPlaceOfDelivery() {
        return placeOfDelivery;
    }

    /**
     * Setter za placeOfDelivery
     * @param placeOfDelivery
     */
    public void setPlaceOfDelivery(String placeOfDelivery) {
        this.placeOfDelivery = placeOfDelivery;
    }

    /**
     * Getter za deliveryType
     * @return deliveryType
     */
    public String getDeliveryType() {
        return deliveryType;
    }

    /**
     * Setter za deliveryType
     * @param deliveryType
     */
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * Getter za paymentStrategy
     * @return paymentStrategy
     */
    public String getPaymentStrategy() {
        return paymentStrategy;
    }

    /**
     * Setter za paymentStrategy
     * @param paymentStrategy
     */
    public void setPaymentStrategy(String paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Metoda koja ispisuje toString metodu
     */
    public void info(){
        System.out.println(toString());
    }

    /**
     * Setter za counter
     * @param cnt
     */
    public static void setCounter(int cnt) {
        counter = cnt;
    }

    /**
     * To strinng metoda
     * @return
     */
    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", cstName='" + cstName + '\'' +
                ", cstLastName='" + cstLastName + '\'' +
                ", cstAddress='" + cstAddress + '\'' +
                ", cstEmail='" + cstEmail + '\'' +
                ", bookInShopName='" + bookInShopName + '\'' +
                ", typeOfBookCover='" + typeOfBookCover + '\'' +
                ", placeOfDelivery='" + placeOfDelivery + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", paymentStrategy='" + paymentStrategy + '\'' +
                '}';
    }
}
