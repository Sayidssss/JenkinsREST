package com.itwangxu.jenkinsrest.bean;

import com.google.gson.JsonObject;

import java.io.Serializable;
import java.util.List;

/**
 * 创建日期：2018/8/27 17:04
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class BuildDetailBean implements Serializable {


    /**
     * _class : hudson.model.FreeStyleBuild
     * artifacts : [{"displayPath":"wd_sit_0.9.19.apk","fileName":"wd_sit_0.9.19.apk","relativePath":"app/build/outputs/apk/sit/wd_sit_0.9.19.apk"}]
     * building : false
     * description : null
     * displayName : #31
     * duration : 280015
     * estimatedDuration : 170322
     * executor : null
     * fullDisplayName : U8-APP-TEST #31
     * id : 31
     * keepLog : false
     * number : 31
     * queueId : 31
     * result : SUCCESS
     * timestamp : 1535194080290
     * url : http://172.22.200.88:8080/job/U8-APP-TEST/31/
     * builtOn :
     * changeSet : {"_class":"hudson.plugins.git.GitChangeSetList","items":[{"_class":"hudson.plugins.git.GitChangeSet","affectedPaths":["app/src/main/java/com/uns/uu/ui/homepage/adapter/SlideMsgAdapter.java","app/src/main/java/com/uns/uu/ui/setting/activity/PersonSettingActivity.kt"],"commitId":"677143e905595c38854b6cb1f975c977ecad8bc3","timestamp":1535178853000,"author":{"absoluteUrl":"http://172.22.200.88:8080/user/zhang93","fullName":"zhang93"},"authorEmail":"zhang93@126.com","comment":"云仓消息\n","date":"2018-08-25 14:34:13 +0800","id":"677143e905595c38854b6cb1f975c977ecad8bc3","msg":"云仓消息","paths":[{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/homepage/adapter/SlideMsgAdapter.java"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/setting/activity/PersonSettingActivity.kt"}]},{"_class":"hudson.plugins.git.GitChangeSet","affectedPaths":["app/src/main/java/com/uns/uu/ui/chat/view/ChatVideoView.java","app/src/main/java/com/uns/uu/ui/homepage/view/fragment/binder/GoodItemViewBinder.java","app/src/main/java/com/uns/uu/ui/chat/view/ChatImageView.java"],"commitId":"3690cc515db767cccf6b6153c39bd97fc8ecd3db","timestamp":1535179487000,"author":{"absoluteUrl":"http://172.22.200.88:8080/user/wangxu95","fullName":"wangxu95"},"authorEmail":"wangxu95@wanda.cn","comment":"Glide修复loadImage时  drawableRes识别错误\n","date":"2018-08-25 14:44:47 +0800","id":"3690cc515db767cccf6b6153c39bd97fc8ecd3db","msg":"Glide修复loadImage时  drawableRes识别错误","paths":[{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/homepage/view/fragment/binder/GoodItemViewBinder.java"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/chat/view/ChatVideoView.java"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/chat/view/ChatImageView.java"}]},{"_class":"hudson.plugins.git.GitChangeSet","affectedPaths":["app/src/main/assets/index.android.bundle","app/src/main/java/com/uns/uu/h5/CloudIntentUtil.kt","rn-userver/merchant_app/component/yuncang/WeishopBasicMessage.js","rn-userver/app/corresponds/JsBridge.js","rn-userver/merchant_app/actions/StaffManageAction.js","app/src/main/assets/index.android.bundle.meta","rn-userver/merchant_app/component/uu_yuncang/CCDistributionShopHome.js","app/src/main/assets/merchant.android.bundle.meta","rn-userver/merchant_app/component/UUStaffSearch.js","app/src/main/java/com/uns/uu/h5/js_bridge/CloudJSBridge.kt","rn-userver/merchant_app/component/yuncang/PPAddStoryManage.js","rn-userver/merchant_app/component/PPManageGroupManager.js","app/src/main/assets/merchant.android.bundle","rn-userver/merchant_app/component/product_manage/ProxyProductManager.js","app/src/main/java/com/uns/uu/h5/view/H5Activity.kt","rn-userver/merchant_app/component/StaffManagePage.js","app/src/main/java/com/uns/uu/h5/view/H5Fragment.kt","app/src/main/java/com/uns/uu/react/modules/module/IntentModule.java","rn-userver/merchant_app/component/App.js","rn-userver/merchant_app/component/product_manage/FlagshipProductManager.js","rn-userver/merchant_app/component/yuncang/MicroshopActivation.js","rn-userver/merchant_app/component/yuncang/FlagshopBasicMessage.js","rn-userver/merchant_app/component/yuncang/PPStoryListManage.js"],"commitId":"86371658833dd6b2afcd5b74b10361d0d656ac6f","timestamp":1535191452000,"author":{"absoluteUrl":"http://172.22.200.88:8080/user/zhang93","fullName":"zhang93"},"authorEmail":"zhang93@126.com","comment":"rn更新\n","date":"2018-08-25 18:04:12 +0800","id":"86371658833dd6b2afcd5b74b10361d0d656ac6f","msg":"rn更新","paths":[{"editType":"edit","file":"app/src/main/assets/index.android.bundle.meta"},{"editType":"edit","file":"app/src/main/assets/merchant.android.bundle.meta"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/h5/CloudIntentUtil.kt"},{"editType":"edit","file":"rn-userver/merchant_app/component/PPManageGroupManager.js"},{"editType":"edit","file":"app/src/main/assets/merchant.android.bundle"},{"editType":"edit","file":"rn-userver/merchant_app/component/App.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/yuncang/PPAddStoryManage.js"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/h5/js_bridge/CloudJSBridge.kt"},{"editType":"add","file":"app/src/main/java/com/uns/uu/h5/view/H5Fragment.kt"},{"editType":"edit","file":"rn-userver/merchant_app/component/uu_yuncang/CCDistributionShopHome.js"},{"editType":"edit","file":"rn-userver/merchant_app/actions/StaffManageAction.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/yuncang/MicroshopActivation.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/product_manage/ProxyProductManager.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/yuncang/FlagshopBasicMessage.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/StaffManagePage.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/yuncang/WeishopBasicMessage.js"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/react/modules/module/IntentModule.java"},{"editType":"edit","file":"rn-userver/app/corresponds/JsBridge.js"},{"editType":"edit","file":"app/src/main/assets/index.android.bundle"},{"editType":"edit","file":"rn-userver/merchant_app/component/yuncang/PPStoryListManage.js"},{"editType":"add","file":"app/src/main/java/com/uns/uu/h5/view/H5Activity.kt"},{"editType":"edit","file":"rn-userver/merchant_app/component/product_manage/FlagshipProductManager.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/UUStaffSearch.js"}]},{"_class":"hudson.plugins.git.GitChangeSet","affectedPaths":["app/src/main/java/com/uns/uu/utils/generalutils/ImageUtils.java","app/src/main/res/drawable/img_tran_loading_bg.xml","app/src/main/java/com/uns/uu/utils/Utils.java","app/src/main/java/com/uns/uu/ui/weidynamic/ui/activity/CreateDynamicActivity.java"],"commitId":"ae025680fb389356a3336dea7a37c9167f9570b4","timestamp":1535191990000,"author":{"absoluteUrl":"http://172.22.200.88:8080/user/13585765790","fullName":"13585765790"},"authorEmail":"13585765790@163.com","comment":"动态发布单张图片规则优化\n","date":"2018-08-25 18:13:10 +0800","id":"ae025680fb389356a3336dea7a37c9167f9570b4","msg":"动态发布单张图片规则优化","paths":[{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/weidynamic/ui/activity/CreateDynamicActivity.java"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/utils/generalutils/ImageUtils.java"},{"editType":"add","file":"app/src/main/res/drawable/img_tran_loading_bg.xml"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/utils/Utils.java"}]}],"kind":"git"}
     * culprits : [{"absoluteUrl":"http://172.22.200.88:8080/user/13585765790","fullName":"13585765790"},{"absoluteUrl":"http://172.22.200.88:8080/user/wangxu95","fullName":"wangxu95"},{"absoluteUrl":"http://172.22.200.88:8080/user/zhang93","fullName":"zhang93"}]
     */

    private String _class;
    private boolean building;
    private Object description;
    private String displayName;
    private int duration;
    private int estimatedDuration;
    private Object executor;
    private String fullDisplayName;
    private String id;
    private boolean keepLog;
    private int number;
    private int queueId;
    private String result;
    private long timestamp;
    private String url;
    private String builtOn;
    private ChangeSetBean changeSet;
    private List<ArtifactsBean> artifacts;
    private List<CulpritsBean> culprits;
    private List<JsonObject> actions;

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public boolean isBuilding() {
        return building;
    }

    public void setBuilding(boolean building) {
        this.building = building;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public Object getExecutor() {
        return executor;
    }

    public void setExecutor(Object executor) {
        this.executor = executor;
    }

    public String getFullDisplayName() {
        return fullDisplayName;
    }

    public void setFullDisplayName(String fullDisplayName) {
        this.fullDisplayName = fullDisplayName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isKeepLog() {
        return keepLog;
    }

    public void setKeepLog(boolean keepLog) {
        this.keepLog = keepLog;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = queueId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBuiltOn() {
        return builtOn;
    }

    public void setBuiltOn(String builtOn) {
        this.builtOn = builtOn;
    }

    public ChangeSetBean getChangeSet() {
        return changeSet;
    }

    public void setChangeSet(ChangeSetBean changeSet) {
        this.changeSet = changeSet;
    }

    public List<ArtifactsBean> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<ArtifactsBean> artifacts) {
        this.artifacts = artifacts;
    }

    public List<CulpritsBean> getCulprits() {
        return culprits;
    }

    public void setCulprits(List<CulpritsBean> culprits) {
        this.culprits = culprits;
    }

    public List<JsonObject> getActions() {
        return actions;
    }

    public void setActions(List<JsonObject> actions) {
        this.actions = actions;
    }

    public static class ChangeSetBean implements Serializable{
        /**
         * _class : hudson.plugins.git.GitChangeSetList
         * items : [{"_class":"hudson.plugins.git.GitChangeSet","affectedPaths":["app/src/main/java/com/uns/uu/ui/homepage/adapter/SlideMsgAdapter.java","app/src/main/java/com/uns/uu/ui/setting/activity/PersonSettingActivity.kt"],"commitId":"677143e905595c38854b6cb1f975c977ecad8bc3","timestamp":1535178853000,"author":{"absoluteUrl":"http://172.22.200.88:8080/user/zhang93","fullName":"zhang93"},"authorEmail":"zhang93@126.com","comment":"云仓消息\n","date":"2018-08-25 14:34:13 +0800","id":"677143e905595c38854b6cb1f975c977ecad8bc3","msg":"云仓消息","paths":[{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/homepage/adapter/SlideMsgAdapter.java"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/setting/activity/PersonSettingActivity.kt"}]},{"_class":"hudson.plugins.git.GitChangeSet","affectedPaths":["app/src/main/java/com/uns/uu/ui/chat/view/ChatVideoView.java","app/src/main/java/com/uns/uu/ui/homepage/view/fragment/binder/GoodItemViewBinder.java","app/src/main/java/com/uns/uu/ui/chat/view/ChatImageView.java"],"commitId":"3690cc515db767cccf6b6153c39bd97fc8ecd3db","timestamp":1535179487000,"author":{"absoluteUrl":"http://172.22.200.88:8080/user/wangxu95","fullName":"wangxu95"},"authorEmail":"wangxu95@wanda.cn","comment":"Glide修复loadImage时  drawableRes识别错误\n","date":"2018-08-25 14:44:47 +0800","id":"3690cc515db767cccf6b6153c39bd97fc8ecd3db","msg":"Glide修复loadImage时  drawableRes识别错误","paths":[{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/homepage/view/fragment/binder/GoodItemViewBinder.java"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/chat/view/ChatVideoView.java"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/chat/view/ChatImageView.java"}]},{"_class":"hudson.plugins.git.GitChangeSet","affectedPaths":["app/src/main/assets/index.android.bundle","app/src/main/java/com/uns/uu/h5/CloudIntentUtil.kt","rn-userver/merchant_app/component/yuncang/WeishopBasicMessage.js","rn-userver/app/corresponds/JsBridge.js","rn-userver/merchant_app/actions/StaffManageAction.js","app/src/main/assets/index.android.bundle.meta","rn-userver/merchant_app/component/uu_yuncang/CCDistributionShopHome.js","app/src/main/assets/merchant.android.bundle.meta","rn-userver/merchant_app/component/UUStaffSearch.js","app/src/main/java/com/uns/uu/h5/js_bridge/CloudJSBridge.kt","rn-userver/merchant_app/component/yuncang/PPAddStoryManage.js","rn-userver/merchant_app/component/PPManageGroupManager.js","app/src/main/assets/merchant.android.bundle","rn-userver/merchant_app/component/product_manage/ProxyProductManager.js","app/src/main/java/com/uns/uu/h5/view/H5Activity.kt","rn-userver/merchant_app/component/StaffManagePage.js","app/src/main/java/com/uns/uu/h5/view/H5Fragment.kt","app/src/main/java/com/uns/uu/react/modules/module/IntentModule.java","rn-userver/merchant_app/component/App.js","rn-userver/merchant_app/component/product_manage/FlagshipProductManager.js","rn-userver/merchant_app/component/yuncang/MicroshopActivation.js","rn-userver/merchant_app/component/yuncang/FlagshopBasicMessage.js","rn-userver/merchant_app/component/yuncang/PPStoryListManage.js"],"commitId":"86371658833dd6b2afcd5b74b10361d0d656ac6f","timestamp":1535191452000,"author":{"absoluteUrl":"http://172.22.200.88:8080/user/zhang93","fullName":"zhang93"},"authorEmail":"zhang93@126.com","comment":"rn更新\n","date":"2018-08-25 18:04:12 +0800","id":"86371658833dd6b2afcd5b74b10361d0d656ac6f","msg":"rn更新","paths":[{"editType":"edit","file":"app/src/main/assets/index.android.bundle.meta"},{"editType":"edit","file":"app/src/main/assets/merchant.android.bundle.meta"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/h5/CloudIntentUtil.kt"},{"editType":"edit","file":"rn-userver/merchant_app/component/PPManageGroupManager.js"},{"editType":"edit","file":"app/src/main/assets/merchant.android.bundle"},{"editType":"edit","file":"rn-userver/merchant_app/component/App.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/yuncang/PPAddStoryManage.js"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/h5/js_bridge/CloudJSBridge.kt"},{"editType":"add","file":"app/src/main/java/com/uns/uu/h5/view/H5Fragment.kt"},{"editType":"edit","file":"rn-userver/merchant_app/component/uu_yuncang/CCDistributionShopHome.js"},{"editType":"edit","file":"rn-userver/merchant_app/actions/StaffManageAction.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/yuncang/MicroshopActivation.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/product_manage/ProxyProductManager.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/yuncang/FlagshopBasicMessage.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/StaffManagePage.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/yuncang/WeishopBasicMessage.js"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/react/modules/module/IntentModule.java"},{"editType":"edit","file":"rn-userver/app/corresponds/JsBridge.js"},{"editType":"edit","file":"app/src/main/assets/index.android.bundle"},{"editType":"edit","file":"rn-userver/merchant_app/component/yuncang/PPStoryListManage.js"},{"editType":"add","file":"app/src/main/java/com/uns/uu/h5/view/H5Activity.kt"},{"editType":"edit","file":"rn-userver/merchant_app/component/product_manage/FlagshipProductManager.js"},{"editType":"edit","file":"rn-userver/merchant_app/component/UUStaffSearch.js"}]},{"_class":"hudson.plugins.git.GitChangeSet","affectedPaths":["app/src/main/java/com/uns/uu/utils/generalutils/ImageUtils.java","app/src/main/res/drawable/img_tran_loading_bg.xml","app/src/main/java/com/uns/uu/utils/Utils.java","app/src/main/java/com/uns/uu/ui/weidynamic/ui/activity/CreateDynamicActivity.java"],"commitId":"ae025680fb389356a3336dea7a37c9167f9570b4","timestamp":1535191990000,"author":{"absoluteUrl":"http://172.22.200.88:8080/user/13585765790","fullName":"13585765790"},"authorEmail":"13585765790@163.com","comment":"动态发布单张图片规则优化\n","date":"2018-08-25 18:13:10 +0800","id":"ae025680fb389356a3336dea7a37c9167f9570b4","msg":"动态发布单张图片规则优化","paths":[{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/weidynamic/ui/activity/CreateDynamicActivity.java"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/utils/generalutils/ImageUtils.java"},{"editType":"add","file":"app/src/main/res/drawable/img_tran_loading_bg.xml"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/utils/Utils.java"}]}]
         * kind : git
         */

        private String _class;
        private String kind;
        private List<ItemsBean> items;

        public String get_class() {
            return _class;
        }

        public void set_class(String _class) {
            this._class = _class;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean implements Serializable{
            /**
             * _class : hudson.plugins.git.GitChangeSet
             * affectedPaths : ["app/src/main/java/com/uns/uu/ui/homepage/adapter/SlideMsgAdapter.java","app/src/main/java/com/uns/uu/ui/setting/activity/PersonSettingActivity.kt"]
             * commitId : 677143e905595c38854b6cb1f975c977ecad8bc3
             * timestamp : 1535178853000
             * author : {"absoluteUrl":"http://172.22.200.88:8080/user/zhang93","fullName":"zhang93"}
             * authorEmail : zhang93@126.com
             * comment : 云仓消息
             * <p>
             * date : 2018-08-25 14:34:13 +0800
             * id : 677143e905595c38854b6cb1f975c977ecad8bc3
             * msg : 云仓消息
             * paths : [{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/homepage/adapter/SlideMsgAdapter.java"},{"editType":"edit","file":"app/src/main/java/com/uns/uu/ui/setting/activity/PersonSettingActivity.kt"}]
             */

            private String _class;
            private String commitId;
            private long timestamp;
            private AuthorBean author;
            private String authorEmail;
            private String comment;
            private String date;
            private String id;
            private String msg;
            private List<String> affectedPaths;
            private List<PathsBean> paths;

            public String get_class() {
                return _class;
            }

            public void set_class(String _class) {
                this._class = _class;
            }

            public String getCommitId() {
                return commitId;
            }

            public void setCommitId(String commitId) {
                this.commitId = commitId;
            }

            public long getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(long timestamp) {
                this.timestamp = timestamp;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public String getAuthorEmail() {
                return authorEmail;
            }

            public void setAuthorEmail(String authorEmail) {
                this.authorEmail = authorEmail;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public List<String> getAffectedPaths() {
                return affectedPaths;
            }

            public void setAffectedPaths(List<String> affectedPaths) {
                this.affectedPaths = affectedPaths;
            }

            public List<PathsBean> getPaths() {
                return paths;
            }

            public void setPaths(List<PathsBean> paths) {
                this.paths = paths;
            }

            public static class AuthorBean implements Serializable{
                /**
                 * absoluteUrl : http://172.22.200.88:8080/user/zhang93
                 * fullName : zhang93
                 */

                private String absoluteUrl;
                private String fullName;

                public String getAbsoluteUrl() {
                    return absoluteUrl;
                }

                public void setAbsoluteUrl(String absoluteUrl) {
                    this.absoluteUrl = absoluteUrl;
                }

                public String getFullName() {
                    return fullName;
                }

                public void setFullName(String fullName) {
                    this.fullName = fullName;
                }
            }

            public static class PathsBean implements Serializable{
                /**
                 * editType : edit
                 * file : app/src/main/java/com/uns/uu/ui/homepage/adapter/SlideMsgAdapter.java
                 */

                private String editType;
                private String file;

                public String getEditType() {
                    return editType;
                }

                public void setEditType(String editType) {
                    this.editType = editType;
                }

                public String getFile() {
                    return file;
                }

                public void setFile(String file) {
                    this.file = file;
                }
            }
        }
    }

    public static class ArtifactsBean implements Serializable{
        /**
         * displayPath : wd_sit_0.9.19.apk
         * fileName : wd_sit_0.9.19.apk
         * relativePath : app/build/outputs/apk/sit/wd_sit_0.9.19.apk
         */

        private String displayPath;
        private String fileName;
        private String relativePath;

        public String getDisplayPath() {
            return displayPath;
        }

        public void setDisplayPath(String displayPath) {
            this.displayPath = displayPath;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getRelativePath() {
            return relativePath;
        }

        public void setRelativePath(String relativePath) {
            this.relativePath = relativePath;
        }
    }

    public static class CulpritsBean implements Serializable{
        /**
         * absoluteUrl : http://172.22.200.88:8080/user/13585765790
         * fullName : 13585765790
         */

        private String absoluteUrl;
        private String fullName;

        public String getAbsoluteUrl() {
            return absoluteUrl;
        }

        public void setAbsoluteUrl(String absoluteUrl) {
            this.absoluteUrl = absoluteUrl;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }

}
