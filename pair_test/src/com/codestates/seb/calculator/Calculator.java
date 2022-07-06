package com.codestates.seb.calculator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {

  public static void main(String[] args) {
    System.out.println("===Java Calculator===");
    Scanner input = new Scanner(System.in);
    String Test = "";
    while(true){
      Test = input.nextLine();
      if(Test.equals("~")) break;
      cal_(Test);
    }
  }

  private static void cal_(String Test) {
    // =====================================================
    StringBuffer sb = new StringBuffer();
    // =====================================================

    sb.append(EnterSpace(Test));
    int symbolNum = symbolChk(Test);

    StringTokenizer st = new StringTokenizer(sb.toString());
    String[] arithmeticArr = new String[st.countTokens()];

    int i = 0;
    while (st.hasMoreTokens()) {
      arithmeticArr[i++] = st.nextToken();
    }

    Double n1 = Double.parseDouble(arithmeticArr[0]);
    Double n2 = Double.parseDouble(arithmeticArr[2]);

    double result = 0.0;
    switch (symbolNum) {
      case 0:
        result = n1 + n2;
        break;
      case 1:
        result = n1 - n2;
        break;
      case 2:
        result = n1 * n2;
        break;
      case 3:
        if(n2 == 0){
          System.out.println("Err: 0으로 나눌 수 없습니다.");
          return;
        }
        result = n1 / n2;
        break;
      default:
        System.out.println("*** Err : 지원하지 않는 연산 기능 ***");
        return;
    }

    if(result % 1 <=0 ){
      System.out.println(Test + " = " + Math.round(result));
    } else{
      System.out.println(Test + " = " + result);
    }

  }

  //
  public static int symbolChk(String inpMsg){
    int chkNum = -1;
    int cnt = 0;
    String[] symbolArr = {"+", "-", "*" , "/"};
    for (int i = 0; i < symbolArr.length; i++){
      if (inpMsg.contains(symbolArr[i])){
        chkNum = i;
      }
    }
    return chkNum;
  }

  public static StringBuffer EnterSpace(String Test){
    StringBuffer sb = new StringBuffer();
    char ascii = 0;
    for (int i = 0, j = i + 1; i < Test.length(); i++){
      ascii = Test.charAt(i);
      if (ascii > 47 && ascii < 58) {
        sb.append(ascii);
      } else {
        sb.append(" ");
        sb.append(ascii);
        sb.append(" ");
      }
    }
    return sb;
  }
}

