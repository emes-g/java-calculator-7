package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.print("문자열 입력 : ");
        String inputString = Console.readLine();
        System.out.printf("입력받은 문자열 : %s\n", inputString);

        String[] splitStrings = splitString(inputString);
        System.out.println("[입력받은 문자열을 분리한 결과]");
        for (String splitString : splitStrings) {
            System.out.println(splitString);
        }
    }

    private static boolean isStringWithCustomDelimiter(String str) {
        if (str.length() < 5) {
            return false;
        }
        String prefix = str.substring(0, 2);
        String suffix = str.substring(3, 5);

        return prefix.equals("//") && suffix.equals("\\n");
    }

    private static String[] splitString(String str) {
        if (isStringWithCustomDelimiter(str)) {
            char customDelimiter = str.charAt(2);
            String regexWithCustomDelimiter = ",|:|" + customDelimiter;
            String strContent = str.substring(5);

            return strContent.split(regexWithCustomDelimiter);
        }
        return str.split("[,:]");
    }
}
