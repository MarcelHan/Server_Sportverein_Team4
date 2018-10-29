package persistence.dao;

import persistence.pojo.ResultPOJO;

public class ResultDAO extends BaseDAO<ResultPOJO, Integer> {

	private static ResultDAO _instance;

	private ResultDAO() {
		super(ResultPOJO.class);
	}

	public static ResultDAO getInstance() {
		if(_instance == null) {
			_instance = new ResultDAO();
		}
		return _instance;
	}
}
