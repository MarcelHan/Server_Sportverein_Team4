package persistence.dao;

import persistence.pojo.CompetitionTeamPOJO;

public class CompetitionTeamDAO extends BaseDAO<CompetitionTeamPOJO, Integer> {

	private static CompetitionTeamDAO _instance;

	private CompetitionTeamDAO() {
		super(CompetitionTeamPOJO.class);
	}

	public static CompetitionTeamDAO getInstance() {
		if(_instance == null) {
			_instance = new CompetitionTeamDAO();
		}
		return _instance;
	}
}
