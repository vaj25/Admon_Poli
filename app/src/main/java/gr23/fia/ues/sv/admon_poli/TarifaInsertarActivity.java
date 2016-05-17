package gr23.fia.ues.sv.admon_poli;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;

public class TarifaInsertarActivity extends Activity {
    ControlBD helper;
    EditText cantHoras;
    EditText cantPersonas;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifa_insertar);
        helper = new ControlBD(this);
        cantHoras = (EditText) findViewById(R.id.cantHoras);
        cantPersonas = (EditText) findViewById(R.id.cantPersonas);

    }

    public void insertarTarifa(View v) {
        String regInsertados;
        Double canthoras = Double.parseDouble(cantHoras.getText().toString());
        int cantpersonas = Integer.parseInt(cantPersonas.getText().toString());

        Tarifa tar = new Tarifa();
        tar.setCanthora(canthoras);
        tar.setCantPersonas(cantpersonas);
        tar.monto();

        helper.abrir();
        int id = helper.contarRegistros("tarifa", "idtarifa") ;
        tar.setIdTarifa(id);
        regInsertados = helper.insertar(tar);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        cantHoras.setText("");
        cantPersonas.setText("");
    }
}