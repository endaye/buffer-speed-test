package rawdata;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用已有字典生成5000个关键词
 * @author Administrator
 *	
 */
public class Keyword {
	final private String[] keywords = new String[5000];

	private void importDict() {
        String encoding = "Unicode";
		String txtFile = "/Users/yzhang/test/Buffer/fingerDic_UTF.txt";

        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(txtFile), encoding);
            BufferedReader in = new BufferedReader(read);
            for(int i = 0; i < 5000; i++) {
                keywords[i] = in.readLine();
			}
            in.close();
            read.close();
			// System.out.println(i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public String[] getKeyword() {
		if(keywords[0] == null) {
			importDict();
		}
		return this.keywords;
	}

	public void output() {
		if(keywords[0] == null) {
			importDict();
		}
		for(int i = 0; i < keywords.length; i++) {
			System.out.print(keywords[i] + " ");
		}
		System.out.println();
	}
}
