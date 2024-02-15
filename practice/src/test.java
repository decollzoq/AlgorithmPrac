import java.util.ArrayList;

public class test {
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList(5);
        for(int i = 0; i < 5; i++){
            a.add(i);
        }

        for(int i : a){
            System.out.println(i);
        }
    }
}
