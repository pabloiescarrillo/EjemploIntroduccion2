package es.iescarrillo.android.ejemplointroduccion2.database;

import java.util.ArrayList;
import java.util.List;

import es.iescarrillo.android.ejemplointroduccion2.models.Person;

public class Database {

    public static List<Person> personList;

    public static void initializeList(){

        if(personList == null){
            personList = new ArrayList<>();

            Person p = new Person();
            p.setName("Pablo");
            p.setSurname("Carrillo");
            p.setEmail("pablo@gmail.com");
            p.setDni("45787896P");
            p.setAge(30);
            p.setPhone("+34666999888");

            personList.add(p);

            for (int i=0; i<50; i++){
                Person p2 = new Person();
                p2.setName("Name " + i);
                p2.setSurname("Surname " + i);
                p2.setEmail("name"+ i +"@gmail.com");
                p2.setDni("45787896P");
                p2.setAge(30);
                p2.setPhone("+34666999888");
                personList.add(p2);
            }
        }

    }
}
