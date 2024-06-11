package Seminari.Seminar02.hw;

public class Hw1 {
    public static void main(String[] args) {
        String QUERY = "select * from students where ";
        String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        String sqlRequest = sqlRequestMaker(QUERY, PARAMS);
        System.out.println(sqlRequest);
    }

    public static String sqlRequestMaker(String sql, String json) {
        json = json.replace("{", "").replace("}", "").replace(":", ",").replace(" ", "").replaceAll("\"", "");
        String[] jsonArray = json.split(",");
        StringBuilder sb = new StringBuilder();
        
        sb.append(sql);
        
        boolean firstCondition = true;

        for (int i = 0; i < jsonArray.length; i += 2) {
            String key = jsonArray[i];
            String value = jsonArray[i + 1];

            if (!value.equals("null")) {
                if (!firstCondition) {
                    sb.append(" and ");
                }
                sb.append(key).append("='").append(value).append("'");
                firstCondition = false;
            }
        }

        return sb.toString();
    }
}
