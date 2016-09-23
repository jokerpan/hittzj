package top.hittzj.service;

import top.hittzj.dao.ListAllCSDao;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.TzjList;

public class GetAllCSService {
	private ListAllCSDao dao;

	public GetAllCSService() {
		this.dao = new ListAllCSDao();
	}

	public TzjList<Commodity_Sell> list(TzjList<Commodity_Sell> list) {

		return dao.getList(list);
	}
}
