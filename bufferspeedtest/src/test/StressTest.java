package test;

/**
 * Created by yzhang on 12/18/15.
 */
public class StressTest extends Test {

    public StressTest(int max) {
        this.max = max;
        data = (new TestData(max)).getData();
    }
    @Override
    public void test() {
        System.out.println("#### 压力测试 ####");

        System.out.println("#### 测试数据: " + max + "个 ####");
        // 引擎 1
        tic(1);
        for(int i = 0; i < data.length; i+=3) {
            se.search1(data[i], data[i+1], data[i+2]);
        }
        toc(1);

        // 引擎 2
        tic(2);
        for(int i = 0; i < data.length; i+=3) {
            se.search2(data[i], data[i+1], data[i+2]);
        }
        toc(2);
    }
}
