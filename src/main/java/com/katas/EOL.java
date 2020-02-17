package com.katas;

public class EOL {
  public static String trim(String lines) {
    int pos = 0, n = lines.length();
    StringBuilder out = new StringBuilder(n);
    final int i = lines.indexOf('\n', pos);
    if(i != -1) {
      n = i;
    }
    out.append(lines.substring(pos, n - skip(lines, n - 1)));
    if(i != -1) {
      out.append('\n');
    }
    return out.toString();
  }

  public static int skip(String s, int pos) {
    int n = 0;
    while(pos >= 0 && s.charAt(pos) == ' ') {
      n++;
      pos--;
    }
    return n;
  }
}
