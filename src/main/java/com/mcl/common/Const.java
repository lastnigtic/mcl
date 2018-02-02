package com.mcl.common;



public class Const {

    public static final String CURRENT_USER = "currentUser";


    public interface Role{
        int ROLE_CUSTOMER = 0; //普通
        int ROLE_ADMIN = 1;//管理员
    }

    public interface DeliveryStatus{
        int AlreadyDelivered = 1 ; //已投递
        int AlreadyViewed = 2 ; //被查看
        int InvitedToInterview = 3 ;//邀约面试
        int PassInterview = 4 ;//面试通过
        int FailInterview = 5 ;//面试不通过
    }

    public interface JobStatus{
        int Overdue = 3 ; //过期
        int FailTOPass = 2 ; //审批不通过
        int SuccessTOPass = 1 ; //审批通过
        int NoApproval = 0 ; //未审批


    }
    public interface CompStatus{
        int FailTOPass = 2 ; //审批不通过
        int SuccessTOPass = 1 ; //审批通过
        int NoApproval = 0 ; //未审批


    }
}
