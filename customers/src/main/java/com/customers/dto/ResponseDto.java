package com.customers.dto;

public class ResponseDto {

	private String messagge;
	private Object body;

	public ResponseDto() {
		super();
	}

	public ResponseDto(String status, Object body) {
		this.messagge = status;
		this.body = body;
	}

	public String getMessagge() {
		return messagge;
	}

	public void setMessagge(String messagge) {
		this.messagge = messagge;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

}
