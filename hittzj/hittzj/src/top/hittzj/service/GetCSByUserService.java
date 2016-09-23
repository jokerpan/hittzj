package top.hittzj.service;

import top.hittzj.dao.ListCSByUserDao;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.TzjList;
import top.hittzj.entity.User;

public class GetCSByUserService {
	private ListCSByUserDao dao;

	public GetCSByUserService() {
		dao = new ListCSByUserDao();

	}

	public TzjList<Commodity_Sell> list(TzjList<Commodity_Sell> list, User user) {
		return dao.getList(list, user);
	}

}
