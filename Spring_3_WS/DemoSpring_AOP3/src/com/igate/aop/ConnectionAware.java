package com.igate.aop;

import java.sql.Connection;

public interface ConnectionAware {
	public void setConnection(Connection connection);
	public void removeConnection();
	
}
