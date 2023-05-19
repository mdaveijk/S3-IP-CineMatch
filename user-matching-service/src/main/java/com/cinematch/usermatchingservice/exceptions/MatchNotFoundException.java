package com.cinematch.usermatchingservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Match Not Found")
public class MatchNotFoundException extends Exception {
    // TODO
}
