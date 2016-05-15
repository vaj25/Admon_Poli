package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HorarioEliminarActivity extends Activity {
   // EditText IdHorario;
    Spinner sHorario;
    List<String> lista;
    ControlBD helper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_eliminar);
        helper=new ControlBD (this);
        //IdHorario=(EditText)findViewById(R.id.IdHorario);
        sHorario = (Spinner) findViewById(R.id.selectHorario);

        lista = new ArrayList<>();
        lista=helper.consultaHorario();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sHorario.setAdapter(adaptador);
    }
    public void eliminarHorario(View v){
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
        String regEliminadas;
        Horario horario=new Horario();
        //String idhorario=IdHorario.getText().toString();
        horario.setIdHorario(idhorario);
        helper.abrir();
        regEliminadas=helper.eliminar(horario);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
