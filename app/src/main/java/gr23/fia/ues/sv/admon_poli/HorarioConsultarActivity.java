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

public class HorarioConsultarActivity extends Activity {
    ControlBD helper;
    //EditText IdHorario;  //id del campo en  layout
    EditText Hora;
    EditText Dia;
    CheckBox Cheked;
    Spinner sHorario;
    List<String> lista;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_horario_consultar);
        helper = new ControlBD(this);
        //IdHorario = (EditText) findViewById(R.id.IdHorario);
        Dia = (EditText) findViewById(R.id.Dia);
        Hora = (EditText) findViewById(R.id.Hora);
        Cheked = (CheckBox) findViewById(R.id.Instruct);
        sHorario = (Spinner) findViewById(R.id.selectHorario);

        lista = new ArrayList<>();
        lista=helper.consultaHorario();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sHorario.setAdapter(adaptador);

    }
    public void consultarHorario(View v) {
        helper.abrir();
        //String idhorario=IdHorario.getText().toString();
        int position= sHorario.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        int idhorario=0;
        while( iterador.hasNext() ) {
            Horario horario = (Horario) iterador.next();
            if(count==position){
                idhorario=horario.getIdHorario();
            }
            count++;
        }
        Horario horario = helper.consultarHorario(idhorario);
        helper.cerrar();
        if(horario == null)
            Toast.makeText(this, "Horario no encontrado", Toast.LENGTH_LONG).show();

        else{
            Dia.setText(horario.getDia());
            Hora.setText(horario.getHora());
            Cheked.setChecked(horario.getInstructor());
        }
    }
    public void limpiarTexto(View v){
        Hora.setText("");
        Dia.setText("");
        Cheked.setChecked(false);
    }
}