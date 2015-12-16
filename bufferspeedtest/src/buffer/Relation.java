package buffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import rawdata.Attribute;
import rawdata.Category;
import rawdata.Keyword;
import rawdata.ModelName;

/**
 * 把功能模块id、分类、属性、关键词，关联在一起
 * @author Administrator
 *
 */
public class Relation {
	final private JsonBuff jb = new JsonBuff();
    final private StrBuff sb = new StrBuff();

	final private ModelName gnmk = new ModelName();
    final private Category cls = new Category();
    final private Attribute attr = new Attribute();
	final private Keyword kws = new Keyword();
	final private String[] names = gnmk.getModelName();
    final private String[] classes = cls.getCatalog();
    final private String[] attributes = attr.getAttr();
	final private String[] keys = kws.getKeyword();
	private boolean isMade = false;
	private boolean isTransformed = false;
	
	/**
	 * 创建显示关系，以功能模为索引
	 * {
		id: gmmk_id0001,
		class: [class_mc01, class_mc03, class_mc09, class_mc23],
		attribute: [gnsx_mc001: [sxz_001_01, sxz_001_05],
			    gnsx_mc003: [sxz_003_02, sxz_003_03, sxz_003_04, ...],
			    gnsx_mc005: [sxz_005_01, sxz_005_02, sxz_005_15], 
			    ...],
		keyword: [kw_val00003, kw_val00005, kw_val00007, ...]
	 } ,
	 */
	public void makeRelation() {
		if(!isMade) {
			jb.setId(names);
            jb.setClass(classes);
            jb.setAttr(attributes);
            jb.setKw(keys);
			isMade = true;
		}
	}
	
	/**
	 * 转换以上关系，分别以关键词、属性、分类为索引
	 */
	public void transform() {
        if(!isTransformed) {
            sb.initId(names);
            sb.initClass(classes);
            sb.initAttribute(attributes);
            sb.initKeyword(keys);

            sb.transform(jb);

            isTransformed = true;
        }

	}
	
	public void test() {
		this.makeRelation();
        this.transform();
        //sb.outputKeyword();
        //sb.outputAttribute();
		//jb.output();
        System.out.println(sb.getAttrBuff());
//        System.out.println(sb.getClassBuff());
//        System.out.println(sb.getKeyBuff());
        //System.out.println(jb.getBuff());
	}
}
