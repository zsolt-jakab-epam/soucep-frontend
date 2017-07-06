package com.soucep.frontend.user.domain;

import com.soucep.frontend.configuration.immutables.style.SoucepImmutablesStyle;
import org.immutables.value.Value;



/**
 * Created by Zsolt_Jakab on 7/3/2017.
 */
@Value.Immutable
@SoucepImmutablesStyle
public interface UserRegistrationRequest {

    String firstName();

    String lastName();

    String email();

    class Builder extends ImmutableUserRegistrationRequest.Builder {
    }

    static Builder builder() {
        return new Builder();
    }
}
