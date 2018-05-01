package parser;

import scanner.model.ScannerOutput;

import java.util.ArrayList;

/**
 * Created by amr-sameh on 01/05/18.
 */
public class LL1_Parser {

private  ParserStack parserStack;
private ParseTable parseTable;
private ArrayList<ScannerOutput> input;
private int currentIndex ;
private ArrayList<ParserOutPut> outPuts;

    public LL1_Parser(){
        this.parseTable = ParseTable.getInstance();
        this.currentIndex=0;

    }

    public ArrayList<ParserOutPut> Parse(ArrayList<ScannerOutput> input){
        this.parserStack = new ParserStack();
        this.outPuts = new ArrayList<ParserOutPut>();
        this.parserStack.push("$");
        this.parserStack.push("Program");
        this.input = input;
        this.start();
        return this.outPuts;
    }

    private void start() {
        ParserOutPut outPut ;
        while (!this.parserStack.isEmpety()) {
            outPut = new ParserOutPut();
            String first = this.parserStack.pop();
            outPut.parsed = first;
            String inputTop = input.get(this.currentIndex++).token;
            //TODO add line number to output
            outPut.lineNum = input.get(this.currentIndex++).lineNo;
            // the first is non-terminal
            if (!this.parseTable.isTerminal(first)) {
                outPut.isTerminal = false;
                GrammerRule rule = this.parseTable.getRule(first, inputTop);
                if (rule == null) {
                    outPut.isError = true;
                    this.outPuts.add(outPut);
                    return; //TODO error state
                }
                String ruleDefinition = rule.ruleDefinition;
                outPut.Action = ruleDefinition;
                ArrayList<String> ruleOutput = rule.ruleOutput;
                for (String output : ruleOutput)
                this.parserStack.push(output);

            } else { //the first is terminal
                outPut.isTerminal = true ;
                if (first.equals("$") && first.equals(inputTop)){// Accepted
                    outPut.isAccepted = true;
                    this.outPuts.add(outPut);
                    return;
                }
                if (first.equals(inputTop)){// successful match
                    outPut.isMached = true;
                }
                else{// failed
                    outPut.isError = true;
                    this.outPuts.add(outPut);
                    return;
                     }

            }

    this.outPuts.add(outPut);
        }
        outPut = new ParserOutPut();
        outPut.parsed= "EOF";
        outPut.isError = true;
        this.outPuts.add(outPut);
        return ; //failed
    }



private  class ParserStack{
    private ArrayList<String> data;
    public ParserStack(){
        this.data=new ArrayList<String>();
    }

    public void push(String s){
        this.data.add(s);
    }
    public String pop(){
        if (this.data.size()<=0)
            return null;
        String s = this.data.get(this.data.size() - 1);
        return s;
    }
    public boolean isEmpety(){
        return (this.data.size()==0);
    }

}

}

