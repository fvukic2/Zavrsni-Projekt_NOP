package view;

/**
 * Klasa kojom definiramo nacin placanja PayPalom
 * @author Filip
 */
public class PayPalPaymentStrategy implements WayOfPaymentStrategy {

    /**
     * Implementirana metoda payment iz sucelja WayOfPaymentStrategy koja vraca nacin placanja
     * @return
     */
    @Override
    public String payment() {
        return "PayPal";
    }

    /**
     * To string metoda klase CreditCardPaymentStrategy nam je potrebna da pravilno prikaze metodu nacina placanja u JComboBoxu
     * @return
     */
    @Override
    public String toString() {
        return "PayPal";
    }
}
