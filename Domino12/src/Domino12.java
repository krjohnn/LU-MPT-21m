import java.util.Scanner;

public class Domino12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x, c;
		/* Temporary input */
		
		Scanner scanner = new Scanner(System.in);
//		x = Integer.parseInt(scanner.nextLine());
		x = scanner.nextInt();
		
//		x = Integer.parseInt(args[0]); // Input param, player count
		c = 12;
		System.out.println("a \n");
		for(int i=0; i<=12; i++, c--) {
			for(int j=i; j<=12; j++) {
				System.out.println(j+"-"+i+"\n");
			}
//			System.out.println(i + " i \n");
//			System.out.println(c + " c \n");
		}
		return;
	}

}
