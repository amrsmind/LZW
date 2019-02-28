import java.util.*;
import java.io.*;

public class UI {
	 public static void main(String[] args) throws IOException {
		 
	//ABAACBA
    
	//Compress c = new Compress("wabbawabba");
	//Compress c = new Compress("aaaaaaaaaa");

	//c.Docompression();
	//c.printencoded();
	//c.printtable();
	
	/*ArrayList<String> tbl = new ArrayList<String>();
	File myfile = new File("tbl.txt");
	BufferedReader bufreader = new BufferedReader(new FileReader(myfile));
	String s = "";
	String[] row;
	while((s = bufreader.readLine())!= null){
		row = s.split("  ");     //determine if two spaces or one before run the code 
	   //int i = Integer.parseInt(row[0]);
		if(row.length == 1) {
			tbl.add(" ");
			continue;
		}
		//System.out.println(row[1]);

	    tbl.add(row[1]);	
	}
	bufreader.close();
	for(String sintbl:tbl) {
		System.out.println(sintbl);
	}*/
	File tblfile = new File("tbl.txt");
	File dfile = new File("decoded.txt");
	File efile = new File("encoded.txt");
	Compress c = new Compress("abaababbaabaabaabaaaababbbbbbbb");
	c.Docompression();
	c.printencoded();
	c.printtable();
	c.tblinfile(tblfile);
	c.encodeinfile(dfile);
	Decompress d = new Decompress(c.decoded);
	//d.readIfromfile(dfile);
	//d.readtblfromfile(tblfile);
	d.m_decompress();
	d.print();
	System.out.println(d.str);
	
	
	
	
	/*Decompress d = new Decompress();
	//d.readtblfromfile(tblfile);
	d.readIfromfile(dfile);
	d.m_decompress();
	System.out.println(d.print());*/
	
	 }
}
