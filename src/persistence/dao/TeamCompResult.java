package persistence.dao;

import persistence.pojo.TeamCompResultPOJO;

public class TeamCompResult extends BaseDAO<TeamCompResultPOJO, Integer> {

	private static TeamCompResult _instance;

	private TeamCompResult() {
		super(TeamCompResultPOJO.class);
	}

	public static TeamCompResult getInstance() {
		if(_instance == null) {
			_instance = new TeamCompResult();
		}
		return _instance;
	}
}
