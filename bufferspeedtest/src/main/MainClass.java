package main;

import buffer.Relation;
import rawdata.Keyword;
import rawdata.ModelName;
import search.SearchEngine;
import test.AccuracyTest;
import test.StressTest;

public class MainClass {

    public static void main(String[] args) {
//        AccuracyTest at = new AccuracyTest();
//        StressTest st = new StressTest();
//        at.test();
//        st.test();
//		Relation r = new Relation();
//        r.test();
//		String str1 = r.getStrBuff();
//		String str2 = r.getJSONBuff();
//
//        SearchEngine engine = new SearchEngine();
//		engine.search(str1);
//		//System.out.println(str1);
//		System.out.println(str2);
//		Attribute a = new Attribute();
//		a.output();
//		Category c = new Category();
//		c.output();
        ModelName mn = new ModelName();
        System.out.println(mn.getModelName().length);

        Keyword kw = new Keyword();
//        kw.output();
        System.out.println(kw.getKeyword().length);

//        Keyword kw = new Keyword();
//        kw.output();
    }
}
