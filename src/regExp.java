/**Author: NAZMUDDIN AL MASOOD - Contact:nazmumasood96@gmail.com 
  Date started:16/11/2018; Date finished:16/11/2018; Last edited:16/11/2018
  **/

/*                  ----- About the program ----
 The program takes a string input from user and checks it's acceptance under various regular expressions.
 For simplicity, we will assume that there is a fixed set of regular expressions. We will not consider
 out of these. But we must not use any built-in method or package in our implementation. 
 In Regular Expression (RE), 
 '*' means occurrence of zero of more characters, 
 '+' indicates happening of one or more characters, 
 '?'  means only once or not at all occurrence, 
 '[ ]' indicates happening of inclusive characters, 
 '^' indicates that next characters will not be used in the pattern,
 '[a-d]{3}' indicates that valid string will be exactly of  length 3 inclusively using a, b, c, d. 
 The following table contains a fixed set of RE that will be used in our program.
 
 Description               RE             Valid                 Invalid
 ============           =========       =========              =========
 Zero or more           a(bc)*de        ade;abcbcde            abde;abcbde
 
 One or more            a(bc)+de        abcde;abcbcde          ade;abc
 
 
 Once or not at all     a(bc)?de        ade;abcde              abc;abcbcde
 
 Character classes      [a-m]*          blackmail;imbecile     above;below
 
 Negation of 
 character classes      [^aeiou]        b;c                    a;e 
 
 Exactly N times        [^aeiou]{6}     rhythm;syzygy          rhythms;allowed
 
 ------
 INPUT:
 abcbcde
 
 OUTPUT:
 Given string : abcbcde 
 ==== Regular Expression : a(bc)*de ==== 
 YES 
 ==== Regular Expression : a(bc)+de ==== 
 YES 
 ==== Regular Expression : a(bc)?de ==== 
 NO 
 ==== Regular Expression : [a-m] ==== 
 YES 
 ==== Regular Expression : [^aeiou] ==== 
 NO 
 ==== Regular Expression : [^aeiou]{6} ==== 
 NO  
 ------
 INPUT:
 syzygy
 
 OUTPUT:
 Given string : syzygy 
 ==== Regular Expression : a(bc)*de ==== 
 NO 
 ==== Regular Expression : a(bc)+de ==== 
 NO 
 ==== Regular Expression : a(bc)?de ==== 
 NO 
 ==== Regular Expression : [a-m] ==== 
 NO 
 ==== Regular Expression : [^aeiou] ==== 
 YES 
 ==== Regular Expression : [^aeiou]{6} ==== 
 YES 
 */

/* Methods used : main(), checkRE(), zeroOrMore(), oneOrMore(), onceOrNotAtAll(), charClass(),
 negationOfCharClass(), exactlyNTimesNegationOfCharClass(), letsPrint() */

import java.util.Scanner;
public class regExp{
  static boolean flag=false;static int acceptedAt=0;
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter a string : ");
    String s= sc.nextLine(); 
    System.out.println("Given string : "+s);
    checkRE(s);
  }
//Checks for the string's acceptance under each regular expression rule  
  public static int checkRE(String s){
    zeroOrMore(s); letsPrint("a(bc)*de");
    oneOrMore(s); letsPrint("a(bc)+de");
    onceOrNotAtAll(s);letsPrint("a(bc)?de");
    charClass(s);letsPrint("[a-m]");
    negationOfCharClass(s);letsPrint("[^aeiou]");
    exactlyNTimesNegationOfCharClass(s);letsPrint("[^aeiou]{6}");
    return 0;
  }
//Matches against the regular expression "a(bc)*de" 
  public static int zeroOrMore(String s){
    flag=false;
    if(s.length()<3){return 0;}   
    if(s.equals("ade")){flag=true;acceptedAt=1;return 0;}    
    if(!Character.toString(s.charAt(0)).equals("a")||!Character.toString(s.charAt(s.length()-2)).equals("d")||
       !Character.toString(s.charAt(s.length()-1)).equals("e")){ 
      return 0;
    }
    
    s=s.substring(1,s.length()-2);
    if(s.length()%2!=0){return 0;}
    while(!s.equals("")){
      flag=false; acceptedAt=0;
      if(s.substring(0,2).equals("bc")){flag=true;acceptedAt=1;}
      s=s.substring(2,s.length());   
    }    
    return 0;
  }
  
//Matches against the regular expression "a(bc)+de"   
  public static int oneOrMore(String s){
    flag=false;
    if(s.length()<5){return 0;}    
    if(!Character.toString(s.charAt(0)).equals("a")||!Character.toString(s.charAt(s.length()-2)).equals("d")||
       !Character.toString(s.charAt(s.length()-1)).equals("e")){ 
      return 0;
    }
    
    s=s.substring(1,s.length()-2);
    if(s.length()%2!=0){return 0;}
    while(!s.equals("")){
      flag=false; acceptedAt=0;
      if(s.substring(0,2).equals("bc")){flag=true;acceptedAt=2;}
      s=s.substring(2,s.length());   
    }    
    return 0;
  }
  
//Matches against the regular expression "a(bc)?de"   
  public static int onceOrNotAtAll(String s){
    flag=false;
    if(s.length()>5){return 0;}   
    if(s.equals("ade")){flag=true;acceptedAt=3;return 0;}    
    if(s.equals("abcde")){flag=true;acceptedAt=3;return 0;}   
    return 0;
  }
//Matches against the regular expression "[a-m]"   
  public static int charClass(String s){
    flag=false;
    String ill = "nopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for(int i=0;i<s.length();i++){
      for(int j=0;j<ill.length();j++){
        //System.out.println(Character.toString(s.charAt(i))+" and "+Character.toString(ill.charAt(j)));
        if(Character.toString(s.charAt(i)).equals(Character.toString(ill.charAt(j)))){
          return 0;
        }
      }
    }
    flag=true;acceptedAt=4; 
    return 0;
  }
  
//Matches against the regular expression "[^aeiou]"   
  public static int negationOfCharClass(String s){
    flag=false;
    String ill = "aeiou";
    for(int i=0;i<s.length();i++){
      for(int j=0;j<ill.length();j++){
        if(Character.toString(s.charAt(i)).equals(Character.toString(ill.charAt(j)))){
          return 0;
        }
      }
    }
    flag=true;acceptedAt=5; 
    return 0;
  }
  
//Matches against the regular expression "[^aeiou]{6}"   
  public static int exactlyNTimesNegationOfCharClass(String s){
    flag=false;
    if(s.length()!=6){return 0;}
    String ill = "aeiou";
    for(int i=0;i<s.length();i++){
      for(int j=0;j<ill.length();j++){
        if(Character.toString(s.charAt(i)).equals(Character.toString(ill.charAt(j)))){
          return 0;
        }
      }
    }
    flag=true;acceptedAt=6; 
    return 0;
  }
  
//Prints the outputs  
  public static void letsPrint(String s){
    System.out.println("==== Regular Expression : "+s+" ====");
    if(flag){System.out.println("YES");}
    if(!flag){System.out.println("NO");}
  }
}