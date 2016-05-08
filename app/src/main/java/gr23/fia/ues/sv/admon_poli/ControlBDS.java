package gr23.fia.ues.sv.admon_poli;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class ControlBDS {

    private final Context context;     //Almacenara el context de nuestra Activity
    private DatabaseHelper DBHelper; //Nuestro Auxiliador de BD
    private SQLiteDatabase db;      //Instancia de nuestra BD

    public NuestraClaseQueControlaLaBD (Context ctx) {
        this. context = ctx;
        DBHelper = new DatabaseHelper( context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String BASE_DATOS = "AdmonPoli.s3db" ;
        private static final int VERSION = 1;

        DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL();
                db.execSQL();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase(); //Abrir BD con permisos R/W
        return;
    }

    public void cerrar() {
        DBHelper.close();
    }
}
