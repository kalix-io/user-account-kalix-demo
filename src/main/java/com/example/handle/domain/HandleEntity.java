package com.example.handle.domain;

import com.example.handle.HandleApi;
import com.google.protobuf.Empty;
import kalix.javasdk.valueentity.ValueEntityContext;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Value Entity Service described in your com/example/handle/handle_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class HandleEntity extends AbstractHandleEntity {
  @SuppressWarnings("unused")
  private final String entityId;

  public HandleEntity(ValueEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public HandleDomain.HandleState emptyState() {
    return null;
  }

  @Override
  public Effect<Empty> reserve(HandleDomain.HandleState currentState, HandleApi.Handle handle) {
    if (currentState != null)
      return effects().error("Handle [" + handle.getHandleId() + "] is already taken");
    else
      return effects()
          .updateState(
              HandleDomain.HandleState.newBuilder().setHandle(handle.getHandleId()).build())
          .thenReply(Empty.getDefaultInstance());
  }

  @Override
  public Effect<Empty> confirm(HandleDomain.HandleState currentState, HandleApi.Handle handle) {
    HandleDomain.HandleState updated = currentState.toBuilder().setConfirmed(true).build();
    return effects().updateState(updated).thenReply(Empty.getDefaultInstance());
  }

  @Override
  public Effect<Empty> expire(HandleDomain.HandleState currentState, HandleApi.Handle handle) {
    // do nothing if already confirmed
    if (currentState.getConfirmed()) {
      return effects().reply(Empty.getDefaultInstance());
    } else {
      return delete(currentState, handle);
    }
  }

  @Override
  public Effect<Empty> delete(HandleDomain.HandleState currentState, HandleApi.Handle handle) {
    return effects().deleteState().thenReply(Empty.getDefaultInstance());
  }

  @Override
  public Effect<HandleApi.HandleStatus> getStatus(HandleDomain.HandleState currentState, HandleApi.Handle handle) {
    if (currentState != null) {
      return effects().reply(HandleApi.HandleStatus.newBuilder().setConfirmed(currentState.getConfirmed()).build());
    } else {
      return effects().error("No handle found for: " + handle.getHandleId());
    }

  }
}
