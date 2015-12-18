package rawdata;

/**
 * 模拟出属性
 *
 * @author Administrator
 */
public class Attribute {
    final private String[] attr = new String[66];

    public Attribute() {
        attr[0] = "属性A_值1";
        attr[1] = "属性A_值2";
        attr[2] = "属性A_值3";
        attr[3] = "属性A_值4";

        attr[4] = "属性B_值1";
        attr[5] = "属性B_值2";
        attr[6] = "属性B_值3";
        attr[7] = "属性B_值4";
        attr[8] = "属性B_值5";
        attr[9] = "属性B_值6";
        attr[10] = "属性B_值7";
        attr[11] = "属性B_值8";

        attr[12] = "属性C_值1";
        attr[13] = "属性C_值2";
        attr[14] = "属性C_值3";

        attr[15] = "属性D_值1";
        attr[16] = "属性D_值2";
        attr[17] = "属性D_值3";

        attr[18] = "属性E_值1";
        attr[19] = "属性E_值2";
        attr[20] = "属性E_值3";
        attr[21] = "属性E_值4";
        attr[22] = "属性E_值5";
        attr[23] = "属性E_值6";
        attr[24] = "属性E_值7";

        attr[25] = "属性F_值1";
        attr[26] = "属性F_值2";
        attr[27] = "属性F_值3";
        attr[28] = "属性F_值4";
        attr[29] = "属性F_值5";
        attr[30] = "属性F_值6";
        attr[31] = "属性F_值7";
        attr[32] = "属性F_值8";
        attr[33] = "属性F_值9";
        attr[34] = "属性F_值10";

        attr[35] = "属性G_值1";
        attr[36] = "属性G_值2";
        attr[37] = "属性G_值3";
        attr[38] = "属性G_值4";
        attr[39] = "属性G_值5";
        attr[40] = "属性G_值6";

        attr[41] = "属性H_值1";
        attr[42] = "属性H_值2";
        attr[43] = "属性H_值3";
        attr[44] = "属性H_值4";
        attr[45] = "属性H_值5";
        attr[46] = "属性H_值6";
        attr[47] = "属性H_值7";

        attr[48] = "属性I_值1";
        attr[49] = "属性I_值2";
        attr[50] = "属性I_值3";
        attr[51] = "属性I_值4";
        attr[52] = "属性I_值5";

        attr[53] = "属性J_值1";
        attr[54] = "属性J_值2";
        attr[55] = "属性J_值3";
        attr[56] = "属性J_值4";
        attr[57] = "属性J_值5";
        attr[58] = "属性J_值6";
        attr[59] = "属性J_值7";

        attr[60] = "属性K_值1";
        attr[61] = "属性K_值2";
        attr[62] = "属性K_值3";
        attr[63] = "属性K_值4";
        attr[64] = "属性K_值5";
        attr[65] = "属性K_值6";
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
