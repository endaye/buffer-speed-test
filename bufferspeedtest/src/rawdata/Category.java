package rawdata;
/**
 * ģ���25������
 * @author Administrator
 *
 */
public class Category {
	final private String[] catalog = new String[25];
	
	public Category() {
		//һ������
		catalog[0] = "ȫ��";
		//��������
		catalog[1] = "����1";
		catalog[2] = "����2";
		//��������
		catalog[3] = "����1_1";
		catalog[4] = "����1_2";
		catalog[5] = "����2_1";
		catalog[6] = "����2_2";
		catalog[7] = "����2_3";
		catalog[8] = "����2_4";
		//�ļ�����
		catalog[9]  = "����1_1_1";
		catalog[10] = "����1_1_2";
		catalog[11] = "����1_1_3";

		catalog[12] = "����1_2_1";
		catalog[13] = "����1_2_2";

		catalog[14] = "����2_1_1";
		catalog[15] = "����2_1_2";

		catalog[16] = "����2_2_1";
		catalog[17] = "����2_2_2";
		catalog[18] = "����2_2_3";

		catalog[19] = "����2_3_1";
		catalog[20] = "����2_3_2";
		catalog[21] = "����2_3_3";
		catalog[22] = "����2_3_4";

		catalog[23] = "����2_4_1";
		catalog[24] = "����2_4_2";
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
