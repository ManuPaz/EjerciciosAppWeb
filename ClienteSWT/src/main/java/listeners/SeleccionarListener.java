package listeners;

import avisos.MensajesError;
import com.fasterxml.jackson.databind.JsonNode;
import interfaz.Constante;
import interfaz.Gui;
import org.eclipse.swt.widgets.*;
import peticionesRest.RestJuegos;

public class SeleccionarListener implements Listener {
    private Table table;
    RestJuegos verjuegos;
    private Shell shell;
    private MensajesError mensajesError;
    private Combo combo;
    private Gui gui;
    public SeleccionarListener(Table table, RestJuegos verjuegos, Shell shell, MensajesError mensajesError, Combo combo, Gui gui) {
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
        this.gui.getButton1().setEnabled(true);
        this.gui.getButton2().setEnabled(true);
        this.gui.getButton3().setEnabled(true);


    }

}
