package top.hittzj.service;

import top.hittzj.dao.ListCNByCollectorDao;
import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.TzjList;
import top.hittzj.entity.User;

public class GetCNListByCollectorService {
	ListCNByCollectorDao dao;

	public GetCNListByCollectorService() {
		this.dao = new ListCNByCollectorDao();
	}

	public TzjList<Commodity_Need> list(TzjList<Commodity_Need> list ,User user) {
		list = dao.list(list, user);
		return list;
	
	}

}
