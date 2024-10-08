package es.iescarrillo.android.ejemplointroduccion2.activities;

import static es.iescarrillo.android.ejemplointroduccion2.database.Database.personList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.iescarrillo.android.ejemplointroduccion2.R;
import es.iescarrillo.android.ejemplointroduccion2.adapters.PersonAdapter;
import es.iescarrillo.android.ejemplointroduccion2.models.Person;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName, tvEmail, tvDni, tvPhone;
    private Spinner spPersons;
    private Button btnSendPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtengo los componentes de la vista
        tvName = findViewById(R.id.tvNameDetail);
        tvEmail = findViewById(R.id.tvEmailDetail);
        tvDni = findViewById(R.id.tvDniDetail);
        tvPhone = findViewById(R.id.tvPhoneDetail);
        spPersons = findViewById(R.id.spPersons);
        btnSendPerson = findViewById(R.id.btnSendPerson);

        // Obtengo el intent que ha iniciado la Activity
        Intent intent = getIntent();
        // Recupero el valor de la clave 'person'
        Person p= (Person) intent.getSerializableExtra("person");
        // Muestro en el log
        Log.i("person", p.toString());

        tvName.setText(p.getName() + " " + p.getSurname() );
        tvPhone.setText(p.getPhone());
        tvEmail.setText(p.getEmail());
        tvDni.setText(p.getDni());

        PersonAdapter adapter = new PersonAdapter(DetailActivity.this, 0, personList);
        spPersons.setAdapter(adapter);

        btnSendPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMain = new Intent(DetailActivity.this, MainActivity.class);

                // Método getSelectedItem() devuelve el objeto seleccionado en el spinner
                intentMain.putExtra("person", (Person) spPersons.getSelectedItem());

                Log.i("persona seleccionada", spPersons.getSelectedItem().toString());

                startActivity(intentMain);
            }
        });
    }

}