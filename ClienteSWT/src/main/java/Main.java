import avisos.MensajesError;
import interfaz.Gui;
import org.eclipse.swt.widgets.*;
import peticionesRest.RestJuegos;

import java.io.IOException;

public class Main


{
    public static void main(String[] args) throws IOException {
        Display display = new Display();
        Shell shell = new Shell(display);
        MensajesError mensajesError=new MensajesError(shell);
        RestJuegos verjuegos=new RestJuegos("http://localhost:8080","admin","manuel",mensajesError);

        Gui gui=new Gui(shell,verjuegos,mensajesError,display);


        shell.pack();

        shell.open();

        while (!shell.isDisposed()) {

            if (!display.readAndDispatch()) display.sleep();

        }display.sleep();
        }

    }
