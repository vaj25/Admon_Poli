package gr23.fia.ues.sv.admon_poli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TarifaActualizarActivity extends AppCompatActivity {

    ControlBD helper;
    List<Tarifa> lista ;
    //EditText EditMonto;
    EditText HorasTarifa;
    EditText PersonasTarifa;
    EditText montoTarifa;
    Spinner idTarifa ;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifa_actualizar);
        helper=new ControlBD(this);

       // EditMonto=(EditText)findViewById(R.id.editText16);
        HorasTarifa=(EditText)findViewById(R.id.cantHoras);
        PersonasTarifa=(EditText)findViewById(R.id.cantPersonas);
        montoTarifa=(EditText)findViewById(R.id.monto);
        idTarifa = (Spinner) findViewById(R.id.selectTarifa) ;

        lista = new ArrayList<>();
        lista=helper.consultaTarifa();

        ArrayAdapter<Tarifa> adaptador =new ArrayAdapter<Tarifa>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idTarifa.setAdapter(adaptador);
    }

    public void actualizarTarifa(View v) {
        int position= idTarifa.getSelectedItemPosition();
        Iterator iterador = lista.listIterator();
        int count=0;
        int idtarifa=0;
        while( iterador.hasNext() ) {
            Tarifa tar = (Tarifa) iterador.next();
            if(count==position){
                idtarifa=tar.getIdTarifa();
            }
            count++;
        }

        Tarifa tarif= new Tarifa();
        //Solicitante sol = new Solicitante();
        //tarif = helper.consultarTarifa(idtarifa);
        tarif.setIdTarifa(idtarifa);
        tarif.setCanthora(Double.parseDouble(HorasTarifa.getText().toString()));
        tarif.setCantPersonas(Integer.parseInt(PersonasTarifa.getText().toString()));
        double precio =(20*(Double.parseDouble(HorasTarifa.getText().toString())))+(1*(Double.parseDouble(PersonasTarifa.getText().toString())));
        tarif.setPrecio(precio);

        helper.abrir();
        String estado = helper.actualizar(tarif);
        helper.cerrar();
        montoTarifa.setText(String.valueOf(precio));
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {   //metodo convocado en el evento onclick del boton limpiar en el layout
        HorasTarifa.setText("");
        PersonasTarifa.setText("");
    }
}