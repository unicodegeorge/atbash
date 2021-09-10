import java.util.Scanner;

public class RunMe {


    public static void main(String[] args) {
        String word = "";
        Encryptor encryptor = new Encryptor(word);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your sentence : ");
        String sentence = sc.nextLine();


        System.out.println("dope : " + encryptor.getEncryptedSentence(sentence));

    }
}
