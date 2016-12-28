import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter{
	public static void  main(String[] args){
		BinarySearchST<String, Integer> BSST = new BinarySearchST<>();
		SequentialSearchST<String, Integer>SSST = new SequentialSearchST<>();
		BinarySeachTree<Integer, Integer>BST = new BinarySeachTree<>();
		//readTxtFile("F:\\AlgorithmsWorkSpace\\SearchSignedTable\\tinyTale.txt" , SSST );
		//readTxtFile("F:\\AlgorithmsWorkSpace\\SearchSignedTable\\tinyTale.txt" , SSST );
		//readTxtFile("F:\\AlgorithmsWorkSpace\\SearchSignedTable\\tinyTale.txt" , BST);
		BinarySeachTree<Integer, Integer> tree = (BinarySeachTree<Integer, Integer>) IntegerOperateST(100, BST);
		StdOut.println(tree.floor(200));
	}
	
	public static void readTxtFile(String filePath , ST<String,Integer> st ){
        try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	String[] temp = lineTxt.split(" ");
                    	OperateST(temp, 1, st);
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
     
    }
	
	public static void OperateST(String[] words, int minlength, ST<String, Integer> st){
		for(String word : words){
			if(word.length() < minlength){
				continue;
			}
			if(!st.contains(word)){
				st.put(word, 1);
			}else{
				st.put(word, st.get(word) + 1);
			}
    	}
		for(String word : st.keys()){
			StdOut.println(word);
		}
		
		
	}
	
	public static ST IntegerOperateST(int length, ST<Integer, Integer> st){
		for(int i = 0 ; i < length ; i++){
			int word = (int)(Math.random()*100.0d);
			if(!st.contains(word)){
				st.put(word, 1);
			}else{
				st.put(word, st.get(word) + 1);
			}
    	}	
		return st;
		
	}
}