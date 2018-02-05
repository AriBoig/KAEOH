package com.example.arist.kaeoh;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by arist on 17/11/2017.
 */

public class BaseDeDonnees extends SQLiteOpenHelper {

    private static final String NOM_TABLE = "table";

    // Table Raspberrys
    private static final String TABLE_RASPERRY = "Raspberry";
    private static final String ID_RASPBERRY = "id_raspberry";
    private static final String NAME_RASPBERRY = "name_raspberry";
    private static final String IP_RASPBERRY = "ip_raspberry";

    private static final String CREATE_TABLE_RASPBERRY = "CREATE TABLE " + TABLE_RASPERRY
            + "(" + ID_RASPBERRY + " INTEGER, "
            + NAME_RASPBERRY + " TEXT NOT NULL, "
            + IP_RASPBERRY + " TEXT NOT NULL, "
            + " PRIMARY KEY('id_raspberry'));";

    final String rasp1 = "INSERT INTO Raspberry(id_raspberry,name_raspberry,ip_raspberry) VALUES (1, 'NODE_001','192.168.0.1')";
    final String rasp2 = "INSERT INTO Raspberry(id_raspberry,name_raspberry,ip_raspberry) VALUES (2, 'NODE_002','192.168.0.2')";
    final String rasp3 = "INSERT INTO Raspberry(id_raspberry,name_raspberry,ip_raspberry) VALUES (3, 'NODE_003','192.168.0.3')";
    final String rasp4 = "INSERT INTO Raspberry(id_raspberry,name_raspberry,ip_raspberry) VALUES (4, 'NODE_004','192.168.0.4')";
    final String rasp5 = "INSERT INTO Raspberry(id_raspberry,name_raspberry,ip_raspberry) VALUES (5, 'NODE_005','192.168.0.5')";
    final String rasp6 = "INSERT INTO Raspberry(id_raspberry,name_raspberry,ip_raspberry) VALUES (6, 'NODE_006','192.168.0.6')";


    public BaseDeDonnees(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public BaseDeDonnees(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public void cleaner(SQLiteDatabase db){
        db.execSQL("DROP TABLE " + TABLE_RASPERRY + ";");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RASPBERRY);
        db.execSQL(rasp1);
        db.execSQL(rasp2);
        db.execSQL(rasp3);
        db.execSQL(rasp4);
        db.execSQL(rasp5);
        db.execSQL(rasp6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABLE_RASPERRY);
        onCreate(db);
    }

    private final String MY_QUERY = "SELECT name_raspberry,ip_raspberry FROM Raspberry";

    public List<Raspberry> createRaspberry(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Raspberry> liste = new LinkedList<>();
        Cursor res = db.rawQuery(MY_QUERY, new String[]{});
        res.moveToFirst();
        while(!res.isAfterLast()){
            Raspberry r = new Raspberry();
            r.setName(res.getString(0));
            r.setIp(res.getString(1));
            liste.add(r);
            res.moveToNext();
        }
        return liste;
    }
}
