package rawdata;
/**
 * 模拟出25个分类
 * @author Administrator
 *
 */
public class Category {
	final private String[] catalog = new String[25];
	
	public Category() {
		//一级分类
		catalog[0] = "全部";
		//二级分类
		catalog[1] = "分类1";
		catalog[2] = "分类2";
		//三级分类
		catalog[3] = "分类1_1";
		catalog[4] = "分类1_2";
		catalog[5] = "分类2_1";
		catalog[6] = "分类2_2";
		catalog[7] = "分类2_3";
		catalog[8] = "分类2_4";
		//四级分类
		catalog[9]  = "分类1_1_1";
		catalog[10] = "分类1_1_2";
		catalog[11] = "分类1_1_3";

		catalog[12] = "分类1_2_1";
		catalog[13] = "分类1_2_2";

		catalog[14] = "分类2_1_1";
		catalog[15] = "分类2_1_2";

		catalog[16] = "分类2_2_1";
		catalog[17] = "分类2_2_2";
		catalog[18] = "分类2_2_3";

		catalog[19] = "分类2_3_1";
		catalog[20] = "分类2_3_2";
		catalog[21] = "分类2_3_3";
		catalog[22] = "分类2_3_4";

		catalog[23] = "分类2_4_1";
		catalog[24] = "分类2_4_2";
	}
	
	public String[] getCatalog() {
		return this.catalog;
	}
	
	public void output() {
		for(int i = 0; i < catalog.length; i++) {
			System.out.print(catalog[i] + " ");
		}
		System.out.println();
	}
}
