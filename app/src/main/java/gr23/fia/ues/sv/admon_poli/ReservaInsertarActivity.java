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

public class ReservaInsertarActivity extends Activity {

    ControlBD helper;
    //EditText IdReserva;  //id del campo en  layout
    EditText FechaReserva;
    EditText TiempoReserva;
    EditText IdHorario;
    Spinner sHorario;
    List<String> lista;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_insertar);
        helper = new ControlBD(this);
        //IdReserva = (EditText) findViewById(R.id.IdReserva);
        FechaReserva = (EditText) findViewById(R.id.FechaReserva);
        TiempoReserva = (EditText) findViewById(R.id.TiempoReserva);
        sHorario = (Spinner) findViewById(R.id.selectHorario);

        lista = new ArrayList<>();
        lista=helper.consultaHorario();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sHorario.setAdapter(adaptador);
    }

    public void insertarReserva(View v) {//metodo convocado en el evento onclick del boton insertar en el layout
        int idreserva=helper.contarRegistros("reserva ","idreserva");
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
        String fechareserva=FechaReserva.getText().toString();
        String tiemporeserva=TiempoReserva.getText().toString();
        //String idhorario=IdHorario.getText().toString();
        String regInsertados;
        Reserva reserva =new Reserva();
        reserva.setIdReserva(idreserva);
        reserva.setFechaReserva(fechareserva);
        reserva.setTiempoReserva(tiemporeserva);
        reserva.setIdHorario(idhorario);
        helper.abrir();
        regInsertados=helper.insertar(reserva);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {   //metodo convocado en el evento onclick del boton limpiar en el layout
        //IdReserva.setText("");
        FechaReserva.setText("");
        TiempoReserva.setText("");
        //IdHorario.setText("");
    }
}