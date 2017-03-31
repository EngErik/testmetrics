package com.github.mauricioaniche.testmetrics;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.github.mauricioaniche.ck.CK;
import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		
		if(args.length != 2) {
			System.out.println("Usage:");
			System.out.println("  java -jar tool.jar <path to source code dir> <path to output csv file>");
			System.exit(-1);
		}
		
		long start = System.currentTimeMillis();
				
		String path = args[0];
		String csvPath = args[1];
		
		CKReport report = buildCK()
				.calculate(path);
		
		PrintStream ps = new PrintStream(csvPath);
		ps.println("file,class,type,cbo,wmc,dit,noc,rfc,lcom,nom,nopm,nosm,nof,nopf,nosf,nosi,loc,istest,asserts,testmethods");
		for(CKNumber result : report.all()) {
			if(result.isError()) continue;
			
			ps.println(
				result.getFile() + "," +
				result.getClassName() + "," +
				result.getType() + "," +
				result.getCbo() + "," +
				result.getWmc() + "," +
				result.getDit() + "," +
				result.getNoc() + "," +
				result.getRfc() + "," +
				result.getLcom() + "," +
				result.getNom() + "," +
				result.getNopm() + "," + 
				result.getNosm() + "," +
				result.getNof() + "," +
				result.getNopf() + "," + 
				result.getNosf() + "," +
				result.getNosi() + "," +
				result.getLoc() + "," +
				result.getSpecific("isTest") + "," +
				result.getSpecific("asserts") + "," +
				result.getSpecific("test-methods")
				
			);
		}

		ps.close();
		
		long end = System.currentTimeMillis();
		
		System.out.println("Done!");
		System.out.println("It took " + ((end - start)/1000/60) + " minutes");
	}

	private static CK buildCK() {
		return new TestMetricFactory().build();
	}
}
