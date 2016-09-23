package top.hittzj.service;

import top.hittzj.dao.ListAllCNDao;
import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.TzjList;

public class GetAllCNService {
	private ListAllCNDao dao;

	public GetAllCNService() {
		this.dao = new ListAllCNDao();
	}

	public TzjList<Commodity_Need> list(TzjList<Commodity_Need> list) {
		return dao.getUserList(list);

	}
}
