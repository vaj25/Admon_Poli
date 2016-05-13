package gr23.fia.ues.sv.admon_poli;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
public class HorarioConsultarActivity extends Activity {
    ControlBD helper;
    EditText IdHorario;  //id del campo en  layout
    EditText Hora;
    EditText Dia;
    CheckBox Cheked;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_horario_consultar);
        helper = new ControlBD(this);
        IdHorario = (EditText) findViewById(R.id.IdHorario);
        Dia = (EditText) findViewById(R.id.Dia);
        Hora = (EditText) findViewById(R.id.Hora);
        Cheked = (CheckBox) findViewById(R.id.Instruct);
    }
    public void consultarHorario(View v) {
        helper.abrir();
        String idhorario=IdHorario.getText().toString();
        Horario horario = helper.consultarHorario(Integer.parseInt(idhorario));
        helper.cerrar();
        if(horario == null)
            Toast.makeText(this, "Horario con Id " + IdHorario.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();

        else{
            Dia.setText(horario.getDia());
            Hora.setText(horario.getHora());
            Cheked.setChecked(horario.getInstructor());
        }
    }
    public void limpiarTexto(View v){
        IdHorario.setText("");
        Hora.setText("");
        Dia.setText("");
        Cheked.setChecked(false);
    }
}