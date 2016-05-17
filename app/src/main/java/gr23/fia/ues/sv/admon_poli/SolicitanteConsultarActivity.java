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

public class SolicitanteConsultarActivity extends Activity {
    ControlBD helper;
    //EditText IdHorario;  //id del campo en  layout
    EditText dui;
    EditText nombreSol;
    EditText apellidoSol;
    EditText telefonoSol;
    EditText emailSol;

    Spinner sSolicitante;
    List<String> lista;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_solicitante_consultar);
        helper = new ControlBD(this);
        //IdHorario = (EditText) findViewById(R.id.IdHorario);
        dui = (EditText) findViewById(R.id.dui);
        nombreSol = (EditText) findViewById(R.id.nombreSol);
        apellidoSol = (EditText) findViewById(R.id.apellidoSol);
        telefonoSol = (EditText) findViewById(R.id.telefono);
        emailSol = (EditText) findViewById(R.id.email);
        sSolicitante = (Spinner) findViewById(R.id.selectSolicitante);

        lista = new ArrayList<>();
        lista=helper.consultaSolicitante();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSolicitante.setAdapter(adaptador);

    }
    public void consultarSolicitante(View v) {
        helper.abrir();
        //String idhorario=IdHorario.getText().toString();
        int position= sSolicitante.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        String idsolicitante="";
        while( iterador.hasNext() ) {
            Solicitante sol = (Solicitante) iterador.next();
            if(count==position){
                idsolicitante=sol.getDui();
            }
            count++;
        }
        Solicitante solicitante = helper.consultarSolicitante(idsolicitante);
        helper.cerrar();
        if(solicitante == null)
            Toast.makeText(this, "Horario no encontrado", Toast.LENGTH_LONG).show();

        else{
            dui.setText(solicitante.getDui());
            nombreSol.setText(solicitante.getNombreSol());
            apellidoSol.setText(solicitante.getApellidoSol());
            telefonoSol.setText(String.valueOf(solicitante.getTelefonoSol()));
            emailSol.setText(solicitante.getMail());
        }
    }
    public void limpiarTexto(View v){
        dui.setText("");
        nombreSol.setText("");
        apellidoSol.setText("");
        telefonoSol.setText("");
        emailSol.setText("");
    }
}