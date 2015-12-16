package search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {
	
	public void search(String str) {
		Pattern pattern = Pattern.compile("values [(]\'(\\w*)\'");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			System.out.println(matcher.group(0));
		}
	}
}
