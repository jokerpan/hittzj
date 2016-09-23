package top.hittzj.service;

import top.hittzj.dao.ListCNByUserDao;
import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.TzjList;
import top.hittzj.entity.User;

public class GetCNByUserService {
	private ListCNByUserDao dao;

	public GetCNByUserService() {
		this.dao = new ListCNByUserDao();
	}

	public TzjList<Commodity_Need> list(TzjList<Commodity_Need> list, User user) {
		return dao.getUserList(list, user);
	}

}
