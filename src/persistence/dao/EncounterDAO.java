package persistence.dao;

import persistence.pojo.EncounterPOJO;

public class EncounterDAO extends BaseDAO<EncounterPOJO, Integer> {

	private static EncounterDAO _instance;

	private EncounterDAO() {
		super(EncounterPOJO.class);
	}

	public static EncounterDAO getInstance() {
		if(_instance == null) {
			_instance = new EncounterDAO();
		}
		return _instance;
	}
}
