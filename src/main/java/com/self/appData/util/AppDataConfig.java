package com.self.appData.util;

public class AppDataConfig {

	private String jdbcUrl;
	private String appSchema;

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getAppSchema() {
		return appSchema;
	}

	public void setAppSchema(String schema) {
		this.appSchema = schema;
	}
}

