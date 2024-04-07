-- user: table
CREATE TABLE `user` (
                        `id` bigint NOT NULL,
                        `name` varchar(50) NOT NULL,
                        `gender` tinyint NOT NULL COMMENT '性别 男1 女0',
                        `grade` varchar(20) NOT NULL COMMENT '年级',
                        `academy` varchar(20) NOT NULL COMMENT '学院',
                        `phone_number` varchar(20) NOT NULL,
                        `social_info` varchar(255) DEFAULT NULL COMMENT '社交信息',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `name` (`name`),
                        KEY `name_2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- item: table
CREATE TABLE `item` (
                        `id` bigint NOT NULL,
                        `uid` bigint NOT NULL,
                        `name` varchar(50) NOT NULL,
                        `description` varchar(255) DEFAULT NULL,
                        `prices` decimal(10,2) NOT NULL,
                        PRIMARY KEY (`id`,`uid`),
                        KEY `uid` (`uid`),
                        CONSTRAINT `item_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- No native definition for element: uid (index)

-- manager: table
CREATE TABLE `manager` (
                           `id` bigint NOT NULL,
                           `name` varchar(50) NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- manager_pwd: table
CREATE TABLE `manager_pwd` (
                               `id` bigint NOT NULL,
                               `password` varchar(255) DEFAULT NULL,
                               PRIMARY KEY (`id`),
                               CONSTRAINT `manager_pwd_ibfk_1` FOREIGN KEY (`id`) REFERENCES `manager` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- purchase_info: table
CREATE TABLE `purchase_info` (
                                 `id` bigint NOT NULL,
                                 `uid` bigint NOT NULL,
                                 `item_id` bigint NOT NULL,
                                 `create_time` datetime NOT NULL,
                                 `prices` decimal(10,2) NOT NULL COMMENT '交易成功的价格',
                                 `type` tinyint NOT NULL COMMENT '状态信息: 0交易中 1交易结束',
                                 PRIMARY KEY (`id`,`uid`,`item_id`),
                                 KEY `uid` (`uid`),
                                 KEY `item_id` (`item_id`),
                                 CONSTRAINT `purchase_info_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
                                 CONSTRAINT `purchase_info_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- No native definition for element: uid (index)

-- No native definition for element: item_id (index)


-- No native definition for element: name_2 (index)

-- user_pwd: table
CREATE TABLE `user_pwd` (
                            `uid` bigint NOT NULL,
                            `password` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`uid`),
                            CONSTRAINT `user_pwd_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `message` (
                           `id` bigint NOT NULL,
                           `create_time` datetime,
                           `content` text NOT NULL,
                           `tousername` text,
                           `fromusername` text,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

