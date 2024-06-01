package com.example.listaelectronica_raqs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ElementoAdapter extends RecyclerView.Adapter<ElementoAdapter.ElementoViewHolder> {

    private List<Elemento> elementos;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    private Context context;

    public interface OnItemClickListener {
        void onItemClick(Elemento elemento);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(Elemento elemento);
    }

    public ElementoAdapter(Context context, List<Elemento> elementos, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
        this.elementos = elementos;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
        this.context = context;
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
        holder.bind(context, elemento, onItemClickListener, onItemLongClickListener);
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    static class ElementoViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombre;
        TextView precio;
        TextView contador;

        public ElementoViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen);
            nombre = itemView.findViewById(R.id.nombre);
            precio = itemView.findViewById(R.id.precio);
            contador = itemView.findViewById(R.id.contador);
        }

        public void bind(final Context context, final Elemento elemento, final OnItemClickListener onItemClickListener, final OnItemLongClickListener onItemLongClickListener) {
            imagen.setImageResource(elemento.getImagenResId());
            nombre.setText(elemento.getNombre());
            precio.setText("Precio: $" + elemento.getPrecio());
            contador.setText("Cantidad: " + elemento.getCantidad());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Seleccionaste: " + elemento.getNombre(), Toast.LENGTH_SHORT).show();
                    elemento.setCantidad(elemento.getCantidad() + 1);
                    contador.setText("Cantidad: " + elemento.getCantidad());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (elemento.getCantidad() > 0) {
                        elemento.setCantidad(elemento.getCantidad() - 1);
                        contador.setText("Cantidad: " + elemento.getCantidad());
                    }
                    return true;
                }
            });
        }
    }
}
