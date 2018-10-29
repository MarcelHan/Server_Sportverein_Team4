package persistence.dao;

import persistence.pojo.PersonTeamPOJO;

public class PersonTeamDAO extends BaseDAO<PersonTeamPOJO, Integer> {

	private static PersonTeamDAO _instance;

	private PersonTeamDAO() {
		super(PersonTeamPOJO.class);
	}

	public static PersonTeamDAO getInstance() {
		if(_instance == null) {
			_instance = new PersonTeamDAO();
		}
		return _instance;
	}
}
