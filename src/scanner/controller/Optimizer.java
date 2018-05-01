/*
 * Copyright (c) 2018.
 * By kareem
 */

package scanner.controller;

public class Optimizer {
    public String Optimize(String document)
    {
        String newDocument = "";
        boolean isBlockComment = false;
        boolean isLineComment = false;
        char current;
        char next;
        for (int i = 0; i < document.length() -1 ; i++) {
            current = document.charAt(i);
            next = document.charAt(i+1);
            if (current == '<' && next == '^') {
                isBlockComment = true;
                i+=1;
            }
            else if (current == '^' && next == '>') {
                isBlockComment = false;
                i+=1;
            }
            else if (current == '^' && next == '^'){
                isLineComment = true;
                i+=1;
            }
            else if (isLineComment && current == '\n'){
                isLineComment = false;
            }
            else if ((!isBlockComment && !isLineComment) || current == '\n')
                newDocument += current;
        }
        return newDocument ;
    }
}
