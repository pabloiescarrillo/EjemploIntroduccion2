package es.iescarrillo.android.ejemplointroduccion2.activities;

import static es.iescarrillo.android.ejemplointroduccion2.database.Database.initializeList;
import static es.iescarrillo.android.ejemplointroduccion2.database.Database.personList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.iescarrillo.android.ejemplointroduccion2.R;
import es.iescarrillo.android.ejemplointroduccion2.adapters.PersonAdapter;
import es.iescarrillo.android.ejemplointroduccion2.models.Person;

public class MainActivity extends AppCompatActivity {

    private ListView lvPersons;
    private TextView tvPerson;

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

        // Obtengo de la pantalla el listView y el textView
        lvPersons = findViewById(R.id.lvPersons);
        tvPerson = findViewById(R.id.tvPerson);

        // Inicializo la lista estática
        initializeList();

        // Creo el adaptador (contexto, id, lista de personas)
        PersonAdapter adapter = new PersonAdapter(MainActivity.this, 0, personList);

        // Asignar el adaptador al listView
        lvPersons.setAdapter(adapter);

        lvPersons.setOnItemClickListener((parent, view, position, id) -> {
            Person p = personList.get(position);

            Log.i("person click", p.toString());

            Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);

            detailIntent.putExtra("person", p);

            startActivity(detailIntent);

        });

        // Recuperamos el intent que ha llamado a esta Activity
        // y el objeto person, el cual vamos a mostrar en el textView
        Intent detailIntent = getIntent();
        if(detailIntent.getSerializableExtra("person") != null)
            tvPerson.setText(detailIntent.getSerializableExtra("person").toString());
    }
}