package interfaz;

import avisos.MensajesError;
import com.fasterxml.jackson.databind.JsonNode;
import listeners.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import peticionesRest.RestJuegos;

import java.io.IOException;

public class Gui {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button butonEnviarModal;
    private Button butonCancelarModal;
    private Table table;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;
    private Label label8;
    private Label label9;
    private Label label10;
    private Label label11;
    private Label label12;
    private Label label13;
    private Label label14;

    private Text text1;
    private Text text4;
    private Text text5;

    public Text getText13() {
        return text13;
    }

    public void setText13(Text text13) {
        this.text13 = text13;
    }

    public Text getText14() {
        return text14;
    }

    public void setText14(Text text14) {
        this.text14 = text14;
    }

    private Text text8;
    private Text text9;
    private Text text10;
    private Text text11;
    private Text text12;
    private Text text13;
    private Text text14;

    private Combo combo2;
    private Combo combo3;
    private Combo combo4;

    public Label getLabel6() {
        return label6;
    }

    public void setLabel6(Label label6) {
        this.label6 = label6;
    }

    public Label getLabel7() {
        return label7;
    }

    public void setLabel7(Label label7) {
        this.label7 = label7;
    }

    public Button getButton5() {
        return button5;
    }

    public void setButton5(Button button5) {
        this.button5 = button5;
    }

    public Label getLabel8() {
        return label8;
    }

    public void setLabel8(Label label8) {
        this.label8 = label8;
    }

    public Label getLabel9() {
        return label9;
    }

    public void setLabel9(Label label9) {
        this.label9 = label9;
    }

    public Label getLabel10() {
        return label10;
    }

    public void setLabel10(Label label10) {
        this.label10 = label10;
    }

    public Label getLabel11() {
        return label11;
    }

    public void setLabel11(Label label11) {
        this.label11 = label11;
    }

    public Label getLabel12() {
        return label12;
    }

    public void setLabel12(Label label12) {
        this.label12 = label12;
    }

    public Label getLabel13() {
        return label13;
    }

    public void setLabel13(Label label13) {
        this.label13 = label13;
    }

    public Label getLabel14() {
        return label14;
    }

    public void setLabel14(Label label14) {
        this.label14 = label14;
    }

    public Text getText8() {
        return text8;
    }

    public void setText8(Text text8) {
        this.text8 = text8;
    }

    public Text getText9() {
        return text9;
    }

    public void setText9(Text text9) {
        this.text9 = text9;
    }

    public Text getText10() {
        return text10;
    }

    public void setText10(Text text10) {
        this.text10 = text10;
    }

    public Text getText11() {
        return text11;
    }

    public void setText11(Text text11) {
        this.text11 = text11;
    }

    public Text getText12() {
        return text12;
    }

    public void setText12(Text text12) {
        this.text12 = text12;
    }

    public Combo getCombo7() {
        return combo7;
    }

    public void setCombo7(Combo combo7) {
        this.combo7 = combo7;
    }

    private Combo combo5;
    private Combo combo6;
    private Combo combo7;
    private GridData tableGridData;
    private RestJuegos verjuegos;
    private Shell shell;
    private MensajesError mensajesError;
    private Shell modalShell;
    private Display display;
    public Gui(Shell shell, RestJuegos verjuegos, MensajesError mensajesError,Display display) throws IOException {
        this.shell=shell;
        this.verjuegos=verjuegos;
        this.inicializar();
        this.initTable();
        this.mensajesError=mensajesError;
        this.addListeners();
        this.limpiarTextos();
        this.display=display;


    }

    public Button getButonEnviarModal() {
        return butonEnviarModal;
    }

    public void setButonEnviarModal(Button butonEnviarModal) {
        this.butonEnviarModal = butonEnviarModal;
    }

    public Button getButonCancelarModal() {
        return butonCancelarModal;
    }

    public void setButonCancelarModal(Button butonCancelarModal) {
        this.butonCancelarModal = butonCancelarModal;
    }

    public Shell getModalShell() {
        return modalShell;
    }

    public void setModalShell(Shell modalShell) {
        this.modalShell = modalShell;
    }

