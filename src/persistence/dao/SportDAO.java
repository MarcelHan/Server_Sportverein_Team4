package persistence.dao;

import persistence.pojo.SportPOJO;

public class SportDAO extends BaseDAO<SportPOJO, Integer> {

	private static SportDAO _instance;

	private SportDAO() {
		super(SportPOJO.class);
	}

	public static SportDAO getInstance() {
		if(_instance == null) {
			_instance = new SportDAO();
		}
		return _instance;
	}
}
