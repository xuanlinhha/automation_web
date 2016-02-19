package vn.ldl.automation.exchange;

public class IResponse {
	private String status;
	private String data;

	public static final String BAD_REQUEST = "BAD REQUEST";
	public static final String SUCCESS = "SUCCESS";
	public static final String FAIL = "FAIL";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
