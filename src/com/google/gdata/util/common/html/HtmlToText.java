package com.google.gdata.util.common.html;

import com.google.gdata.util.common.base.StringUtil;
import java.util.regex.Pattern;

public final class HtmlToText {
    public static final int EMAIL_LINE_WIDTH_MAX = 72;
    private static final Pattern htmlListPattern;
    private static final Pattern htmlNewlinePattern;
    private static final Pattern htmlTagPattern;

    static {
        htmlNewlinePattern = Pattern.compile("\\s*<(br|/?p)>\\s*");
        htmlListPattern = Pattern.compile("\\s*<li>\\s*");
        htmlTagPattern = Pattern.compile("</?([^<]*)>");
    }

    private HtmlToText() {
    }

    public static String htmlToPlainText(String html) {
        if (html == null) {
            throw new NullPointerException("Html parameter may not be null.");
        }
        return StringUtil.fixedWidth(StringUtil.unescapeHTML(htmlTagPattern.matcher(htmlListPattern.matcher(htmlNewlinePattern.matcher(StringUtil.stripAndCollapse(html)).replaceAll("\n")).replaceAll("\n- ")).replaceAll(StringUtil.EMPTY_STRING)).trim().split("\n"), (int) EMAIL_LINE_WIDTH_MAX);
    }
}
