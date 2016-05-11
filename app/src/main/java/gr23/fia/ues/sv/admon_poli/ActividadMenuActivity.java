package gr23.fia.ues.sv.admon_poli;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActividadMenuActivity extends ListActivity {
    String[] menu={"Nueva Actividad","Eliminar Actividad","Consultar Actividad", "Actualizar Actividad"};
    String[] activities={"ActividadInsertarActivity","ActividadEliminarActivity","ActividadConsultarActivity", "ActividadActualizarActivity"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(255, 255, 255));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        String nombreValue=activities[position];
        l.getChildAt(position).setBackgroundColor(Color.rgb(0, 128, 64));
        try{
            Class<?> clase=Class.forName("gr23.fia.ues.sv.admon_poli."+nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
