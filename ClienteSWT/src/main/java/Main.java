import avisos.MensajesError;
import com.fasterxml.jackson.databind.JsonNode;
import listeners.ModificarListener;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import peticionesRest.VerJuegos;

import java.io.IOException;

public class Main


{
    public static void main(String[] args) throws IOException {
        Display display = new Display();
        Shell shell = new Shell(display);
        MensajesError mensajesError=new MensajesError(shell);
        VerJuegos verjuegos=new VerJuegos("http://localhost:8080","admin","manuel",mensajesError);
        JsonNode juegos=verjuegos.pedirJuegos();



        //shell.setSize(280, 300);

        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 3;

        shell.setLayout(gridLayout);

        Button b1=new Button(shell, SWT.PUSH);
        b1.setText("Añadir sede");




        b1.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));



        Button  b2=new Button(shell, SWT.PUSH);
        b2.setText("Modificar sede");



        //GridData grid2=new GridData(GridData.HORIZONTAL_ALIGN_FILL );
        //b2.setLayoutData(grid2);

        //b4.setLayoutData(grid2);
        Button b3=new Button(shell, SWT.PUSH);
        b3.setText("Eliminar sede");
        b3.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        final Combo combo3  = new Combo(shell, SWT.PUSH);
        //combo2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        combo3.setVisible(false);
        final Combo combo2  = new Combo(shell, SWT.PUSH);
        //combo2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        combo2.setVisible(false);

        final Combo combo4  = new Combo(shell, SWT.PUSH);
        //combo2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        combo4.setVisible(false);

        Button b4=new Button(shell, SWT.PUSH);
        b4.setText("Enviar");
        final Combo combo5  = new Combo(shell, SWT.PUSH);
        //combo2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        combo5.setVisible(false);
        final Combo combo6  = new Combo(shell, SWT.PUSH);
        //combo2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        combo6.setVisible(false);
        final Combo combo7  = new Combo(shell, SWT.PUSH);
        //combo2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        combo7.setVisible(false);
        final Combo combo8  = new Combo(shell, SWT.PUSH);
        //combo2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        combo8.setVisible(false);






        Table table = new Table(shell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL
                | SWT.H_SCROLL);

        table.setHeaderVisible(true);
        String[] titles = { "Id  de la ciudad ","Ciudad ","Pais","Id del pais","Valor","Numero de veces que fue sede", "Tipo de sede " };
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

            if (i.get("descripcion_tipo_jjoo").asText()!="null")
            item.setText(6,i.get("descripcion_tipo_jjoo").asText());
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



        Listener listener=new ModificarListener(table,verjuegos,shell,mensajesError,combo2);
        b2.addListener(SWT.Selection,listener);

        shell.pack();

        shell.open();

        while (!shell.isDisposed()) {

            if (!display.readAndDispatch()) display.sleep();

        }display.sleep();
        }

    }
