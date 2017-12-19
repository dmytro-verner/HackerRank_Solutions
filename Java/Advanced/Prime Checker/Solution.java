import static java.lang.System.in;

class Prime{
    void checkPrime(int... arr){
        for (int number : arr) {            
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
        
        System.out.println();
    }
    
    boolean isPrime(int number){
        if(number == 1)
            return false;
        for(int i = 2; i <= (int)Math.sqrt(number); i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }
}