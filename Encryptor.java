import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Encryptor {
    private String sentence;
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    //Only letters
    String regex = "(?<=\\s|^)[a-zA-Z]*(?=[.,;:]?\\s|$)";

    public Encryptor(String word) {
        this.sentence = word;

    }

    public String getEncryptedSentence(String sentence) {
        String encryptedWord = "";
        StringBuilder stringBuilder = new StringBuilder(sentence);
        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);
            System.out.println("currentChar : " + currentChar);
            boolean isLowerCase = Character.isLowerCase(currentChar);
            boolean isValid = Pattern.matches(regex, Character.toString(currentChar));
            boolean isSpace = currentChar == ' ';


            int currentPos = sentence.indexOf(currentChar);


            if (!isValid && !isSpace) {
                stringBuilder.setCharAt(currentPos, ' ');
                continue;
            }

            if(isSpace) {
                continue;
            } else {
                int posOfCharInAlphabet = alphabet.indexOf(Character.toLowerCase(currentChar));
                int reversedPos = (alphabet.length() - 1) - posOfCharInAlphabet;
                char encryptedChar = alphabet.charAt(reversedPos);
                stringBuilder.setCharAt(currentPos, isLowerCase ? Character.toLowerCase(encryptedChar) : Character.toUpperCase(encryptedChar));
            }
        }
        return stringBuilder.toString();
    }
}