package test;

/**
 * Created by yzhang on 12/18/15.
 */
public class StressTest extends Test {

    @Override
    public void test() {
        int max = 100;
        System.out.println("#### 准确性测试 ####");

        System.out.println("#### 测试数据: " + max + "个 ####");
        // 引擎 1
        tic(1);
        for(int i = 0; i < max; i++) {
            se.search1("安全帽 安全角 安全区, 安身之地 保长", null, null);
            se.search1("安全帽", null, null);
            se.search1("安全帽", "", null);
            se.search1("安全", null, null);
            se.search1("安全帽 安全角 安全区, 安身之地 保长", "属性F_值8, 属性I_值4, 属性F_值7", null);
            se.search1("安全帽 安全角 安全区, 安身之地 保长", "属性F_值8, 属性I_值4, 属性F_值7", "分类2_2_1");
            se.search1("安全帽 安全角 安全区, 安身之地 保长", null, "分类2_2_1");
            se.search1("安全帽 安全角 安全区, 安身之地 保长", " ", null);
        }
        toc(1);

        // 引擎 2
        tic(2);
        for(int i = 0; i < max; i++) {
            se.search2("安全帽 安全角 安全区, 安身之地 保长", null, null);
            se.search2("安全帽", null, null);
            se.search2("安全帽", "", null);
            se.search2("安全", null, null);
            se.search2("安全帽 安全角 安全区, 安身之地 保长", "属性F_值8, 属性I_值4, 属性F_值7", null);
            se.search2("安全帽 安全角 安全区, 安身之地 保长", "属性F_值8, 属性I_值4, 属性F_值7", "分类2_2_1");
            se.search2("安全帽 安全角 安全区, 安身之地 保长", null, "分类2_2_1");
            se.search2("安全帽 安全角 安全区, 安身之地 保长", " ", null);
        }
        toc(2);
    }
}
