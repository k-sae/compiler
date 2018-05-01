package scanner.controller;

import scanner.model.ScannerOutput;

public class Matcher {
    private final String document;

    public Matcher(String document) {
        this.document = document;
    }

    public ScannerOutput match(int start, int end, int line_count)
    {
        System.out.println(document.substring(start, end));
        return new ScannerOutput();
    }
}
