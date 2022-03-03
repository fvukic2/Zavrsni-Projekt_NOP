package view;

import model.OrderDetail;

import java.util.EventObject;

/**
 * Klasa kojom kreiramo OrderDetailEvent
 */
public class OrderDetailEvent extends EventObject {

    /**
     * Varijabla kojom pohranjujemo ime kupca
     */
    private String name;
    /**
     * Varijabla kojom pohranjujemo prezime kupca
     */
    private String lastName;
    /**
     * Varijabla kojom pohranjujemo adresu kupca
     */
    private String address;
    /**
     * Varijabla kojom pohranjujemo email kupca
     */
    private String email;
    /**
     * Varijabla kojom pohranjujemo kupljenu knjigu kupca
     */
    private String bksInShop;
    /**
     * Varijabla kojom pohranjujemo tip knjige
     */
    private String typeOfBkCover;
    /**
     * Varijabla kojom pohranjujemo mjesto dostave
     */
    private String placeOfDel;
    /**
     * Varijabla kojom pohranjujemo tip dostave
     */
    private String delTyp;
    /**
     * Varijabla kojom pohranjujemo nacin placanja
     */
    private String pymStr;

    /**
     * Konstruktor klase OrderDetailEvent
     * @param source
     * @param orderDetail
     */
    public OrderDetailEvent(Object source , OrderDetail orderDetail) {
        super(source);

        name = orderDetail.getCstName();
        lastName = orderDetail.getCstLastName();
        address = orderDetail.getCstAddress();
        email = orderDetail.getCstEmail();
        bksInShop = orderDetail.getBookInShopName();
        typeOfBkCover = orderDetail.getTypeOfBookCover();
        placeOfDel = orderDetail.getPlaceOfDelivery();
        delTyp = orderDetail.getDeliveryType();
        pymStr = orderDetail.getPaymentStrategy();
    }

    /**
     * Getters za ime
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getters za prezime
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getters za adresu
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Getters za email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getters za knjige u ducanu
     * @return bksInShop
     */
    public String getBksInShop() {
        return bksInShop;
    }

    /**
     * Getters za tip knjige
     * @return typeOfBkCover
     */
    public String getTypeOfBkCover() {
        return typeOfBkCover;
    }

    /**
     * Getters za mjesto dostave
     * @return placeOfDel
     */
    public String getPlaceOfDel() {
        return placeOfDel;
    }

    /**
     * Getters za tip dostave
     * @return delTyp
     */
    public String getDelTyp() {
        return delTyp;
    }

    /**
     * Getters za nacin placanja
     * @return pymStr
     */
    public String getPymStr() {
        return pymStr;
    }
}
