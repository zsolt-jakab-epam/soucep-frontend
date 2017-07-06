package com.soucep.frontend.user.domain.argumentresolver;

import com.soucep.frontend.user.domain.UserRegistrationRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.core.MethodParameter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import static common.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Zsolt_Jakab on 7/5/2017.
 */
@RunWith(SpringRunner.class)
public class UserRegistrationRequestResolverTest {

    private UserRegistrationRequestResolver underTest = new UserRegistrationRequestResolver();

    @Mock
    private MethodParameter methodParameter;

    @Mock
    ModelAndViewContainer modelAndViewContainer;

    @Mock
    NativeWebRequest nativeWebRequest;

    @Mock
    WebDataBinderFactory webDataBinderFactory;

    @Test
    public void supportsParameter_Should_ReturnTrue_When_ParamTypeIsUserRegistrationRequest() {
        //GIVEN
        doReturn(UserRegistrationRequest.class).when(methodParameter).getParameterType();

        //WHEN
        boolean result = underTest.supportsParameter(methodParameter);

        //THEN
        assertTrue(result);
        verify(methodParameter, times(ONE)).getParameterType();
    }

    @Test
    public void supportsParameter_Should_ReturnFalse_When_ParamTypeIsNotUserRegistrationRequest() {
        //GIVEN
        doReturn(HandlerMethodArgumentResolver.class).when(methodParameter).getParameterType();

        //WHEN
        boolean result = underTest.supportsParameter(methodParameter);

        //THEN
        assertFalse(result);
        verify(methodParameter, times(ONE)).getParameterType();
    }

    @Test
    public void resolveArgument_Should_CreateNewUserRegistrationRequest_When_ParamTypeIsUserRegistrationRequest() throws Exception {
        //GIVEN
        doReturn(HandlerMethodArgumentResolver.class).when(methodParameter).getParameterType();
        given(nativeWebRequest.getParameter(FIRST_NAME)).willReturn(ELVIS);
        given(nativeWebRequest.getParameter(LAST_NAME)).willReturn(COSTELLO);
        given(nativeWebRequest.getParameter(EMAIL)).willReturn(ELVIS_COSTELLOS_EMAIL);
        UserRegistrationRequest expected = UserRegistrationRequest.builder().firstName(ELVIS).lastName(COSTELLO).email(ELVIS_COSTELLOS_EMAIL).build();;

        //WHEN
        UserRegistrationRequest result = (UserRegistrationRequest) underTest.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);

        //THEN

        assertEquals(expected, result);
        verify(nativeWebRequest, times(ONE)).getParameter(FIRST_NAME);
        verify(nativeWebRequest, times(ONE)).getParameter(LAST_NAME);
        verify(nativeWebRequest, times(ONE)).getParameter(EMAIL);
    }

    @Test
    public void resolveArgument_Should_CreateNewUserRegistrationRequest_With_EmptyFields_When_NativeWebRequestParametersAreNotSet() throws Exception {
        //GIVEN
        doReturn(HandlerMethodArgumentResolver.class).when(methodParameter).getParameterType();
        given(nativeWebRequest.getParameter(FIRST_NAME)).willReturn(null);
        given(nativeWebRequest.getParameter(LAST_NAME)).willReturn(null);
        given(nativeWebRequest.getParameter(EMAIL)).willReturn(null);
        UserRegistrationRequest expected = UserRegistrationRequest.builder().firstName(EMPTY).lastName(EMPTY).email(EMPTY).build();;

        //WHEN
        UserRegistrationRequest result = (UserRegistrationRequest) underTest.resolveArgument(methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory);

        //THEN

        assertEquals(expected, result);
        verify(nativeWebRequest, times(ONE)).getParameter(FIRST_NAME);
        verify(nativeWebRequest, times(ONE)).getParameter(LAST_NAME);
        verify(nativeWebRequest, times(ONE)).getParameter(EMAIL);
    }

}
