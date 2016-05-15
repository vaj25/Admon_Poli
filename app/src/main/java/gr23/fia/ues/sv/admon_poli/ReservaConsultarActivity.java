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

public class ReservaConsultarActivity extends Activity {

    ControlBD helper;
    //EditText IdReserva;  //id del campo en  layout
    EditText FechaReserva;
    EditText TiempoReserva;
    EditText IdHorario;
    Spinner sReserva;
    List<String> lista;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_consultar);
        helper = new ControlBD(this);
        //IdReserva = (EditText) findViewById(R.id.IdReserva);
        FechaReserva = (EditText) findViewById(R.id.FechaReserva);
        TiempoReserva = (EditText) findViewById(R.id.TiempoReserva);
        IdHorario = (EditText) findViewById(R.id.IdHorario);
        sReserva = (Spinner) findViewById(R.id.selectReserva);

        lista = new ArrayList<>();
        lista=helper.consultaReserva();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sReserva.setAdapter(adaptador);

    }
    public void consultarReserva(View v) {
        helper.abrir();
        int position= sReserva.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        int idreserva=0;
        while( iterador.hasNext() ) {
            Reserva reserv = (Reserva) iterador.next();
            if(count==position){
                idreserva=reserv.getIdReserva();
            }
            count++;
        }
        Reserva reserva = helper.consultarReserva(idreserva);
        helper.cerrar();
        if(reserva == null)
            Toast.makeText(this, "Reserva no encontrada", Toast.LENGTH_LONG).show();

        else{
            FechaReserva.setText(reserva.getFechaReserva());
            TiempoReserva.setText(reserva.getTiempoReserva());
            int aux = reserva.getIdHorario();
            helper.abrir();
            Horario horario = helper.consultarHorario(aux);
            helper.cerrar();
            IdHorario.setText(String.valueOf(horario.getIdHorario())+"-"+ horario.getDia()+" "+horario.getHora());
        }
    }
    public void limpiarTexto(View v){
        FechaReserva.setText("");
        TiempoReserva.setText("");
        IdHorario.setText("");
    }
}

