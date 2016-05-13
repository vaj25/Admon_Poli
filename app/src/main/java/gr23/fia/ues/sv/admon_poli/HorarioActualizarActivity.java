package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class HorarioActualizarActivity extends Activity {

    ControlBD helper;
    EditText IdHorario;  //id del campo en  layout
    EditText Hora;
    EditText Dia;
    CheckBox Cheked;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_actualizar);
        helper = new ControlBD(this);
        IdHorario = (EditText) findViewById(R.id.IdHorario);
        Hora = (EditText) findViewById(R.id.Hora);
        Dia = (EditText) findViewById(R.id.Dia);
        Cheked = (CheckBox) findViewById(R.id.Instruct);
    }

    public void actualizarHorario(View v) {
        Horario horario = new Horario();
        horario.setIdHorario(Integer.parseInt(IdHorario.getText().toString()));
        horario.setHora(Hora.getText().toString());
        horario.setDia(Dia.getText().toString());
        horario.setInstructor(Cheked.isChecked());
        helper.abrir();
        String estado = helper.actualizar(horario);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {   //metodo convocado en el evento onclick del boton limpiar en el layout
        IdHorario.setText("");
        Hora.setText("");
        Dia.setText("");
        Cheked.setChecked(false);
    }
}