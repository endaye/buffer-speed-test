package test;

import search.SearchEngine;

/**
 * Created by yzhang on 12/18/15.
 */
public class Test {
    SearchEngine se = new SearchEngine();
    Long tic = System.currentTimeMillis();
    Long tic1 = System.currentTimeMillis();
    Long tic2 = System.currentTimeMillis();
    Long toc, toc1, toc2;
    int max = -1;
    String[] data;

    void tic(int id) {
        if(id == 1) {
            tic1 = System.currentTimeMillis();
        } else if(id == 2) {
            tic2 = System.currentTimeMillis();
        } else {
            tic = System.currentTimeMillis();
        }
    }

    void tic() {
        tic = System.currentTimeMillis();
    }

    void toc(int id) {
        if(id == 1) {
            toc1 = System.currentTimeMillis();
            System.out.println("#### 引擎 "+ id +" 用时: " + (toc1 - tic1)/1000 + "." + (toc1 - tic1)%1000 + "s ####");
            tic1 = System.currentTimeMillis();
        } else if(id == 2) {
            toc2 = System.currentTimeMillis();
            System.out.println("#### 引擎 " + id +" 用时: " + (toc2 - tic2)/1000 + "." + (toc2 - tic2)%1000 + "s ####");
            tic2 = System.currentTimeMillis();
        } else {
            toc = System.currentTimeMillis();
            System.out.println("#### 总共用时: " + (toc - tic)/1000 + "." + (toc - tic)%1000 + "s ####");
            tic = System.currentTimeMillis();
        }
    }

    void toc() {
        toc = System.currentTimeMillis();
        System.out.println("#### 总共用时: " + (toc - tic)/1000 + "." + (toc - tic)%1000 + "s ####");
        tic = System.currentTimeMillis();
    }

    public void test() {

    }
}
