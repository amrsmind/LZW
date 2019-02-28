import java.util.ArrayList;
import java.io.*;

public class Decompress{
	public String str = ""; 
	ArrayList<String> tbl = new ArrayList<String>();
	ArrayList<Integer> decoded = new ArrayList<Integer>();
	//int strlen;
	Decompress(){
		for(int i=32;i<127;i++) {
		     char a = (char)i;
		     this.tbl.add(Character.toString(a));
		}
	}
	Decompress(ArrayList<Integer> decoded){
		for(int i=32;i<127;i++) {
		     char a = (char)i;
		     this.tbl.add(Character.toString(a));
		}
		this.decoded = decoded;
	}
	/*public void m_decompress(){
		for(int i:decoded){
		    str+=tbl.get(i);
		}
		str = str.replace(" ", "");
	}*/
	/*public void m_decompress(){
		String d = "";
		String pre = "";
		for(int i = 0;i<decoded.size();i++){
			if(decoded.get(i) >= tbl.size()) {
				tbl.add(pre + pre.charAt(0));
				i--;
			}
			else {
				
			}
			int length = tbl.size();
			if(i>length-1) {
				
			}
		}
		str = str.replace(" ", "");
	}*/
	public void m_decompress(){	
		str+=tbl.get(decoded.get(0));
	    String prepicked = str;
	    String cur = "";
	    int counter = 0;
	    int dsize = decoded.size();
	    for(int i=1;i<dsize;i++) {
	    	if(decoded.get(i)>=tbl.size()) {
	    		counter++;
	    	cur = prepicked + prepicked.charAt(0);
	    	tbl.add(cur);
	    	}
	    	else {
	    	cur = tbl.get(decoded.get(i));
	    	tbl.add(prepicked + cur.charAt(0));
	    	}
	    	str+=cur;
	    	prepicked = cur;
	    }
	    System.out.println(counter);
	}
	
	public String print(){
		return str;
	}
	public void readtblfromfile(File myfile) throws IOException {
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
	}
	public void readIfromfile(File myfile) throws IOException {
		BufferedReader bufreader = new BufferedReader(new FileReader(myfile));
        String s = "";
        s = bufreader.readLine();
        String[] d = s.split(" ");
        for(String sind:d){
        	decoded.add(Integer.parseInt(sind));
        	//System.out.println(Integer.parseInt(sind));	
        }
        bufreader.close();
	}
	public void writestrinfile(File myfile) throws IOException {
		FileOutputStream fos = new FileOutputStream(myfile);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		bw.write(str);
		bw.close();
	}
}
