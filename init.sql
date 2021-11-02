drop table pe_user;
CREATE TABLE `pe_user` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '用户编号id',
  `username` varchar(32) NOT NULL COMMENT '用户姓名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `real_name` varchar(32) COMMENT '真实姓名',
  `mobile` varchar(32)  COMMENT '手机号',
  `email` varchar(32)  COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';