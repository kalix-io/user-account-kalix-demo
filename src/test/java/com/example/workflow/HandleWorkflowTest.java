package com.example.workflow;

import org.junit.Ignore;
import org.junit.Test;

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class HandleWorkflowTest {

  @Test
  @Ignore("to be implemented")
  public void exampleTest() {
    WorkflowHandleTestKit service = WorkflowHandleTestKit.of(HandleWorkflow::new);
    // // use the testkit to execute a command
    // SomeCommand command = SomeCommand.newBuilder()...build();
    // ActionResult<SomeResponse> result = service.someOperation(command);
    // // verify the reply
    // SomeReply reply = result.getReply();
    // assertEquals(expectedReply, reply);
  }

  @Test
  @Ignore("to be implemented")
  public void onHandleChangeTest() {
    WorkflowHandleTestKit testKit = WorkflowHandleTestKit.of(HandleWorkflow::new);
    // ActionResult<Empty> result = testKit.onHandleChange(HandleDomain.HandleState.newBuilder()...build());
  }

}
