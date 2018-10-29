package persistence.dao;

import persistence.pojo.LeaguePOJO;

public class LeagueDAO extends BaseDAO<LeaguePOJO, Integer> {

	private static LeagueDAO _instance;

	private LeagueDAO() {
		super(LeaguePOJO.class);
	}

	public static LeagueDAO getInstance() {
		if(_instance == null) {
			_instance = new LeagueDAO();
		}
		return _instance;
	}
}
