package app.hw7;

public class Corrector {

    private final String targetSymbol = "b";
    private final String correctSymbol = "o";


    public String handleData(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String str : strs) {
            if (str.contains(targetSymbol)) {
                str = str.replace(targetSymbol, correctSymbol);
            }
            count++;
            sb.append(count).append(") ").append(str).append("\n");
        }
        return sb.toString();
    }
}
