import java.util.*;
import java.io.*;

public class Compress {
public String str; 
ArrayList<String> tbl = new ArrayList<String>();
ArrayList<Integer> decoded = new ArrayList<Integer>();
int strlen;
Compress(){
	for(int i=32;i<127;i++) {
	     char a = (char)i;
	     tbl.add(Character.toString(a));
	}
}
Compress(String str){
	this.str = str;
	strlen = str.length();
	for(int i=32;i<127;i++) {
	     char a = (char)i;
	     tbl.add(Character.toString(a));
	}
}
/*public void Docompression(){
	int i = 0;
	String temp = "";
	int tableplace = 0;
	boolean contained = false;
	while(i<strlen){
		temp += str.charAt(i);
		if(tbl.contains(temp)){
			i++;
			if(i==strlen) {
			    //tbl.add(temp);
			    decoded.add(tbl.indexOf(temp));
			    break;
			}
			tableplace = tbl.indexOf(temp);
			contained = true;
			continue;
		}
		if(contained) {
			tbl.add(temp);
			decoded.add(tableplace);
			contained = false;
			temp = "";
			//i++;
			continue;
		}
		tbl.add(temp);
		decoded.add(tbl.indexOf(temp));
		temp = "";
		i++;

	}
}*/
public void Docompression(){
	int i = 0;
	String temp = "";
	int tableplace = 0;
	while(i<strlen){
		temp += str.charAt(i);
		if(tbl.contains(temp)){
			i++;
			if(i==strlen) {
			    //tbl.add(temp);
			    decoded.add(tbl.indexOf(temp));
			    break;
			}
			tableplace = tbl.indexOf(temp);
			continue;
		}
		tbl.add(temp);
		decoded.add(tableplace);
		temp = "";
		//i++;
		/*if(i==strlen-1){
			decoded.add(tbl.indexOf(Character.toString(str.charAt(i))));
			break;
		}*/
	}
}

public void printencoded() {	 	
	System.out.println("----------------------Decoded----------------------------");
	for(int i:decoded) {
		System.out.print(i + " ");
	}
	System.out.println("------------------------------------------------");
}

public void printtable(){
	int length = tbl.size();
	System.out.println("---------------------------table---------------------------");
	for(int i = 0;i<length;i++) {
		System.out.println(i +"   "+tbl.get(i));
	}
	System.out.println("----------------------------------------------------");
}
public void encodeinfile(File myfile) throws IOException{
	FileOutputStream fos = new FileOutputStream(myfile);
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	for(int i:decoded) {
		bw.write(Integer.toString(i) + "  ");
		//("hello");
	}
	bw.close();
}

public void tblinfile(File myfile) throws IOException{
	FileOutputStream fos = new FileOutputStream(myfile);
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	int length = tbl.size();
		for(int i = 0;i<length;i++){
			bw.write(Integer.toString(i) +"   "+tbl.get(i));
			bw.newLine();
		}
		bw.close();
}

public void readstrfromfile(File myfile) throws IOException {
	BufferedReader bufreader = new BufferedReader(new FileReader(myfile));
	str= bufreader.readLine();
	bufreader.close();
	strlen = str.length();
}

}
