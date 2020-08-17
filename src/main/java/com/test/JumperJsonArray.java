package com.test;

/**
 * description:
 *
 * @outhor wangxu
 * @create 2020-08-03 22:11
 */
public class JumperJsonArray {
    private static String JsonArrary;

    private JumperJsonArray(String JsonArrary) {
        this.JsonArrary = JsonArrary;
    }

    public static JumperJsonArray parseArrary(String json) {
        JumperJsonArray arrary = new JumperJsonArray(json);
        return arrary;
    }

    /**
     * Obtain the corresponding value of the queue by index
     *
     * @param NameStrs
     * @return Map<String, String>
     */
    public JumperJson get(int index) {
        int i = 0;
        JumperJson result = null;
        String indexJson = null;
        int begin = 0;
        int end = 0;
        int rightCount = 0;
        for (; ; ) {
            begin = JsonArrary.indexOf("{", begin);
            if (begin == -1) {
                break;
            }
            int cour = JsonArrary.indexOf("}", end);
            if (cour != -1) {
                rightCount++;
                end = cour + 1;
            }
            String jumperJson = JsonArrary.substring(begin, end);
            int leftCount = countLeft(jumperJson, "{");
            if (rightCount == leftCount) {
                indexJson = jumperJson;
                if (i == index) {
                    result = new JumperJson(indexJson);
                    break;
                }
                i++;
                begin = end;
                rightCount = 0;
            }
        }
        return result;
    }

    /**
     * Gets the length of the queue
     *
     * @return int
     */
    public int getLength() {
        int length = 0;
        int begin = 0;
        int end = 0;
        int rightCount = 0;
        for (; ; ) {
            begin = JsonArrary.indexOf("{", begin);
            if (begin == -1) {
                break;
            }
            int cour = JsonArrary.indexOf("}", end);
            if (cour != -1) {
                rightCount++;
                end = cour + 1;
            }
            String jumperJson = JsonArrary.substring(begin, end);
            int leftCount = countLeft(jumperJson, "{");
            if (rightCount == leftCount) {
                length++;
                begin = end;
                rightCount = 0;
            }
        }
        return length;
    }

    private int countLeft(String leftJson, String str) {
        Integer count = 0;
        int end = 0;
        for (; ; ) {
            int begin = leftJson.indexOf(str, end);
            if (begin == -1) {
                break;
            }
            end = begin + 1;
            if (leftJson.substring(begin, end).indexOf(str) != -1) {
                count++;
            }
        }
        return count;
    }
}
