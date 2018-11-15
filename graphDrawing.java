package myMath;

import java.awt.Color;
import java.util.Scanner;

public class graphDrawing {

	public static void main(String[] args) {
		final int Bounds  = 50;
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setXscale(-Bounds, Bounds);
		StdDraw.setYscale(-Bounds, Bounds);
		StdDraw.setPenRadius(0.003);

		//user input (polynom)
		System.out.println("Enter Your Polynom:");
		Scanner rs = new Scanner(System.in);
		String poly = rs.nextLine();
		Polynom p = new Polynom(poly);

		//polynomial area:
		System.out.println("Enter limits for X (2 numbers):");
		double x0 = rs.nextDouble();
		double x1 = rs.nextDouble();
		System.out.println("Polynom area is : " + p.area(x0, x1, 0.01));

		//Extremum:
		Polynom_able dp = p.derivative();
		boolean rootFlag = false;
		System.out.print("Polynom's Extremum : ");
		for (int i = (int)x0 ; i < x1 ; i++) 
			if (dp.f(i) * dp.f(i+1) <= 0) {
				double rootX = dp.root(i, i+1, 0.01);
				double rootY = dp.f(rootX);
				System.out.println("(" + rootX + "," + rootY + ")");
				rootFlag = true;
				i++;
			}
		if(!rootFlag)
			System.out.println("No Extremum for this polynom.");



		//x/y lines		
		int n = Bounds;
		StdDraw.line(Bounds, 0, -Bounds, 0);
		StdDraw.line(0, Bounds, 0, -Bounds);
		StdDraw.setPenColor(Color.BLUE);

		//x/y arrays:
		double [] arrx = new double [n+1];
		double [] arry = new double [n+1];

		//polynom convertion into arrays of points:
		for(int i = 0; i<=n ; i++) {
			arrx[i] = -n/2+i;
			arry[i] = p.f(-n/2+i);	
		}

		//polynom draw:
		for (int i=0; i<Bounds-1 ; i++) {
			StdDraw.line(arrx[i], arry[i], arrx[i+1], arry[i+1]);
		}

	}
	

}
