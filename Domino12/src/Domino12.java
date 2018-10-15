/*
 * Autors
 * 
 * Vārds: Krišjānis
 * Uzvārds: Šulcs
 * Studentu apliecības numurs: ks10163
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Domino12 {
	
	public static class Piece {
		 private int first_q; //value of the first quadrant
		 private int second_q; //value of the second quadrant
		 
		 //class constructor
		 public Piece(int first, int second) {
		  first_q = first;
		  second_q = second;
		 }
		 
		//rewrite toString method
		 public String toString() {
		      return first_q + "-" + second_q;
		 }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		
		/* Temporary input */	
//		Scanner scanner = new Scanner(System.in);
//		x = scanner.nextInt();
		
		x = Integer.parseInt(args[0]); // Input param, player count

		// Domino Piece generator
		
//		Piece Set2[] = new Piece[91];
		List<Piece> Set = new ArrayList<Piece>();
		
		int count = 0;
		for(int i=0; i<=12; i++) {
			for(int j=i; j<=12; j++) {
//				System.out.println(count+": "+j+"-"+i);
//				Set2[count] = new Piece(j,i);
				Set.add(new Piece(j,i));
//				System.out.println(Set2[count].toString());
				count++;
			}
		}
		
		/* Skip this for now

		System.out.println("------Array------");
		for(int i=0; i<Set2.length; i++) {
			System.out.println(Set2[i].toString());
		}
		
		*/
		
		/*This works*/
//		System.out.println("------Array List------");
		Collections.shuffle(Set);
		for(int i=0, count2=0; i<Set.size(); i++, count2++) {
//			System.out.println(count2+": "+Set.get(i).toString());
		}
		
		
		/*
		Random rand = new Random();
		int n = rand.nextInt(Set.size())+0;
		for(int i=0; i<Set.size(); i++) {
			n = rand.nextInt(Set.size())+0;
//			System.out.println(n);
			System.out.println(Set.get(n).toString());
			Set.remove(n);
		}
		
		*/
		
		/*Player generate*/
		int piecesPerPlayer = (Set.size()-Set.size()%x)/x;
		int offset = 0;
//		System.out.println(Set.size());
		for(int i=1; i<=x; i++) {
			System.out.print(i+".speletajam ir:");
			for(int j=0; j<piecesPerPlayer; j++) {
				System.out.print(" "+Set.get(0).toString());
//				System.out.println(j+": "+Set.get(5j).toString());
				Set.remove(0);
			}
			System.out.print("\n");
//			System.out.println(i);
		}
		
		return;
	}

}
