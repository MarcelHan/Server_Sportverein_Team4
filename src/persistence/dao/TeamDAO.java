package persistence.dao;

import persistence.pojo.TeamPOJO;

public class TeamDAO extends BaseDAO<TeamPOJO, Integer> {

	private static TeamDAO _instance;

	private TeamDAO() {
		super(TeamPOJO.class);
	}

	public static TeamDAO getInstance() {
		if(_instance == null) {
			_instance = new TeamDAO();
		}
		return _instance;
	}
}
