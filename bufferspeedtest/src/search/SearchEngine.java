package search;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {

    final private String jsonFile = "/Users/yzhang/test/Buffer/jsonBuff.txt";
    final private String keyFile = "/Users/yzhang/test/Buffer/keyBuff.txt";
    final private String attrFile = "/Users/yzhang/test/Buffer/attrBuff.txt";
    final private String classFile = "/Users/yzhang/test/Buffer/classBuff.txt";
    private String jsonBuff = "";
    private String classBuff = "";
    private String attrBuff = "";
    private String keyBuff = "";

    final private HashMap<String, Integer> result = new HashMap<>();

    public void search1Debug(String k, String a, String c) {
        String kv = k==null?"null":"\""+k+"\"";
        String av = a==null?"null":"\""+a+"\"";
        String cv = c==null?"null":"\""+c+"\"";

        System.out.println("关键词:\t" + kv + "\n属性:\t" + av + "\n分类:\t" + cv);
        search1(k, a, c);
        output();
    }

    public void search1(String k, String a, String c) {
        // 拆分关键词: y.match(/([^ ,])+(?=[ ,])/g)
        // y最后以空格和逗号分割,并且最后必须是空格或括号
        // 最多10个关键词
        result.clear();
        Pattern pattern = Pattern.compile("([^ ,])+(?=[ ,])");
        Matcher matcher;

        // 拆分分类
        String regC;
        if(c == null || c.isEmpty()) {
            regC = "\\[([^\\]]*)\\],";
        } else {
            String cs = c.replace(" ", "").replace(",", "");
            if(cs.isEmpty() || cs.equals("")) {
                regC = "\\[([^\\]]*)\\],";
            } else {
                //System.out.println(cs);
                regC = "\\[[^\\]]*" + cs + "[^\\]]*\\],";
            }
        }

        // 拆分属性
        int i;
        String regA;
        if(a == null || a.isEmpty()) {
            regA = "\\[([^\\]]*)\\],";
        } else {
            String as = a.replace(", ", " ").replace(",", " ").replace("  ", " ").replace(" ", "|");
            if(as.equals("") || as.equals( "|" )) {
                // 属性值为空
                regA = "\\[([^\\]]*)\\],";
            } else {
                // 属性不为空
                regA = "\\[[^\\]]*(" + as + ")[^\\]]*\\],";
            }
        }

        // 拆分关键词
        matcher = pattern.matcher(k + " "); // 添加空格作为结尾标记
        String[] ks = new String[10];
        i = 0;
        while(i < 10 && matcher.find()) {
            ks[i++] = matcher.group();
        }

        String tmp = "";
        for(int j = 0; j < i; j++) {
            String reg = "(\\[([^\\],]*)\\]," +
                    regC +
                    regA +
                    ")\\[[^\\]]*" + ks[j] + "[^\\]]*\\],";

            pattern = Pattern.compile(reg);
            matcher = pattern.matcher(jsonBuff);
            while(matcher.find()) {
                tmp += matcher.group(1);
            }
            //searchKey(jsonBuff, reg);
        }
        System.out.println(tmp);
        if(tmp == "") return;

        // 过滤属性
        if(result.isEmpty()) return;
    }

	private void searchKey(String buff, String regex) {
        // 分类 s.match(/\[([^\],]*)\],\[[^\]]*分类2,[^\[]*\],/)[1]
        // 属性 s.match(/\[([^\],]*)\],\[([^\]]*)\],\[[^\]]*属性C_值2[^\]]*\],/g)
        // 关键词 s.match(/\[([^\],]*)\],\[([^\]]*)\],\[([^\]]*)\],\[[^\]]*安全[^\]]*\],/g)
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(buff);
		while(matcher.find()) {
            String id = matcher.group(1);
            if(result.containsKey(id)) {
                result.put(id, result.get(id)+1);
            } else {
                result.put(id, 1);
            }
		}
	}

	private String importBuffer(String txtFile) {
        String buff = "";
		try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(txtFile), "GBK"));

            String s;
			int i = 0;
			while((s = in.readLine()) != null) {
                buff += s;
            }
			//System.out.println(buff);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return buff;
	}

    private void importAllBuffer() {
        jsonBuff = importBuffer(jsonFile);
        classBuff = importBuffer(classFile);
        attrBuff = importBuffer(attrFile);
        keyBuff = importBuffer(keyFile);
    }


    public void output() {
        if(result.isEmpty()) {
            System.out.println("无相关功能模块匹配.");
        } else {
            System.out.println(result);
        }
        System.out.println();
    }

    public void test() {
        importAllBuffer();
        System.out.println("#### 开始搜索 ####\n");
        search1Debug("安全帽 安全角 安全区, 安身之地 保长", null, null);
        search1Debug("安全帽 安全角 安全区, 安身之地 保长", "属性F_值8, 属性I_值4, 属性F_值7", null);
        search1Debug("安全帽 安全角 安全区, 安身之地 保长", "属性F_值8, 属性I_值4, 属性F_值7", "分类2_2_1");
        search1Debug("安全帽 安全角 安全区, 安身之地 保长", " ", null);
        System.out.println("#### 搜索结束 ####\n");
    }
}
