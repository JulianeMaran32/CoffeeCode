package br.com.juhmaran.cleancode.fitnesse.wikitext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class BoldWidget extends ParentWidget {
    public static final String REGEXP = "'''.+?'''";
    private static final Pattern pattern = Pattern.compile("'''(.+?)'''",
            Pattern.MULTILINE + Pattern.DOTALL);
    public BoldWidget(ParentWidget parent, String text) throws Exception {
        super(parent);
        Matcher match = pattern.matcher(text);
        match.find();
        addChildWidgets(match.group(1));
    }
    private void addChildWidgets(String group) { }
    public String render() throws Exception {
        StringBuffer html = new StringBuffer("<br>");
        html.append(childHtml()).append("</br>");
        return html.toString();
    }
    private String childHtml() {
        return "";
    }
}