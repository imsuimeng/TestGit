package com;

import java.util.HashMap;
import java.util.Map;

/**
 * map��remove�����ǿ���ֱ��ɾ������Ԫ�صģ���Ȼkey������Ҳ���ᱨ��
 * ͬ���ģ�map.get(key)Ҳ�ǿ���ֱ��ȡ����ֵ�ģ���Ȼkey������Ҳ���ᱨ��
 * @author WGJ
 *
 */
public class TestMapRemove {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", 123);
		map.put("2", 456);
		map.put("3", "gfds");
		map.put("4", "rtqwg");
		map.put("5", "ert");
		map.put("8","324");
		
		map.remove("8");
		
		System.out.println(map.get("8"));
		
		System.out.println(map.get("1"));
	}
	
}
