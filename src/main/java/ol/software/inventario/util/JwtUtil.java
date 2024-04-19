package ol.software.inventario.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

  private String secretKey = "miClaveSecreta";
  private long expirationTime = 1000 * 60 * 60 * 10;

  public String generarToken(Long id, String username) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("id", id);
    claims.put("username", username);

    return Jwts.builder()
      .setClaims(claims)
      .setSubject(username)
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
      .signWith(SignatureAlgorithm.HS512, secretKey)
      .compact();
  }

  public Long obtenerIdDelToken(String token) {
    Claims claims = extractAllClaims(token);
    return claims.get("id", Long.class);
  }

  public String obtenerNombreDeUsuarioDelToken(String token) {
    Claims claims = extractAllClaims(token);
    return claims.getSubject();
  }

  public boolean validarToken(String token) {
    try {
      Claims claims = extractAllClaims(token);
      return claims != null &&
        !claims.getExpiration().before(new Date());
    } catch (Exception e) {
      return false;
    }
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parser()
      .setSigningKey(secretKey)
      .parseClaimsJws(token)
      .getBody();
  }

  public boolean esTokenValidoParaUsuario(String token, UserDetails userDetails) {
    String nombreUsuarioDelToken = obtenerNombreDeUsuarioDelToken(token);
    return nombreUsuarioDelToken.equals(userDetails.getUsername());
  }
}
