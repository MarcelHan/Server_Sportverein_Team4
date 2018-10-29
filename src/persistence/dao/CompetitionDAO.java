package persistence.dao;

import persistence.pojo.CompetitionPOJO;

public class CompetitionDAO extends BaseDAO<CompetitionPOJO, Integer> {

	private static CompetitionDAO _instance;

	private CompetitionDAO() {
		super(CompetitionPOJO.class);
	}

	public static CompetitionDAO getInstance() {
		if(_instance == null) {
			_instance = new CompetitionDAO();
		}
		return _instance;
	}
}
