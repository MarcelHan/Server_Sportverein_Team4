package persistence.dao;

import persistence.pojo.RolePOJO;

public class RoleDAO extends BaseDAO<RolePOJO, Integer> {

	private static RoleDAO _instance;

	private RoleDAO() {
		super(RolePOJO.class);
	}

	public static RoleDAO getInstance() {
		if(_instance == null) {
			_instance = new RoleDAO();
		}
		return _instance;
	}
}
