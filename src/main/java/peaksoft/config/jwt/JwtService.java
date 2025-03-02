package peaksoft.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import peaksoft.model.User;

import java.time.ZonedDateTime;
@Component
@Service
public class JwtService {
    @Value("${app.jwt.secret}")
    private String secretKey;

    //create jwt token encode

    public String createToken(User user ) {
        Algorithm algorithm = Algorithm.HMAC512(secretKey);
        return JWT.create()
                .withClaim("email", user.getUsername())
                .withClaim("id", user.getId())
                .withClaim("name", user.getLastName())
                .withClaim("role", user.getRole().name())
                .withIssuedAt(ZonedDateTime.now().toInstant())
                .withExpiresAt(ZonedDateTime.now().plusMonths(1).toInstant())
                .sign(algorithm);

    }

    //verify token  decode

    public String verifyToken(String token){
        Algorithm algorithm = Algorithm.HMAC512(secretKey);
       JWTVerifier jwtVerifier= JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        String email= decodedJWT.getClaim("email").asString();

        return email;


    }
}
