package com.github.magicsky.sya.enumerators;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public enum ErrorItem {
    AUTO_PTR(1, "不要使用std::auto_ptr"),
    BUFFER_OVERFLOW_FUNCTION(1, "不要使用会造成缓冲区溢出(buffer overflow)的函数")
    ;

    private int value;
    private String desc;

     ErrorItem(int value, String desc) {
        setValue(value);
        setDesc(desc);
    }

    public static ErrorItem getDescByValue(int value) {
        ErrorItem errorItem = null;
        for (ErrorItem type: ErrorItem.values()) {
            if (type.getValue() == value) {
                errorItem = type;
                break;
            }
        }
        return errorItem;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}