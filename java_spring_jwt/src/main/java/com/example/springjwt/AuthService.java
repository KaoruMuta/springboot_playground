package com.example.springjwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Service
@Slf4j
public class AuthService {

    private static final int EXPIRATION_MINUTES = 5;

    // NOTE: Require to describe random secret in application.properties
    @Value("${jwt.secret.key}")
    private String secretKey;

    public String getToken(final String id) {
        String token = "";
        try {
            final JWSSigner signer = new MACSigner(secretKey);
            final JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.HS256)
                    .type(JOSEObjectType.JWT)
                    .build();
            final JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject("test")
                    .issuer("nimbus-jose-jwt")
                    .claim("id", id)
                    .expirationTime(new Date(new Date().getTime() + EXPIRATION_MINUTES * 60 * 1000))
                    .build();
            final SignedJWT signedJWT = new SignedJWT(jwsHeader, claimsSet);
            signedJWT.sign(signer);
            token = signedJWT.serialize();
        } catch (final JOSEException e) {
            log.error(e.getMessage(), e);
        }
        return token;
    }

    public String verify(final String token) {
        String requestId = "";
        try {
            final SignedJWT signedJWT = SignedJWT.parse(token);
            log.info("Signature:{}", signedJWT.getSignature());
            final JWSVerifier verifier = new MACVerifier(secretKey);
            boolean isVerified = signedJWT.verify(verifier);
            if (!isVerified) {
                log.error("JWT is not verified");
                return "";
            }
            log.info("Claims:{}", signedJWT.getJWTClaimsSet());
            requestId = signedJWT.getJWTClaimsSet().getStringClaim("id");
        } catch (ParseException | JOSEException e) {
            log.error(e.getMessage(), e);
        }
        return requestId;
    }
}
