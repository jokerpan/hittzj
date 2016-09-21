package top.hittzj.service;

import top.hittzj.dao.IsUserExistDao;

public class IsUserExistService {
	private IsUserExistDao dao;

	public IsUserExistService() {
		this.dao = new IsUserExistDao();
	}

	public boolean isExist(String count) {
		return dao.isExist(count);
	}
}
