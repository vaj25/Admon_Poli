package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class HorarioEliminarActivity extends Activity {
    EditText IdHorario;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_eliminar);
        controlhelper=new ControlBD (this);
        IdHorario=(EditText)findViewById(R.id.IdHorario);
    }
    public void eliminarHorario(View v){
        String regEliminadas;
        Horario horario=new Horario();
        String idhorario=IdHorario.getText().toString();
        horario.setIdHorario(Integer.parseInt(idhorario));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(horario);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
