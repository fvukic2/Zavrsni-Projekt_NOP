package view;

/**
 * Klasa kojom definiramo nacin placanja google payom
 * @author Filip
 */
public class GooglePayPaymentStrategy implements WayOfPaymentStrategy {

    /**
     * Implementirana metoda payment iz sucelja WayOfPaymentStrategy koja vraca nacin placanja
     * @return
     */
    @Override
    public String payment() {
        return "GooglePay";
    }

    /**
     * To string metoda klase CreditCardPaymentStrategy nam je potrebna da pravilno prikaze metodu nacina placanja u JComboBoxu
     * @return
     */
    @Override
    public String toString() {
        return "GooglePay";
    }
}
