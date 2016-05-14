package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdministradorActualizarActivity extends Activity {
    ControlBD helper;
    EditText editIdAdmin;
    EditText editTelefono;
    EditText editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_actualizar);
        helper= new ControlBD(this);
        editIdAdmin = (EditText)findViewById(R.id.editIdAdminActualizar);
        editTelefono=(EditText) findViewById(R.id.editTelefonoActualizar);
        editEmail=(EditText)findViewById(R.id.editEmailActualizar);
    }
    public void actualizarAdministrador(View v){
        Administrador administrador= new Administrador();
        administrador.setIdAdministrador( Integer.parseInt(editIdAdmin.getText().toString()));
        administrador.setTelefonoadmin(Integer.parseInt(editTelefono.getText().toString()));
        helper.abrir();
        String stado=helper.actualizar(administrador);
        helper.cerrar();
        Toast.makeText(this, stado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdAdmin.setText("");
        editTelefono.setText("");
        editEmail.setText("");
    }
}
