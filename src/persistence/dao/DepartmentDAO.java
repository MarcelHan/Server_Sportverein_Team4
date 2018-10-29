package persistence.dao;

import persistence.pojo.DepartmentPOJO;

public class DepartmentDAO extends BaseDAO<DepartmentPOJO, Integer> {

	private static DepartmentDAO _instance;

	private DepartmentDAO() {
		super(DepartmentPOJO.class);
	}

	public static DepartmentDAO getInstance() {
		if(_instance == null) {
			_instance = new DepartmentDAO();
		}
		return _instance;
	}
}
