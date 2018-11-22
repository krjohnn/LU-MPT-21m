import java.math.BigInteger;

/*
 * Autors
 * 
 * Vārds: Krišjānis
 * Uzvārds: Šulcs
 * Studentu apliecības numurs: ks10163
 * 
 */

// ================ Klasi MD3 modificet aizliegts!
public class MD3 {

    public static void main(String[] args)
    {
       LielsSkaitlis lielsSkaitlis1 = new LielsSkaitlis(args[0]);
       LielsSkaitlis lielsSkaitlis2 = new LielsSkaitlis(args[1]);

       lielsSkaitlis1.add(lielsSkaitlis2);
       lielsSkaitlis1.display();
       lielsSkaitlis1.reverse();
       lielsSkaitlis1.display();

       lielsSkaitlis2.sub(lielsSkaitlis1);
       lielsSkaitlis2.display();
       lielsSkaitlis2.reverse();
       lielsSkaitlis2.display();
    }
}
// ================ Klasi MD3 modificet aizliegts!


//Japapildina klase "LielsSkaitlis" ar nepieciesamo funcionalitati
class LielsSkaitlis {
    private String skaitlis;
    private BigInteger skaitlisBi;
    //Varat pievienot savus laukus, ja tas ir nepieciesams
	
	
    LielsSkaitlis(String str) { 
    	skaitlis = str; 
    	skaitlisBi = new BigInteger(skaitlis);
    }

    public void add(LielsSkaitlis sk) {
    	if(this.skaitlis == "SKAITLIS PAR MAZU" || this.skaitlis == "SKAITLIS PAR LIELU") {
    		return;
    	} else if (sk.skaitlis == "SKAITLIS PAR MAZU" || sk.skaitlis == "SKAITLIS PAR LIELU") {
    		this.skaitlis = sk.skaitlis;
    		return;
    	}
//    	System.out.println("lielsSkaitlis1: " + this.skaitlisBi + " lielsSkaitlis2: " + sk.skaitlisBi);
    	this.skaitlisBi = this.skaitlisBi.add(sk.skaitlisBi);
//    	System.out.println("lielsSkaitlis1: " + this.skaitlisBi);
    	this.skaitlis = skaitlisBi.toString();
    	
//    	System.out.println(this.skaitlis.length());
    	if(this.skaitlis.length()>=21 && this.skaitlis.charAt(0)=='-') {
    		this.skaitlis = "SKAITLIS PAR MAZU";
    	} else if(this.skaitlis.length()>=21) {
    		this.skaitlis = "SKAITLIS PAR LIELU";
    	} else {
    		this.skaitlis = skaitlisBi.toString();
    	}
    }
    public void sub(LielsSkaitlis sk) { 
    	if(this.skaitlis == "SKAITLIS PAR MAZU" || this.skaitlis == "SKAITLIS PAR LIELU") {
    		return;
    	} else if (sk.skaitlis == "SKAITLIS PAR MAZU" || sk.skaitlis == "SKAITLIS PAR LIELU") {
    		this.skaitlis = sk.skaitlis;
    		return;
    	}
//    	System.out.println("lielsSkaitlis2: " + this.skaitlisBi + " lielsSkaitlis1: " + sk.skaitlisBi);
    	this.skaitlisBi = this.skaitlisBi.subtract(sk.skaitlisBi);
//    	System.out.println("lielsSkaitlis2: " + this.skaitlisBi);
    	this.skaitlis = skaitlisBi.toString();
    	
//    	System.out.println("DEBUG: " + this.skaitlis.length() + this.skaitlis.charAt(0));
    	if(this.skaitlis.length()>=21) {
    		this.skaitlis = "SKAITLIS PAR MAZU";
    	} else {
    		this.skaitlis = skaitlisBi.toString();
    	}
    }
    public void reverse() { 

//    	System.out.println("Failing here..." + skaitlis.length());
    	if(this.skaitlis == "SKAITLIS PAR MAZU" || this.skaitlis == "SKAITLIS PAR LIELU") {
    		return;
    	} else if(this.skaitlis.charAt(0)=='-'){
    		this.skaitlis = skaitlis.replaceFirst("^-*", "");
        	this.skaitlis = new StringBuffer(skaitlis).reverse().toString();
        	this.skaitlis = skaitlis.replaceFirst("^0*", "");
        	this.skaitlis = "-" + this.skaitlis;
//        	System.out.println(this.skaitlis + " " + this.skaitlisBi);
    		this.skaitlisBi = new BigInteger(this.skaitlis);
    	} else {
        	this.skaitlis = new StringBuffer(skaitlis).reverse().toString();
        	if(skaitlis.length()!=1) {
        		this.skaitlis = skaitlis.replaceFirst("^0*", "");
        	}
//        	System.out.println(this.skaitlis + " " + this.skaitlisBi);
    		this.skaitlisBi = new BigInteger(this.skaitlis);
    	}
    }

	//Varat pievienot savas metodes, ja tas ir nepieciesams


    // ================= Metodi display() modificet aizliegts!
    public void display() {System.out.println(skaitlis);}
}