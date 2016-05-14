package gr23.fia.ues.sv.admon_poli;

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
    EditText monto;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifa_insertar);
        helper = new ControlBD(this);
        cantHoras = (EditText) findViewById(R.id.cantHoras);
        cantPersonas = (EditText) findViewById(R.id.cantPersonas);
        monto = (EditText) findViewById(R.id.monto);

    }

    public void insertarTarifa(View v) {
        String regInsertados;
        Double canthoras = Double.parseDouble(cantHoras.getText().toString());
        Integer cantpersonas = Integer.parseInt(cantPersonas.getText().toString());
        //Double mon = Double.parseDouble(monto.getText().toString());

        Tarifa tar = new Tarifa();
        tar.setCanthora(canthoras);
        tar.setCantPersonas(cantpersonas);
        tar.setMontoArea();


        helper.abrir();
        regInsertados = helper.insertar(tar);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        monto.setText(tar.getMontoArea().toString());
    }

    public void limpiarTexto(View v) {
        cantHoras.setText("");
        cantPersonas.setText("");
        monto.setText("");

    }
}