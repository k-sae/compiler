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
            if (current == '\n') newDocument += '\n';
            if (!isLineComment && !isBlockComment)
            if (current == '<' && next == '^') {
                isBlockComment = true;
                i+=1;
            }
            else if (current == '^' && next == '^'){
                isLineComment = true;
                i+=1;
            }
            if (current == '^' && next == '>' && !isLineComment) {
                isBlockComment = false;
                i+=1;
            }
            else if (isLineComment && current == '\n' && !isBlockComment){
                isLineComment = false;
            }
            else if ((!isBlockComment && !isLineComment && current != '\n'))
                newDocument += current;
        }
        return newDocument  + document.charAt(document.length() - 1);
    }
}
