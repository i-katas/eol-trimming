package com.katas;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EndOfLineTrimmingTest {
  @Test
  public void returnOriginalStringImmediatelyThatContainsNoWhitespaces() throws Throwable {
    assertThat(EOL.trim("a"), equalTo("a"));
  }

  @Test
  public void removesLastWhitespaces() throws Throwable {
    assertThat(EOL.trim("a "), equalTo("a"));
    assertThat(EOL.trim("a  "), equalTo("a"));
  }
}
