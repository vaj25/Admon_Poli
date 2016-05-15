package gr23.fia.ues.sv.admon_poli;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class HorarioInsertarActivity extends Activity {

    ControlBD helper;
    EditText IdHorario;  //id del campo en  layout
    EditText Hora;
    EditText Dia;
    CheckBox Cheked;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_insertar);
        helper = new ControlBD(this);
        IdHorario = (EditText) findViewById(R.id.IdHorario);
        Hora = (EditText) findViewById(R.id.Hora);
        Dia = (EditText) findViewById(R.id.Dia);
        Cheked = (CheckBox) findViewById(R.id.Instruct);

    }

    public void insertarHorario(View v) {                  //metodo convocado en el evento onclick del boton insertar en el layout
        int idhorario=helper.contarRegistros("horario ","idhorario");
        String hora=Hora.getText().toString();
        String dia=Dia.getText().toString();
        boolean checked = Cheked.isChecked();
        String regInsertados;
        Horario horario =new Horario();
        horario.setIdHorario(idhorario);
        horario.setHora(hora);
        horario.setDia(dia);
        horario.setInstructor(checked);
        helper.abrir();
        regInsertados=helper.insertar(horario);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {   //metodo convocado en el evento onclick del boton limpiar en el layout
        Hora.setText("");
        Dia.setText("");
        Cheked.setChecked(false);
    }
}