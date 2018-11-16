regExp ~ Java Regular Expression Evaluator
=================================================

## Introduction
regExp is a sample regular expression evaluator for Java that checks a string's acceptance under certain different regular expressions.

## Details about the program
 The program takes a string input from user and checks it's acceptance under various regular expressions.
 For simplicity, we will assume that there is a fixed set of regular expressions. We will not consider
 out of these. But we must not use any built-in method or package in our implementation. 
 In Regular Expression (RE),
 ```
 '*' means occurrence of zero of more characters, 
 '+' indicates happening of one or more characters, 
 '?'  means only once or not at all occurrence, 
 '[ ]' indicates happening of inclusive characters, 
 '^' indicates that next characters will not be used in the pattern,
 '[a-d]{3}' indicates that valid string will be exactly of  length 3 inclusively using a, b, c, d. 
 ```
 The following table contains a fixed set of RE that will be used in our program.
 <table>
  <tr><th>Description</th><th>RE</th><th>Valid</th><th>Invalid</th></tr>
  <tr><th>Zero or more</th><th>a(bc)*de</th><th>ade;abcbcde</th><th>abde;abcbde</th></tr>
  <tr><th>One or more</th><th>a(bc)+de</th><th>abcde;abcbcde</th><th>ade;abc</th></tr>
  <tr><th>Once or not at all</th><th>a(bc)?de</th><th>ade;abcde</th><th>abc;abcbcde</th></tr>
  <tr><th>Character classes</th><th>[a-m]*</th><th>blackmail;imbecile</th><th>above;below</th></tr>
  <tr><th>Negation of 
 character classes</th><th>[^aeiou]</th><th>b;c</th><th>a;e</th></tr>
  <tr><th>Exactly N times</th><th>[^aeiou]{6}</th><th>rhythm;syzygy</th><th>rhythms;allowed</th></tr>  
</table>
 
 Some sample inputs and outputs are given below for better understanding:
``` 
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
``` 
### Notes
```
!!!The program only works for mentioned regular expressions
```

### Project Layout
The program was created and tested using Java 10.0.2.

## About author
 NAZMUDDIN AL MASOOD 
 <br> Contact: nazmumasood96@gmail.com
