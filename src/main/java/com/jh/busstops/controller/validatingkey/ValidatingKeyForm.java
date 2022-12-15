package com.jh.busstops.controller.validatingkey;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ValidatingKeyForm {

	@NotNull
	@Size(min=32, max=32, message="32 chars required")
	private String apiKey="";

	public String getApiKey() {
		return this.apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}


	public String toString() {
		return "ApiKey: " + this.apiKey;
	}
}
