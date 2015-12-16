package buffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class StrBuff {
    final public HashMap<String, HashSet<String>> cls = new HashMap<String, HashSet<String>>();
    final public HashMap<String, HashSet<String>> attr = new HashMap<String, HashSet<String>>();
    final public HashMap<String, HashSet<String>> kw = new HashMap<String, HashSet<String>>();
    private String[] id;
    private String[] classes;
    private String[] attributes;
    private String[] keywords;

    public void initId(String[] id) {
        this.id = new String[id.length];
        for (int i = 0; i < id.length; i++) {
            this.id[i] = id[i];
        }
    }

    public void initClass(String[] c) {
        this.classes = new String[c.length];
        for (int i = 0; i < c.length; i++) {
            this.cls.put(c[i], new HashSet<String>());
            this.classes[i] = c[i];
        }
    }

    public void initAttribute(String[] a) {
        this.attributes = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            this.attr.put(a[i], new HashSet<String>());
            this.attributes[i] = a[i];
        }
    }

    public void initKeyword(String[] k) {
        this.keywords = new String[k.length];
        for (int i = 0; i < k.length; i++) {
            this.kw.put(k[i], new HashSet<String>());
            this.keywords[i] = k[i];
        }
    }

    public void transClass(JsonBuff jb) {
        for (int i = 0; i < id.length; i++) {
            for (int j = 0; j < 4; j++) {
                this.cls.get(jb.set.get(id[i]).cls[j]).add(id[i]);
            }
        }
    }

    public void transAttribute(JsonBuff jb) {
        for (int i = 0; i < id.length; i++) {
            for (Iterator<String> it = jb.set.get(id[i]).attr.iterator(); it.hasNext(); ) {
                this.attr.get(it.next()).add(id[i]);
            }
        }
    }

    public void transKeyword(JsonBuff jb) {
        for (int i = 0; i < id.length; i++) {
            for (Iterator<String> it = jb.set.get(id[i]).kws.iterator(); it.hasNext(); ) {
                this.kw.get(it.next()).add(id[i]);
            }
        }
    }

    public void transform(JsonBuff jb) {
        transClass(jb);
        transAttribute(jb);
        transKeyword(jb);
    }

    public void outputClass() {
        for (int i = 0; i < classes.length; i++) {
            System.out.println(i + "\t: " + classes[i] + ":" + cls.get(classes[i]).toString());
        }
    }

    public void outputAttribute() {
        for (int i = 0; i < attributes.length; i++) {
            System.out.println(i + "\t: " + attributes[i] + ":" + attr.get(attributes[i]).toString());
        }
    }

    public void outputKeyword() {
        for (int i = 0; i < keywords.length; i++) {
            System.out.println(i + "\t: " + keywords[i] + ":" + kw.get(keywords[i]).toString());
        }
    }

    public String getClassBuff() {
        String str = "";
        for (int i = 0; i < classes.length; i++) {
            str += classes[i] + ":" + cls.get(classes[i]).toString();
        }
        return str;
    }

    public String getAttrBuff() {
        String str = "";
        for (int i = 0; i < attributes.length; i++) {
            str += attributes[i] + ":" + attr.get(attributes[i]).toString();
        }
        return str;
    }

    public String getKeyBuff() {
        String str = "";
        for (int i = 0; i < keywords.length; i++) {
            str += keywords[i] + ":" + kw.get(keywords[i]).toString();
        }
        return str;
    }

}
