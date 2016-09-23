package top.hittzj.service;

import top.hittzj.dao.ListCSByCollector;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.TzjList;
import top.hittzj.entity.User;

public class GetCSByCollectorService {
	private ListCSByCollector dao;

	public GetCSByCollectorService() {
		this.dao = new ListCSByCollector();
	}

	public TzjList<Commodity_Sell> list(TzjList<Commodity_Sell> list, User user) {
		return dao.list(list, user);
	}

}
