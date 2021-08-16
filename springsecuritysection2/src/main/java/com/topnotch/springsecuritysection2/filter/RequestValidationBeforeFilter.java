package com.topnotch.springsecuritysection2.filter;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class RequestValidationBeforeFilter implements Filter {

    public static final String AUTHENTICATION_SCHEME_BASIC = "Basic";
    private Charset credentialsCharset = StandardCharsets.UTF_8;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String header = httpServletRequest.getHeader(AUTHORIZATION);

        if(header != null){
            header = header.trim();
            if(StringUtils.startsWithIgnoreCase(header, AUTHENTICATION_SCHEME_BASIC)){
                byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
                byte[] decoded;
                try{
                    decoded = Base64.getDecoder().decode(base64Token);
                    String token = new String(decoded, getCredentialsCharset(httpServletRequest));
                    int delimiterIndex = token.indexOf(":");
                    if(delimiterIndex == -1){
                        throw new BadCredentialsException("Invalid Basic Authentication Token");
                    }
                    String email = token.substring(0, delimiterIndex);
                    if(email.toLowerCase().contains("test")){
                        httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        return;
                    }
                }catch (IllegalArgumentException e){
                    throw new BadCredentialsException("Failed to decode the basic authentication token");
                }
            }
        }
        chain.doFilter(request, response);
    }

    protected Charset getCredentialsCharset(HttpServletRequest request){
        return getCredentialsCharset();
    }

    public Charset getCredentialsCharset(){
        return this.credentialsCharset;
    }
}
