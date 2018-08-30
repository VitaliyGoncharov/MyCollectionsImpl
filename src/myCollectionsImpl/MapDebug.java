package myCollectionsImpl;


public class MapDebug {
	public static void main(String[] args) {
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("dog", 1);
		map.put("cat", 2);
		
//		System.out.println(Integer.toBinaryString(-1));
//		long l = Long.parseLong("11111111111111111111111111111111",2);
//		System.out.println((int) l);
	}
	
	/**
	 * Converts an integer to a 32-bit binary string
	 * @param number
	 *      The number to convert
	 * @param groupSize
	 *      The number of bits in a group
	 * @return
	 *      The 32-bit long bit string
	 */
	public static String intToString(int number, int groupSize) {
	    StringBuilder result = new StringBuilder();

	    for(int i = 31; i >= 0 ; i--) {
	        int mask = 1 << i;
	        System.out.println(Integer.toBinaryString(mask));
	        result.append((number & mask) != 0 ? "1" : "0");

	        if (i % groupSize == 0)
	            result.append(" ");
	    }
	    result.replace(result.length() - 1, result.length(), "");

	    return result.toString();
	}
}
