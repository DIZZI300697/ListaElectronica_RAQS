package com.example.listaelectronica_raqs;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final List<Elemento> elementos = new ArrayList<>();
        elementos.add(new Elemento("Televisor", 0));
        elementos.add(new Elemento("Radio", 0));
        elementos.add(new Elemento("Computadora", 0));
        elementos.add(new Elemento("Tablet", 0));
        elementos.add(new Elemento("Celular", 0));

        ElementoAdapter adapter = new ElementoAdapter(elementos, new ElementoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Elemento elemento) {
                elemento.setCantidad(elemento.getCantidad() + 1);
            }
        }, new ElementoAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(Elemento elemento) {
                if (elemento.getCantidad() > 0) {
                    elemento.setCantidad(elemento.getCantidad() - 1);
                }
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
