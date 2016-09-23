package top.hittzj.service;

import top.hittzj.dao.ListCSByTypeDao;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.Commodity_Type;
import top.hittzj.entity.TzjList;

public class GetCSByTypeService {
	private ListCSByTypeDao dao;

	public GetCSByTypeService() {
		// TODO Auto-generated constructor stub
		this.dao = new ListCSByTypeDao();
	}

	public TzjList<Commodity_Sell> list(TzjList<Commodity_Sell> list,
			Commodity_Type type) {
		return dao.getList(list, type);
	}
}
