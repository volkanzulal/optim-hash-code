import java.util.ArrayList;
import java.util.List;

public class OptimumHashCode {
    private static String[] base = new String[] {"Aa", "BB"};

    public static List<String> generateN(int n) {
        if(n <= 0) {
            return null;
        }

        List<String> list = generateStr(null);
        for(int i = 1; i < n; ++i) {
            list = generateStr(list);
        }

        return list;
    }


    public static List<String> generateStr(List<String> strList) {
        if((null == strList) || (0 == strList.size())) {
            strList = new ArrayList<String>();
            for(int i = 0; i < base.length; ++i) {
                strList.add(base[i]);
            }
            return strList;
        }

        List<String> result = new ArrayList<String>();

        for(int i = 0; i < base.length; ++i) {
            for(String str: strList) {
                result.add(base[i]  + str);
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        List<String> l = generateN(3);

        String stringA = l.get(0);
        String stringB = l.get(1);
        String stringC = l.get(2);

        System.out.println("stringA : " + stringA);
        System.out.println("stringB : " + stringB);
        System.out.println("stringC : " + stringC);

        boolean truth = stringA.hashCode() == stringB.hashCode() && !stringA.equals(stringB)
                && stringB.hashCode() == stringC.hashCode() && !stringB.equals(stringC)
                && !stringA.equals(stringC);


        System.out.println(truth);
    }

}
