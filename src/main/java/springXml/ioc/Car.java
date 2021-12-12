package springXml.ioc;

import lombok.Data;

@Data
public class Car {

    private String name;
    private String length;
    private String width;
    private String height;
    private Wheel wheel;

    // 省略其他不重要代码
}
