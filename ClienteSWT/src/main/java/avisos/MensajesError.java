package avisos;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class MensajesError {

    private Shell shell;

    public MensajesError(Shell shell) {
        this.shell = shell;
    }
    public void avisar(String mensaje){
        MessageBox messageBox = new MessageBox(this.shell, SWT.ERROR);
        messageBox.setMessage(mensaje);
        messageBox.open();

    }
    public void confirmar(String mensaje){
        MessageBox messageBox = new MessageBox(this.shell, SWT.ICON_INFORMATION);
        messageBox.setMessage(mensaje);
        messageBox.open();

    }
}
