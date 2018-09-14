package json;

import java.util.HashMap;
import java.util.Map;

public class ParseTest {
public static void main(String[] args) {
	String param = "{\"name\":\"홍길똥\"}";
	Map<String,String> map = new HashMap<>();
	
	String[] strs;
	map.put(param.split("\"")[1], param.split("\"")[3]);
	
	System.out.println(map.get("name"));
	
	
/*	//System.out.println(param.substring(param.indexOf("\"")+1, param.indexOf("\"", 2)));
	System.out.println( param.substring(param.indexOf("\"",2), param.indexOf("\"", 3)));
	map.put(param.substring(param.indexOf("\"")+1, param.indexOf("\"", 2)), param.substring(param.indexOf("\"",3), param.indexOf("\"", 4)));
	System.out.println(map.get("name"));*/
}
}
