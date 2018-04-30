package scanner.controller;

import scanner.model.Token;

import java.util.ArrayList;

public class parser
{
    private final String document;

    public parser(String document) {
        this.document = document;

    }
    public ArrayList<Token> parse()
    {
        ArrayList<Token> tokens = new ArrayList<>();
        char current;
        int line_count = 1;
        // hold the index of the word
        int last_delimiter = 0;
        for (int i = 0; i < document.length(); i++) {
            current = document.charAt(i);
            if (current == '\n') line_count++;
            if (isDelimiter(current)){
                //TODO
                // pass the last_delimiter and index -1 to matcher
            }
            else if(isAssign(current))
            {
                //TODO
                // pass the before the equal to matcher
                // add assign as token
            }
            else if (isArithmetic(current))
            {
                //TODO
                // pass the before the equal to matcher
                // add assign as token
            }
            else if(isRelational(current))
            {
                //TODO
                // pass the before the equal to matcher
                // add assign as token
            }
            else if(isAccess(current))
            {
                //TODO
                // pass the before the equal to matcher
                // add assign as token
            }
            else if(isBraces(current))
            {

            }
            else if (isQuotation(current))
            {

            }

        }
        return tokens;
    }

    private boolean isQuotation(char current) {
        return true;
    }

    private boolean isRelational(char c) {
        return true;
    }

    private boolean isArithmetic(char c) {
        return true;
    }
    // dot operator
    private boolean isAccess(char c){
        return true;
    }

    private boolean isBraces(char c){
        return true;
    }

    //TODO

    private boolean isDelimiter(char c)
    {
        return c == '\n' || c == ';';
    }
    private boolean isAssign(char c)
    {
        return true;
    }
}
