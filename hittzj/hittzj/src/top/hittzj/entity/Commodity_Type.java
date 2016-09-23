package top.hittzj.entity;

import java.util.List;
import java.util.Set;

/**
 * @author zy_q
 * @version 1.0 
 * 商品分类
 */
public class Commodity_Type {
	private int id;
	private String name;
	private Set<Commodity_Sell> commodity_Sell;
	
	public Set<Commodity_Sell> getCommodity_Sell() {
		return commodity_Sell;
	}
	public void setCommodity_Sell(Set<Commodity_Sell> commodity_Sell) {
		this.commodity_Sell = commodity_Sell;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
