create table m_blog
(
    id          bigint auto_increment
        primary key,
    user_id     bigint       not null,
    title       varchar(255) not null,
    description varchar(255) not null,
    content     longtext null,
    created     datetime     not null on update CURRENT_TIMESTAMP,
    status      tinyint null
);

INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (1, 1, 'testtitle1', 'testdesc', 'testcontent', '2022-06-29 15:41:17', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (2, 1, 'testtitle', 'testdesc', 'testcontent', '2022-06-29 15:27:53', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (3, 1, 'testtitle', 'testdesc', 'testcontent', '2022-06-29 15:27:53', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (4, 1, 'testtitle', 'testdesc', 'testcontent', '2022-06-29 15:27:53', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (5, 1, 'testtitle5', 'testdesc', 'testcontent', '2022-06-29 15:41:17', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (6, 1, 'testtitle', 'testdesc', 'testcontent', '2022-06-29 15:27:53', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (7, 1, 'testtitle', 'testdesc', 'testcontent', '2022-06-29 15:27:53', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (8, 1, 'testtitle', 'testdesc', 'testcontent', '2022-06-29 15:27:53', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (9, 1, 'testtitle9', 'testdesc', 'testcontent', '2022-06-29 15:40:54', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (10, 1, 'testtitle', 'testdesc', 'testcontent', '2022-06-29 15:27:53', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (11, 1, 'testtitle', 'testdesc', 'testcontent', '2022-06-29 15:27:53', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (12, 1, 'testtitle', 'testdesc', 'testcontent', '2022-06-29 15:27:53', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (13, 1, 'testtitle', 'testdesc', 'testcontent', '2022-06-29 15:27:53', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (14, 1, 'testtitle14', 'testdesc', 'testcontent', '2022-06-29 15:40:54', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (15, 1, 'testtitle15', 'testdesc', 'testcontent', '2022-06-29 15:40:54', 0);
INSERT INTO simpleblog.m_blog (id, user_id, title, description, content, created, status)
VALUES (16, 1, 'test', 'test', '	', '2022-06-30 09:22:30', 0);
