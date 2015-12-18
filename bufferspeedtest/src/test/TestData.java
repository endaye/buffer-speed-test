package test;

import rawdata.*;

import java.util.Random;

/**
 * Created by yzhang on 12/18/15.
 */
public class TestData {
    final String[] data = new String[9*10];
    final private Random r1 = new Random(1);
    final private String[] kw = (new Keyword()).getKeyword();
    final private String[] cg = (new Category()).getCatalog();
    final private String[] at = (new Attribute()).getAttr();

    private String getKeyword() {
        String kws = "";
        // 1 - 5 个关键词
        for(int i = 0; i < r1.nextInt(4) + 1; i++) {
            kws += kw[r1.nextInt(kw.length) - 1] + " ";
        }
        return kws;
    }

    private String getAttr() {
        String attrs = "";
        // 1 - 3 个属性
        for(int i = 0; i < r1.nextInt(2) + 1; i++) {
            attrs += at[r1.nextInt(at.length-1)] + " ";
        }
        return attrs;
    }

    private String getCategory() {
        // 只有1个属性
        return cg[r1.nextInt(cg.length-1)];
    }

    private void build() {
        for(int i = 0; i < data.length; i += 3) {
            data[i] = getKeyword();
            data[i+1] = getAttr();
            data[i+2] = getCategory();
            System.out.println(data[i] + "\n" + data[i+1] + "\n" +data[i+2] + "\n");
        }
    }

    public void test() {
        build();
    }


}
