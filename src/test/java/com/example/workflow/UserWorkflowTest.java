package com.example.workflow;

import org.junit.Ignore;
import org.junit.Test;

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class UserWorkflowTest {

  @Test
  @Ignore("to be implemented")
  public void exampleTest() {
    WorkflowUserTestKit service = WorkflowUserTestKit.of(UserWorkflow::new);
    // // use the testkit to execute a command
    // SomeCommand command = SomeCommand.newBuilder()...build();
    // ActionResult<SomeResponse> result = service.someOperation(command);
    // // verify the reply
    // SomeReply reply = result.getReply();
    // assertEquals(expectedReply, reply);
  }

  @Test
  @Ignore("to be implemented")
  public void onUserCreatedTest() {
    WorkflowUserTestKit testKit = WorkflowUserTestKit.of(UserWorkflow::new);
    // ActionResult<Empty> result = testKit.onUserCreated(UserDomain.UserCreated.newBuilder()...build());
  }

  @Test
  @Ignore("to be implemented")
  public void onHandleChangedTest() {
    WorkflowUserTestKit testKit = WorkflowUserTestKit.of(UserWorkflow::new);
    // ActionResult<Empty> result = testKit.onHandleChanged(UserDomain.HandleChanged.newBuilder()...build());
  }

}
