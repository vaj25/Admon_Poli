package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HorarioActualizarActivity extends Activity {

    ControlBD helper;
    //EditText IdHorario;  //id del campo en  layout
    EditText Hora;
    EditText Dia;
    CheckBox Cheked;
    Spinner sHorario;
    List<String> lista;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_actualizar);
        helper = new ControlBD(this);
       // IdHorario = (EditText) findViewById(R.id.IdHorario);
        Hora = (EditText) findViewById(R.id.Hora);
        Dia = (EditText) findViewById(R.id.Dia);
        Cheked = (CheckBox) findViewById(R.id.Instruct);
        sHorario = (Spinner) findViewById(R.id.selectHorario);

        lista = new ArrayList<>();
        lista=helper.consultaHorario();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sHorario.setAdapter(adaptador);
    }

    public void actualizarHorario(View v) {
        int position= sHorario.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        int idhorario=0;
        while( iterador.hasNext() ) {
            Horario hor = (Horario) iterador.next();
            if(count==position){
                idhorario=hor.getIdHorario();
            }
            count++;
        }
        Horario horario = new Horario();
        horario.setIdHorario(idhorario);
        horario.setHora(Hora.getText().toString());
        horario.setDia(Dia.getText().toString());
        horario.setInstructor(Cheked.isChecked());
        helper.abrir();
        String estado = helper.actualizar(horario);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {   //metodo convocado en el evento onclick del boton limpiar en el layout
        Hora.setText("");
        Dia.setText("");
        Cheked.setChecked(false);
    }
}