package scanner;

import scanner.controller.Parser;
import scanner.model.Dictionary;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Parser parser = new Parser("test=test;;\ntest==;test;==;=;\n3{4}\n3344<=4;;54");
        parser.parse();
    }
}
