package view;

/**
 * Sucelje koje implementiraju nase strategije placanja
 */
public interface WayOfPaymentStrategy {

    /**
     * Metoda koju implementiraju strategije placanja koja ima povratni tip String
     * @return
     */
    String payment();

}
