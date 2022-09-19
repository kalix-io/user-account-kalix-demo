package com.example.handle.domain;

import com.example.handle.HandleApi;
import com.google.protobuf.Empty;
import kalix.javasdk.testkit.ValueEntityResult;
import kalix.javasdk.valueentity.ValueEntity;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class HandleEntityTest {

  @Test
  @Ignore("to be implemented")
  public void exampleTest() {
    HandleEntityTestKit service = HandleEntityTestKit.of(HandleEntity::new);
    // // use the testkit to execute a command
    // // of events emitted, or a final updated state:
    // SomeCommand command = SomeCommand.newBuilder()...build();
    // ValueEntityResult<SomeResponse> result = service.someOperation(command);
    // // verify the reply
    // SomeReply reply = result.getReply();
    // assertEquals(expectedReply, reply);
    // // verify the final state after the command
    // assertEquals(expectedState, service.getState());
  }

  @Test
  @Ignore("to be implemented")
  public void reserveTest() {
    HandleEntityTestKit service = HandleEntityTestKit.of(HandleEntity::new);
    // Handle command = Handle.newBuilder()...build();
    // ValueEntityResult<Empty> result = service.reserve(command);
  }


  @Test
  @Ignore("to be implemented")
  public void confirmTest() {
    HandleEntityTestKit service = HandleEntityTestKit.of(HandleEntity::new);
    // Handle command = Handle.newBuilder()...build();
    // ValueEntityResult<Empty> result = service.confirm(command);
  }


  @Test
  @Ignore("to be implemented")
  public void expireTest() {
    HandleEntityTestKit service = HandleEntityTestKit.of(HandleEntity::new);
    // Handle command = Handle.newBuilder()...build();
    // ValueEntityResult<Empty> result = service.expire(command);
  }


  @Test
  @Ignore("to be implemented")
  public void deleteTest() {
    HandleEntityTestKit service = HandleEntityTestKit.of(HandleEntity::new);
    // Handle command = Handle.newBuilder()...build();
    // ValueEntityResult<Empty> result = service.delete(command);
  }


  @Test
  @Ignore("to be implemented")
  public void getStatusTest() {
    HandleEntityTestKit service = HandleEntityTestKit.of(HandleEntity::new);
    // Handle command = Handle.newBuilder()...build();
    // ValueEntityResult<HandleStatus> result = service.getStatus(command);
  }

}
