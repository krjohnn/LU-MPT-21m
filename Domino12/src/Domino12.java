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
		
		x = Integer.parseInt(args[0]); // Input param, player count

		// Domino Piece generator
		
		List<Piece> Set = new ArrayList<Piece>();
		
		int count = 0;
		for(int i=0; i<=12; i++) {
			for(int j=i; j<=12; j++) {
				Set.add(new Piece(j,i));
				count++;
			}
		}
		
		Collections.shuffle(Set);
		
		/*Player generate*/
		int piecesPerPlayer = (Set.size()-Set.size()%x)/x;
		int offset = 0;
		for(int i=1; i<=x; i++) {
			System.out.print(i+".speletajam ir:");
			for(int j=0; j<piecesPerPlayer; j++) {
				System.out.print(" "+Set.get(0).toString());
				Set.remove(0);
			}
			System.out.print("\n");
		}
		return;
	}

}
