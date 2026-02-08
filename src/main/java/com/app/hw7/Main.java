package app.hw7;

public class Main {
    public static void main(String[] args) {
//        getOutput(new Corrector().handleData(
//                new DataProvider().getData())
//        );

        String[] arr = {"lalla", "comma"};
        System.out.println(String.join(",", arr));
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
