package top.hittzj.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author zy_q
 * @version 1.0 用户需要的商品
 */
public class Commodity_Need {
	private int id;
	private String name;
	private String money;
	private String number;
	private String img;
	private String location;
	private String desc;
	private Date time;
	private User user;
	// 收藏者
	private Set<User> collectors;


	public Set<User> getCollectors() {
		return collectors;
	}

	public void setCollectors(Set<User> collectors) {
		this.collectors = collectors;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Commodity_Need [id=" + id + ", name=" + name + ", money="
				+ money + ", number=" + number + ", img=" + img + ", location="
				+ location + ", desc=" + desc + ", time=" + time + "]";
	}

}
