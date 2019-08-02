package com.atd.duckstersService.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.filter.GenericFilterBean;

import com.atd.duckstersService.config.CharResponseWrapper;
import com.atd.duckstersService.config.SaltAES256;
import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;

public class AesFilter extends GenericFilterBean {

	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
		CharResponseWrapper responseWrapper = new CharResponseWrapper(response);
		BufferedInputStream in = new BufferedInputStream(request.getInputStream());
		JSONObject object = new JSONObject();
		if ("POST".equalsIgnoreCase(request.getMethod())) {
			try {
				JSONObject jsonObject = new JSONObject(new String(ByteStreams.toByteArray(in), Charsets.UTF_8));
				String encodedeStr = jsonObject.getString("data");
				System.out.println(encodedeStr);
				request.setAttribute("paramData", new JSONObject(SaltAES256.decrypt(encodedeStr)));
			} catch (Exception err) {
				System.out.println(err.toString());
				bufferedOutputStream.write(SaltAES256.defaultError.getBytes());
				bufferedOutputStream.flush();
				return;
			}
			// System.out.print(request.getAttribute("paramData"));
			if (object != null) {
				chain.doFilter(request, responseWrapper);
			}
			try {
				object.put("status", "SUCCESS");
				object.put("data", responseWrapper.toString());
			} catch (JSONException e) {
				e.printStackTrace();
				bufferedOutputStream.write(SaltAES256.defaultError.getBytes());
				bufferedOutputStream.flush();
				return;
			}

		} else {
			try {
				object.put("status", "ERROR");
				object.put("data", "Invalid Request Err01.");
			} catch (JSONException e) {
				e.printStackTrace();
				bufferedOutputStream.write(SaltAES256.defaultError.getBytes());
				bufferedOutputStream.flush();
				return;
			}
		}
		String encryptResponse = SaltAES256.encrypt(responseWrapper.toString());
		String decryptedString = SaltAES256.decrypt(encryptResponse);
		bufferedOutputStream.write(encryptResponse.getBytes());
		bufferedOutputStream.flush();
		System.out.println("AFTER filter, original response: " + responseWrapper.toString());
//		System.out.println("AFTER filter, original response: " + encryptResponse);
//		System.out.println("AFTER filter, original response: " + decryptedString);

	}

}
