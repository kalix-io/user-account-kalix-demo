package com.example.api;

import com.example.handle.HandleApi;
import com.example.user.UserApi;
import com.google.protobuf.Empty;
import kalix.javasdk.action.ActionCreationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.CompletionStage;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Action Service described in your com/example/api/user_action.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class UserAction extends AbstractUserAction {

  private Logger logger = LoggerFactory.getLogger(getClass());

  public UserAction(ActionCreationContext creationContext) {}

  @Override
  public Effect<UserActionApi.UserId> create(UserActionApi.CreateUser createUser) {

    UserActionApi.UserId userId =
        UserActionApi.UserId
            .newBuilder().setValue(UUID.randomUUID().toString()).build();

    // reserve the handle first
    HandleApi.Handle reserveHandleCmd =
        HandleApi.Handle
            .newBuilder()
            .setHandleId(createUser.getHandle())
            .build();

    CompletionStage<Empty> handleRes =
        components().handleEntity().reserve(reserveHandleCmd)
            .execute();

    // create user command
    UserApi.CreateUser createUserCmd =
        UserApi.CreateUser.newBuilder()
            .setUserId(userId.getValue())
            .setFullName(createUser.getFullName())
            .setHandle(createUser.getHandle())
            .setEmail(createUser.getEmail())
            .build();

    CompletionStage<Effect<UserActionApi.UserId>> userCreationRes =
        handleRes
            // compose handleRes with userCreation
            .thenCompose(handleCreated ->
                components()
                    .userEntity().create(createUserCmd)
                    .execute()
                    // when user creation completes, return user id wrapped in an effect
                    .thenApply(userCreated -> effects().reply(userId))
            )
            // if handleRes is a failure, we return its original message
            .exceptionally(exp -> effects().error(exp.getMessage()));

    return effects().asyncEffect(userCreationRes);
  }
}
