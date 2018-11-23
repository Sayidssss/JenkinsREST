package com.itwangxu.jenkinsrest.bean;

/**
 * 创建日期：2018/8/27 16:29
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class BuildBean {

    /**
     * _class : hudson.model.FreeStyleBuild
     * id : 53
     * number : 53
     * result : SUCCESS
     * timestamp : 1535352480290
     */

    private String _class;
    private String id;
    private int number;
    private String result;
    private long timestamp;

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


}
