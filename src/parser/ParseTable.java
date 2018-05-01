package parser;

/**
 * Created by amr-sameh on 01/05/18.
 */
public class ParseTable {
    public static ParseTable instance=null;
    private ParseTable(){}
    public static ParseTable getInstance(){
        if(instance==null)
            instance = new ParseTable();
        return instance;
    }
    public boolean isTerminal (String s){
        return false;
    }
    public GrammerRule getRule (String token , String input){
        return null;
    }
}

