package gr23.fia.ues.sv.admon_poli;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DetalleSolicitudMenuActivity extends ListActivity {

    String[] menu = {"Insertar Detalle de Solicitud","Eliminar Detalle de Solicitud","Consultar Detalle de Solicitud",
            "Actualizar Detalle d Solicitud"};
    String[] activities = {"DetalleSolicitudInsertarActivity","DetalleSolicitudEliminarActivity",
            "DetalleSolicitudConsultarActivity", "DetalleSolicitudActualizarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(207, 207, 192));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        String nombreValue = activities[position];
        l.getChildAt(position).setBackgroundColor(Color.rgb(207, 207, 200));
        try{
            Class<?> clase=Class.forName("gr23.fia.ues.sv.admon_poli."+nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
