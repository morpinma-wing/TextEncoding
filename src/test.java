public class test {

    private int a = 125;
    private int b = 28;
    private int m = 6;

    test(){

    }

    private int testgeta(int num, int n){
        if (num % m == 1){
            return n;
        }
        else{
            return testgeta(num + a, n+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new test().testgeta(125, 1));
    }

}
