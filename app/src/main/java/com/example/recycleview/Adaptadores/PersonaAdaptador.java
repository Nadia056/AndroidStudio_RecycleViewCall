package com.example.recycleview.Adaptadores;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.Modelos.Persona;
import com.example.recycleview.R;

import java.security.Permission;
import java.util.List;

public class PersonaAdaptador extends RecyclerView.Adapter<PersonaAdaptador.viewholder>{
    public PersonaAdaptador(List<Persona> lP) {
        this.lP = lP;
    }

    List<Persona>lP;
    @NonNull
    @Override
    public PersonaAdaptador.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.it,parent,false);
        return new viewholder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaAdaptador.viewholder holder, int position) {
       holder.setData(lP.get(position));
    }

    @Override
    public int getItemCount() {
        return lP.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtNombre;
        TextView txtTelefono;
        Persona persona;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            txtNombre= itemView.findViewById(R.id.txtNombre);
            txtTelefono= itemView.findViewById(R.id.txtNumero);
            itemView.setOnClickListener(this);
        }

        public void setData(Persona p) {
            persona=p;
            txtNombre.setText(p.getNombre());
            txtTelefono.setText(p.getTelefono());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),"click",Toast.LENGTH_SHORT).show();
            Intent llamada=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ persona.getTelefono()));

            view.getContext().startActivity(llamada);
        }
    }

}
