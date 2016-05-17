package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdministradorActualizarActivity extends Activity {
    ControlBD helper;
    //EditText editIdAdmin;
    EditText editTelefono;
    EditText editEmail;
    Spinner sAdmin;
    List<Administrador> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_actualizar);
        helper= new ControlBD(this);
        //editIdAdmin = (EditText)findViewById(R.id.editIdAdminActualizar);
        sAdmin = (Spinner) findViewById(R.id.selectActualizarAdministrador);
        lista = new ArrayList<>();
        lista=helper.consultaAdministrador();///////////////////////////////////////
        ArrayAdapter<Administrador> adaptador =new ArrayAdapter<Administrador>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sAdmin.setAdapter(adaptador);
        editTelefono=(EditText) findViewById(R.id.editTelefonoActualizar);
        editEmail=(EditText)findViewById(R.id.editEmailActualizar);
    }
    public void actualizarAdministrador(View v){
        int position= sAdmin.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        int idadmin=0;
        while( iterador.hasNext() ) {
            Administrador administrador = (Administrador) iterador.next();
            if(count==position){
                idadmin=administrador.getIdAdministrador();
            }
            count++;
        }
        Administrador administrador= new Administrador();
        administrador.setIdAdministrador(idadmin);
        administrador.setTelefonoadmin(Integer.parseInt(editTelefono.getText().toString()));
        administrador.setEmailadmin(editEmail.getText().toString());
        helper.abrir();
        String stado=helper.actualizar(administrador);
        helper.cerrar();
        Toast.makeText(this, stado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        //editIdAdmin.setText("");
        editTelefono.setText("");
        editEmail.setText("");
    }
}
