package com.example.negociogeneral.Utils;

import com.example.negociogeneral.Security.config.TokenProvider;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Component
public class TokenUtils {
    @Value("${jwt.header.string}")
    public String HEADER_STRING;

    @Value("${jwt.token.prefix}")
    public String TOKEN_PREFIX;

    @Autowired
    private TokenProvider jwtTokenUtil;

    public String getUsernameToToken (HttpServletRequest req) {
        String header = req.getHeader(HEADER_STRING);
        String username = null;
        String authToken = null;
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            authToken = header.replace(TOKEN_PREFIX,"");
            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e) {
                System.out.println( "An error occurred while fetching Username from Token");
            } catch (ExpiredJwtException e) {
                System.out.println( "The token has expired");
            } catch(SignatureException e){
                System.out.println( "Authentication Failed. Username or Password not valid.");
            }
        } else {
            System.out.println( "Couldn't find bearer string, header will be ignored");
        }
        return username;
    }
}
