package top.hittzj.service;

import top.hittzj.dao.ModifyCSDao;
import top.hittzj.entity.Commodity_Sell;

public class ModifyCSService {
	private ModifyCSDao dao;
	public ModifyCSService() {
		// TODO Auto-generated constructor stub
		this.dao=new ModifyCSDao();
	}
	public boolean change(Commodity_Sell cs){
		return dao.modify(cs);
		
	}
}
