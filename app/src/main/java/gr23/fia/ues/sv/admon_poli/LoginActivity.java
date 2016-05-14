package gr23.fia.ues.sv.admon_poli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ControlBD helper ;
    EditText username ;
    EditText password ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        helper = new ControlBD(this) ;
        helper.abrir();
        String tost = helper.llenarBD();
        helper.cerrar();

        username = (EditText)findViewById(R.id.editUsername);
        password = (EditText)findViewById(R.id.editPassword);

    }

    public void login(View v){

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if(validate())
            return ;

        Usuario u = new Usuario() ;
        u.setNomUsuario(user) ;
        u.setClave(pass) ;

        u = helper.verificarCredenciales(u) ;
        if(u != null){
            try {
                Class<?> clase = Class.forName("gr23.fia.ues.sv.admon_poli.MainActivity");
                Intent inte = new Intent(LoginActivity.this, clase);
                inte.putExtra("nomUsuario", u.getNomUsuario());
                inte.putExtra("idUsuario", u.getIdUsuario());
                startActivity(inte);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else{
            Toast.makeText(getBaseContext(), "Error Credenciales Incorrectas", Toast.LENGTH_LONG).show();
        }
    }

    private boolean validate(){

        boolean r = false;

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (user.isEmpty()) {
            Toast.makeText(getBaseContext(), "Error Usuario NULL", Toast.LENGTH_LONG).show();
            r = true ;
        }

        if(pass.isEmpty()){
            Toast.makeText(getBaseContext(), "Error Contraseña NULL", Toast.LENGTH_LONG).show();
            r = true ;
        } else if(pass.length() < 3 || pass.length() > 5){
            Toast.makeText(getBaseContext(), "Error Contraseña Entre 3 y 5 Caracteres", Toast.LENGTH_LONG).show();
            r = true ;
        }

        return r ;
    }
}
