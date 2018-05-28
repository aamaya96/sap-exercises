public class Switcher {

    //Array that contains elements
    int[] options = {2,1};

    public static void main(String[] args){
        Switcher sw = new Switcher();
        System.out.println(sw.switcher(1));
        System.out.println(sw.switcher(2));
    }

    public int switcher(int option){
        return options[option - 1];
    }

}
