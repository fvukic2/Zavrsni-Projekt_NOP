package model;

import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa u kojoj se sprema objekt tipa OrderDetails
 *
 * @author Filip
 */
public class DataBase {

    /**
     * Array lista tipa OrderDetail koja sadrzi sve narudzbe
     */
    private List<OrderDetail> orderDetails;
    /**
     * Objekt tipa Connection
     */
    private Connection connection;

    /**
     * Konstruktor klase DataBase
     */

    public DataBase() {
        orderDetails = new LinkedList<OrderDetail>();

    }


    /**
     * Metoda kojom se dodaje orderDetail u listu orderDetails
     *
     * @param orderDetail
     */
    public void addOrderDetails(OrderDetail orderDetail) {
        System.out.println("In DB: " + orderDetails.size());
        System.out.println(orderDetail);
        orderDetails.add(orderDetail);
        System.out.println("In DB: " + orderDetails.size());
    }

    /**
     * Metoda kojom se dohvacaju sve narudzbe u bazi
     *
     * @return
     */
    public List<OrderDetail> getAllOrderDetailsFromDataBase() {
        return orderDetails;
    }

    /**
     * Metoda kojom se ispisuju svi podaci o narudzbama iz baze
     */
    public void listAllOrderDetailsInDataBase() {
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.info();
        }
    }

    /**
     * Metoda kojom ucitavamo podatke sa baze podataka
     */
    public void loadDataFromDataBaseServer() {

        ResultSet results = null;
        PreparedStatement selectStatement = null;

        if (connection != null) {
            System.out.println("Loading data from database server!");
            String selectSQL = "select * from OrderDetailsT order by name";

            try {
                selectStatement = connection.prepareStatement(selectSQL);
                results = selectStatement.executeQuery();

                orderDetails.clear();

                while (results.next()) {
                    int col = 1;
                    int id = results.getInt(col++);
                    String name = results.getString(col++);
                    String surname = results.getString(col++);
                    String address = results.getString(col++);
                    String email = results.getString(col++);
                    String bookName = results.getString(col++);
                    String bookCover = results.getString(col++);
                    String placeOfDel = results.getString(col++);
                    String deliveryType = results.getString(col++);
                    String paymentStr = results.getString(col++);

                    OrderDetail orderDetail = new OrderDetail(id, name, surname, address, email, bookName, bookCover, placeOfDel, deliveryType, paymentStr);
                    orderDetails.add(orderDetail);

                }
                results.close();
                selectStatement.close();

                System.out.println("List: " + orderDetails);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * Metoda kojom spremamo podatke u bazu podataka
     */
    public void saveDataToDataBaseServer() throws SQLException {

        System.out.println("In DB size is: " + orderDetails.size());
        System.out.println("Ord det: " + orderDetails);
        if (connection != null) {

            // SQL Queries
            String countSQLOrderDetails = "select count(*) as count from OrderDetailsT where id = ?";
            String insertSQL = "insert into OrderDetailsT (id, name, surname, address, email, book_name, type_of_book_cover, place_of_delivery, way_of_delivery, type_of_payment) values (?,?,?,?,?,?,?,?,?,?)";
            String updateSql = "update OrderDetailsT set name = ?, surname = ?, address = ?, email = ?, book_name = ?, type_of_book_cover = ?, place_of_delivery = ?, way_of_delivery = ?, type_of_payment = ? where id = ?";

            //Statments
            PreparedStatement countStemOrderDetails = connection.prepareStatement(countSQLOrderDetails);
            PreparedStatement insertStatment = connection.prepareStatement(insertSQL);
            PreparedStatement updateStatment = connection.prepareStatement(updateSql);

            for (OrderDetail ordDet : orderDetails) {
                System.out.println("hewhdewd");
                int id = ordDet.getId();
                String name = ordDet.getCstName();
                String surname = ordDet.getCstLastName();
                String address = ordDet.getCstAddress();
                String email = ordDet.getCstEmail();
                String bookName = ordDet.getBookInShopName();
                String bookCover = ordDet.getTypeOfBookCover();
                String placeOfDel = ordDet.getPlaceOfDelivery();
                String deliveryType = ordDet.getDeliveryType();
                String paymentStr = ordDet.getPaymentStrategy();

                countStemOrderDetails.setInt(1, id);
                ResultSet result = countStemOrderDetails.executeQuery();
                result.next();
                int count = result.getInt(1);
                System.out.println("Counted: " + count);

                if (count == 0) {
                    System.out.println("Inserting new order details in database -> id: " + id);

                    // insert commands
                    int col = 1;
                    insertStatment.setInt(col++, id);
                    insertStatment.setString(col++, name);
                    insertStatment.setString(col++, surname);
                    insertStatment.setString(col++, address);
                    insertStatment.setString(col++, email);
                    insertStatment.setString(col++, bookName);
                    insertStatment.setString(col++, bookCover);
                    insertStatment.setString(col++, placeOfDel);
                    insertStatment.setString(col++, deliveryType);
                    insertStatment.setString(col++, paymentStr);

                    insertStatment.executeUpdate();

                } else {
                    System.out.println("Update order details in database with id -> " + id);

                    // update data command
                    int col = 1;
                    updateStatment.setString(col++, name);
                    updateStatment.setString(col++, surname);
                    updateStatment.setString(col++, address);
                    updateStatment.setString(col++, email);
                    updateStatment.setString(col++, bookName);
                    updateStatment.setString(col++, bookCover);
                    updateStatment.setString(col++, placeOfDel);
                    updateStatment.setString(col++, deliveryType);
                    updateStatment.setString(col++, paymentStr);
                    updateStatment.setInt(col++, id);

                    updateStatment.executeUpdate();

                }
            }
            countStemOrderDetails.close();
            insertStatment.close();
            updateStatment.close();

        }

    }


    /**
     * Metoda kojom se povezujemo na bazu podataka
     */
    public void connect() {
        System.out.println("Connecting to a server...");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://db4free.net:3306/"; //Your data
            String user = ""; //Your data
            String pswd = ""; //Your data
            connection = DriverManager.getConnection(url, user, pswd);
            System.out.println("Connected to: " + connection.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda kojom se odjavljujemo sa baze podataka
     */
    public void disconnect() {
        try {
            connection.close();
            System.out.println("Success - disconnected from MySQL DB!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("No connection to close!");
        }
    }

    /**
     * Metoda kojom spremamo podatke u file
     * @param file
     * @throws IOException
     */
    public void saveToFile(File file) throws IOException {
        OrderDetail[] ordDet = orderDetails.toArray(new OrderDetail[orderDetails.size()]);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(ordDet);
        os.close();
    }

    /**
     * Metoda kojom citamo podatke iz filea
     * @param file
     * @throws IOException
     */
    public void readFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            OrderDetail[] prgms = (OrderDetail[]) ois.readObject();
            orderDetails.clear();
            orderDetails.addAll(Arrays.asList(prgms));
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ois.close();
    }
}
























