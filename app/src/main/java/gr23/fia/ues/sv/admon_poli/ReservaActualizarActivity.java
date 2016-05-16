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

public class ReservaActualizarActivity extends Activity {

    ControlBD helper;
  //  EditText IdReserva;  //id del campo en  layout
    EditText FechaReserva;
    EditText TiempoReserva;
   // EditText IdHorario;
    Spinner sReserva;
    Spinner sHorario;
    List<String> lista;
    List<String> lista1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_actualizar);
        helper = new ControlBD(this);
        //IdReserva = (EditText) findViewById(R.id.IdReserva);
        FechaReserva = (EditText) findViewById(R.id.FechaReserva);
        TiempoReserva = (EditText) findViewById(R.id.TiempoReserva);
        //IdHorario = (EditText) findViewById(R.id.IdHorario);
        sReserva = (Spinner) findViewById(R.id.selectReserva);
        sHorario = (Spinner) findViewById(R.id.selectHorario);

        lista = new ArrayList<>();
        lista=helper.consultaReserva();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sReserva.setAdapter(adaptador);

        lista1 =new ArrayList<>();
        lista1=helper.consultaHorario();
        ArrayAdapter<String> adaptador1 =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sHorario.setAdapter(adaptador1);
    }

    public void actualizarReserva(View v) {
        int position= sReserva.getSelectedItemPosition();
        int position1= sHorario.getSelectedItemPosition();
        //int count = helper.count("area");
        Iterator iterador = lista.listIterator();
        Iterator iterador1 = lista1.listIterator();
        int count=0;
        int idreserva=0;
        int idhorario=0;
        while( iterador.hasNext() ) {
            Reserva reserva = (Reserva) iterador.next();
            if(count==position){
                idreserva=reserva.getIdReserva();
            }
            count++;
        }
        int count1=0;
        while( iterador1.hasNext() ) {
            Horario horario = (Horario) iterador1.next();
            if(count1==position1){
                idhorario=horario.getIdHorario();
            }
            count1++;
        }
        Reserva reserv = new Reserva();
        reserv.setIdReserva(idreserva);
        reserv.setFechaReserva(FechaReserva.getText().toString());
        reserv.setTiempoReserva(TiempoReserva.getText().toString());
        reserv.setIdHorario(idhorario);
        helper.abrir();
        String estado = helper.actualizar(reserv);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {   //metodo convocado en el evento onclick del boton limpiar en el layout
        FechaReserva.setText("");
        TiempoReserva.setText("");
    }
}