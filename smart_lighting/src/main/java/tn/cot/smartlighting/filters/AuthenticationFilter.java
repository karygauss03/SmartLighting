package tn.cot.smartlighting.filters;

import tn.cot.smartlighting.repositories.UserTokenRepository;
import tn.cot.smartlighting.security.AccessToken;
import tn.cot.smartlighting.security.UserJWT;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Priorities;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Provider
@Priority(Priorities.AUTHENTICATION)
@Secured

public class AuthenticationFilter implements HttpAuthenticationMechanism {
    private static final Pattern CHALLENGE_PATTERN = Pattern.compile("^Bearer *([^ ]+) *$", Pattern.CASE_INSENSITIVE);
    private  static  final  List NOT_SECURED_PREFIX=List.of("oauth2","signup") ;

    @Inject
    private UserTokenRepository repository;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response,
                                                HttpMessageContext httpMessageContext) {

        if(!(request.getRequestURI().contains("oauth2") || request.getRequestURI().contains("signup"))) {
            final String authorization = request.getHeader("Authorization");
            Matcher matcher = CHALLENGE_PATTERN.matcher(Optional.ofNullable(authorization).orElse(""));
            if (!matcher.matches()) {
                System.out.println(matcher);
                return httpMessageContext.responseUnauthorized();
            }
            final String token = matcher.group(1);

            final Optional<AccessToken> optional = repository.findByAccessToken(token)
                    .flatMap(u -> u.findAccessToken(token));

            final AccessToken accessToken = optional.get();
            final Optional<UserJWT> optionalUserJWT = UserJWT.parse(accessToken.getToken(), accessToken.getJwtSecret());
            if (optionalUserJWT.isPresent()) {
                final UserJWT userJWT = optionalUserJWT.get();
                return httpMessageContext.notifyContainerAboutLogin(userJWT.getUser(), userJWT.getRoles());
            } else {
                return httpMessageContext.responseUnauthorized();
            }

        }else {
            return  httpMessageContext.doNothing() ;
        }
    }

}
