package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolicitanteInsertarActivity extends Activity {

    ControlBD helper;
    //EditText IdReserva;  //id del campo en  layout
    EditText Dui;
    EditText NombreSol;
    EditText ApellidoSol;
    EditText TelefonoSol;
    EditText EmailSol;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitante_insertar);
        helper = new ControlBD(this);
        Dui = (EditText) findViewById(R.id.dui);
        NombreSol = (EditText) findViewById(R.id.nombreSol);
        ApellidoSol = (EditText) findViewById(R.id.apellidoSol);
        TelefonoSol = (EditText) findViewById(R.id.telefono);
        EmailSol = (EditText) findViewById(R.id.email);


    }

    public void insertarSolicitante(View v) {
        //int idhorario=helper.contarRegistros("horario ","idhorario");
        String dui=Dui.getText().toString();
        String nombreSol=NombreSol.getText().toString();
        String apellidoSol=ApellidoSol.getText().toString();
        String telefono=TelefonoSol.getText().toString();
        String email=EmailSol.getText().toString();
        String regInsertados;
        Solicitante sol =new Solicitante();
        sol.setDui(dui);
        sol.setNombreSol(nombreSol);
        sol.setApellidoSol(apellidoSol);
        sol.setTelefonoSol(Integer.valueOf(telefono));
        sol.setMail(email);
        helper.abrir();
        regInsertados=helper.insertar(sol);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {   //metodo convocado en el evento onclick del boton limpiar en el layout
        Dui.setText("");
        NombreSol.setText("");
        ApellidoSol.setText("");
        TelefonoSol.setText("");
        EmailSol.setText("");
    }
}
