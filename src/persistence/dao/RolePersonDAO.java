package persistence.dao;

import persistence.pojo.RolePersonPOJO;

public class RolePersonDAO extends BaseDAO<RolePersonPOJO, Integer> {

	private static RolePersonDAO _instance;

	private RolePersonDAO() {
		super(RolePersonPOJO.class);
	}

	public static RolePersonDAO getInstance() {
		if(_instance == null) {
			_instance = new RolePersonDAO();
		}
		return _instance;
	}
}
