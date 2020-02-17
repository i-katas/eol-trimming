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

  @Test
  public void trimmingBlankLine() throws Throwable {
    assertThat(EOL.trim(" "), equalTo(""));
  }

  @Test
  public void removesLeftSideWhitespacesOfLineEncoding() throws Throwable {
    assertThat(EOL.trim("a \n"), equalTo("a\n"));
    assertThat(EOL.trim("a \nb \n"), equalTo("a\nb\n"));
  }

  @Test
  public void removeRightSideWhitespacesOfLineEncoding() throws Throwable {
    //assertThat(EOL.trim("a\n b"), equalTo("a\nb"));
  }

  @Test
  public void skipRightWhitespaces() throws Throwable {
    assertThat(EOL.skip("a", 0), equalTo(0));
    assertThat(EOL.skip(" ", 0), equalTo(1));
    assertThat(EOL.skip("  ", 1), equalTo(2));
  }

}
