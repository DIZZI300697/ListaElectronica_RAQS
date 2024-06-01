package com.example.listaelectronica_raqs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ElementoAdapter extends RecyclerView.Adapter<ElementoAdapter.ElementoViewHolder> {

    private List<Elemento> elementos;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public interface OnItemClickListener {
        void onItemClick(Elemento elemento);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(Elemento elemento);
    }

    public ElementoAdapter(List<Elemento> elementos, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
        this.elementos = elementos;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @NonNull
    @Override
    public ElementoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_elemento, parent, false);
        return new ElementoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementoViewHolder holder, int position) {
        Elemento elemento = elementos.get(position);
        holder.bind(elemento, onItemClickListener, onItemLongClickListener);
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    static class ElementoViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombre;
        TextView precio;

        public ElementoViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen);
            nombre = itemView.findViewById(R.id.nombre);
            precio = itemView.findViewById(R.id.precio);
        }

        public void bind(final Elemento elemento, final OnItemClickListener onItemClickListener, final OnItemLongClickListener onItemLongClickListener) {
            imagen.setImageResource(elemento.getImagenResId());
            nombre.setText(elemento.getNombre());
            precio.setText("Precio: $" + elemento.getPrecio());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(elemento);
                    precio.setText("Precio: $" + elemento.getPrecio());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemLongClickListener.onItemLongClick(elemento);
                    precio.setText("Precio: $" + elemento.getPrecio());
                    return true;
                }
            });
        }
    }
}


