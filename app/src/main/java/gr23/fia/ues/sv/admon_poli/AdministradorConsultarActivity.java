package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdministradorConsultarActivity extends Activity {
    ControlBD helper;
    //EditText editIdAdmin;
    Spinner sAdmin;
    List<Administrador> lista;
    EditText editTelefono;
    EditText editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_consultar);
        helper= new ControlBD(this);
        sAdmin = (Spinner) findViewById(R.id.selectAdministrador);
        lista = new ArrayList<>();
        //editIdAdmin= (EditText)findViewById(R.id.editIdConsultarAdmin);
        lista=helper.consultaAdministrador();///////////////////////////////////////
        ArrayAdapter<Administrador> adaptador =new ArrayAdapter<Administrador>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sAdmin.setAdapter(adaptador);
        editTelefono= (EditText)findViewById(R.id.editTelefonoConsultar);
        editEmail= (EditText)findViewById(R.id.editEmailAdConsultar);
    }
    public void consultarAdministrador(View v){
        int position= sAdmin.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        int idadmin=0;
        while( iterador.hasNext() ) {
            Administrador admin = (Administrador) iterador.next();
            if(count==position){
                idadmin=admin.getIdAdministrador();
            }
            count++;
        }
        helper.abrir();

        Administrador administrador = helper.consultar(idadmin);
        helper.cerrar();
        if(administrador == null)
            Toast.makeText(this, "Administrador con Identificador " + String.valueOf(idadmin) +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editTelefono.setText("Telefono: "+ "\n"+administrador.getTelefonoadmin());
            editEmail.setText("Email: "+ "\n"+administrador.getEmailadmin());
        }
    }

    public void limpiarTexto(View v){
        //editIdAdmin.setText("");
        editTelefono.setText("");
        editEmail.setText("");
    }
}
