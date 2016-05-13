package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdministradorInsertarActivity extends Activity {
    ControlBD helper;
    EditText editIdAdmin;
    EditText editTelefono;
    EditText editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_insertar);
        helper =new ControlBD(this);
        editIdAdmin=(EditText)findViewById(R.id.editIdAdmin);
        editTelefono=(EditText)findViewById(R.id.editTelefonoActualizar);
        editEmail=(EditText)findViewById(R.id.editEmail);
    }

    public void insertarAdministrador(View v){
        int idAdmin = Integer.parseInt(editIdAdmin.getText().toString());
        int telAdmin = Integer.parseInt(editTelefono.getText().toString());
        String email= editEmail.getText().toString();
        String regInsertados;
        Administrador administrador= new Administrador();
        administrador.setIdAdministrador(idAdmin);
        administrador.setTelefonoadmin(telAdmin);
        administrador.setEmailadmin(email);
        helper.abrir();
        regInsertados=helper.insertar(administrador);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdAdmin.setText("");
        editTelefono.setText("");
        editEmail.setText("");
    }
}
