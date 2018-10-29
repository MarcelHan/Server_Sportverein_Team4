package persistence.dao;

import persistence.pojo.LineUpPersonPOJO;

public class LineUpPersonDAO extends BaseDAO<LineUpPersonPOJO, Integer> {

	private static LineUpPersonDAO _instance;

	private LineUpPersonDAO() {
		super(LineUpPersonPOJO.class);
	}

	public static LineUpPersonDAO getInstance() {
		if(_instance == null) {
			_instance = new LineUpPersonDAO();
		}
		return _instance;
	}
}
