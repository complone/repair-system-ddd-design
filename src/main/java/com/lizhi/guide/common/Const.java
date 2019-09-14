package com.lizhi.guide.common;


import com.google.common.collect.Sets;

import java.util.Set;

public class Const {

    public static final String CURRENT_USER ="currentUser";
    public static final String USERNAME  ="username";
    public static final String  EMAIL ="email";
    public static final String TRANSER_LENGTH = "length";


    public interface FilePath{
        String DOCUMENT_UPLOAD_PATH = "project_docuemnt";

        String RESPO_UPLOAD_PATH = "project_respo";

        String DOCUMENT_TEST = "project_test";
    }

    public interface FileSuffix{
        String FILE_MD = "md";
        String FILE_JPG = "jpg";
        String FILE_PNG = "png";
    }


    public interface EditorViewMD{
        int DocumentVIew = 1; // 项目说明与介绍
        int ReSpo = 2;//项目地址
        int Demo =3; //用户使用指南
        int Record = 4; // 项目发布记录
        int CommitBug = 5;
    }

    public interface Role{
        int ROLE_CUSTOMER =0;
        int ROLE_ADMIN = 1;

    }

    public interface ProjectListOrderBy{
        Set<String> PROJECT_ASC_DESC = Sets.newHashSet("project_asc","project_desc");
    }

    public enum ProjectEnumStatus{
        ON_SALE(1,"在线");
        private String value;
        private Integer code;

        ProjectEnumStatus(Integer code,String value) {
            this.value = value;
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public Integer getCode() {
            return code;
        }
    }

}
