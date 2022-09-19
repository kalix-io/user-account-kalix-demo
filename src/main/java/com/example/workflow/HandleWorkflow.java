package com.example.workflow;

import com.example.handle.HandleApi;
import com.example.handle.domain.HandleDomain;
import com.google.protobuf.Empty;
import kalix.javasdk.action.ActionCreationContext;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletionStage;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Action Service described in your com/example/workflow/workflow_handle_action.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class HandleWorkflow extends AbstractHandleWorkflow {

  public HandleWorkflow(ActionCreationContext creationContext) {
  }

  @Override
  public Effect<Empty> onHandleChange(HandleDomain.HandleState handleState) {

    // it's not guarantee to see all changes.
    // If we see a confirmed handle, we don't need to do anything
    // If we see an unconfirmed handle, we can schedule a timer to expire it
    if (handleState.getConfirmed()) {
      return effects().reply(Empty.getDefaultInstance());
    } else {
      CompletionStage<Empty> expirationTimer =
          timers()
              .startSingleTimer(
                  HandleTimerName.of(handleState.getHandle()),
                  Duration.of(30, ChronoUnit.MINUTES),
                  components().handleEntity().expire(HandleApi.Handle.newBuilder().setHandleId(handleState.getHandle()).build())
              )
              .thenApply(__ -> Empty.getDefaultInstance());

      return effects().asyncReply(expirationTimer);
    }
  }
}
