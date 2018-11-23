package com.itwangxu.jenkinsrest.bean;

import java.util.List;

/**
 * 创建日期：2018/8/27 15:13
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class JobListBean {

    /**
     * _class : hudson.model.Hudson
     * assignedLabels : [{"name":"master"}]
     * mode : NORMAL
     * nodeDescription : the master Jenkins node
     * nodeName :
     * numExecutors : 2
     * description : null
     * jobs : [{"_class":"hudson.model.FreeStyleProject","name":"U8-APP-TEST","url":"http://172.22.200.88:8080/job/U8-APP-TEST/","color":"blue"},{"_class":"hudson.model.FreeStyleProject","name":"WD_SIT_MVP","url":"http://172.22.200.88:8080/job/WD_SIT_MVP/","color":"blue"}]
     * overallLoad : {}
     * primaryView : {"_class":"hudson.model.AllView","name":"all","url":"http://172.22.200.88:8080/"}
     * quietingDown : false
     * slaveAgentPort : -1
     * unlabeledLoad : {"_class":"jenkins.model.UnlabeledLoadStatistics"}
     * useCrumbs : true
     * useSecurity : true
     * views : [{"_class":"hudson.model.AllView","name":"all","url":"http://172.22.200.88:8080/"}]
     */

    private String _class;
    private String mode;
    private String nodeDescription;
    private String nodeName;
    private int numExecutors;
    private Object description;
    private OverallLoadBean overallLoad;
    private PrimaryViewBean primaryView;
    private boolean quietingDown;
    private int slaveAgentPort;
    private UnlabeledLoadBean unlabeledLoad;
    private boolean useCrumbs;
    private boolean useSecurity;
    private List<AssignedLabelsBean> assignedLabels;
    private List<JobsBean> jobs;
    private List<ViewsBean> views;

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getNodeDescription() {
        return nodeDescription;
    }

    public void setNodeDescription(String nodeDescription) {
        this.nodeDescription = nodeDescription;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public int getNumExecutors() {
        return numExecutors;
    }

    public void setNumExecutors(int numExecutors) {
        this.numExecutors = numExecutors;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public OverallLoadBean getOverallLoad() {
        return overallLoad;
    }

    public void setOverallLoad(OverallLoadBean overallLoad) {
        this.overallLoad = overallLoad;
    }

    public PrimaryViewBean getPrimaryView() {
        return primaryView;
    }

    public void setPrimaryView(PrimaryViewBean primaryView) {
        this.primaryView = primaryView;
    }

    public boolean isQuietingDown() {
        return quietingDown;
    }

    public void setQuietingDown(boolean quietingDown) {
        this.quietingDown = quietingDown;
    }

    public int getSlaveAgentPort() {
        return slaveAgentPort;
    }

    public void setSlaveAgentPort(int slaveAgentPort) {
        this.slaveAgentPort = slaveAgentPort;
    }

    public UnlabeledLoadBean getUnlabeledLoad() {
        return unlabeledLoad;
    }

    public void setUnlabeledLoad(UnlabeledLoadBean unlabeledLoad) {
        this.unlabeledLoad = unlabeledLoad;
    }

    public boolean isUseCrumbs() {
        return useCrumbs;
    }

    public void setUseCrumbs(boolean useCrumbs) {
        this.useCrumbs = useCrumbs;
    }

    public boolean isUseSecurity() {
        return useSecurity;
    }

    public void setUseSecurity(boolean useSecurity) {
        this.useSecurity = useSecurity;
    }

    public List<AssignedLabelsBean> getAssignedLabels() {
        return assignedLabels;
    }

    public void setAssignedLabels(List<AssignedLabelsBean> assignedLabels) {
        this.assignedLabels = assignedLabels;
    }

    public List<JobsBean> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobsBean> jobs) {
        this.jobs = jobs;
    }

    public List<ViewsBean> getViews() {
        return views;
    }

    public void setViews(List<ViewsBean> views) {
        this.views = views;
    }

    public static class OverallLoadBean {
    }

    public static class PrimaryViewBean {
        /**
         * _class : hudson.model.AllView
         * name : all
         * url : http://172.22.200.88:8080/
         */

        private String _class;
        private String name;
        private String url;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class UnlabeledLoadBean {
        /**
         * _class : jenkins.model.UnlabeledLoadStatistics
         */

        private String _class;

        public String get_class() {
            return _class;
        }

        public void set_class(String _class) {
            this._class = _class;
        }
    }

    public static class AssignedLabelsBean {
        /**
         * name : master
         */

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class JobsBean {
        /**
         * _class : hudson.model.FreeStyleProject
         * name : U8-APP-TEST
         * url : http://172.22.200.88:8080/job/U8-APP-TEST/
         * color : blue
         */

        private String _class;
        private String name;
        private String url;
        private String color;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public static class ViewsBean {
        /**
         * _class : hudson.model.AllView
         * name : all
         * url : http://172.22.200.88:8080/
         */

        private String _class;
        private String name;
        private String url;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
