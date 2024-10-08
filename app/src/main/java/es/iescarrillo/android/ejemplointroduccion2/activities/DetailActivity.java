package es.iescarrillo.android.ejemplointroduccion2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.iescarrillo.android.ejemplointroduccion2.R;
import es.iescarrillo.android.ejemplointroduccion2.models.Person;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName, tvEmail, tvDni, tvPhone;

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
    }
}