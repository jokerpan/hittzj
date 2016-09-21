package top.hittzj.service;

import top.hittzj.dao.RelieveCollectorCSDao;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.User;

public class RelieveCollectorCSService {
	private RelieveCollectorCSDao dao;
	public RelieveCollectorCSService(){
		this.dao=new RelieveCollectorCSDao();
	}
	public boolean relieve(Commodity_Sell cs,User user){
		return dao.relieve(cs, user);
	}

}
