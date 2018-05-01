package scanner.controller;

import scanner.model.Dictionary;
import scanner.model.ScannerOutput;

import java.util.ArrayList;

public class Parser
{
    private final String document;

    public Parser(String document) {
        this.document = document;

    }
    // TODO
    // fix bug test==;test and ;;54 the end of docs
    public ArrayList<ScannerOutput> parse()
    {
        ArrayList<ScannerOutput> scannerOutputs = new ArrayList<>();
        char current;
        int line_count = 1;
        int last_delimiter = 0; // hold the index of the word
        Matcher matcher = new Matcher(document);
        boolean operatorFlag = false;
        for (int i = 0; i < document.length(); i++) {
            current = document.charAt(i);
            if (current == '\n') line_count++;
            if (isOperator(current) && !operatorFlag){
                //TODO
                // pass the last_delimiter and index -1 to Matcher
                scannerOutputs.add(matcher.match(last_delimiter, i, line_count));
                operatorFlag = true;
                last_delimiter = i;
            }
            else if (!isOperator(current) && operatorFlag)
            {
                scannerOutputs.add(matcher.match(last_delimiter, i, line_count));
                operatorFlag = false;
                last_delimiter = i;
            }
            else if (isDelimiter(current)) {
                scannerOutputs.add(matcher.match(last_delimiter, i, line_count));
                last_delimiter = i;
            }


        }
        scannerOutputs.add(matcher.match(last_delimiter, document.length(), line_count));

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
    private boolean isOperator(char c)
    {
        for (int i = 0; i < Dictionary.operators.length; i++) {
            if (c == Dictionary.operators[i])
                return true;

        }
        return false;
    }
}

