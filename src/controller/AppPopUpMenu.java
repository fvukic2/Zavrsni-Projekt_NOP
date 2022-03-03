package controller;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa koja sluzi za izradu popUpMenia
 * @author Filip
 */
public class AppPopUpMenu extends JPopupMenu {

    /**
     * Sucelje koje nam sluzi za rukovanje eventovima
     */
    private ActionListener menuListener;
    /**
     * Objekt klase JMenuItem kojim kopiramo podatke sa txtarea
     */
    private JMenuItem copyItem;
    /**
     * Objekt klase JMenuItem kojim lijepimo podatke na txtarea
     */
    private JMenuItem pasteItem;
    /**
     * Objekt klase JMenuItem kojim cistimo podatke sa txtarea
     */
    private JMenuItem cutItem;
    /**
     * Objekt klase JMenuItem kojim oznacavmo sve podatke na txtarea
     */
    private JMenuItem selectAllItem;

    /**
     * Konstruktor klase AppPopUpMenu
     * @param commandManager
     */
    public AppPopUpMenu(CommandManager commandManager) {
        menuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == copyItem) {
                    commandManager.copy();
                } else if (e.getSource() == pasteItem) {
                    commandManager.paste();
                } else if (e.getSource() == cutItem) {
                    commandManager.cut();
                } else if (e.getSource() == selectAllItem) {
                    commandManager.selectAll();
                }
            }
        };
        initPopUpMenuItems();
        //activatePopUpMenuItems();
    }

    /**
     * Setters za actionListener
     * @param listener
     */
    // you may use this, but it is not necessarily
    public void setPopUpMenuActionListener(ActionListener listener) {
        this.menuListener = listener;
    }


    /**
     * Metoda kojom inicijaliziramo elmente popUpMenia
     */
    private void initPopUpMenuItems() {

        add(copyItem = new JMenuItem("Copy"));
        copyItem.setHorizontalTextPosition(JMenuItem.RIGHT);
        copyItem.setActionCommand("Copy");
        System.out.println("CopyItem: " + copyItem.hashCode());
        copyItem.addActionListener(menuListener);
        add(pasteItem = new JMenuItem("Paste"));
        pasteItem.setHorizontalTextPosition(JMenuItem.RIGHT);
        pasteItem.setActionCommand("Paste");
        System.out.println("PasteItem: " + pasteItem.hashCode());
        pasteItem.addActionListener(menuListener);
        add(cutItem = new JMenuItem("Cut"));
        cutItem.setHorizontalTextPosition(JMenuItem.RIGHT);
        cutItem.setActionCommand("Cut");
        System.out.println("CutItem: " + cutItem.hashCode());
        cutItem.addActionListener(menuListener);
        addSeparator();
        add(selectAllItem = new JMenuItem("Select all"));
        selectAllItem.setHorizontalTextPosition(JMenuItem.RIGHT);
        selectAllItem.setActionCommand("Select all");
        System.out.println("SelectAllItem: " + selectAllItem.hashCode());
        selectAllItem.addActionListener(menuListener);

        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        // you can set dimension for popup menu
        Dimension preferredSize = new Dimension(105, 120);
        setPreferredSize(preferredSize);

    }
}
