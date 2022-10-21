package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.recycleview.Adaptadores.PersonaAdaptador;
import com.example.recycleview.Modelos.Persona;

import java.util.ArrayList;
import  java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Persona> p=new ArrayList<Persona>();
        Persona pe=new Persona("Nadia","8715854676");
        p.add (new Persona("Nadia","8745962315"));
        p.add (new Persona("Juan","8725962315"));
        p.add (new Persona("Alan","8715962315"));
        p.add (new Persona("Carlos","8735962315"));
        p.add (new Persona("Cristian","8745962315"));

        PersonaAdaptador adaptador=new PersonaAdaptador(p);
        LinearLayoutManager l=new LinearLayoutManager((this));
        RecyclerView li=(RecyclerView)findViewById(R.id.recycle);
        li.setAdapter(adaptador);
        li.setLayoutManager(l);
        li.setHasFixedSize(true);


    }
}