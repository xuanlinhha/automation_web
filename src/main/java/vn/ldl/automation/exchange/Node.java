package vn.ldl.automation.exchange;

import java.util.List;

public class Node {
	String type;
	String id;
	String description;
	List<Integer> status;

	public static final String SWITCH = "SWITCH";
	public static final String LIGHT = "LIGHT";
	public static final String MOOD_LIGHT = "MOOD_LIGHT";
	public static final String COLOR_LIGHT = "COLOR_LIGHT";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Integer> getStatus() {
		return status;
	}

	public void setStatus(List<Integer> status) {
		this.status = status;
	}
}
