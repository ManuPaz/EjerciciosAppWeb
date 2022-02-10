import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import peticionesRest.VerJuegos;
public class CustomShell extends Shell {
    private Button b1;
    private Button b2;
    private Button b3;
    private Table table;
    private Combo combo1;
    private Combo combo2;
    private Combo combo3;
    private VerJuegos verjuegos;
    public CustomShell(Display display) throws JsonProcessingException {
        super(display);

        this.verjuegos=new VerJuegos("http://localhost:8080/juegos","admin","manuel");
        JsonNode juegos=this.verjuegos.pedirJuegos();

        Shell shell=this;
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 3;

        shell.setLayout(gridLayout);

        Button b=new Button(shell, SWT.PUSH);
        b.setText("Añadir sede");
        b.addListener(SWT.Dispose, new Listener() {
            public void handleEvent(Event event) {
                // widget was disposed
            }
        });




        b.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        final Combo combo  = new Combo(shell, SWT.PUSH);
        combo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

        String[] items = new String[] { "English", "Vietnamese" };
        combo.setItems(items);
        b=new Button(shell, SWT.PUSH);
        b.setText("Modificar sede");
        b.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                switch (e.type) {
                    case SWT.Selection:
                        String[] items = new String[] { "Manu","Jaco" };
                        combo.setItems(items);
                        break;
                }
            }
        });

        final Combo combo1  = new Combo(shell, SWT.PUSH);
        combo1.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        b.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING ));
        b=new Button(shell, SWT.PUSH);
        b.setText("Eliminar sede");
        b.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        final Combo combo2 = new Combo(shell, SWT.PUSH);
        combo2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));


        GridLayout gridLayout2 = new GridLayout();

        gridLayout2.numColumns = 1;

        shell.setLayout(gridLayout2);


        Table table = new Table(shell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL
                | SWT.H_SCROLL);
        table.setHeaderVisible(true);
        String[] titles = { "Id  de la ciudad ","Ciudad ","Pais","Id del pais","Valor","Numero de veces que fue sede","Año ", "Tipo de sede " };
        GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

        gridData.verticalSpan = 20;
        table.setLayoutData(gridData);
        table.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
            TableColumn column = new TableColumn(table, SWT.NULL);
            column.setText(titles[loopIndex]);
        }
        for (JsonNode i : juegos){
            TableItem item = new TableItem(table, SWT.PUSH);
            if (i.get("año").asText()!="null")
                item.setText(6,i.get("año").asText());
            if (i.get("descripcion_tipo_jjoo").asText()!="null")
                item.setText(7,i.get("descripcion_tipo_jjoo").asText());
            item.setText(1,i.get("nombre_ciudad").asText());
            item.setText(0,i.get("id_ciudad").asText());
            item.setText(2,i.get("nombre_pais").asText());
            item.setText(3,i.get("id_pais").asText());
            item.setText(4,i.get("valor").asText());
            item.setText(5,i.get("numero_veces_sede").asText());

        }



        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
            table.getColumn(loopIndex).pack();
        }

        table.setBounds(25, 25, 220, 200);








    }

    public Button getB1() {
        return b1;
    }

    public Button getB2() {
        return b2;
    }

    public Button getB3() {
        return b3;
    }

    public Table getTable() {
        return table;
    }




}
