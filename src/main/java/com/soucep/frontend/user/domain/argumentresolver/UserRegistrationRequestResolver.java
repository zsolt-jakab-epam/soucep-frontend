package com.soucep.frontend.user.domain.argumentresolver;

import com.soucep.frontend.user.domain.UserRegistrationRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import static com.google.common.base.MoreObjects.firstNonNull;
import static common.Constants.*;


/**
 * Created by Zsolt_Jakab on 7/4/2017.
 */
public class UserRegistrationRequestResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserRegistrationRequest.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String firstName = firstNonNull(webRequest.getParameter(FIRST_NAME), EMPTY);
        String lastName = firstNonNull(webRequest.getParameter(LAST_NAME), EMPTY);
        String email = firstNonNull(webRequest.getParameter(EMAIL), EMPTY);

        return UserRegistrationRequest.builder().firstName(firstName).lastName(lastName).email(email).build();
    }
}
