package test;

import rawdata.*;

import java.util.Random;

/**
 * Created by yzhang on 12/18/15.
 */
public class TestData {
    private int max;
    private String[] data;
    final private Random r1 = new Random(1);
    final private String[] kw = (new Keyword()).getKeyword();
    final private String[] cg = (new Category()).getCatalog();
    final private String[] at = (new Attribute()).getAttr();
    private boolean isBuilt = false;

    public TestData(int max) {
        this.max = max;
        data = new String[max * 3];
    }
    private String getKeyword() {
        String kws = "";
        // 1 - 10 个关键词
        for(int i = 0; i < r1.nextInt(9) + 1; i++) {
            kws += kw[r1.nextInt(kw.length-1)] + " ";
        }
        return kws.trim();
    }

    private String getAttr() {
        if(r1.nextBoolean()) {
            return null;
        }
        String attrs = "";
        // 1 - 3 个属性
        for(int i = 0; i < r1.nextInt(2) + 1; i++) {
            attrs += at[r1.nextInt(at.length-1)] + " ";
        }
        return attrs.trim();
    }

    private String getCategory() {
        // 只有1个属性
        if(r1.nextBoolean()) {
            return null;
        }
        return cg[r1.nextInt(cg.length-1)];
    }

    private void build() {
        for(int i = 0; i < data.length; i += 3) {
            data[i] = getKeyword();
            data[i+1] = getAttr();
            data[i+2] = getCategory();
//            System.out.println(data[i] + "\n" + data[i+1] + "\n" +data[i+2] + "\n");
        }
        isBuilt = true;
        System.out.println("#### 随机数据生成:" + max + " ####");
    }

    public String[] getData() {
        if(!isBuilt) build();
        return data;
    }

    public void test() {
        build();
    }


}
