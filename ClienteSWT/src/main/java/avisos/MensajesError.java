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
        MessageBox messageBox = new MessageBox(this.shell, SWT.OK
                | SWT.ICON_WARNING);
        messageBox.setMessage(mensaje);
        messageBox.open();

    }
}
