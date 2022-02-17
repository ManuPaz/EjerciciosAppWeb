package listeners;

import avisos.MensajesError;
import com.fasterxml.jackson.databind.JsonNode;
import interfaz.Constante;
import interfaz.Gui;
import org.eclipse.swt.widgets.*;
import peticionesRest.RestJuegos;

public class ModificarListener implements Listener {
    private Table table;
    RestJuegos verjuegos;
    private Shell shell;
    private MensajesError mensajesError;
    private Combo combo;
    private Gui gui;
    public ModificarListener(Table table, RestJuegos verjuegos, Shell shell, MensajesError mensajesError, Combo combo, Gui gui) {
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
        final int row=this.table.getSelectionIndex();

        if (row!=-1){
          TableItem item=  table.getItem(row);
          Integer num=Integer.valueOf(item.getText(5));
          String ciudad=item.getText(1);
          String tipo=item.getText(6);
          Integer idciudad=Integer.valueOf(item.getText(0));
          if (num==0){
              this.mensajesError.avisar(ciudad+Constante.MENSAJE_ERROR_NO_ES_SEDE);


          }
          else{


              JsonNode años= null;
              try {
                  años = this.verjuegos.buscarPorCiudad(idciudad,tipo);

                    this.gui.getButton3().setEnabled(false);
                    this.gui.getButton2().setEnabled(false);
                  this.gui.newShell(años);




              } catch (Exception ex) {
                  //ex.printStackTrace();
                  this.mensajesError.avisar(Constante.MENSAJE_ERROR_BUSCAR_SEDE);

              }




          }




        }else{
            this.mensajesError.avisar(Constante.MENSAJE_ERROR_SELECCIONAR_CIUDAD);


        }


    }

}
