/*
Polynomial class
Send Feedback
Implement a polynomial class, that contains following functions -
1. setCoefficient -
This function sets coefficient for a particular degree value. If term with given degree is not there in the polynomial, then corresponding term (with specified degree and value) is added. If the term is already present in the polynomial, then previous coefficient value is replaced by given coefficient value.
2. add -
Adds two polynomials and returns a new polynomial which has the result.
3. subtract -
Subtracts two polynomials and returns a new polynomial which has the result.
4. multiply -
Multiplies two polynomials and returns a new polynomial which has the result.
5. print -
Prints all the terms (only terms with non zero coefficients are to be printed) in increasing order of degree.
Print pattern for a single term : "x"
And multiple terms should be printed separated by space. For more clarity, refer sample test cases.
Note : Only keep those terms which have non - zero coefficients.
Sample Input 1 :
P1 : 1x2 2x3 4x6 
P2 : 3x4 1x2
Sample Output 1 :
P1 + P2 = 2x2 2x3 3x4 4x6
Sample Input 2 :
P1 : 1x2 2x3 4x6 
P2 : 3x4 1x2
Sample Output 2 :
P1 - P2 = 2x3 -3x4 4x6
*/
import java.util.Scanner;


public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int degree1[] = new int[n];
		for(int i = 0; i < n; i++){
			degree1[i] = s.nextInt();
		}
		int coeff1[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff1[i] = s.nextInt();
		}
		Polynomial first = new Polynomial();
		for(int i = 0; i < n; i++){
			first.setCoefficient(degree1[i],coeff1[i]);
		}
		n = s.nextInt();
		int degree2[] = new int[n];
		for(int i = 0; i < n; i++){
			degree2[i] = s.nextInt();
		}
		 int coeff2[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff2[i] = s.nextInt();
		}
		Polynomial second = new Polynomial();
		for(int i = 0; i < n; i++){
			second.setCoefficient(degree2[i],coeff2[i]);
		}
		int choice = s.nextInt();
		Polynomial result;
		switch(choice){
		// Add
		case 1: 
			 result = first.add(second);
			result.print();
			break;
		// Subtract	
		case 2 :
			 result = first.subtract(second);
			result.print();
			break;
		// Multiply
		case 3 :
			 result = first.multiply(second);
			result.print();
			break;
		}

	}
 

public class Polynomial {

    private int coff[];
	static int indexDegree=0;
    static int indexCoeff=0;
  
	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
    
    Polynomial(){
        coff = new int[5];
    }
    
    Polynomial(int[] coeff){
        coff = coeff;
    }
    
	public void setCoefficient(int degree, int coeff){
		while(degree >= coff.length)
            coff = restructure(coff);
        coff[degree] = coeff;	
	}
	
    private static int[] restructure(int coff[]){
        int temp[] = coff;
        coff = new int[2*coff.length];
        for(int i=0;i<temp.length;i++)
            coff[i]=temp[i];
        return coff;
    }
    
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
		for(int i=0;i<coff.length;i++){
            if(coff[i] != 0)
                System.out.print(coff[i] + "x" + i+" ");
        }
       // System.out.println();
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
		if(coff.length<p.coff.length){
            for(int i=0;i<coff.length;i++)
                coff[i] += p.coff[i];
        }
        else{
            for(int i=0;i<p.coff.length;i++)
                coff[i] += p.coff[i];
        }
        p.coff = coff;
		return p;
	}
	 
	public Polynomial subtract(Polynomial p){
        if(coff.length<p.coff.length){
            for(int i=0;i<coff.length;i++)
                coff[i] -= p.coff[i];
        }
        else{
            for(int i=0;i<p.coff.length;i++)
                coff[i] -= p.coff[i];
        }
        p.coff = coff;
        return p;
	}
	 
	public Polynomial multiply(Polynomial p){
        
        int mul_arr[] = new int[5];
        int k=0;
		for(int i=0;i<p.coff.length;i++){
            for(int j=0;j<coff.length;j++){
                while((i+j)>=mul_arr.length)
                    mul_arr=restructure(mul_arr);
                mul_arr[i+j] += p.coff[i]*coff[j];
            }
        }
        p.coff = mul_arr;
        return p;
	}
    
 

}

}
