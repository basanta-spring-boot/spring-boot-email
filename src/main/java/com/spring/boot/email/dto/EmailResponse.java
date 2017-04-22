package com.spring.boot.email.dto;

public class EmailResponse {

	private String status;
	private int sendCount;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSendCount() {
		return sendCount;
	}

	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}

	public EmailResponse(String status, int sendCount) {
		super();
		this.status = status;
		this.sendCount = sendCount;
	}

}
