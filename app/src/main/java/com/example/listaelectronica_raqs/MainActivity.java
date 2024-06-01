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
        elementos.add(new Elemento("Televisor", 400, R.drawable.televisor));
        elementos.add(new Elemento("Radio", 50, R.drawable.radio));
        elementos.add(new Elemento("Computadora", 600, R.drawable.computadora));
        elementos.add(new Elemento("Tablet", 300, R.drawable.tablet));
        elementos.add(new Elemento("Celular", 800, R.drawable.celular));

        ElementoAdapter adapter = new ElementoAdapter(this, elementos, new ElementoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Elemento elemento) {
                // No se necesita acción aquí, ya se maneja en el adaptador
            }
        }, new ElementoAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(Elemento elemento) {
                // No se necesita acción aquí, ya se maneja en el adaptador
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
