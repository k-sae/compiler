package scanner.model;

public class ScannerOutput {
    public  final String lexeme;
    public  final String token;
    public  final boolean isMatched;
    public  final int lineNo;

    public ScannerOutput(String lexeme, String token, boolean isMatched, int lineNo) {
        this.lexeme = lexeme;
        this.token = token;
        this.isMatched = isMatched;
        this.lineNo = lineNo;
    }
}
