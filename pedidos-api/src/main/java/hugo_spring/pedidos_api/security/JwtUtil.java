package hugo_spring.pedidos_api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;



@Component
public class JwtUtil {
    private static final Key secret = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPIRATION = 1000 * 60 * 60 *24;

    public static String generateToken(String email){
        return Jwts.builder().subject(email).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+ 86400000)).signWith(secret).compact();
    }
    public static String extrairEmail(String token){
        return Jwts.parser().verifyWith((javax.crypto.SecretKey)secret).build().parseSignedClaims(token).getPayload().getSubject();
    }
    public static boolean validarToken(String token){
        try{
            extrairEmail(token);
                    return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
