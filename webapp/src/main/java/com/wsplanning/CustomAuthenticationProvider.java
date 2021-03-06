package com.wsplanning;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
  private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

  public static final String SESSION_LANG = "SESSION_LANG";
  public static final String SESSION_SITEID = "SESSION_SITEID";

  public CustomAuthenticationProvider() {
    logger.info("*** CustomAuthenticationProvider created");
    hsmLang = new HashMap<>();
    hsmLang.put("100","vi");
    hsmLang.put("102","en");
    hsmLang.put("103","en");
    hsmLang.put("104","en");
    hsmLang.put("105","en");
    hsmLang.put("106","en");

    hsmCountry = new HashMap<>();
    hsmCountry.put("100","VN");
    hsmCountry.put("102","en");
    hsmCountry.put("103","en");
    hsmCountry.put("104","en");
    hsmCountry.put("105","en");
    hsmCountry.put("106","en");

    //http://localhost:8081/mechanic/?lang=vi
  }

  @Autowired(required = false)
  private HttpServletRequest request;

  @Autowired
  private HttpSession session;

  public static HashMap<String,String> hsmLang = new HashMap<>();
  public static HashMap<String,String> hsmCountry = new HashMap<>();

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String siteId = (String) request.getParameter("siteId");
    String language = hsmLang.get(siteId);
    if(language == null || StringUtils.isBlank(language)){
      language = "en";
    }
    session.setAttribute(SESSION_LANG, language);
    System.out.println("request siteId testing= " + siteId);
    session.setAttribute(SESSION_SITEID, siteId);
    if (authentication.getName().equals("admin") && authentication.getCredentials().equals("admin")) {
      List<GrantedAuthority> grantedAuths = new ArrayList<>();
      grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
      grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
      return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), grantedAuths);
    } else {
      return null;
    }

  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
