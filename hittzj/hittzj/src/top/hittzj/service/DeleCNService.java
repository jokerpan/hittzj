package top.hittzj.service;

import top.hittzj.dao.DeleCNDao;
import top.hittzj.entity.Commodity_Need;

public class DeleCNService {
	private DeleCNDao dao;

	public DeleCNService() {
		// TODO Auto-generated constructor stub
		this.dao = new DeleCNDao();
	}

	public boolean delet(Commodity_Need commodity_Need) {
		return dao.delet(commodity_Need);
	}

}
