package es.iescarrillo.android.ejemplointroduccion2.adapters;

import static es.iescarrillo.android.ejemplointroduccion2.database.Database.personList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import es.iescarrillo.android.ejemplointroduccion2.R;
import es.iescarrillo.android.ejemplointroduccion2.models.Person;

public class PersonAdapter extends ArrayAdapter<Person> {

    private List<Person> persons;

    /* Llamada al constructor del padre (contexto, idResource, lista de objetos que
        queremos recorrer*/
    public PersonAdapter(Context context, int resource, List<Person> persons){
        super(context, resource, persons);
        this.persons = persons;
    }

    // Método para indicar el XML de la vista y realizar las modificaciones
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Person p = this.persons.get(position);

        // Si todavía no se ha creado la vista
        if (convertView == null){
            /* Aquí le indicamos el XML que queremos que cree llamando al método .infalte
                .inflate(hace referencia al xml que queremos mostrar, Viewgroup parent,
                false para que primero cree el xml padre y luego el hijo)*/
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_person, parent, false);
        }

        // Recogemos de la vista los componentes
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvEmail = convertView.findViewById(R.id.tvEmail);
        TextView tvPhone = convertView.findViewById(R.id.tvPhone);

        // Modificamos los atributos de los componentes
        tvName.setText(p.getName() + " " + p.getSurname());
        tvEmail.setText(p.getEmail());
        tvPhone.setText(p.getPhone());

        // Devolvemos la vista ya modificada
        return convertView;
    }

    // Método getDropDownView se ejecuta al pulsar sobre el spinner
    // Método llamando a una vista propia => item_person.xml
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent){

        Person p = personList.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.drop_down_person, parent, false);
        }

        // Recogemos de la vista los componentes
        TextView tvName = convertView.findViewById(R.id.tvNameSpinner);
        TextView tvEmail = convertView.findViewById(R.id.tvEmailSpinner);

        // Modificamos los atributos de los componentes
        tvName.setText(p.getName() + " " + p.getSurname());
        tvEmail.setText(p.getEmail());

        // Devolvemos la vista ya modificada
        return convertView;
    }

    /* Método getDropDownView llamando al xml por defecto de Android => android.R.layout.simple_spinner_dropdown_item
    * @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent){

        Person p = personList.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        // Recogemos de la vista los componentes
        TextView tvName = convertView.findViewById(android.R.id.text1);

        // Modificamos los atributos de los componentes
        tvName.setText(p.getName() + " " + p.getSurname());

        // Devolvemos la vista ya modificada
        return convertView;
    }
    * */
}
