drop table pe_user;
CREATE TABLE `pe_user` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '用户编号id',
  `username` varchar(32) NOT NULL COMMENT '用户姓名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `real_name` varchar(32) COMMENT '真实姓名',
  `mobile` varchar(32)  COMMENT '手机号',
  `email` varchar(32)  COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE
    pe_course
(
    id bigint(50) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
    title VARCHAR(32) NOT NULL COMMENT '课程标题',
    description VARCHAR(100) NOT NULL COMMENT '课程描述',
    PRIMARY KEY (id)
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

CREATE TABLE
    pr_user_course
(
    user_id bigint(50) not null comment '用户id',
    course_id bigint(50) not null comment '课程id',
    PRIMARY KEY (user_id,course_id)
)
    ENGINE=InnoDB DEFAULT CHARSET=UTF8 comment='用户-课程关系表';

CREATE TABLE
    pe_teacher
(
    user_id bigint(50) not null AUTO_INCREMENT comment '用户id',
    intro varchar(64) not null comment '教师介绍',
    stars bigint(50) not null comment '教师星级',
    primary key(user_id)
)
    ENGINE=InnoDB DEFAULT CHARSET=UTF8 comment='教师信息表';