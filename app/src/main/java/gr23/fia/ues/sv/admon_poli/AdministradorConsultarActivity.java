package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdministradorConsultarActivity extends Activity {
    ControlBD helper;
    EditText editIdAdmin;
    EditText editTelefono;
    EditText editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_consultar);
        helper= new ControlBD(this);
        editIdAdmin= (EditText)findViewById(R.id.editIdConsultarAdmin);
        editTelefono= (EditText)findViewById(R.id.editTelefonoConsultar);
        editEmail= (EditText)findViewById(R.id.editEmailAdConsultar);
    }
    public void consultarAdministrador(View v){
        helper.abrir();
        Administrador administrador= helper.consultar(Integer.parseInt(editIdAdmin.getText().toString()));
        helper.cerrar();
        if (administrador==null)
            Toast.makeText(this, "El administrador " + editIdAdmin.getText().toString() +
                    " no fue encontrado", Toast.LENGTH_LONG).show();
        else {
            Toast.makeText(this,"el emaail"+administrador.getEmailadmin(),Toast.LENGTH_LONG);

            editTelefono.setText(String.valueOf(administrador.getTelefonoadmin()));
            editEmail.setText(administrador.getEmailadmin());
        }
    }

    public void limpiarTexto(View v){
        editIdAdmin.setText("");
        editTelefono.setText("");
        editEmail.setText("");
    }
}
