package scanner;

import scanner.model.Dictionary;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.printf(Dictionary.getDictionary().getLexemes().get(0).keyword);
    }
}
