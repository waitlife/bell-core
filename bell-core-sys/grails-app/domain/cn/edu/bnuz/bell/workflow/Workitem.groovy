package cn.edu.bnuz.bell.workflow

import cn.edu.bnuz.bell.security.User

/**
 * 工作项
 * @author Yang Lin
 */
class Workitem {
    /**
     * ID
     */
    UUID id

    /**
     * 发起人
     */
    User from

    /**
     * 事件
     */
    Event event

    /**
     * 状态
     */
    State state

    /**
     * 发起人备注
     */
    String note

    /**
     * IP地址
     */
    String ipAddress

    /**
     * 接收人
     */
    User to

    /**
     * 活动
     */
    WorkflowActivity activity

    /**
     * 工作流实例
     */
    WorkflowInstance instance

    /**
     * 提交时间
     */
    Date dateCreated

    /**
     * 接收时间
     */
    Date dateReceived

    /**
     * 办结时间
     */
    Date dateProcessed

    static belongsTo = [instance: WorkflowInstance]

    static mapping = {
        comment       '消息'
        id            generator: 'uuid2', type:'pg-uuid', comment: '消息ID'
        from          column: 'from_user', length: 10, comment: '提交用户'
        event         sqlType: 'event', type: EventUserType, comment: '事件'
        state         sqlType: 'state', type: StateUserType, comment: '状态'
        note          length: 2000, comment: '提交注备'
        ipAddress     length: 50, comment: 'IP地址'
        to            index:'workitem_user_idx', column: 'to_user', length: 50, comment: '接收用户'
        instance      index: 'workitem_instance_idx', column: 'instance', comment: '实例'
        activity      column: 'activity', length: 50, comment: '活动'
        dateCreated   index: 'workitem_instance_idx', comment: '提交时间'
        dateReceived  comment: '接收时间'
        dateProcessed index:'user_workitem_idx', comment: '办结时间'
    }

    static constraints = {
        note          nullable: true
        to            nullable: true
        activity      nullable: true
        dateReceived  nullable: true
        dateProcessed nullable: true
    }

    String getActivitySuffix() {
        this.activity.id.substring(this.activity.id.lastIndexOf('.') + 1)
    }
}
