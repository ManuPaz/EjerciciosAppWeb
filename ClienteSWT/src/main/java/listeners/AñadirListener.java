package listeners;

import avisos.MensajesError;
import interfaz.Gui;
import org.eclipse.swt.widgets.*;
import peticionesRest.RestJuegos;

public class AñadirListener implements Listener {
    private Table table;
    RestJuegos verjuegos;
    private Shell shell;
    private MensajesError mensajesError;
    private Combo combo;
    private Gui gui;
    public AñadirListener(Table table, RestJuegos verjuegos, Shell shell, MensajesError mensajesError, Combo combo, Gui gui) {
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
        final int row = this.table.getSelectionIndex();

        if (row != -1) {
            TableItem item=  table.getItem(row);

            String ciudad=item.getText(1);
           this.gui.getText1().setText(ciudad);


        }
        this.gui.getLabel1().setVisible(true);
        this.gui.getLabel4().setVisible(true);
        this.gui.getText1().setVisible(true);
        this.gui.getText4().setVisible(true);
        this.gui.getButton4().setVisible(true);
        this.gui.getButton5().setVisible(true);
        this.gui.getButton1().setEnabled(false);
        this.gui.getButton2().setEnabled(false);
        this.gui.getButton3().setEnabled(false);
        this.gui.getCombo6().setVisible(true);
        this.gui.getLabel6().setVisible(true);
        this.gui.getLabel12().setVisible(true);
        this.gui.getText12().setVisible(true);
        this.gui.getLabel13().setVisible(true);
        this.gui.getText13().setVisible(true);
        this.gui.getLabel8().setVisible(true);
        this.gui.getText8().setVisible(true);
        this.gui.getLabel10().setVisible(true);
        this.gui.getText10().setVisible(true);
    }

}
