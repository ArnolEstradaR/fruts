package com.isoft.frutas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyList extends ArrayAdapter<Fruta>
{
    private LayoutInflater inflater;
    //private Fruta fruta;
    private List<Fruta> fruta;
    Context context;

    public MyList(Context context, List<Fruta> fruta) {
        super(context, R.layout.lista, fruta);
        this.fruta = fruta;
    }

    /*@Override
    public int getCount() {
        return fruta.length;
    }

    @Override
    public Object getItem(int i) {
        return fruta[i];
    }

    @Override
    public long getItemId(int i) {
        return fruta[i].id;
    }*/

    @Override
    public View getView(int i, View cview, ViewGroup viewGroup) {
        /*if(view == null) {
            view = inflater.inflate(R.layout.lista,viewGroup,false);
        }*/
        Fruta item = fruta.get(i);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.lista, null);
        ImageView picture=(ImageView) view.findViewById(R.id.image);
        TextView name=view.findViewById(R.id.name);
        TextView description=(TextView) view.findViewById(R.id.description);
        TextView quantity=(TextView) view.findViewById(R.id.quantity);


        picture.setImageResource(R.mipmap.ic_launcher );
        name.setText(item.name);
        description.setText(item.description);
        quantity.setText(item.quantity+"");
        return view;
    }
}

