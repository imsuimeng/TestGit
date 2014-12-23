package com;

import java.util.HashMap;
import java.util.Map;

/**
 * map的remove方法是可以直接删除任意元素的，纵然key不存在也不会报错
 * 同样的，map.get(key)也是可以直接取任意值的，纵然key不存在也不会报错
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
