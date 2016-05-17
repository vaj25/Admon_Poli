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

public class TarifaEliminarActivity extends Activity {
    ControlBD helper;
    Spinner sTarifa;
    List<String> lista;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifa_eliminar);
        helper=new ControlBD (this);
        sTarifa = (Spinner) findViewById(R.id.selectTarifa);

        lista = new ArrayList<>();
        lista=helper.consultaTarifa();
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sTarifa.setAdapter(adaptador);

    }
    public void eliminarTarifa(View v){
        int position= sTarifa.getSelectedItemPosition();
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
        String regEliminadas;
        Tarifa tarifa=new Tarifa();
        tarifa.setIdTarifa(idtarifa);
        helper.abrir();
        regEliminadas=helper.eliminar(tarifa);
        helper.cerrar();
        Toast.makeText(this, "Filas afectadas= " + regEliminadas, Toast.LENGTH_SHORT).show();
    }
}