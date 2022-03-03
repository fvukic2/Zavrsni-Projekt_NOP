package view;

import controller.AppPopUpMenu;
import controller.CommandManager;
import controller.MousePopUpListener;
import model.DataBase;
import model.OrderDetail;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.util.List;

/**
 * Klasa ViewPanel koja sadrzi textArea
 * Sluzi nam za postavljanje i dohvacanje teksta sa textArea
 *
 * @author Filip
 */
public class ViewPanel extends JPanel {

    /**
     * Objekt klase JTextPane kojim dodajemo textArea na ekran
     */
    private JTextPane jTextPane;
    /**
     * Klasa AppPopUpMenu nam je potrebna za dodavanje pop up menu klikom misa na textArea
     */
    private AppPopUpMenu appPopUpMenu;
    /**
     * Klasomom undoManager dobijamo funckionalnost za undo i redo operacije
     */
    UndoManager undoManager = new UndoManager();

    private StyledDocument doc;
    private SimpleAttributeSet attributes;
    private AbstractTableModel tabModel;
    private JTable table;
    private List<OrderDetail> orderDetails;

    /**
     * Konstruktor klase ViewPanel koji prema customerInformationPanel radi njegova pozicioniranja
     *
     * @param customerInformationPanel
     */
    public ViewPanel(CustomerInformationPanel customerInformationPanel) {

        setSizeOfTextAreaPanel();
        setLayout(new BorderLayout());
        initializeAllComponents();
        add(new JScrollPane(jTextPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.CENTER);
        //jTextArea.setEditable(true);
        jTextPane.setForeground(Color.GREEN);
        jTextPane.setBackground(Color.BLACK);
        add(customerInformationPanel, BorderLayout.WEST);
        doc = jTextPane.getStyledDocument();
        attributes = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attributes, "Consolas");
        StyleConstants.setFontSize(attributes, 12);
        attributes.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.TRUE);

        appPopUpMenu = new AppPopUpMenu(new CommandManager(this));
        jTextPane.addMouseListener(new MousePopUpListener(appPopUpMenu));

        jTextPane.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
    }

    /**
     * Metoda kojom kreiramo sve komponente
     */
    private void initializeAllComponents() {
        jTextPane = new JTextPane();
    }

    /**
     * Metoda kojom odredujemo velicinu panela
     */
    private void setSizeOfTextAreaPanel() {
        Dimension dimension = new Dimension();
        dimension.height = 250;
        dimension.width = 400;
        setPreferredSize(dimension);
    }

    /**
     * Metoda kojom dodajemo procitani objekt na textArea
     *
     * @param text
     */
    public void setTextToPanel(String text) {
        jTextPane.setText(text + "\n");
    }

    /**
     * Metoda kojom cisitimo sve sa textArea
     */
    public void clearAllTextFromArea() {
        jTextPane.selectAll();
        jTextPane.replaceSelection(null);
    }

    /**
     * Metoda kojom dohvacamo sve podatke sa textArea
     *
     * @return
     */
    public String getAll() {
        jTextPane.selectAll();
        return jTextPane.getSelectedText();
    }

    /**
     * Metoda kojom dohvacamo textArea
     *
     * @return
     */
    public JTextPane getjTextPane() {
        return jTextPane;
    }

    /**
     * Metoda kojom prikazujemo podatke na textArea
     * @param ord
     */
    public void showOnTextArea(OrderDetail ord) {
        try {
            doc.insertString(doc.getLength(), ord.toString() + "\n\n", attributes);
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showImportedDataInTextPanel(List<OrderDetail> data){
        for (OrderDetail ordDet : data){
            showOnTextArea(ordDet);
        }
    }

    public void setOrderDetails(DataBase dataBase) {
        orderDetails = dataBase.getAllOrderDetailsFromDataBase();
    }
}
