package christmas.util.validator;

import java.util.regex.Pattern;

public enum InputValueFormat {
    VISIT_DATE(Pattern.compile("\\d+")),
    ORDER(Pattern.compile("^([가-힣]+-\\d+)+(,[가-힣]+-\\d+)*"));

    private final Pattern pattern;

    InputValueFormat(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
