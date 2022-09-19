package com.example.api;

import akka.stream.javadsl.Source;
import com.example.api.UserAction;
import com.example.api.UserActionApi;
import com.example.api.UserActionTestKit;
import kalix.javasdk.testkit.ActionResult;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class UserActionTest {

  @Test
  @Ignore("to be implemented")
  public void exampleTest() {
    UserActionTestKit service = UserActionTestKit.of(UserAction::new);
    // // use the testkit to execute a command
    // SomeCommand command = SomeCommand.newBuilder()...build();
    // ActionResult<SomeResponse> result = service.someOperation(command);
    // // verify the reply
    // SomeReply reply = result.getReply();
    // assertEquals(expectedReply, reply);
  }

  @Test
  @Ignore("to be implemented")
  public void createTest() {
    UserActionTestKit testKit = UserActionTestKit.of(UserAction::new);
    // ActionResult<UserActionApi.UserId> result = testKit.create(UserActionApi.CreateUser.newBuilder()...build());
  }

}
