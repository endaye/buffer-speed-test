package rawdata;

/**
 * ģ�������
 *
 * @author Administrator
 */
public class Attribute {
    final private String[] attr = new String[66];

    public Attribute() {
        attr[0] = "����A_ֵ1";
        attr[1] = "����A_ֵ2";
        attr[2] = "����A_ֵ3";
        attr[3] = "����A_ֵ4";

        attr[4] = "����B_ֵ1";
        attr[5] = "����B_ֵ2";
        attr[6] = "����B_ֵ3";
        attr[7] = "����B_ֵ4";
        attr[8] = "����B_ֵ5";
        attr[9] = "����B_ֵ6";
        attr[10] = "����B_ֵ7";
        attr[11] = "����B_ֵ8";

        attr[12] = "����C_ֵ1";
        attr[13] = "����C_ֵ2";
        attr[14] = "����C_ֵ3";

        attr[15] = "����D_ֵ1";
        attr[16] = "����D_ֵ2";
        attr[17] = "����D_ֵ3";

        attr[18] = "����E_ֵ1";
        attr[19] = "����E_ֵ2";
        attr[20] = "����E_ֵ3";
        attr[21] = "����E_ֵ4";
        attr[22] = "����E_ֵ5";
        attr[23] = "����E_ֵ6";
        attr[24] = "����E_ֵ7";

        attr[25] = "����F_ֵ1";
        attr[26] = "����F_ֵ2";
        attr[27] = "����F_ֵ3";
        attr[28] = "����F_ֵ4";
        attr[29] = "����F_ֵ5";
        attr[30] = "����F_ֵ6";
        attr[31] = "����F_ֵ7";
        attr[32] = "����F_ֵ8";
        attr[33] = "����F_ֵ9";
        attr[34] = "����F_ֵ10";

        attr[35] = "����G_ֵ1";
        attr[36] = "����G_ֵ2";
        attr[37] = "����G_ֵ3";
        attr[38] = "����G_ֵ4";
        attr[39] = "����G_ֵ5";
        attr[40] = "����G_ֵ6";

        attr[41] = "����H_ֵ1";
        attr[42] = "����H_ֵ2";
        attr[43] = "����H_ֵ3";
        attr[44] = "����H_ֵ4";
        attr[45] = "����H_ֵ5";
        attr[46] = "����H_ֵ6";
        attr[47] = "����H_ֵ7";

        attr[48] = "����I_ֵ1";
        attr[49] = "����I_ֵ2";
        attr[50] = "����I_ֵ3";
        attr[51] = "����I_ֵ4";
        attr[52] = "����I_ֵ5";

        attr[53] = "����J_ֵ1";
        attr[54] = "����J_ֵ2";
        attr[55] = "����J_ֵ3";
        attr[56] = "����J_ֵ4";
        attr[57] = "����J_ֵ5";
        attr[58] = "����J_ֵ6";
        attr[59] = "����J_ֵ7";

        attr[60] = "����K_ֵ1";
        attr[61] = "����K_ֵ2";
        attr[62] = "����K_ֵ3";
        attr[63] = "����K_ֵ4";
        attr[64] = "����K_ֵ5";
        attr[65] = "����K_ֵ6";
    }

    public String[] getAttr() {
        return this.attr;
    }

    public void output() {
        for (int i = 0; i < attr.length; i++) {
            System.out.print(attr[i] + " ");
        }
        System.out.println();
    }
}
