package org.pht.user;

import java.io.Serializable;
import org.pht.user.data.Data;
import org.pht.user.data.Quota;

public class User implements Serializable {
	private static final long serialVersionUID = -5183535606282242445L;
	// Actual data
	private int height, weight, age;
	public enum Gender { MALE, FEMALE };
	private String name;
	private Data data;
	private Quota quota;
	private Gender gender;

	public User() {
	}
	
	public User(String name, Gender gender, int height, int weight, int age) {
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.age = age;
		data = new Data();
		quota = new Quota();
		quota.setWeeklyProgress(this.data);
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Quota getQuota() {
		return quota;
	}

	public void setQuota(Quota quota) {
		this.quota = quota;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", data=" + data + ", quota=" + quota
				+ "]";
	}
}