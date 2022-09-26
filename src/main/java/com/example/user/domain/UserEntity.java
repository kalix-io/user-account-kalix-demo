package com.example.user.domain;

import com.example.user.UserApi;
import com.google.protobuf.Empty;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityContext;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Event Sourced Entity Service described in your com/example/user/user_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class UserEntity extends AbstractUserEntity {

  @SuppressWarnings("unused")
  private final String entityId;

  public UserEntity(EventSourcedEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public UserDomain.UserState emptyState() {
    return null;
  }


  @Override
  public Effect<Empty> create(UserDomain.UserState currentState, UserApi.CreateUser createUser) {
    if (currentState != null) {
      return effects().error("User [" + entityId + "] already created");
    } else {
      UserDomain.UserCreated event =
          UserDomain.UserCreated.newBuilder()
              .setFullName(createUser.getFullName())
              .setHandle(createUser.getHandle())
              .setEmail(createUser.getEmail())
              .build();
      return effects()
          .emitEvent(event)
          .thenReply(__ -> Empty.getDefaultInstance());
    }
  }

  @Override
  public Effect<Empty> changeHandle(UserDomain.UserState currentState,
                                    UserApi.ChangeHandleRequest changeHandleRequest) {

    UserDomain.HandleChanged event =
        UserDomain.HandleChanged
            .newBuilder()
            .setNewHandle(changeHandleRequest.getNewHandle())
            .build();

    return effects()
        .emitEvent(event)
        .thenReply(__ -> Empty.getDefaultInstance());
  }

  @Override
  public Effect<UserApi.User> get(UserDomain.UserState currentState, UserApi.GetUser getUser) {
    return effects().reply(
        UserApi.User
            .newBuilder()
            .setFullName(currentState.getFullName())
            .setEmail(currentState.getEmail())
            .setHandle(currentState.getHandle())
            .build()
    );
  }

  @Override
  public UserDomain.UserState userCreated(UserDomain.UserState currentState,
                                          UserDomain.UserCreated userCreated) {

    return UserDomain.UserState.newBuilder()
        .setFullName(userCreated.getFullName())
        .setEmail(userCreated.getEmail())
        .setHandle(userCreated.getHandle())
        .build();
  }

  @Override
  public UserDomain.UserState handleChanged(UserDomain.UserState currentState,
                                            UserDomain.HandleChanged handleChanged) {
    return currentState.toBuilder().setHandle(handleChanged.getNewHandle()).build();
  }


}
