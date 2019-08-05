package com.atd.duckstersauthentication.config;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CharResponseWrapper extends HttpServletResponseWrapper {
	private String outputStr = "";

	public String toString() {
		return outputStr.toString();
	}

	public CharResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	public ServletOutputStream getOutputStream() {
		return new ServletOutputStream() {
			@Override
			public void write(int arg0) throws IOException {
				outputStr += Character.toString((char) arg0);
			}

			@Override
			public void setWriteListener(WriteListener listener) {

			}

			@Override
			public boolean isReady() {
				return false;
			}
		};
	}

}
