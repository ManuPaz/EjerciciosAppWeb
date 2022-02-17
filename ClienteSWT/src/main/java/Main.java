import avisos.MensajesError;
import interfaz.Gui;
import org.eclipse.swt.widgets.*;
import peticionesRest.RestJuegos;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Main


{
    public static void main(String[] args) throws IOException, ParseException {
        Display display = new Display();
        Shell shell = new Shell(display);
        MensajesError mensajesError=new MensajesError(shell);

       InputStream input = Main.class.getClassLoader().getResourceAsStream("dev.properties");

       Properties prop = new Properties();



        //load a properties file from class path, inside static method
        prop.load(input);

        //get the property value and print it out




        String user =prop.getProperty("user");
        String password = prop.getProperty("password");
        System.out.println(user);

        RestJuegos verjuegos=new RestJuegos("http://localhost:8080",user,password,mensajesError);

        Gui gui=new Gui(shell,verjuegos,mensajesError,display);


        shell.pack();

        shell.open();

        while (!shell.isDisposed()) {

            if (!display.readAndDispatch()) display.sleep();

        }display.sleep();
        }

    }
