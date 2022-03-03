package controller;

import model.DataBase;
import model.OrderDetail;
import view.ViewPanel;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Posrednik sa bazom i view panelom
 * @author Filip
 */
public class Controller {

    /**
     * Objekt klase DataBase
     */
    private DataBase dataBase;

    /**
     * Konstruktor klase Controller
     */
    public Controller(){
        dataBase = new DataBase();
    }

    /**
     * Metoda kojom dodajemo detalje o narudzbi u bazu podataka
     * @param orderDetail
     */
    public void addNewOrderDetailsToDataBase(OrderDetail orderDetail){
        System.out.println(orderDetail);
        dataBase.addOrderDetails(orderDetail);
    }

    /**
     * Metoda kojom dohvacamo sve narudzbe iz baze podataka
     * @return
     */
    public List<OrderDetail> getAllOrderDetailsFromDataBase(){
        return dataBase.getAllOrderDetailsFromDataBase();
    }

    /**
     * Metoda kojom izlistavamo sve narudzbe iz baze podataka
     */
    public void listAllOrderDetailsInDataBase(){
        System.out.println("------------------------- Listing all order details -------------------------");
        dataBase.listAllOrderDetailsInDataBase();
    }

    /**
     * Metoda kojom spremamo podatke u file
     * @param file
     * @throws IOException
     */
    public void saveDataToTextFile(File file) throws IOException {
        dataBase.saveToFile(file);
    }

    /**
     * Metoda kojom citamo podatke iz filea
     * @param file
     */
    public void loadDataFromTextFile(File file) throws IOException {
        dataBase.readFromFile(file);
    }

    /**
     * Metoda kojom se spajamo na bazu podataka
     */
    public void connectToDataBase(){
        dataBase.connect();
    }

    /**
     * Metoda kojom se odjavljujemo sa baze podataka
     */
    public void disconnectFromDataBase(){
        dataBase.disconnect();
    }

    /**
     * Metoda kojom spremamo podatke u bazu podataka
     */
    public void saveDataToDataBase() throws SQLException {
        dataBase.saveDataToDataBaseServer();
    }

    /**
     * Metoda kojom ucitavamo podatke iz baze podataka
     */
    public void loadDataToDataBase(){
        dataBase.loadDataFromDataBaseServer();
    }

    /**
     * Metoda kojom prikazujemo importani tekst na textArea
     * @param viewPanel
     */
    public void showImportedDataInTextPanel(ViewPanel viewPanel){
        viewPanel.showImportedDataInTextPanel(dataBase.getAllOrderDetailsFromDataBase());
    }

    /**
     * Metoda kojom prikazujemo tekst na textArea
     * @param viewPanel
     * @param orderDetail
     */
    public void showOrderDetailData(ViewPanel viewPanel, OrderDetail orderDetail){
        viewPanel.showOnTextArea(orderDetail);
    }

    /**
     * Metoda za postavljanje podataka
     * @param viewPanel
     */
    public void setData(ViewPanel viewPanel){
        viewPanel.setOrderDetails(dataBase);
    }

}


















