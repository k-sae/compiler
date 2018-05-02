package parser;

import java.util.ArrayList;

/**
 * Created by amr-sameh on 02/05/18.
 */

/**
 * Row Data :
 * ID   +   -   Number  ϵ   =   Bplo    Derp    EQl     Folp      Grp       IPOL    Shrk    SiPOsL  {   BluePrint
 * InNMN    <^  ^^  using_command   !=  <   <=  ==  >   >=  Number  and     or  DpiWhen     ERo     (       *
 * /    LPwhen      Retu    Spt     write   read    Pero    ,   ;   Having
 */
public class ParseTableRow {
   public String noneTerminal;
   public ArrayList<GrammerRule> rowData;
public ParseTableRow(){
    rowData = new ArrayList<>();
    noneTerminal="";
}

    public ParseTableRow(String noneTerminal, ArrayList<GrammerRule> rowData) {
        this.noneTerminal = noneTerminal;
        this.rowData = rowData;
    }
}
