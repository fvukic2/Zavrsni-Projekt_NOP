package view;

/**
 * Klasa kojom dodajemo undo i redo funkcionalnost
 * @author Filip
 */
public class UndoRedoHandler {

    /**
     * Klasa viewPanel nam je potrebna jer se u njoj nalazi textArrea
     */
    private ViewPanel viewPanel;

    /**
     * Konstruktor klase UndoRedoHandler
     * @param viewPanel
     */
    public UndoRedoHandler(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    /**
     * Metoda za undo radnje
     */
    public void undo(){
        viewPanel.undoManager.undo();
    }

    /**
     * Metoda za redo radnje
     */
    public void redo(){
        viewPanel.undoManager.redo();
    }

}
