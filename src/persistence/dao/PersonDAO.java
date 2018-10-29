package persistence.dao;

import persistence.dao.BaseDAO;
import persistence.pojo.PersonPOJO;

public class PersonDAO extends BaseDAO<PersonPOJO, Integer> {

	private static PersonDAO _instance;

	private PersonDAO() {
		super(PersonPOJO.class);
	}

	public static PersonDAO getInstance() {
		if(_instance == null) {
			_instance = new PersonDAO();
		}
		return _instance;
	}
}
