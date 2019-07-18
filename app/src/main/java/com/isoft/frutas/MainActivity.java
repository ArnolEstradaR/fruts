package com.isoft.frutas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Fruta fruta[];
    private int i;

    List<Fruta> items = new ArrayList<>();
    MyList adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list =(ListView)findViewById(R.id.lista);

        items.add(new Fruta("A0","D1",0));
        items.add(new Fruta("A1","D2",0));
        adapter = new MyList(this, items);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),items.get(position).name,Toast.LENGTH_LONG).show();
                //items.set(0,new Fruta("X","Y",100));
                /*TextView name=(TextView) view.findViewById(R.id.quantity);
                int suma=Integer.parseInt(name.getText()+"")+1;
                name.setText(suma+"");*/
                Fruta item = items.get(position);
                //items.get(position).quantity=10;
                item.quantity++;
                //items.set(position,item);
                //adapter.add();
                adapter.notifyDataSetChanged();
            }
        });
    }
    public void addFruts()
    {
        //adapter.add(new Fruta("A"+items.size(),"alguna descripción",0));
        items.add(new Fruta("A"+items.size(),"alguna descripción",0));
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        addFruts();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
