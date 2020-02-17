package com.katas;

public class EOL {
  private static final int FORWARD = 1;
  private static final int BACKWORD = -1;

  public static String trim(String lines) {
    if(lines == null) {
      return null;
    }

    int pos = 0, n = lines.length();
    StringBuilder out = new StringBuilder(n);
    for(int i; ; pos = i + 1 + skip(lines, i + 1, FORWARD)) {
      if((i = crlf(lines, pos)) == -1) {
        break;
      }
      out.append(lines.substring(pos, i - skip(lines, i - 1, BACKWORD)));
      out.append(lines.charAt(i));
    }

    out.append(lines.substring(pos, n - skip(lines, n - 1, BACKWORD)));
    return out.toString();
  }

  private static int crlf(String s, int pos) {
    for(int size = s.length(); pos < size; pos++) {
      switch(s.charAt(pos)) {
        case '\r':
        case '\n':
          return pos;
      }
    }
    return -1;
  }

  private static int skip(String s, int pos, int dir) {
    int n = 0;
    for(int size = s.length(); pos >= 0 && pos < size; ) {
      switch(s.charAt(pos)) {
        case ' ':
        case '\t':
          n++;
          pos += dir;
          break;
        default:
          return n;
      }
    }
    return n;
  }
}