    public void newShell(JsonNode años){
        final String [ ] tipos = { "INVIERNO","VERANO" };


        GridData gridData1 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

        gridData1.horizontalSpan=2;
        Shell dialogShell = new Shell(display, SWT.APPLICATION_MODAL);
// populate dialogShell
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 2;
        dialogShell.setLayout(gridLayout);

        dialogShell.setLayout(gridLayout);
        this.label2  = new Label(dialogShell , SWT.PUSH);
        this.label2.setText("* Selecciona sede:");



        this.combo2  = new Combo(dialogShell , SWT.PUSH);
        //combo2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

        this.label5  = new Label(dialogShell , SWT.PUSH);
        this.label5.setText("Nuevo año:");

        Text text5=new Text(dialogShell , SWT.PUSH |SWT.BORDER);
        text5.setSize(Constante.TEXT_WIDTH,Constante.TEXT_HEIGHT);
        text5.setEditable(true);

        this.text5=text5;

        this.label7  = new Label(dialogShell , SWT.PUSH);
        this.label7.setText("Nuevo tipo de sede:");

        Combo combo7=new Combo(dialogShell , SWT.PUSH |SWT.BORDER);
        this.combo7=combo7;
        combo7.setItems(tipos);




        this.label9  = new Label(dialogShell , SWT.PUSH);
        this.label9.setText("Nuevo id de ciudad:");

        Text text9=new Text(dialogShell , SWT.PUSH |SWT.BORDER);
        text9.setSize(Constante.TEXT_WIDTH,Constante.TEXT_HEIGHT);
        text9.setEditable(true);

        this.text9=text9;
        this.label11  = new Label(dialogShell , SWT.PUSH);
        this.label11.setText("Nuevo nombre de ciudad:");

        Text text11=new Text(dialogShell , SWT.PUSH |SWT.BORDER);
        text11.setSize(Constante.TEXT_WIDTH,Constante.TEXT_HEIGHT);
        text11.setEditable(true);

        this.text11=text11;
        Button b4=new Button(dialogShell , SWT.PUSH);
        b4.setText("Enviar");

        b4.setLayoutData(gridData1);
        this.butonEnviarModal=b4;
        Button b5=new Button(dialogShell , SWT.PUSH);
        b5.setText("Cancelar");

        b5.setLayoutData(gridData1);
        this.butonCancelarModal=b5;

        this.modalShell=dialogShell;
        Listener listener=new EnviarListener(table,verjuegos,shell,mensajesError,combo2,this);
        this.butonEnviarModal.addListener(SWT.Selection,listener);
        listener=new CancelarListener(table,verjuegos,shell,mensajesError,combo2,this);
        this.butonCancelarModal.addListener(SWT.Selection,listener);
        for (JsonNode año:años){


            this.combo2.add(año.get("año").toString()+"-"+año.get("descripcion_tipo_jjoo").asText());



        }
        dialogShell.pack();
        dialogShell.open();

        while (!dialogShell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }


    }
    private void addListeners(){

        Listener listener=new ModificarListener(table,verjuegos,shell,mensajesError,combo2,this);
        button2.addListener(SWT.Selection,listener);
        listener=new EliminarListener(table,verjuegos,shell,mensajesError,combo2,this);
        button3.addListener(SWT.Selection,listener);
        listener=new EnviarListener(table,verjuegos,shell,mensajesError,combo2,this);
        button4.addListener(SWT.Selection,listener);
        listener=new AñadirListener(table,verjuegos,shell,mensajesError,combo2,this);
        button1.addListener(SWT.Selection,listener);
        listener=new CancelarListener(table,verjuegos,shell,mensajesError,combo2,this);
        button5.addListener(SWT.Selection,listener);
        listener=new SeleccionarListener(table,verjuegos,shell,mensajesError,combo2,this);
        table.addListener(SWT.Selection,listener);
    }

    public Label getLabel2() {
        return label2;
    }

    public void setLabel2(Label label2) {
        this.label2 = label2;
    }

    public Label getLabel3() {
        return label3;
    }

    public void setLabel3(Label label3) {
        this.label3 = label3;
    }

    public Label getLabel4() {
        return label4;
    }

    public void setLabel4(Label label4) {
        this.label4 = label4;
    }

    public Label getLabel5() {
        return label5;
    }

    public void setLabel5(Label label5) {
        this.label5 = label5;
    }

    public Text getText4() {
        return text4;
    }

    public void setText4(Text text4) {
        this.text4 = text4;
    }

    public Text getText5() {
        return text5;
    }

    public void setText5(Text text5) {
        this.text5 = text5;
    }

    public GridData getTableGridData() {
        return tableGridData;
    }

    public void setTableGridData(GridData tableGridData) {
        this.tableGridData = tableGridData;
    }

    public RestJuegos getVerjuegos() {
        return verjuegos;
    }

    public void setVerjuegos(RestJuegos verjuegos) {
        this.verjuegos = verjuegos;
    }

    public Shell getShell() {
        return shell;
    }

    public void setShell(Shell shell) {
        this.shell = shell;
    }

    public MensajesError getMensajesError() {
        return mensajesError;
    }

    public void setMensajesError(MensajesError mensajesError) {
        this.mensajesError = mensajesError;
    }

