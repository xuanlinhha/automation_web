package vn.ldl.automation.exchange;

import java.util.List;

public class IRequest {
	private String type;
	private String id;
	int autoVersionMajor;
	int autoVersionMinor;
	private List<Integer> params;

	public static final String DISPLAY = "DISPLAY";
	public static final String SET = "SET";

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

	public List<Integer> getParams() {
		return params;
	}

	public void setParams(List<Integer> params) {
		this.params = params;
	}

	public int getAutoVersionMajor() {
		return autoVersionMajor;
	}

	public void setAutoVersionMajor(int autoVersionMajor) {
		this.autoVersionMajor = autoVersionMajor;
	}

	public int getAutoVersionMinor() {
		return autoVersionMinor;
	}

	public void setAutoVersionMinor(int autoVersionMinor) {
		this.autoVersionMinor = autoVersionMinor;
	}

	public String toIRequestString() {
		StringBuilder builder = new StringBuilder();
		builder.append(type);
		builder.append(FormatConst.COMP_SEPERATOR);
		builder.append(id);
		builder.append(FormatConst.COMP_SEPERATOR);
		builder.append("AUTO/");
		builder.append(autoVersionMajor);
		builder.append('.');
		builder.append(autoVersionMinor);
		builder.append("\r\n");
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size() - 1; i++) {
				builder.append(params.get(i));
				builder.append(FormatConst.SUB_COMP_SEPERATOR);
			}
			builder.append(params.get(params.size() - 1));
		}
		builder.append("\r\n");
		return builder.toString();
	}

}
