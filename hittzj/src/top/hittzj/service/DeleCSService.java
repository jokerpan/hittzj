package top.hittzj.service;

import top.hittzj.dao.DeleCSDao;
import top.hittzj.entity.Commodity_Sell;

public class DeleCSService {
	private DeleCSDao dao;

	public DeleCSService() {
		// TODO Auto-generated constructor stub
		this.dao = new DeleCSDao();
	}

	public boolean delet(Commodity_Sell cs) {
		return dao.delet(cs);
	}

}
