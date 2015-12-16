package rawdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 导入功能模块表
 * @author Administrator
 *
 */
public class ModelName {
	final private String[] gnmk = new String[640];
	
	private void importModel() {
		BufferedReader in;
		String txtFile = "C:\\Documents and Settings\\Administrator\\桌面\\导出表\\qx_gnmk.txt";
		Pattern pattern = Pattern.compile("values [(]\'(\\w*)\'");
		try {
			in = new BufferedReader(new FileReader(txtFile));
			String s;
			int i = 0;
			while((s = in.readLine()) != null){
				Matcher matcher = pattern.matcher(s);
				if(matcher.find()) {
					this.gnmk[i] = matcher.group(1);
					i++;
				}
			}
			// System.out.println(i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String[] getModelName() {
		if(gnmk[0] == null){
			importModel();
		}
		return this.gnmk;
	}
	
	public void output() {
		if(gnmk[0] == null){
			importModel();
		}
		for(int i = 0; i < gnmk.length; i++){
			System.out.print(gnmk[i] + " ");
		}
		System.out.println();
	}
}
