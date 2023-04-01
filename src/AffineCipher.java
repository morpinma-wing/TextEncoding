import java.lang.reflect.Array;

public class AffineCipher {

    private int a,b;

    private int m = 26;
    private String alphabet;

    AffineCipher(){
        this.a = 27;
        this.b = 28;
        alphabet = new Alphabet().getAlphabet();
    }

    AffineCipher(int a, int b){
        this.a = a;
        this.b = b;
        alphabet = new Alphabet().getAlphabet();
    }

    public String encode(String text){
        char[] empty = new char[text.length()];
        for (int i = 0; i < text.length(); i++){
            //System.out.println(text.charAt(i) + 0);
            //System.out.println(((a * text.charAt(i) + b) % 26));
            //empty[i] = (char) ((a * text.charAt(i) + b) % 26);
            //empty[i] = text.in
            char ch = text.toCharArray()[i];
            boolean iscap = Character.isUpperCase(ch);
            if (Character.isWhitespace(ch)){
                //System.out.println("whitespace");
                empty[i] = ch;
            }
            else if (iscap){
                int position = alphabet.indexOf(ch);
                empty[i] = alphabet.charAt((a * position + b) % 26);
                //System.out.println(position + " " + empty[i]);
            }
            else{
                char upperCh = Character.toUpperCase(ch);
                int position = alphabet.indexOf(upperCh);
                empty[i] = Character.toLowerCase(alphabet.charAt((a * position + b) % 26));
                //System.out.println(position + " " + empty[i]);
            }
        }

        return new String(empty);
    }

    public String decode(String text){
        char[] empty = new char[text.length()];
        for (int i = 0; i < text.length(); i++){
            //System.out.println(text.charAt(i) + 0);
            //System.out.println(((a * text.charAt(i) + b) % 26));
            //empty[i] = (char) ((a * text.charAt(i) + b) % 26);
            //empty[i] = text.in
            char ch = text.toCharArray()[i];
            boolean iscap = Character.isUpperCase(ch);
            if (Character.isWhitespace(ch)){
                System.out.println("whitespace");
                empty[i] = ch;
            }
            else if (iscap){
                int position = alphabet.indexOf(ch);
                empty[i] = alphabet.charAt(wrapping(position, decryption(a, 1)));
                //System.out.println(position + " " + empty[i]);
            }
            else{
                char upperCh = Character.toUpperCase(ch);
                int position = alphabet.indexOf(upperCh);
                empty[i] = Character.toLowerCase(alphabet.charAt(wrapping(position,decryption(a, 1))));
                //System.out.println(position + " " + empty[i]);
            }
        }
        return new String(empty);
    }

    private int wrapping(int position, int aInv){
        int new_pos = aInv * (position - b) % 26;
        if (new_pos < 0){
            return new_pos + 26;
        }
        else {
            return new_pos;
        }
    }

    private int decryption(int num, int n){
        if (num % m == 1){
            return n;
        }
        else{
            return decryption(num + a, n+1);
        }
    }
}
