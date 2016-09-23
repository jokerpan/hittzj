package top.hittzj.service;

import top.hittzj.dao.GetCSDao;
import top.hittzj.entity.Commodity_Sell;

public class GetCSService {
	private GetCSDao dao;

	public GetCSService() {
		// TODO Auto-generated constructor stub
		this.dao = new GetCSDao();
	}

	public Commodity_Sell get(int id) {
		Commodity_Sell cs = new Commodity_Sell();
		cs.setId(id);
		return dao.getCommodity_Sell(cs);
	}

}
