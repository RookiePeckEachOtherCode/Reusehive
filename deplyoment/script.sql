#CREATE DATABASE reusehive;
USE reusehive;

CREATE TABLE user
(
    id           BIGINT PRIMARY KEY,
    name         VARCHAR(50) UNIQUE             NOT NULL,
    gender       TINYINT COMMENT '性别 男1 女0' NOT NULL,
    grade        VARCHAR(20) COMMENT '年级'     NOT NULL,
    academy      VARCHAR(20) COMMENT '学院'     NOT NULL,
    phone_number VARCHAR(20)                    NOT NULL,
    social_info  VARCHAR(255) COMMENT '社交信息',
    avatar_img   VARCHAR(255),
    back_img     VARCHAR(255),
    INDEX (name)
);
CREATE TABLE user_pwd
(
    uid      BIGINT PRIMARY KEY,
    password VARCHAR(255),
    FOREIGN KEY (uid) REFERENCES user (id)
);

CREATE TABLE item
(
    id          BIGINT,
    uid         BIGINT,
    back_img    VARCHAR(255),

    PRIMARY KEY (id, uid),

    name        VARCHAR(50)    NOT NULL,
    description VARCHAR(255),
    prices      DECIMAL(10, 2) NOT NULL,

    type        TINYINT        NOT NULL COMMENT '0未交易; 1交易中; 2交易结束',

    FOREIGN KEY (uid) REFERENCES user (id)
);

CREATE TABLE purchase_info
(
    id          BIGINT,
    uid         BIGINT,
    item_id     BIGINT,
    create_time DATETIME       NOT NULL,
    prices      DECIMAL(10, 2) NOT NULL COMMENT '交易成功的价格',
    `lock`      BOOLEAN        NOT NULL COMMENT '交易锁 上锁true  解锁false',
    lock_time   DATETIME       NOT NULL COMMENT '上锁时间',


    PRIMARY KEY (id, uid, item_id),
    FOREIGN KEY (uid) REFERENCES user (id),
    FOREIGN KEY (item_id) REFERENCES item (id)
);

CREATE TABLE message (
                         id BIGINT PRIMARY KEY,
                         tousername VARCHAR(255),
                         fromusername VARCHAR(255),
                         content TEXT,
                         createTime TIMESTAMP
);
