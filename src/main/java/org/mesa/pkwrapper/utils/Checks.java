package org.mesa.pkwrapper.utils;

import org.mesa.pkwrapper.exceptions.InvalidTokenException;

import java.util.Base64;

public class Checks {
    public static void token(String token) throws InvalidTokenException {
        if (token.length() != 64) throw new InvalidTokenException("The token is invalid. Please specify a valid token.");
        if (Base64.getDecoder().decode(token).length != 48) throw new InvalidTokenException("The token is invalid. Please specify a valid token.");
    }
}
