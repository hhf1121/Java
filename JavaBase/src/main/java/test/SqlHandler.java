package test;



import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlHandler
{
  public static String handler(String text)
  {
    StringBuilder sb = new StringBuilder();
    try
    {
      String str = firstWash(text);
      List<String> sqlList = secondWash(str);

      for (String sql : sqlList) {
        sb.append(sql).append("\r\n");
      }

      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private static List<String> secondWash(String str) {
    List list = new ArrayList();

    Pattern pattern = Pattern.compile("(Preparing.*\r\n.*Parameters.*[\r\n|\\)])");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
      String part = matcher.group();

      list.add(getSQL(part));
    }
    return list;
  }

  private static String getSQL(String part) {
    String sql = getPrepareSQL(part);
    List paramList = getParamterList(part);

    for (Iterator localIterator = paramList.iterator(); localIterator.hasNext(); ) { Object param = localIterator.next();
      sql = sql.replaceFirst("[?]", String.valueOf(param));
    }
    return sql + ";";
  }

  private static List<Object> getParamterList(String str) {
    Pattern pattern = Pattern.compile("(?<=Parameters: ).*");
    Matcher matcher = pattern.matcher(str);

    if (matcher.find()) {
      String part = matcher.group();
      return parameterList(part);
    }
    return null;
  }

  private static String getPrepareSQL(String str) {
    StringBuilder sb = new StringBuilder();

    Pattern pattern = Pattern.compile("(?<=Preparing: ).*");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
      String part = matcher.group();
      sb.append(part);
    }
    return sb.toString();
  }

  private static List<Object> parameterList(String str) {
    List typeList = new ArrayList(Arrays.asList(new String[] { "Long", "Integer", "BigDecimal" }));

    Pattern pattern = Pattern.compile("([a-zA-z0-9\\.@一-龥]+|[\\d\\-]+\\s[\\d\\:\\.]+|[\\d\\-]+)+");
    Matcher matcher = pattern.matcher(str);

    List list = new ArrayList();
    while (matcher.find()) {
      String part = matcher.group();
      list.add(part);
    }

    List paramsList = new ArrayList();

    if (list.size() > 0) {
      Collections.reverse(list);

      for (int i = 0; i < list.size(); ++i) {
        Object type = list.get(i);
        ++i;
        Object value = list.get(i);
        if (typeList.contains(type))
          paramsList.add(value);
        else {
          paramsList.add(MessageFormat.format("''{0}''", new Object[] { value }));
        }
      }

      Collections.reverse(paramsList);
    }
    return paramsList;
  }

  private static String firstWash(String str) {
    StringBuilder sb = new StringBuilder();
    Pattern pattern = Pattern.compile("(Preparing.*\r\n.*Parameters.*[\r\n|\\)])");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
      String part = matcher.group();
      sb.append(part);
    }
    return sb.toString();
  }
}