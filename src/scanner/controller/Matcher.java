package scanner.controller;

import scanner.model.Dictionary;
import scanner.model.ScannerOutput;

import java.util.ArrayList;

public class Matcher {
    private final String document;

    public Matcher(String document) {
        this.document = document;
    }

    public ScannerOutput match(int start, int end, int line_count)
    {
        Dictionary dictionary = Dictionary.getDictionary();
        for (int i = 0; i < dictionary.getLexemes().size(); i++) {
            Dictionary.Lexeme lexeme = dictionary.getLexemes().get(i);
            if(isMatched(start, end, lexeme.keyword))
                return new ScannerOutput(lexeme.keyword, lexeme.token, true, line_count);
        }
        if (isIdentifier(start, end))
            return new ScannerOutput(getLexeme(start, end), "IDENTIFIER" , true, line_count);
        else if (isNumber(start, end))
            return new ScannerOutput(getLexeme(start, end), "Constant" , true, line_count);
        return new ScannerOutput(getLexeme(start, end), "Error" , false, line_count);
    }
    private boolean isMatched(int start, int end, String key)
    {
        if (end -start != key.length()) return false;
        for (int i = start, j =0; i < end && j < key.length(); i++, j++) {
            if (document.charAt(i) != key.charAt(j)) return false;
        }
         return true;
    }
    //TODO later
    public ScannerOutput match(int start, int end, int line_count, int flag)
    {
        ArrayList<Dictionary.Lexeme> lexemesToSearchIn = Dictionary.getDictionary().getLexemes();
        ArrayList<Dictionary.Lexeme> nextLexemes = new ArrayList<>();
        int base = start;
        for (int i = start; i < end; i++) {
            for (int j = 0; j < lexemesToSearchIn.size(); j++) {
                int currentIndex = i - base;
                Dictionary.Lexeme lexeme = lexemesToSearchIn.get(j);
                if (lexeme.keyword.length() > currentIndex && document.charAt(i) == lexeme.keyword.charAt(currentIndex))
                    nextLexemes.add(lexeme);
            }
            lexemesToSearchIn.clear();
            lexemesToSearchIn.addAll(nextLexemes);
            nextLexemes.clear();
        }
        if (lexemesToSearchIn.size() > 0)
            return new ScannerOutput(lexemesToSearchIn.get(0).keyword,
                    lexemesToSearchIn.get(0).token, true, line_count);
        if (isIdentifier(start, end))
            return new ScannerOutput(getLexeme(start, end), "IDENTIFIER" , true, line_count);
        else if (isNumber(start, end))
            return new ScannerOutput(getLexeme(start, end), "Constant" , true, line_count);
        return new ScannerOutput(getLexeme(start, end), "Error" , false, line_count);

    }
    private boolean isIdentifier(int start, int end)
    {
        if (!isCharacter(document.charAt(start)))
            return false;
        for (int i = start; i < end; i++) {
            if (!isCharacter(document.charAt(i)) && !isDigit(document.charAt(i))) return false;
        }
        return true;
    }
    private boolean isNumber(int start, int end)
    {
        for (int i = start; i < end; i++) {
            if (!isDigit(document.charAt(i))) return false;
        }
        return true;
    }
    private boolean isCharacter(char c)
    {
        int asciiVal = ((int) c);
        return (asciiVal >= 97 && asciiVal <= 122) || (asciiVal >= 65 && asciiVal <= 90) || c == '_';
    }
    private boolean isDigit(char c){
        int asciiVal = ((int) c);
        return (asciiVal >= 48 && asciiVal <= 57);
    }
    private String getLexeme(int start, int end){
        String lexeme = "";
        for (int i = start; i < end; i++) {
            lexeme += document.charAt(i);

        }
        return lexeme;
    }
}
