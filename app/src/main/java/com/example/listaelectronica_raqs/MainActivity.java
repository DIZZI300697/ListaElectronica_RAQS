package com.example.listaelectronica_raqs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ElementoAdapter adapter;
    private List<Elemento> elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        elementos = new ArrayList<>();
        elementos.add(new Elemento(getString(R.string.nombre_televisor), 400, R.drawable.televisor));
        elementos.add(new Elemento(getString(R.string.nombre_radio), 50, R.drawable.radio));
        elementos.add(new Elemento(getString(R.string.nombre_computadora), 600, R.drawable.computadora));
        elementos.add(new Elemento(getString(R.string.nombre_tablet), 300, R.drawable.tablet));
        elementos.add(new Elemento(getString(R.string.nombre_celular), 800, R.drawable.celular));

        adapter = new ElementoAdapter(this, elementos, new ElementoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Elemento elemento) {
                // Handle item click
            }
        }, new ElementoAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(Elemento elemento) {
                // Handle item long click
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
