package test;

import search.SearchEngine;

/**
 * Created by yzhang on 12/18/15.
 */
public class AccuracyTest extends Test {


    @Override
    public void test() {
        System.out.println("#### 准确性测试 ####");
        tic();
        se.search1Debug("安全帽 安全角 安全区, 安身之地 保长", null, null);
        se.search2Debug("安全帽 安全角 安全区, 安身之地 保长", null, null);
        se.search1Debug("安全帽", null, null);
        se.search2Debug("安全帽", null, null);
        se.search1Debug("安全帽", "", null);
        se.search2Debug("安全帽", "", null);
        se.search1Debug("安全", null, null);
        se.search2Debug("安全", null, null);
        se.search1Debug("安全帽 安全角 安全区, 安身之地 保长", "属性F_值8, 属性I_值4, 属性F_值7", null);
        se.search2Debug("安全帽 安全角 安全区, 安身之地 保长", "属性F_值8, 属性I_值4, 属性F_值7", null);
        se.search1Debug("安全帽 安全角 安全区, 安身之地 保长", "属性F_值8, 属性I_值4, 属性F_值7", "分类2_2_1");
        se.search2Debug("安全帽 安全角 安全区, 安身之地 保长", "属性F_值8, 属性I_值4, 属性F_值7", "分类2_2_1");
        se.search1Debug("安全帽 安全角 安全区, 安身之地 保长", null, "分类2_2_1");
        se.search2Debug("安全帽 安全角 安全区, 安身之地 保长", null, "分类2_2_1");
        se.search1Debug("安全帽 安全角 安全区, 安身之地 保长", " ", null);
        se.search2Debug("安全帽 安全角 安全区, 安身之地 保长", " ", null);
        toc();
    }
}
