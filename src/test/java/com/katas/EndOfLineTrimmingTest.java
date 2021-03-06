package com.katas;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

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
  public void trimmingNull() throws Throwable {
    assertThat(EOL.trim(null), is(nullValue()));
  }

  @Test
  public void removesLeftSideWhitespacesOfLineEncoding() throws Throwable {
    assertThat(EOL.trim("a \n"), equalTo("a\n"));
    assertThat(EOL.trim("a \nb \n"), equalTo("a\nb\n"));
  }

  @Test
  public void removeRightSideWhitespacesOfLineEncoding() throws Throwable {
    assertThat(EOL.trim("a\n b"), equalTo("a\nb"));
  }

  @Test
  public void removesTabsInTheEndOfLine() throws Throwable {
    assertThat(EOL.trim("a\t"), equalTo("a"));
  }

  @Test
  public void removeCRLFBothSideWhitespaces() throws Throwable {
    assertThat(EOL.trim("a \r\n b"), equalTo("a\r\nb"));
  }

  @Test
  public void trimmingAllNecessaryWhitespacesAndTabs() throws Throwable {
    assertThat(EOL.trim(" a \r\n b \n c\t"), equalTo(" a\r\nb\nc"));
  }

  @Test
  public void keepsBeginningWhitespaces() throws Throwable {
    assertThat(EOL.trim(" a"), equalTo(" a"));
  }

}
