package persistence.dao;

import persistence.pojo.InternalTeamPOJO;

public class InternalTeamDAO extends BaseDAO<InternalTeamPOJO, Integer> {

	private static InternalTeamDAO _instance;

	private InternalTeamDAO() {
		super(InternalTeamPOJO.class);
	}

	public static InternalTeamDAO getInstance() {
		if(_instance == null) {
			_instance = new InternalTeamDAO();
		}
		return _instance;
	}
}
