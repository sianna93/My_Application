package com.example.personal.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery("select descripcion from articulos ", null);

        String [] articulos;
        ArrayList<String> lista_art= new ArrayList<String>();

        if (fila.moveToFirst()) {

            while (fila.isAfterLast() == false) {
                String name = fila.getString(fila.getColumnIndex("descripcion"));

                lista_art.add(name);
                fila.moveToNext();
            }
        }

        TextView tv1;
        ListView lv1;

        lv1 =(ListView)findViewById(R.id.listView_lista);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, lista_art);
        lv1.setAdapter(adapter);

        /*
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                tv1.setText("Población de " + lv1.getItemAtPosition(i) + " es " + habitantes[i]);
            }
        });*/
    }

    public void regresar(View view) {
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
    }
}