    private void inicializar(){
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 7;
        shell.setLayout(gridLayout);

        shell.setLayout(gridLayout);

        Button b1=new Button(shell, SWT.PUSH);
        b1.setText("Añadir sede");
        //b1.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        this.button1=b1;
        GridData gridData1 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

        gridData1.horizontalSpan=2;



        Button  b2=new Button(shell, SWT.PUSH);

        b2.setText("Modificar sede");

        this.button2=b2;

        Button b3=new Button(shell, SWT.PUSH);
        b3.setText("Eliminar sede");
        //b3.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        this.button3=b3;
        Table table = new Table(shell,   SWT.BORDER | SWT.V_SCROLL
                | SWT.H_SCROLL);
        this.button1.setLayoutData(gridData1);
        GridData gridData2 = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);

        gridData2.horizontalSpan=2;
        this.button2.setLayoutData(gridData2);

        this.button3.setLayoutData(gridData1);

        table.setHeaderVisible(true);
        String[] titles = { "Id  de la ciudad ","Ciudad ","Pais","Id del pais","Valor","Numero de veces que fue sede", "Tipo de sede " };
        GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

        gridData.verticalSpan = 20;

        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
            TableColumn column = new TableColumn(table, SWT.NULL);
            column.setText(titles[loopIndex]);
        }

        this.table=table;
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);

        gridData.verticalSpan = 28;
        this.tableGridData=gridData;



        gridData.heightHint = 10;

        this.table.setLayoutData(gridData);


        this.label1  = new Label(shell, SWT.PUSH);
        this.label1.setText("* Nombre de ciudad:");
        label1.setVisible(false);
        Text textField1=new Text(shell, SWT.PUSH |SWT.BORDER);
        textField1.setSize(Constante.TEXT_WIDTH,Constante.TEXT_HEIGHT);
        textField1.setEditable(true);
        this.text1=textField1;
        this.text1.setVisible(false);
        Label secondLabel = new Label (shell,SWT.NONE);
        secondLabel = new Label (shell,SWT.NONE);

        this.label3  = new Label(shell, SWT.PUSH);
        this.label3.setText("* Selecciona sede: ");
        label3.setVisible(false);

        this.combo3  = new Combo(shell, SWT.PUSH);
        //combo2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        combo3.setVisible(false);


        this.label4  = new Label(shell, SWT.PUSH);
        this.label4.setText("* Año sede:");
        label4.setVisible(false);
        Text text4=new Text(shell, SWT.PUSH |SWT.BORDER);
        text4.setSize(Constante.TEXT_WIDTH,Constante.TEXT_HEIGHT);
        text4.setEditable(true);
        text4.setVisible(false);
        this.text4=text4;
        secondLabel = new Label (shell,SWT.NONE);
        secondLabel = new Label (shell,SWT.NONE);
        Button b4=new Button(shell, SWT.PUSH);
        b4.setText("Enviar");
        b4.setVisible(false);
        b4.setLayoutData(gridData1);
        this.button4=b4;

        this.label6  = new Label(shell, SWT.PUSH);
        this.label6.setText("* Tipo de sede:");
        label6.setVisible(false);
        Combo combo6=new Combo(shell, SWT.PUSH |SWT.BORDER);
        this.combo6=combo6;
        combo6.setVisible(false);
        final String [ ] tipos = { "INVIERNO","VERANO" };
        combo6.setItems(tipos);
        secondLabel = new Label (shell,SWT.NONE);
        secondLabel = new Label (shell,SWT.NONE);
        Button b5=new Button(shell, SWT.PUSH);
        b5.setText("Cancelar");
        b5.setVisible(false);
        b5.setLayoutData(gridData1);
        this.button5=b5;
        this.label8  = new Label(shell, SWT.PUSH);
        this.label8.setText("Pais:");
        label8.setVisible(false);
        Text text8=new Text(shell, SWT.PUSH |SWT.BORDER);
        text8.setSize(Constante.TEXT_WIDTH,Constante.TEXT_HEIGHT);
        text8.setEditable(true);
        text8.setVisible(false);
        this.text8=text8;

        secondLabel = new Label (shell,SWT.NONE);
        secondLabel = new Label (shell,SWT.NONE);
        secondLabel = new Label (shell,SWT.NONE);
        secondLabel = new Label (shell,SWT.NONE);
        this.label10  = new Label(shell, SWT.PUSH);
        this.label10.setText("Codigo de pais:");
        label10.setVisible(false);
        Text text10=new Text(shell, SWT.PUSH |SWT.BORDER);

        text10.setSize(Constante.TEXT_WIDTH,Constante.TEXT_HEIGHT);
        text10.setEditable(true);
        text10.setVisible(false);
        this.text10=text10;
        secondLabel = new Label (shell,SWT.NONE);
        secondLabel = new Label (shell,SWT.NONE);

        secondLabel = new Label (shell,SWT.NONE);
        secondLabel = new Label (shell,SWT.NONE);
        this.label12  = new Label(shell, SWT.PUSH);
        this.label12.setText("Valor de ciudad:");
        label12.setVisible(false);
        Text text12=new Text(shell, SWT.PUSH |SWT.BORDER);

        text12.setSize(Constante.TEXT_WIDTH,Constante.TEXT_HEIGHT);
        text12.setEditable(true);
        text12.setVisible(false);
        this.text12=text12;
        secondLabel = new Label (shell,SWT.NONE);
        secondLabel = new Label (shell,SWT.NONE);
        secondLabel = new Label (shell,SWT.NONE);
        secondLabel = new Label (shell,SWT.NONE);
        this.label13  = new Label(shell, SWT.PUSH);
        this.label13.setText("Valor de pais:");
        label13.setVisible(false);
        Text text13=new Text(shell, SWT.PUSH |SWT.BORDER);
        text13.setSize(Constante.TEXT_WIDTH,Constante.TEXT_HEIGHT);
        text13.setEditable(true);
        text13.setVisible(false);
        this.text13=text13;
        this.button2.setEnabled(false);
        this.button3.setEnabled(false);













    }
    private void update(){



    }
    public void limpiarTextos(){
        this.text1.setText("");

        this.text4.setText("");

        this.text8.setText("");

        this.text10.setText("");

        this.text12.setText("");
        this.text13.setText("");



        this.combo3.deselectAll();


        this.combo6.deselectAll();





    }

    private Combo combo8;

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button button1) {
        this.button1 = button1;
    }
    public void initTable() throws IOException {

        this.table.removeAll();
        JsonNode  juegos=this.verjuegos.pedirJuegos();
        for (JsonNode i : juegos){
            TableItem item = new TableItem(this.table, SWT.PUSH);


            if (i.get("descripcion_tipo_jjoo").asText()!="null")
                item.setText(6,i.get("descripcion_tipo_jjoo").asText());
            item.setText(1,i.get("nombre_ciudad").asText());
            item.setText(0,i.get("id_ciudad").asText());
            item.setText(2,i.get("nombre_pais").asText());
            item.setText(3,i.get("id_pais").asText());
            item.setText(4,i.get("valor").asText());
            item.setText(5,i.get("numero_veces_sede").asText());

        }
        for (int loopIndex = 0; loopIndex < table.getColumnCount(); loopIndex++) {
            table.getColumn(loopIndex).pack();
        }
        table.setBounds(25, 25, 220, 200);

    }
    public void updateTable() throws IOException {

        this.table.removeAll();
        JsonNode  juegos=this.verjuegos.pedirJuegos();
        for (JsonNode i : juegos){
            TableItem item = new TableItem(this.table, SWT.PUSH);


            if (i.get("descripcion_tipo_jjoo").asText()!="null")
                item.setText(6,i.get("descripcion_tipo_jjoo").asText());
            item.setText(1,i.get("nombre_ciudad").asText());
            item.setText(0,i.get("id_ciudad").asText());
            item.setText(2,i.get("nombre_pais").asText());
            item.setText(3,i.get("id_pais").asText());
            item.setText(4,i.get("valor").asText());
            item.setText(5,i.get("numero_veces_sede").asText());

        }

    }

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button button2) {
        this.button2 = button2;
    }

    public Button getButton3() {
        return button3;
    }

    public void setButton3(Button button3) {
        this.button3 = button3;
    }

    public Button getButton4() {
        return button4;
    }

    public void setButton4(Button button4) {
        this.button4 = button4;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }



    public Combo getCombo2() {
        return combo2;
    }

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label label1) {
        this.label1 = label1;
    }

    public Text getText1() {
        return text1;
    }

    public void setText1(Text text1) {
        this.text1 = text1;
    }

    public void setCombo2(Combo combo2) {
        this.combo2 = combo2;
    }

    public Combo getCombo3() {
        return combo3;
    }

    public void setCombo3(Combo combo3) {
        this.combo3 = combo3;
    }

    public Combo getCombo4() {
        return combo4;
    }

    public void setCombo4(Combo combo4) {
        this.combo4 = combo4;
    }

    public Combo getCombo5() {
        return combo5;
    }

    public void setCombo5(Combo combo5) {
        this.combo5 = combo5;
    }

    public Combo getCombo6() {
        return combo6;
    }

    public void setCombo6(Combo combo6) {
        this.combo6 = combo6;
    }



    public Combo getCombo8() {
        return combo8;
    }

    public void setCombo8(Combo combo8) {
        this.combo8 = combo8;
    }
}
