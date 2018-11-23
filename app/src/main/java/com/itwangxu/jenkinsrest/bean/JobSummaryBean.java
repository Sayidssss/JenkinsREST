package com.itwangxu.jenkinsrest.bean;

import java.util.List;

/**
 * 创建日期：2018/8/27 15:39
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class JobSummaryBean {


    /**
     * _class : hudson.model.FreeStyleProject
     * name : U8-APP-TEST
     * healthReport : [{"description":"Build stability: No recent builds failed.","iconClassName":"icon-health-80plus","iconUrl":"health-80plus.png","score":100}]
     * lastBuild : {"_class":"hudson.model.FreeStyleBuild","id":"53","number":53,"result":"SUCCESS","timestamp":1535352480290}
     */

    private String _class;
    private String name;
    private BuildBean lastBuild;
    private List<HealthReportBean> healthReport;

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildBean getLastBuild() {
        return lastBuild;
    }

    public void setLastBuild(BuildBean lastBuild) {
        this.lastBuild = lastBuild;
    }

    public List<HealthReportBean> getHealthReport() {
        return healthReport;
    }

    public void setHealthReport(List<HealthReportBean> healthReport) {
        this.healthReport = healthReport;
    }


    public static class HealthReportBean {
        /**
         * description : Build stability: No recent builds failed.
         * iconClassName : icon-health-80plus
         * iconUrl : health-80plus.png
         * score : 100
         */

        private String description;
        private String iconClassName;
        private String iconUrl;
        private int score;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIconClassName() {
            return iconClassName;
        }

        public void setIconClassName(String iconClassName) {
            this.iconClassName = iconClassName;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
