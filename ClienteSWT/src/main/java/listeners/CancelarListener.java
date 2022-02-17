package listeners;

import avisos.MensajesError;
import com.fasterxml.jackson.databind.JsonNode;
import interfaz.Constante;
import interfaz.Gui;
import org.eclipse.swt.widgets.*;
import peticionesRest.RestJuegos;

public class CancelarListener implements Listener {
    private Table table;
    RestJuegos verjuegos;
    private Shell shell;
    private MensajesError mensajesError;
    private Combo combo;
    private Gui gui;
    public CancelarListener(Table table, RestJuegos verjuegos, Shell shell, MensajesError mensajesError, Combo combo, Gui gui) {
        this.table = table;
        this.verjuegos=verjuegos;
        this.shell=shell;
        this.mensajesError=mensajesError;
        this.combo=combo;
        this.gui=gui;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void handleEvent(Event e) {
        this.gui.getButton4().setVisible(false);
        this.gui.getButton1().setEnabled(true);
        //this.gui.getButton2().setEnabled(true);
        //this.gui.getButton3().setEnabled(true);
        this.gui.getButton5().setVisible(false);
        this.gui.getTable().setEnabled(true);
        this.gui.getText1().setVisible(false);
        this.gui.getText4().setVisible(false);

        this.gui.getText8().setVisible(false);

        this.gui.getText10().setVisible(false);

        this.gui.getText12().setVisible(false);
        this.gui.getText13().setVisible(false);
        this.gui.getLabel1().setVisible(false);

        this.gui.getLabel3().setVisible(false);
        this.gui.getLabel4().setVisible(false);

        this.gui.getLabel6().setVisible(false);

        this.gui.getLabel8().setVisible(false);
        this.gui.getLabel13().setVisible(false);
        this.gui.getLabel10().setVisible(false);

        this.gui.getLabel12().setVisible(false);
        this.gui.getCombo3().setVisible(false);

        this.gui.getCombo6().setVisible(false);

        if (this.gui.getModalShell()!=null){
            this.gui.getModalShell().dispose();


        }






    }

}
