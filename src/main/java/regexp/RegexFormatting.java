package regexp;

/* У вас есть файл с текстом, смешанным с телефонными номерами, в следующем формате:
+ Y (XXX) XXX XX XX Пример строки текста: «Уведомление было отправлено 150 раз до +4 (351) 455 22 44 успешно.
+1 (431 ) 542 56 12 недоступен. «Использование regexp и matchers обрабатывает такой файл и создает новый
 с номерами телефонов в формате YXXXXXXXXXX.*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFormatting {

    public void formattingPhoneNumber(String inFile, String outFile) throws IOException {
        String str;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inFile));
             FileOutputStream fileOutputStream = new FileOutputStream(outFile)) {
            while ((str = bufferedReader.readLine()) != null) {
                Pattern pattern = Pattern.compile("(\\+\\d)(\\(\\d{3}\\))([ ]\\d{3}[ ]\\d{2}[ ]\\d{2})");
                Matcher matcher = pattern.matcher(str);
                while (matcher.find()) {
                    String correctPhoneNumber = matcher.group()
                            .replaceAll("\\W", "");
                    fileOutputStream.write(correctPhoneNumber.getBytes());
                    fileOutputStream.write('\n');
                    System.out.println(correctPhoneNumber);
                }
            }
        }
    }

/*    public void adasd() {
        Pattern pattern = Pattern.compile("(\\+\\d)(\\(\\d{3}\\))([ ]\\d{3}[ ]\\d{2}[ ]\\d{2})");
        Matcher matcher = pattern.matcher();
        while (matcher.find()) {
            String correctPhoneNumber = matcher.group()
                    .replaceAll("\\W", "");
            System.out.println(correctPhoneNumber);
        }
    }

    public void failIn(String inFile, String outFile) throws IOException {

        String str;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inFile));
             FileOutputStream fileOutputStream = new FileOutputStream(outFile)) {
                 while ((str = bufferedReader.readLine()) != null) {
                     adasd();
                     fileOutputStream.write(str.getBytes());
                     fileOutputStream.write('\n');
            }
         */
}

