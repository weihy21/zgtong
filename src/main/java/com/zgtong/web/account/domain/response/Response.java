package com.zgtong.web.account.domain.response;


import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.error.Error;
/**
 * 请求基本信息
 *
 */
public class Response {

    private static final long serialVersionUID = 5099154241595257653L;

    public static final int SUCCESS_CODE = 10000;

    public static final String SYSTEM_CODE = "102";

    //成功
    public static final ServiceResponse SUCCESS = Response.build(Entry.SUCCESS);

    //系统异常
    public static final ServiceResponse SYSE                   = Response.build(Entry.SYSE_20000);
    public static final ServiceResponse BIZE_PARAMS_EXCEPTIONE = Response.build(Entry.BIZE_31000);
    public static final ServiceResponse BIZE_USERNAME_EXISTS   = Response.build(Entry.BIZE_31001);
    public static final ServiceResponse BIZE_PERMISSION_DENIED = Response.build(Entry.BIZE_31003);
    public static final ServiceResponse BIZE_USER_NOT_EXISTS   = Response.build(Entry.BIZE_31005);
    public static final ServiceResponse BIZE_LOGIN             = Response.build(Entry.BIZE_31004);
    public static final ServiceResponse BIZE_TOKEN_ERROR       = Response.build(Entry.BIZE_31007);
    public static final ServiceResponse BIZE_SMSCODE_ERROR     = Response.build(Entry.BIZE_31008);
    public static final ServiceResponse BIZE_SMSCODE_IS_NOT_NULL     = Response.build(Entry.BIZE_31009);
    public static final ServiceResponse BIZE_PASSWORD_CONFIRM_FAILED     = Response.build(Entry.BIZE_31010);
    public static final ServiceResponse BIZE_OLD_PASSWORD_CONFIRM_FAILED     = Response.build(Entry.BIZE_31011);
    public static final ServiceResponse BIZE_RESET_PASSWORD     = Response.build(Entry.BIZE_31012);
    public static final ServiceResponse BIZE_RESET_PASSWORD_FAILED    = Response.build(Entry.BIZE_31013);





    public static class Entry implements Error {


        //成功
        public static final Entry SUCCESS = new Entry("10000", null);

        //系统异常
        public static final Entry SYSE_20000 = new Entry("20000", "请求失败，请重试");

        //业务异常
        public static final Entry BIZE_31000 = new Entry("31000", "参数错误。");
        public static final Entry BIZE_31001 = new Entry("31001", "用户名已存在。");
        public static final Entry BIZE_31002 = new Entry("31002", "操作拒绝，请重新登录。");
        public static final Entry BIZE_31003 = new Entry("31003", "账户权限不足。");
        public static final Entry BIZE_31004 = new Entry("31004", "用户名或密码错误。");
        public static final Entry BIZE_31005 = new Entry("31005", "用户不存在。");
        public static final Entry BIZE_31006 = new Entry("31006", "请求失败。");
        public static final Entry BIZE_31007 = new Entry("31007", "token不正确");
        public static final Entry BIZE_31008 = new Entry("31008", "验证码不正确");
        public static final Entry BIZE_31009 = new Entry("31009", "验证码不能为空");
        public static final Entry BIZE_31010 = new Entry("31010", "两次输入的新密码不一致");
        public static final Entry BIZE_31011 = new Entry("31011", "原密码输入不正确");
        public static final Entry BIZE_31012 = new Entry("31012", "密码过期请重置密码");
        public static final Entry BIZE_31013 = new Entry("31013", "重置密码失败");



        int    code;
        String desc;

        private Entry(String code, String desc) {
            this.code = genRespCode(code);
            this.desc = desc;
        }

        @Override
        public Integer getCode() {
            return code;
        }

        @Override
        public String getDescr() {
            return desc;
        }

        private static int genRespCode(String code) {
            if (code.equals(String.valueOf(SUCCESS_CODE))) {
                return SUCCESS_CODE;
            } else {
                return Integer.parseInt(new StringBuilder(code).insert(1, SYSTEM_CODE).toString());
            }
        }
    }


    public static ServiceResponse build(Response.Entry entry, Object data) {
        return new ServiceResponse(entry, data);
    }

    public static ServiceResponse build(Response.Entry entry) {
        return build(entry, null);
    }


}
