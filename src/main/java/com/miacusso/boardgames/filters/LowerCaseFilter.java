package com.miacusso.boardgames.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class LowerCaseFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		HtmlServletResponseWrapper capturingResponseWrapper = new HtmlServletResponseWrapper(response);

		filterChain.doFilter(request, capturingResponseWrapper);

		String content = capturingResponseWrapper.getCaptureAsString();
		response.getWriter().write(content.toLowerCase());

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String path = request.getServletPath();
		return !path.matches("^/([0-9]+/players|[0-9]+/result-table)$");
	}

}
