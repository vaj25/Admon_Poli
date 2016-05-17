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

public class AdministradorEliminarActivity extends Activity {
    //EditText editId;
    Spinner sAdmin;
    List<Administrador> lista;
    ControlBD controlhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_eliminar);
        controlhelper= new ControlBD(this);
        sAdmin = (Spinner) findViewById(R.id.selectEliminarAdministrador);
        lista = new ArrayList<>();
        lista=controlhelper.consultaAdministrador();///////////////////////////////////////
        ArrayAdapter<Administrador> adaptador =new ArrayAdapter<Administrador>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sAdmin.setAdapter(adaptador);
       // editId=(EditText)findViewById(R.id.editIdEliminarAdmin);
    }

    public void eliminarAdministrador(View v){
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
        int regEliminadas;
        Administrador administrador= new Administrador();
        administrador.setIdAdministrador(idadmin);
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(administrador);
        controlhelper.cerrar();
        Toast.makeText(this,"filas afectadas="+ regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
