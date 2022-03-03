package test_server_db;

import model.DataBase;
import model.OrderDetail;

import java.sql.SQLException;

/**
 * Klasa kojom testiramo funkcionalnost baze podataka prije nego ju dodamo u gui
 * @author Filip
 */
public class AppTestServer {

    public static void main(String[] args) throws SQLException {

        DataBase dataBase = new DataBase();

        OrderDetail orderDetail1 = new OrderDetail("Ante","Antic","Ulica Ante Antica","ante.antic32@gmail.com","In Search of Lost Time by Marcel Proust","Softcover","Apartment delivery","Normal delivery","Google pay");
        OrderDetail orderDetail2 = new OrderDetail("Mate","Matic","Ulica Mate Matica","mate.matic56@gmail.com","War and Peace by Leo Tolstoy","Hardcover with ImageWrap","House delivery","Express delivery","Pay pal");

        dataBase.addOrderDetails(orderDetail1);
        dataBase.addOrderDetails(orderDetail2);
        dataBase.listAllOrderDetailsInDataBase();

        dataBase.connect();
        dataBase.saveDataToDataBaseServer();
        dataBase.loadDataFromDataBaseServer();
        dataBase.disconnect();
    }
}
