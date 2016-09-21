package top.hittzj.service;

import top.hittzj.dao.RelieveCollectorCNDao;
import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.User;

public class RelieveCollectorCNService {
	private RelieveCollectorCNDao dao;

	public RelieveCollectorCNService() {
		this.dao = new RelieveCollectorCNDao();
	}

	public boolean relieve(Commodity_Need cn, User user) {
		return dao.relieve(cn, user);
	}

}
