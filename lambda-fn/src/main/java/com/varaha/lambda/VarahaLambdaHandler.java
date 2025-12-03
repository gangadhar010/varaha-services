package com.varaha.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.varaha.lambda.dto.UserRequest;
import com.varaha.lambda.dto.UserResponse;
import com.varaha.common.service.UserService;

public class VarahaLambdaHandler implements RequestHandler<UserRequest, UserResponse> {

    private final UserService userService = new UserService();

    @Override
    public UserResponse handleRequest(UserRequest request, Context context) {
        // In a real application, you'd use the request to fetch a user
        // For now, we'll just return a dummy response
        return new UserResponse();
    }
}
