package listeners;

import avisos.MensajesError;
import com.fasterxml.jackson.databind.JsonNode;
import interfaz.Constante;
import interfaz.Gui;
import org.eclipse.swt.widgets.*;
import peticionesRest.RestJuegos;

public class EliminarListener implements Listener {
    private Table table;
    RestJuegos verjuegos;
    private Shell shell;
    private MensajesError mensajesError;
    private Combo combo;
    private Gui gui;
    public EliminarListener(Table table, RestJuegos verjuegos, Shell shell, MensajesError mensajesError, Combo combo, Gui gui) {
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
                  this.gui.getCombo3().removeAll();
                  for (JsonNode año:años){

                      this.gui.getCombo3().add(año.get("año").toString()+"-"+año.get("descripcion_tipo_jjoo").asText());



                  }
                  this.gui.getCombo3().setVisible(true);
                  this.table.setEnabled(false);
                  this.gui.getLabel3().setVisible(true);
                  this.gui.getButton1().setEnabled(false);
                  this.gui.getButton2().setEnabled(false);
                  this.gui.getButton3().setEnabled(false);
                  this.gui.getButton4().setVisible(true);
                  this.gui.getButton5().setVisible(true);
                  

              } catch (Exception ex) {

                  this.mensajesError.avisar(Constante.MENSAJE_ERROR_ELIMINAR);

              }




          }




        }else{
            this.mensajesError.avisar(Constante.MENSAJE_ERROR_SELECCIONAR_CIUDAD);


        }


    }

}
