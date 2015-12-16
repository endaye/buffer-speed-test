package buffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class JsonBuff {
    /**
     * Jsonģʽ�洢
     * <p/>
     * {
     * id: gmmk_id0001,
     * class: [class_mc01, class_mc03, class_mc09, class_mc23],
     * attribute: [gnsx_mc001: [sxz_001_01, sxz_001_05],
     * gnsx_mc003: [sxz_003_02, sxz_003_03, sxz_003_04, ...],
     * gnsx_mc005: [sxz_005_01, sxz_005_02, sxz_005_15],
     * ...],
     * keyword: [kw_val00003, kw_val00005, kw_val00007, ...]
     * } ,
     * <p/>
     * ������ֵ�ⲿ�ּ򻯣���ת����Json��ʽ��
     * {
     * "cx005100122":
     * [
     * { "class": ["class_mc01", "class_mc03", "class_mc09", "class_mc23"]},
     * { "attribute": ["shuA_A"]},
     * { "keyword": ["kw_val00003", "kw_val00005", "kw_val00007", ...]}
     * ],
     * "cx005100105":
     * [ ... ],
     * ...
     * }
     */
    final public HashMap<String, JsonBuffElem> set = new HashMap<String, JsonBuffElem>();
    private String[] id;
    final private Random r1 = new Random(1);

    public JsonBuff() {
    }

    public void setId(String[] id) {
        this.id = new String[id.length];
        for (int i = 0; i < id.length; i++) {
            set.put(id[i], new JsonBuffElem());
            this.id[i] = id[i];
        }
    }

    public void setClass(String[] cls) {
        for (int i = 0; i < id.length; i++) {
            set.get(id[i]).cls[0] = cls[0];
            int j = r1.nextInt(16);
            (set.get(id[i]).cls)[3] = cls[j + 9];
            switch (j + 9) {
                case 9:
                case 10:
                case 11: {
                    set.get(id[i]).cls[1] = cls[1];
                    set.get(id[i]).cls[2] = cls[3];
                    break;
                }
                case 12:
                case 13: {
                    set.get(id[i]).cls[1] = cls[1];
                    set.get(id[i]).cls[2] = cls[4];
                    break;
                }
                case 14:
                case 15: {
                    set.get(id[i]).cls[1] = cls[2];
                    set.get(id[i]).cls[2] = cls[5];
                    break;
                }
                case 16:
                case 17:
                case 18: {
                    set.get(id[i]).cls[1] = cls[2];
                    set.get(id[i]).cls[2] = cls[6];
                    break;
                }
                case 19:
                case 20:
                case 21:
                case 22: {
                    set.get(id[i]).cls[1] = cls[2];
                    set.get(id[i]).cls[2] = cls[7];
                    break;
                }
                case 23:
                case 24: {
                    set.get(id[i]).cls[1] = cls[2];
                    set.get(id[i]).cls[2] = cls[8];
                    break;
                }
            }
        }
    }

    public void setAttr(String[] attr) {
        for (int i = 0; i < id.length; i++) {
            for (int j = 0; j < r1.nextInt(9) + 3; j++) {
                set.get(id[i]).attr.add(attr[r1.nextInt(attr.length)]);
            }
        }
    }

    public void setKw(String[] key) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < r1.nextInt(20); j++) {
                set.get(id[r1.nextInt(set.size())]).kws.add(key[i]);
            }
        }
    }

    public void output() {
        String str;
        System.out.print("[\n");
        for (int i = 0; i < id.length; i++) {
            str = "\t\"" + id[i] + "\": {\n";

            str += "\t\t\"class\": [";
            for (int j = 0; j < 4; j++) {
                str += "\"" + set.get(id[i]).cls[j] + "\", ";
            }
            str += "], \n";

            str += "\t\t\"attribute\": [";
            for (Iterator<String> it = set.get(id[i]).attr.iterator(); it.hasNext(); ) {
                str += "\"" + it.next() + "\", ";
            }
            str += "], \n";

            str += "\t\t\"keyword\": [";
            for (Iterator<String> it = set.get(id[i]).kws.iterator(); it.hasNext(); ) {
                str += "\"" + it.next() + "\", ";
            }
            str += "]\n\t}, ";
            System.out.println(str);
        }
        System.out.print("]\n");
    }

    public String getBuff() {
        /**
         [cx005100122],
         [ȫ��,����2,����2_3,����2_3_2,],
         [����B_ֵ1,����G_ֵ1,����C_ֵ3,����F_ֵ5,],
         [��������,����,�Ƴ�,��ȫñ,�Ƴ�,���ƿ���,��ο��,����,�ɰ�,������,���߲�Ʒ,����,����,����,������,���½�,�佱��,����,����,��ʿ,��������,�ɰ���,����,����,����,�Ի�,����ˮ,����,������,����,����", ]
         */

        String str = "";
        String token = "";
        for (int i = 0; i < 10; i++) {
            str += "[" + id[i] + "]," + token;

            str += "[";
            for (int j = 0; j < 4; j++) {
                str += set.get(id[i]).cls[j] + ",";
            }
            str += "]," + token;

            str += "[";
            for (Iterator<String> it = set.get(id[i]).attr.iterator(); it.hasNext(); ) {
                str += it.next() + ",";
            }
            str += "]," + token;

            str += "[";
            for (Iterator<String> it = set.get(id[i]).kws.iterator(); it.hasNext(); ) {
                str += it.next() + ",";
            }
            str += "]," + token;
        }
        return str;
    }
}
