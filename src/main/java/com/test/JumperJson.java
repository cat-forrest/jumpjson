package com.test;

/**
 * description:
 *
 * @outhor wangxu
 * @create 2020-08-03 22:11
 */
public class JumperJson {


    private static String json;

    public JumperJson(String json) {
        this.json = json;
    }

    /**
     * <pre>
     * Example:
     *   name:"value"
     * <pre>
     * @param name
     * @return value
     */
    public String getValue(String name) {
        int begin = json.indexOf("\"" + name + "\"");
        int end = json.indexOf(":", begin + 1);

        if (end - begin != name.length() + 2) {
            return null;
        }

        if (json.substring(end + 1, end + 2).equals("[")) {
            return null;
        }
        if (json.substring(end + 1, end + 2).equals("{")) {
            return null;
        }
        String ended = json.substring(end + 1, end + 2);
        if (ended.indexOf("\"") == -1) {
            end = json.indexOf(",", end);
            if (end == -1) {
                end = json.indexOf("}", end);
            }
            return json.substring(begin + name.length() + 3, end).replace("}", "");
        } else {
            end = json.indexOf("\"", end + 2);
            return json.substring(begin + name.length() + 4, end);
        }
    }


    /**
     * <pre>
     * Example:
     *   Object1:{name:"value1"}
     *   Object2:{name:"value2"}
     * <pre>
     * @param name Object2
     * @return value2
     */
    public String getValue(String name, String Object) {
        int ObjectBegin = json.indexOf("\"" + Object + "\":");
        if (ObjectBegin == -1) {
            return null;
        }
        int begin = json.indexOf("\"" + name + "\"", ObjectBegin);
        int end = json.indexOf(":", begin + 1);
        if (end - begin != name.length() + 2) {
            return null;
        }
        if (json.substring(end + 1, end + 2).equals("[")) {
            return null;
        }
        if (json.substring(end + 1, end + 2).equals("{")) {
            return null;
        }
        String ended = json.substring(end + 1, end + 2);
        if (ended.indexOf("\"") == -1) {
            end = json.indexOf(",", end);
            if (end == -1) {
                end = json.indexOf("}", end);
            }
            return json.substring(begin + name.length() + 3, end).replace("}", "");
        } else {
            end = json.indexOf("\"", end + 2);
            return json.substring(begin + name.length() + 4, end);
        }
    }


    /**
     * <pre>
     * Example:
     * ArraryName[...]
     * </pre>
     *
     * @param arraryName
     * @return
     */
    public JumperJsonArray getJsonArrary(String arraryName) {
        String arrayrJson = null;
        int begin = json.indexOf("\"" + arraryName + "\"");
        int beginEnd = json.indexOf("[", begin + 1);
        if (beginEnd - begin != arraryName.length() + 3) {
            return null;
        }
        int end = json.indexOf("]", beginEnd);
        int rightCount = 0;
        for (; ; ) {
            int cour = json.indexOf("]", end);
            if (cour != -1) {
                end = cour + 1;
                rightCount++;
            }
            arrayrJson = json.substring(begin + arraryName.length() + 3, end);
            int leftCount = countLeft(arrayrJson);
            if (rightCount == leftCount) {
                break;
            }
        }
        return JumperJsonArray.parseArrary(json.substring(begin + arraryName.length() + 3, end));
    }

    private int countLeft(String leftJson) {
        Integer count = 0;
        int end = 0;
        for (; ; ) {
            int begin = leftJson.indexOf("[", end);
            if (begin == -1) {
                break;
            }
            end = begin + 1;
            if (leftJson.substring(begin, end).indexOf("[") != -1) {
                count++;
            }
        }
        return count;
    }

}
