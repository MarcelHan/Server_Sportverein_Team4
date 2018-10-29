package persistence;

import persistence.dao.PersonDAO;
import persistence.pojo.PersonPOJO;

import java.util.List;


/**
 * Fassade als einziger Anlaufpunkt f�r die dar�berliegende Applikationsschicht, um auf die Datenbank zuzugreifen
 * @author sonja
 *
 */
public class DatabaseFacade {

	public List<PersonPOJO> listAllPersons() {
		PersonDAO dao = PersonDAO.getInstance();
		return dao.getAll();
	}

	public void insert(PersonPOJO person) {
		PersonDAO.getInstance().insert(person);
	}
}