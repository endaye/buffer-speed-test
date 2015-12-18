package main;

import buffer.Relation;
import rawdata.Keyword;
import rawdata.ModelName;
import search.SearchEngine;
import test.AccuracyTest;
import test.StressTest;
import test.TestData;

public class MainClass {

    public static void main(String[] args) {
//        AccuracyTest at = new AccuracyTest(10);
//        at.test();
        StressTest st = new StressTest(100);
        st.test();
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
//        TestData td = new TestData(4);
//        td.test();

//        kw.output();

//        Keyword kw = new Keyword();
//        kw.output();
    }
}
