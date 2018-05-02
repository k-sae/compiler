package parser;

import java.util.ArrayList;

/**
 * Created by amr-sameh on 01/05/18.
 */
public class GrammerRule {
    public String ruleDefinition;
    public ArrayList<String> ruleOutput;

    public GrammerRule() {
        ruleDefinition ="";
        ruleOutput = new ArrayList<String>();
    }

    public GrammerRule(String ruleDefinition, ArrayList<String> ruleOutput) {
        this.ruleDefinition = ruleDefinition;
        this.ruleOutput = ruleOutput;
    }
}
