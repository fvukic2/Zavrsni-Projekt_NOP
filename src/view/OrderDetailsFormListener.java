package view;

import java.util.EventListener;

/**
 * Sucelje koje prati promjene koje su nastale uslijed nekog događaja na FormPanelima
 * @author Filip
 */
public interface OrderDetailsFormListener extends EventListener {

    /**
     * Metoda koja prima objekt klase OrderDetail
     * @param orderDetailEvent
     */
    void orderDetailsEventOccurred(OrderDetailEvent orderDetailEvent);
}
