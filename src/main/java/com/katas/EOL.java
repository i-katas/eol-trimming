package com.katas;

public class EOL {
  public static String trim(String lines) {
    int pos = 0, n = lines.length();
    StringBuilder out = new StringBuilder(n);
    final int i = lines.indexOf('\n', pos);
    if(i != -1) {
      n = i - 1;
    }
    while(n > 0 && lines.charAt(n - 1) == ' ') {
      n--;
    }
    out.append(lines.substring(pos, n));
    if(i != -1) {
      out.append('\n');
    }
    return out.toString();
  }
}
