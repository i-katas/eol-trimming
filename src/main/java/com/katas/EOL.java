package com.katas;

public class EOL {
  private static final int FORWARD = 1;
  private static final int BACKWORD = -1;

  public static String trim(String lines) {
    int pos = 0, n = lines.length();
    StringBuilder out = new StringBuilder(n);
    for(int i ; ; pos = i + 1 + skip(lines, i + 1, FORWARD)) {
      i = lines.indexOf('\n', pos);
      if(i == -1) {
        break;
      }
      out.append(lines.substring(pos, i - skip(lines, i - 1, BACKWORD)));
      out.append('\n');
    }

    out.append(lines.substring(pos, n - skip(lines, n - 1, BACKWORD)));
    return out.toString();
  }

  public static int skip(String s, int pos, int dir) {
    int n = 0;
    for(int size = s.length(); pos >= 0 && pos < size && s.charAt(pos) == ' '; ) {
      n++;
      pos += dir;
    }
    return n;
  }
}
