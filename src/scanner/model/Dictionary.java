

/*
 * Copyright (c) 2018.
 * By kareem
 */

package scanner.model;


import java.util.ArrayList;

public class Dictionary {
    private static Dictionary instance;
    private ArrayList<Lexeme> lexemes;
    private static final char[] delimiters = {'\n', ';', '=', '+', '-', '*', '/',
            '&', '|', '~', '!', '.', '{', '{', ','};
    private Dictionary()
    {
        lexemes = new ArrayList<>();
        //TODO Hazem
        lexemes.add(new Lexeme(Keyword._bluePrint, Tokens._class));

    }

    public ArrayList<Lexeme> getLexemes() {
        return lexemes;
    }

    public static char[] getDelimiters() {
        return delimiters;
    }

    //get single instance for this class
    public static Dictionary getDictionary()
    {
        if(instance == null) instance = new Dictionary();
        return instance;
    }

    private static class Keyword{
        public static final String _bluePrint = "BluePrint";
        //TODO Hazem
    }
    private static class Tokens{
        public static final String _class = "Class";
        //TODO Hazem
    }
    public class Lexeme{
        public final String keyword;
        public final String token;

        public Lexeme(String keyword, String token) {
            this.keyword = keyword;
            this.token = token;
        }
    }
}
