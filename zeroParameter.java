@FunctionalInterface
interface displayParam{
    
    void display();
}
public class zeroParameter {
     public static void main(String[] args){
        
        // Lambda expression with zero parameters
        displayParam lambda = ()
            -> System.out.println(
                "This is a zero-parameter lambda expression!");

        // Invoke the method
        lambda.display();
    
}
}
