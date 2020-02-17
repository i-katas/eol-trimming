package com.katas;

public class EOL {
  public static String trim(String lines) {
    int pos = 0, n = lines.length();
    StringBuilder out = new StringBuilder(n);
    for(int i ; ; pos = i + 1) {
      i = lines.indexOf('\n', pos);
      if(i == -1) {
        break;
      }
      out.append(lines.substring(pos, i - skip(lines, i - 1)));
      out.append('\n');
    }

    out.append(lines.substring(pos, n - skip(lines, n - 1)));
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
