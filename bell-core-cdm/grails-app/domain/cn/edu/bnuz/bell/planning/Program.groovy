package cn.edu.bnuz.bell.planning

import cn.edu.bnuz.bell.master.Major


/**
 * 教学计划
 * @author Yang Lin
 */
class Program {
    /**
     * 教学计划号
     * <pre>
     * 按专业培养方案产生的教学计划
     * 201401010
     * --------=
     *   |     |
     *   |     `-- 类别(1) - 0:主修;1:辅修
     *   `-------- 专业(8) - {@link Major#id}
     * </pre>
     */
    Integer id

    /**
     * 所属专业
     */
    Major major

    /**
     * 类别-0:主修;1:辅修（非定向）;2：辅修（定向）3:专升本（插班）;
     */
    Integer type

    /**
     * 总学分
     */
    Integer credit

    static belongsTo = [major: Major]

    static hasMany = [
        directions:        Direction,
        programCourses:    ProgramCourse,
        programProperties: ProgramProperty,
    ]

    static mapping = {
        comment '教学计划'
        table   schema: 'ea'
        id      generator: 'assigned', comment: '教学计划ID'
        major   comment: '所属专业'
        type    defalutValue: "0", comment: '类别-0:主修;1:辅修（非定向）;2：辅修（定向）3:专升本（插班）'
        credit  comment: '总学分'
    }
}
