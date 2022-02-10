import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Main
{
    public static void main(String[] args)
    {
        Display display = new Display();

        Shell shell = new Shell(display);
        //shell.setSize(280, 300);

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

        final Text text = new Text(shell, SWT.BORDER);
        text.setBounds(25, 240, 220, 25);

        Table table = new Table(shell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL
                | SWT.H_SCROLL);
        table.setHeaderVisible(true);
        String[] titles = { "Año ", "Tipo de sede ", "Ciudad ", "Id  de la ciudad ","Pais","Id del pais","Valor","Numero de veces que fue sede" };
        GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

        gridData.verticalSpan = 20;
        table.setLayoutData(gridData);
        table.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
            TableColumn column = new TableColumn(table, SWT.NULL);
            column.setText(titles[loopIndex]);
        }

        for (int loopIndex = 0; loopIndex < 24; loopIndex++) {
            TableItem item = new TableItem(table, SWT.NULL);
            item.setText("Item " + loopIndex);
            item.setText(0, "Item " + loopIndex);
            item.setText(1, "Yes");
            item.setText(2, "No");
            item.setText(3, "A table item");
        }

        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
            table.getColumn(loopIndex).pack();
        }

        table.setBounds(25, 25, 220, 200);

        table.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                if (event.detail == SWT.CHECK) {
                    text.setText("You checked " + event.item);
                } else {
                    text.setText("You selected " + event.item);
                }
            }
        });



        shell.pack();

        shell.open();

        while (!shell.isDisposed()) {

            if (!display.readAndDispatch()) display.sleep();

        }display.sleep();
        }

    }
