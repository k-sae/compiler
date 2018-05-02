package parser;

import java.util.ArrayList;

/**
 * Created by amr-sameh on 01/05/18.
 */
public class ParseTable {
    public static ParseTable instance=null;
    private ArrayList<ParseTableRow> table;

    private ParseTable(){
        table = new ArrayList<ParseTableRow>();
        ArrayList <GrammerRule> rowData =new ArrayList<GrammerRule>();

        rowData.add(new GrammerRule("",new ArrayList<String>()));
        table.add(new ParseTableRow("Add_Op",rowData));
    }
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

