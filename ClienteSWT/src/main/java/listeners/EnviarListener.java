package listeners;

import avisos.MensajesError;
import interfaz.Constante;
import interfaz.Gui;
import org.eclipse.swt.widgets.*;
import peticionesRest.RestJuegos;

import java.io.IOException;

public class EnviarListener implements Listener {
    private Table table;
    RestJuegos verjuegos;
    private Shell shell;
    private MensajesError mensajesError;
    private Combo combo;
    private Gui gui;
    public EnviarListener(Table table, RestJuegos verjuegos, Shell shell, MensajesError mensajesError, Combo combo, Gui gui) {
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
        String accion="";
        boolean  terminar=false;
        if (this.gui.getLabel1().isVisible())
            accion="añadir";

        else if (this.gui.getLabel3().isVisible())
            accion="eliminar";
        else
            accion="modificar";
        switch (accion){
            case "añadir":




                if (this.gui.getCombo6().getSelectionIndex()!=-1){
                    try {
                        Integer año = Integer.parseInt(this.gui.getText4().getText());
                        String ciudad=this.gui.getText1().getText();
                        String tipo=this.gui.getCombo6().getItem(this.gui.getCombo6().getSelectionIndex()).toString();
                        if (!ciudad.equals("")){
                            String pais=null;
                            String codigoPais=null;
                            Integer valorCiudad=null;
                            Integer valorPais=null;
                            if (this.gui.getText12().getText()!="") {

                                valorCiudad = Integer.parseInt(this.gui.getText12().getText());

                            }
                            if (this.gui.getText13().getText()!="") {

                                valorPais= Integer.parseInt(this.gui.getText13().getText());

                            }
                            if (this.gui.getText8().getText()!="") {

                                pais=this.gui.getText8().getText();

                            }
                            if (this.gui.getText10().getText()!="") {

                                codigoPais=this.gui.getText10().getText();

                            }



                            terminar=this.verjuegos.añadirJuegos(ciudad,año,tipo,pais,codigoPais,valorCiudad,valorPais);


                        if (terminar) {


                            this.gui.getText10().setVisible(false);
                            this.gui.getLabel1().setVisible(false);
                            this.gui.getLabel4().setVisible(false);
                            this.gui.getText1().setVisible(false);
                            this.gui.getText4().setVisible(false);
                            this.gui.getCombo6().setVisible(false);
                            this.gui.getLabel6().setVisible(false);
                            this.gui.getLabel12().setVisible(false);
                            this.gui.getText12().setVisible(false);
                            this.gui.getLabel13().setVisible(false);
                            this.gui.getText13().setVisible(false);
                            this.gui.getLabel8().setVisible(false);
                            this.gui.getText8().setVisible(false);
                            this.gui.getLabel10().setVisible(false);
                            this.gui.getButton4().setVisible(false);
                            this.gui.getButton5().setVisible(false);
                            this.mensajesError.confirmar(Constante.MENSAJE_SEDE_AÑADIDA);
                        }
                        }
                        else{

                            this.mensajesError.avisar(Constante.MENSAJE_CIUDAD_INVALIDA);

                        }
                    }catch(NumberFormatException   exception){

                        this.mensajesError.avisar(Constante.MENSAJE_ERROR_AÑO);

                    } catch (IOException ex) {
                        this.mensajesError.avisar(Constante. MENSAJE_CAMPOS_INVALIDOS);
                    }


                }else{

                    this.mensajesError.avisar(Constante.MENSAJE_ERROR_SELECCIONAR_TIPO_SEDE);
                }


                break;

            case "modificar":

                final int indice=this.gui.getCombo2().getSelectionIndex();

                if (indice!=-1) {
                    String item=this.gui.getCombo2().getItem(indice);
                    Integer año=Integer.valueOf(item.split("-")[0]);
                    String tipo=item.split("-")[1];
                    Integer nuevoAño=null;
                    String nuevoTipoSede=null;
                    Integer nuevoIdCiudad=null;
                    String nuevoNombreCiudad=null;
                    try {




                            if (this.gui.getText5().getText()!="") {


                               nuevoAño= Integer.parseInt(this.gui.getText5().getText());

                            }
                            if (this.gui.getText9().getText()!="") {

                                nuevoIdCiudad= Integer.parseInt(this.gui.getText9().getText());

                            }
                            if (this.gui.getText11().getText()!="") {

                               nuevoNombreCiudad=this.gui.getText11().getText();

                            }
                            if (this.gui.getCombo7().getSelectionIndex()!=-1) {
                                nuevoTipoSede=this.gui.getCombo7().getItem(this.gui.getCombo7().getSelectionIndex()).toString();


                            }



                            terminar=this.verjuegos.modificarJuegos( nuevoNombreCiudad,año,tipo,nuevoAño,nuevoTipoSede,nuevoIdCiudad);


                            if (terminar) {


                                this.gui.getModalShell().dispose();
                                this.mensajesError.confirmar(Constante.MENSAJE_SEDE_MODIFICADA);
                            }


                    }catch(NumberFormatException   exception){

                        this.mensajesError.avisarEnModal(Constante.MENSAJE_ERROR_AÑO,this.gui.getModalShell());

                    } catch (IOException ex) {
                        this.mensajesError.avisarEnModal(Constante. MENSAJE_CAMPOS_INVALIDOS,this.gui.getModalShell());
                    }


                }else{

                    this.mensajesError.avisarEnModal(Constante.MENSAJE_ERROR_SELECCIONAR_TIPO_SEDE,this.gui.getModalShell());
                }





                break;
            case "eliminar":

                final int indice1=this.gui.getCombo3().getSelectionIndex();

                if (indice1!=-1) {
                    String item=this.gui.getCombo3().getItem(indice1);
                    Integer año=Integer.valueOf(item.split("-")[0]);
                    String tipo=item.split("-")[1];
                    try {
                        this.verjuegos.eliminarJuegos(año,tipo);
                        terminar=true;
                        this.gui.getCombo3().setVisible(false);
                        this.gui.getLabel3().setVisible(false);

                        this.gui.getButton4().setVisible(false);
                        this.gui.getButton5().setVisible(false);
                    } catch (Exception ex) {

                        this.mensajesError.avisar(Constante.MENSAJE_ERROR_ELIMINAR_SEDE);
                    }

                }
                else
                    this.mensajesError.avisar(Constante.MENSAJE_ERROR_SELECCIONAR_SEDE);
                break;

        }
        if (terminar){
        try {
            this.gui.updateTable();
        } catch (IOException ex) {
            this.mensajesError.avisar( Constante.MENSAJE_ERROR_ACTUALIZAR_TABLA);
        }
        this.gui.getTable().setEnabled(true);
        this.gui.getButton1().setEnabled(true);
        //this.gui.getButton2().setEnabled(true);
        //this.gui.getButton3().setEnabled(true);
        this.gui.getButton4().setVisible(false);
        this.gui.getButton5().setVisible(false);
        this.gui.limpiarTextos();

        }



        }
    }


