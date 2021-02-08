package test.main;

import java.io.File;
import java.io.FileWriter;

/*
 * 1. c:/myFolder/memo.txt 파일을 만들고 
 * 2. "김구라" "해골" "원숭이" "주뎅이" "덩어리"
 * 	문자열을 파일에 출력하기
 */
public class MainClass12 {
	public static void main(String[] args) {
		//1.
		File f=new File("c:/myFolder/memo.txt");
		try {
			if(!f.exists()) {
				f.createNewFile();
				System.out.println("memo.txt 파일을 생성했습니다.");
			}
			//2. c:/myFolder/memo.txt 파일에 문자열을 출력 할 수 있는 객체 생성
			FileWriter fw=new FileWriter(f);
			fw.write("김구라");
			fw.write("\r\n");
			fw.write("해골");
			fw.write("\r\n");
			fw.write("원숭이");
			fw.write("\r\n");
			fw.write("주뎅이");
			fw.write("\r\n");
			fw.write("덩어리");
			fw.flush();
			fw.close(); //.close() 마무리 해줘야 한다.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
