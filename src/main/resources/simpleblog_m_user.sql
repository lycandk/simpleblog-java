create table m_user
(
    id         bigint auto_increment
        primary key,
    username   varchar(255) null,
    avatar     varchar(255) null,
    email      varchar(64) null,
    password   varchar(255) null,
    status     int not null,
    created    datetime null,
    last_login datetime null
);

INSERT INTO simpleblog.m_user (id, username, avatar, email, password, status, created, last_login)
VALUES (1, 'admin',
        'https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg',
        null, '96e79218965eb72c92a549dd5a330112', 0, '2020-04-20 10:44:01', null);
