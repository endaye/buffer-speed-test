package search;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {

    final private static String jsonFile = "/Users/yzhang/test/Buffer/jsonBuff.txt";
    final private static String keyFile = "/Users/yzhang/test/Buffer/keyBuff.txt";
    final private static String attrFile = "/Users/yzhang/test/Buffer/attrBuff.txt";
    final private static String classFile = "/Users/yzhang/test/Buffer/classBuff.txt";
    private static String jsonBuff = "";
    private static String classBuff = "";
    private static String attrBuff = "";
    private static String keyBuff = "";
    private static boolean isImported = false;

    final private HashMap<String, Integer> result = new HashMap<>();

    public SearchEngine() {
        if(!isImported) {
            importAllBuffer();
            System.out.println("#### 缓存加载 ####");
        }
    }
    /**
     * 搜索内容并显示搜索结果
     * @param k 关键词,字符串以逗号或空格分隔
     * @param a 属性值,字符串以逗号或空格分隔
     * @param c 分类,单一字符串
     */
    public void search1Debug(String k, String a, String c) {
        String kv = k==null?"null":"\""+k+"\"";
        String av = a==null?"null":"\""+a+"\"";
        String cv = c==null?"null":"\""+c+"\"";
        System.out.println("引擎 #1\n关键词:\t" + kv + "\n属性:\t" + av + "\n分类:\t" + cv);
        search1(k, a, c);
        output();
    }

    public void search2Debug(String k, String a, String c) {
        String kv = k==null?"null":"\""+k+"\"";
        String av = a==null?"null":"\""+a+"\"";
        String cv = c==null?"null":"\""+c+"\"";
        System.out.println("引擎 #2\n关键词:\t" + kv + "\n属性:\t" + av + "\n分类:\t" + cv);
        search2(k, a, c);
        output();
    }

    /**
     * 以功能模块为索引
     * @param k 关键词,字符串以逗号或空格分隔
     * @param a 属性值,字符串以逗号或空格分隔
     * @param c 分类,单一字符串
     */
    public void search1(String k, String a, String c) {
        result.clear(); // 清除上一次搜索结果

        // 拆分关键词: y.match(/([^ ,])+(?=[ ,])/g)
        // y最后以空格和逗号分割,并且最后必须是空格或括号
        // 最多10个关键词
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
        // 这里预留一个问题:"属性"和"属性值"之间全部是并集的关系,方便模拟
        // 而真正的关系是"属性值"之间是并集,"属性"之间是交集
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
        int i = 0;
        while(i < 10 && matcher.find()) {
            ks[i++] = matcher.group();
        }

        String tmp = "";
        for(int j = 0; j < i; j++) {
            String reg = "\\[([^\\],]*)\\]," + regC + regA +
                    "\\[[^\\]]*" + ks[j] + "[^\\]]*\\],";
//            pattern = Pattern.compile(reg);
//            matcher = pattern.matcher(jsonBuff);
//            while(matcher.find()) {
//                tmp += matcher.group(1);
//            }
            searchId(jsonBuff, reg, 1);
        }
//        System.out.println(tmp);
//        if(tmp == "") return;

        // 过滤属性
        if(result.isEmpty()) return;
    }

	private void searchId(String buff, String regex, int gp) {
        // 分类 s.match(/\[([^\],]*)\],\[[^\]]*分类2,[^\[]*\],/)[1]
        // 属性 s.match(/\[([^\],]*)\],\[([^\]]*)\],\[[^\]]*属性C_值2[^\]]*\],/g)
        // 关键词 s.match(/\[([^\],]*)\],\[([^\]]*)\],\[([^\]]*)\],\[[^\]]*安全[^\]]*\],/g)
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(buff);
		while(matcher.find()) {
            String id = matcher.group(gp);
            if(result.containsKey(id)) {
                result.put(id, result.get(id)+1);
            } else {
                result.put(id, 1);
            }
		}
	}

    /**
     * 分别以k,a,c模块为索引
     * @param k 关键词,字符串以逗号或空格分隔
     * @param a 属性值,字符串以逗号或空格分隔
     * @param c 分类,单一字符串
     */
    public void search2(String k, String a, String c) {
        result.clear(); // 清除上一次搜索结果

        // 拆分关键词: y.match(/([^ ,])+(?=[ ,])/g)
        // y最后以空格和逗号分割,并且最后必须是空格或括号
        // 最多10个关键词
        Pattern pattern;
        Matcher matcher;

        HashSet<String> setC = new HashSet<>(); // 该分类所有的功能id
        HashSet<String> setA = new HashSet<>(); // 该些属性所有的功能id

        // 拆分分类
        String cs;
        if(c == null || c.isEmpty()) {
            cs = "全部";
        } else {
            cs = c.replace(" ", "").replace(",", "");
            if(cs.isEmpty() || cs.equals("")) {
                cs = "全部";
            }
        }
        String regC1 = cs + "[^:\\[\\]]*:\\[(.*?)\\]";
        pattern = Pattern.compile(regC1);
        matcher = pattern.matcher(classBuff);
        String regC2 = "[^, ]+(?=,)?";
        while(matcher.find()) {
            Pattern patternX = Pattern.compile(regC2);
            Matcher matcherX = patternX.matcher(matcher.group(0));
            while(matcherX.find()) {
                setC.add(matcherX.group(0));
            }
        }
//        System.out.println(setC);

        // 拆分属性
        if(a == null || a.replace(" ","").replace(",","").isEmpty()) {
            setA = setC;    // 都是全部
        } else {
            // 清洗拆分输入字符串
            pattern = Pattern.compile("([^ ,])+(?=[ ,])");
            matcher = pattern.matcher(a + " "); // 添加空格作为结尾标记
            String as = "(";
            while(matcher.find()) {
                as += matcher.group() + "|";
            }
            as += " )";
            // 查找属性
            //System.out.println("\n" + as);
            String regA1 = as + "[^:\\[\\]]*:\\[(.*?)\\]";
            pattern = Pattern.compile(regA1);
            matcher = pattern.matcher(attrBuff);
            String regA2 = "[^, ]+(?=,)?";
            while(matcher.find()) {
                //searchId(matcher.group(2), regK2, 0);
                Pattern patternX = Pattern.compile(regA2);
                Matcher matcherX = patternX.matcher(matcher.group(2));
                while(matcherX.find()) {
                    setA.add(matcherX.group(0));
                    //System.out.println(matcherX.group(0));
                }
            }
        }

//        System.out.println(setA);
        setC.retainAll(setA);   // 该分类和属性共有的功能id
//        System.out.println(setC);
        if(setC.isEmpty()) return; // 已经没了,不再继续搜了

        // 拆分关键词
        pattern = Pattern.compile("([^ ,])+(?=[ ,])");
        matcher = pattern.matcher(k + " "); // 添加空格作为结尾标记
        String ks = "(";
        while(matcher.find()) {
            ks += matcher.group() + "|";
        }
        ks += " )";
        String regK1 = "#[^:\\[\\]]*" + ks + "[^:\\[\\]]*:\\[(.*?)\\]";

        pattern = Pattern.compile(regK1);
        matcher = pattern.matcher(keyBuff);
        String regK2 = "[^, ]+(?=,)?";
        while(matcher.find()) {
            //searchId(matcher.group(2), regK2, 0);
            Pattern patternX = Pattern.compile(regK2);
            Matcher matcherX = patternX.matcher(matcher.group(2));
            while(matcherX.find()) {
                String id = matcherX.group(0);
                if(setC.contains(id)) {
                    if(result.containsKey(id)) {
                        result.put(id, result.get(id)+1);
                    } else {
                        result.put(id, 1);
                    }
                }
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
        isImported = true;
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
        System.out.println("#### 开始搜索 ####\n");
        System.out.println("#### 搜索结束 ####\n");
    }
}
