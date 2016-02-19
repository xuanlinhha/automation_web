package vn.ldl.automation.exchange;

import java.util.List;

public class Notification {
	private String id;
	private List<Integer> status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Integer> getStatus() {
		return status;
	}

	public void setStatus(List<Integer> status) {
		this.status = status;
	}
}
