package es.iescarrillo.android.ejemplointroduccion2.activities;

import static es.iescarrillo.android.ejemplointroduccion2.database.Database.inicializeList;
import static es.iescarrillo.android.ejemplointroduccion2.database.Database.personList;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.iescarrillo.android.ejemplointroduccion2.R;
import es.iescarrillo.android.ejemplointroduccion2.adapters.PersonAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView lvPersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtengo de la pantalla el listView
        lvPersons = findViewById(R.id.lvPersons);

        // Inicializo la lista estática
        inicializeList();

        // Creo el adaptador (contexto, id, lista de personas)
        PersonAdapter adapter = new PersonAdapter(MainActivity.this, 0, personList);

        // Asignar el adaptador al listView
        lvPersons.setAdapter(adapter);

    }
}