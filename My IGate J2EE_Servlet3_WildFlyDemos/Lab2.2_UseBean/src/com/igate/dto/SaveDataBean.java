/**
 * 
 */
package com.igate.dto;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author yv824177
 * 
 */
public class SaveDataBean {
	private String contents;
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
		// setrting 
	}

}
