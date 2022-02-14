package listeners;

import avisos.MensajesError;
import com.fasterxml.jackson.databind.JsonNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import peticionesRest.VerJuegos;

import java.io.IOException;

public class ModificarListener implements Listener {
    private Table table;
    VerJuegos verjuegos;
    private Shell shell;
    private MensajesError mensajesError;
    private Combo combo;

    public ModificarListener(Table table, VerJuegos verjuegos, Shell shell, MensajesError mensajesError,Combo combo) {
        this.table = table;
        this.verjuegos=verjuegos;
        this.shell=shell;
        this.mensajesError=mensajesError;
        this.combo=combo;
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
          Integer idciudad=Integer.valueOf(item.getText(0));
          if (num==0){
              this.mensajesError.avisar(ciudad+" no es sede de ningunos JJOO");


          }
          else{


              JsonNode años= null;
              try {
                  años = this.verjuegos.buscarPorCiudad(idciudad);
                  for (JsonNode año:años){

                      this.combo.add(año.toString());



                  }
                  this.combo.setVisible(true);
              } catch (Exception ex) {
                  ex.printStackTrace();
                  this.mensajesError.avisar("No hay años para esta ciudad");

              }




          }




        }else{
            this.mensajesError.avisar("Selecciona una ciudad");


        }


    }

}
