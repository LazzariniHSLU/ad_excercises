package ch.hslu.ad.D1.exc3;

public class Demo {
    public static void main(String[] args){
        CustomStack<String> stack = new CustomStack<>(3);
        try{
            stack.push("toll");
            stack.push("sind");
            stack.push("Datenstrukturen");
            while(stack.isEmpty() == false){
                System.out.println(stack.pop());
            }
        } catch (StackFullException e) {
            e.printStackTrace();
        }
    }
}
