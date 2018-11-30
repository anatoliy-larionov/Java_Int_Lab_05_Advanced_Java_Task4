package regexp;

import java.io.IOException;

public class RunnerMain {

    private static final String IN_FILE = "src/main/resources/fails/inFile.txt";
    private static final String OUT_FILE = "src/main/resources/fails/outFile.txt";

    public static void main(String[] args) throws IOException {

        RegexFormatting regexFormatting = new RegexFormatting();
        regexFormatting.formattingPhoneNumber(IN_FILE, OUT_FILE);
    }
}
