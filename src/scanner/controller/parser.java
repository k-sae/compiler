package scanner.controller;

import scanner.model.Dictionary;
import scanner.model.ScannerOutput;

import java.util.ArrayList;

public class parser
{
    private final String document;

    public parser(String document) {
        this.document = document;

    }
    public ArrayList<ScannerOutput> parse()
    {
        ArrayList<ScannerOutput> scannerOutputs = new ArrayList<>();
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

        }
        return scannerOutputs;
    }
    //TODO

    private boolean isDelimiter(char c)
    {
        for (int i = 0; i < Dictionary.delimiters.length; i++) {
            if (c == Dictionary.delimiters[i])
                return true;

        }
        return false;
    }
}
