public class Encryption {
    public String encrypt(String input) {
        StringBuilder result = new StringBuilder();
        input = input.replaceAll(" ", "");
        int length = input.length();
        double inputSqrRoot = Math.sqrt((double) length);
        int cols = (int) Math.ceil(inputSqrRoot);

        for (int i = 0; i < cols; i++) {
            StringBuilder encryptedWord = new StringBuilder();
            for (int j = i; j < input.length(); j += cols) {
                encryptedWord.append(input.charAt(j));
            }
            encryptedWord.append(" ");
            result.append(encryptedWord.toString());
        }
        return result.toString().trim();
    }
}
