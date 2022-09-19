package com.example.workflow;

import com.example.handle.HandleApi;
import com.example.user.domain.UserDomain;
import com.google.protobuf.Empty;
import kalix.javasdk.action.ActionCreationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Action Service described in your com/example/workflow/workflow_user_action.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class UserWorkflow extends AbstractUserWorkflow {


  private Logger logger = LoggerFactory.getLogger(getClass());

  public UserWorkflow(ActionCreationContext creationContext) {
  }

  @Override
  public Effect<Empty> onUserCreated(UserDomain.UserCreated userCreated) {
    logger.info("User creation with handle [" + userCreated.getHandle() + "] is confirmed!");
    HandleApi.Handle confirmHandle = buildHandle(userCreated.getHandle());
    return effects().forward(components().handleEntity().confirm(confirmHandle));
  }

  @Override
  public Effect<Empty> onHandleChanged(UserDomain.HandleChanged handleChanged) {
    logger.info("User creation with handle [" + handleChanged.getNewHandle() + "] is confirmed," +
        " deleting old handle  [" + handleChanged.getOldHandle() + "].");

    HandleApi.Handle confirmNewHandle = buildHandle(handleChanged.getNewHandle());
    HandleApi.Handle oldHandle = buildHandle(handleChanged.getOldHandle());

    return effects().asyncReply(
        components().handleEntity().confirm(confirmNewHandle).execute()
            .thenCompose(done -> components().handleEntity().delete(oldHandle).execute())
    );
  }

  private HandleApi.Handle buildHandle(String handle) {
    return HandleApi.Handle.newBuilder().setHandleId(handle).build();
  }
}
