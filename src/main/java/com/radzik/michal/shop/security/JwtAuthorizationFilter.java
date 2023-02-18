package com.radzik.michal.shop.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Deprecated
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
       var token = request.getHeader(HttpHeaders.AUTHORIZATION);
       if(token == null || !token.startsWith("Bearer ")){
           chain.doFilter(request, response);
           return;
       }
       var claims = Jwts.parser()
               .setSigningKey("keySecret")
               .parseClaimsJws(token.replace("Bearer ", ""))
               .getBody();
       var email = claims.getSubject();

       if(email==null){
           response.setStatus(401);
           return;
       }
       var authorities = claims.get("authorities", String.class);
        var grantedAuthorities = new ArrayList<GrantedAuthority>();
        if(authorities != null && !authorities.isEmpty()){
            grantedAuthorities = Arrays.stream(authorities.split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toCollection(ArrayList::new));

        }
        var user = new UsernamePasswordAuthenticationToken(email,null,grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(user);
        chain.doFilter(request,response);
    }
}
