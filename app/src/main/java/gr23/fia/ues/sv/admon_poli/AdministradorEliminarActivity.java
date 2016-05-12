package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdministradorEliminarActivity extends Activity {
    EditText editId;
    ControlBD controlhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_eliminar);
        controlhelper= new ControlBD(this);
        editId=(EditText)findViewById(R.id.editIdEliminarAdmin);
    }

    public void eliminarAdministrador(View v){
        String regEliminadas;
        Administrador administrador= new Administrador();
        administrador.setIdAdministrador(Integer.parseInt(editId.getText().toString()));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(administrador);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
