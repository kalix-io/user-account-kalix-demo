package com.example.user.domain;

import com.example.user.UserApi;
import com.google.protobuf.Empty;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityContext;
import kalix.javasdk.testkit.EventSourcedResult;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class UserEntityTest {

  @Test
  @Ignore("to be implemented")
  public void exampleTest() {
    UserEntityTestKit service = UserEntityTestKit.of(UserEntity::new);
    // // use the testkit to execute a command
    // // of events emitted, or a final updated state:
    // SomeCommand command = SomeCommand.newBuilder()...build();
    // EventSourcedResult<SomeResponse> result = service.someOperation(command);
    // // verify the emitted events
    // ExpectedEvent actualEvent = result.getNextEventOfType(ExpectedEvent.class);
    // assertEquals(expectedEvent, actualEvent);
    // // verify the final state after applying the events
    // assertEquals(expectedState, service.getState());
    // // verify the reply
    // SomeReply reply = result.getReply();
    // assertEquals(expectedReply, reply);
  }

  @Test
  @Ignore("to be implemented")
  public void createTest() {
    UserEntityTestKit service = UserEntityTestKit.of(UserEntity::new);
    // CreateUser command = CreateUser.newBuilder()...build();
    // EventSourcedResult<Empty> result = service.create(command);
  }


  @Test
  @Ignore("to be implemented")
  public void changeHandleTest() {
    UserEntityTestKit service = UserEntityTestKit.of(UserEntity::new);
    // ChangeHandleRequest command = ChangeHandleRequest.newBuilder()...build();
    // EventSourcedResult<Empty> result = service.changeHandle(command);
  }


  @Test
  @Ignore("to be implemented")
  public void getTest() {
    UserEntityTestKit service = UserEntityTestKit.of(UserEntity::new);
    // GetUser command = GetUser.newBuilder()...build();
    // EventSourcedResult<User> result = service.get(command);
  }

}
