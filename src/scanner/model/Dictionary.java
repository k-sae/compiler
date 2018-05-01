

/*
 * Copyright (c) 2018.
 * By kareem
 */

package scanner.model;


import java.util.ArrayList;

public class Dictionary {
    private static Dictionary instance;
    private ArrayList<Lexeme> lexemes;
    private Dictionary()
    {
        lexemes = new ArrayList<>();
        //TODO Hazem
        lexemes.add(new Lexeme(Keyword._bluePrint, Tokens._class));
        lexemes.add(new Lexeme(Keyword._InNMN, Tokens._Inheritance));
        lexemes.add(new Lexeme(Keyword._ERo, Tokens._Condition));
        lexemes.add(new Lexeme(Keyword._Plow, Tokens._Condition));
        lexemes.add(new Lexeme(Keyword._IPOL, Tokens._Integer));
        lexemes.add(new Lexeme(Keyword._SiPOsL, Tokens._SInteger));
        lexemes.add(new Lexeme(Keyword._Grp, Tokens._Character));
        lexemes.add(new Lexeme(Keyword._Folp, Tokens._String));
        lexemes.add(new Lexeme(Keyword._Shrk, Tokens._Float));
        lexemes.add(new Lexeme(Keyword._Derp, Tokens._SFloat));
        lexemes.add(new Lexeme(Keyword._EQl, Tokens._Void));
        lexemes.add(new Lexeme(Keyword._Bplo, Tokens._Boolean));
        lexemes.add(new Lexeme(Keyword._Spt,""));
        lexemes.add(new Lexeme(Keyword._DpiWhen,Tokens._Loop));
        lexemes.add(new Lexeme(Keyword._LPwhen,Tokens._Loop));
        lexemes.add(new Lexeme(Keyword._Retu,Tokens._Return));
        lexemes.add(new Lexeme(Keyword._SEPK,Tokens._Struct));
        lexemes.add(new Lexeme(Keyword._ZQe,Tokens._Switch));
        lexemes.add(new Lexeme(Keyword._KLO,Tokens._Switch));
        lexemes.add(new Lexeme(Keyword._Pero,Tokens._Stat_Statement));
        lexemes.add(new Lexeme(Keyword._Fine,Tokens._End_Statement));
        lexemes.add(new Lexeme(Keyword._add,Tokens._Arithmetic_Operation));
        lexemes.add(new Lexeme(Keyword._subtract,Tokens._Arithmetic_Operation));
        lexemes.add(new Lexeme(Keyword._mutpliy,Tokens._Arithmetic_Operation));
        lexemes.add(new Lexeme(Keyword._divison,Tokens._Arithmetic_Operation));
        lexemes.add(new Lexeme(Keyword._and,Tokens._Logic_operators));
        lexemes.add(new Lexeme(Keyword._or,Tokens._Logic_operators));
        lexemes.add(new Lexeme(Keyword._not,Tokens._Logic_operators));
        lexemes.add(new Lexeme(Keyword.r_equal_equal,Tokens._relational_operators));
        lexemes.add(new Lexeme(Keyword.r_smaller,Tokens._relational_operators));
        lexemes.add(new Lexeme(Keyword.r_greater,Tokens._relational_operators));
        lexemes.add(new Lexeme(Keyword.r_not_equal,Tokens._relational_operators));
        lexemes.add(new Lexeme(Keyword.r_greater_equal,Tokens._relational_operators));
        lexemes.add(new Lexeme(Keyword.r_smaller_equal,Tokens._relational_operators));
        lexemes.add(new Lexeme(Keyword._assigment,Tokens._Assignment_operator));
        lexemes.add(new Lexeme(Keyword._seop_acess,Tokens._Access_Operator));
        lexemes.add(new Lexeme(Keyword._left_brace,Tokens._Braces));
        lexemes.add(new Lexeme(Keyword._right_brace,Tokens._Braces));
        lexemes.add(new Lexeme(Keyword._left_ibrace,Tokens._Braces));
        lexemes.add(new Lexeme(Keyword._right_ibrace,Tokens._Braces));
        //numbers
        lexemes.add(new Lexeme(Keyword._singl_quote,Tokens._Quotation_Mark));
        lexemes.add(new Lexeme(Keyword._double_quote,Tokens._Quotation_Mark));
        lexemes.add(new Lexeme(Keyword._Having,Tokens._Inclusion));
    }

    public ArrayList<Lexeme> getLexemes() {
        return lexemes;
    }

    //get single instance for this class
    public static Dictionary getDictionary()
    {
        if(instance == null) instance = new Dictionary();
        return instance;
    }

    private static class Keyword{
        public static final String _bluePrint = "BluePrint";
        public static  final String _InNMN="InNMN";
        public static  final String _ERo="ERO";
        public static  final String _Plow="Plow";
        public static  final String _IPOL="IPOL";
        public static  final String _SiPOsL="SiPOsL"; 
        public static  final String _Grp="Grp";
        public static  final String _Folp="Folp"; 
        public static  final String _Shrk="Shrk";
        public static  final String _Derp="Derp";
        public static  final String _EQl ="EQl ";
        public static  final String _Bplo ="Bplo";
        public static  final String _Spt="Spt";
        public static  final String _DpiWhen="DpiWhen";
        public static  final String _LPwhen="LPwhen";
        public static  final String _Retu="Retu";
        public static  final String _SEPK="SEPK";
        public static  final String _ZQe ="ZQe";
        public static  final String _KLO="KLO";
        public static  final String _Pero="Pero";
        public static  final String _Fine="Fine";
        public static  final String _add="+";
        public static  final String _subtract="-";
        public static  final String _mutpliy="*";
        public static  final String _divison="/";
        public static  final String _and="&&";
        public static  final String _or="||";
        public static  final String _not="~";
        public static  final String r_equal_equal="==";
        public static  final String r_greater=">";
        public static  final String r_smaller="<";
        public static  final String r_not_equal="!=";
        public static  final String r_smaller_equal="<=";
        public static  final String r_greater_equal=">=";
        public static  final String _assigment="=";
        public static  final String _left_brace="{";
        public static  final String _right_brace="}";
        public static  final String _left_ibrace="[";
        public static  final String _right_ibrace="]";
        //numbers [0,9]
        public static  final String _seop_acess=".";
        public static  final String _double_quote="\"";
        public static  final String _singl_quote="\'";
        public static  final String _Having="Having"; 


        //TODO Hazem
    }
    private static class Tokens{
        public static final String _class = "Class";
        public static  final String _Inheritance="Inheritance";
        public static  final String _Condition="Condition";
        public static  final String _Integer="Integer";
        public static  final String _SInteger="SInteger";
        public static  final String _Character="Character";
        public static  final String _String="String";
        public static  final String _Float="Float";
        public static  final String _SFloat="SFloat";
        public static  final String _Void="Void";
        public static  final String _Boolean="Boolean";
        public static  final String _Loop="Loop";
        public static  final String _Return="Return";
        public static  final String _Struct="Struct";
        public static  final String _Switch="Switch";
        public static  final String _Stat_Statement="Stat Statement";
        public static  final String _End_Statement="End Statement";
        public static  final String _Arithmetic_Operation="Arithmetic Operation";
        public static  final String _Logic_operators="Logic operators";
        public static  final String _relational_operators="relational operators";
        public static  final String _Assignment_operator="Assignment operator";
        public static  final String _Access_Operator="Access Operator";
        public static  final String _Braces="Braces";
        public static  final String _Constant="Constant";
        public static  final String _Quotation_Mark="Quotation Mark";
        public static  final String _Inclusion="Inclusion";
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
