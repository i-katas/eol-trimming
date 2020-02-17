package com.katas;

public class EOL {
  public static String trim(String lines) {
    int n = lines.length();
    while(n > 0 && lines.charAt(n - 1) == ' ') {
      n--;
    }
    return lines.substring(0, n);
  }
}
