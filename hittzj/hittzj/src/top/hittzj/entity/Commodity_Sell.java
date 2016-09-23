package top.hittzj.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author zy_q
 * @version 1.0 寄卖商品信息
 * 
 */
public class Commodity_Sell {
	private int id;
	private String name;
	private String money;
	private String number;
	private String useTime;
	private String flaw;
	private String desc;
	private String img;
	private String location;
	private Date time;
	private User user;
	private Commodity_Type type;
	// 收藏者
	private Set<User> collectors;

	public Set<User> getCollectors() {
		return collectors;
	}

	public void setCollectors(Set<User> collectors) {
		this.collectors = collectors;
	}

	public Commodity_Type getType() {
		return type;
	}

	public void setType(Commodity_Type type) {
		this.type = type;
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

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getFlaw() {
		return flaw;
	}

	public void setFlaw(String flaw) {
		this.flaw = flaw;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Commodity_Sell [id=" + id + ", name=" + name + ", money="
				+ money + ", number=" + number + ", useTime=" + useTime
				+ ", flaw=" + flaw + ", desc=" + desc + ", img=" + img
				+ ", location=" + location + ", time=" + time + ", user="
				+ user + ", type=" + type + ", collectors=" + collectors + "]";
	}



}
