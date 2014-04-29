package org.pht.user;

import java.io.Serializable;
import org.pht.user.data.Data;
import org.pht.user.data.Quota;

public class User implements Serializable {
	private static final long serialVersionUID = -5183535606282242445L;
	// Actual data
	private String name;
	private Data data;
	private Quota quota;

	public User() {
	}
	
	public User(String name) {
		data = new Data();
		quota = new Quota();
		this.name = name;
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