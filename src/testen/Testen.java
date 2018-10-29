package testen;

import persistence.DatabaseFacade;
import persistence.pojo.PersonPOJO;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Testen {
    public static void main(String[] args) {
        DatabaseFacade dbf = new DatabaseFacade();

        PersonPOJO person = new PersonPOJO();
        person.setFirstName("Simone");
        person.setLastName("Kirchinger");
        person.setDateOfBirth(new Date(12-12-1992));
        dbf.insert(person);

        List<PersonPOJO> allPersons = dbf.listAllPersons();
        for (PersonPOJO pers:allPersons) {
            System.out.println(pers.getFirstName());
            System.out.println(pers.getLastName());
            System.out.println(pers.getDateOfBirth() + "\n");
        }
    }
}
