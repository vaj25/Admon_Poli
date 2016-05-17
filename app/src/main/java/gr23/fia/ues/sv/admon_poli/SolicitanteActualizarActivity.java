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

public class SolicitanteActualizarActivity extends Activity {

    ControlBD helper;
    //  EditText IdReserva;  //id del campo en  layout

    EditText telefonoSol;
    EditText emailSol;

    Spinner sSolicitante;
    List<String> lista;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitante_actualizar);
        helper = new ControlBD(this);
        //IdReserva = (EditText) findViewById(R.id.IdReserva);
        telefonoSol = (EditText) findViewById(R.id.telefono);
        emailSol = (EditText) findViewById(R.id.email);

        sSolicitante = (Spinner) findViewById(R.id.selectSolicitante);

        lista = new ArrayList<>();
        lista=helper.consultaSolicitante();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSolicitante.setAdapter(adaptador);

    }

    public void actualizarSolicitante(View v) {
        int position= sSolicitante.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        String idsolicitante="";
        while( iterador.hasNext() ) {
            Solicitante solicitante = (Solicitante) iterador.next();
            if(count==position){
                idsolicitante=solicitante.getDui();
            }
            count++;
        }

        Solicitante soli = new Solicitante();
        Solicitante sol = new Solicitante();
        sol = helper.consultarSolicitante(idsolicitante);
        soli.setDui(sol.getDui());
        soli.setNombreSol(sol.getNombreSol());
        soli.setApellidoSol(sol.getApellidoSol());
        soli.setTelefonoSol(Integer.parseInt(telefonoSol.getText().toString()));
        soli.setMail(emailSol.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(soli);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {   //metodo convocado en el evento onclick del boton limpiar en el layout
        telefonoSol.setText("");
        emailSol.setText("");
    }
}