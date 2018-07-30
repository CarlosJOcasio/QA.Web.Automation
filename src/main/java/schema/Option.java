package schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Option {
    Option() { }

    private Option(String name) {
        this.name = name;
    }

    private final List<Option> options = new ArrayList<Option>() { };

    List<Option> getOptions() {
        return options;
    }

    private String name;

    private String getOption() {
        return name;
    }

    void setOption(String options) {
        this.name = options;
        Arrays.stream(getOption().split("&")).forEach(b -> getOptions().add( new Option(b) ));
    }

    @Override
    public String toString() {
        return name;
    }
}