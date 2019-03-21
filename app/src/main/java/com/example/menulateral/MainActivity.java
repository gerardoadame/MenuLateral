package com.example.menulateral;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private LinearLayout linearLayout;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawerLayout);
        linearLayout = findViewById(R.id.contenido);
        listView = findViewById(R.id.menulateral);

        String[] opciones = {"opcion 1", "opcion 2", "opcion 3", "opcion 4", "opcion 5"};

        ArrayAdapter<String> op = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, opciones);

        listView.setAdapter(op);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opseleccionado = (String) listView.getAdapter().getItem(position);

                Toast.makeText(MainActivity.this,opseleccionado,Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(listView);
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //id de la opcion de menu que le haya dado click
        int id=item.getItemId();



        if (id==android.R.id.home)
        {
            if (drawerLayout.isDrawerOpen(listView))
            {
                drawerLayout.closeDrawer(listView);
            }
            else{
                    drawerLayout.openDrawer(listView);
                }
        }

        return super.onOptionsItemSelected(item);
    }
}
