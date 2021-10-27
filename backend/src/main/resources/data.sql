INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_course(name, img_uri, img_gray_uri) VALUES('BootCamp HTML', 'https://images.app.goo.gl/NWXDyrkZCGybcW4B6', 'https://images.app.goo.gl/X1qWNUAYy4t4kCge7');

INSERT INTO tb_offer(edition, star_moment, end_moment, course_id) VALUES('1.0', TIMESTAMP WITH TIME ZONE '2021-10-25T03:00:00Z', TIMESTAMP WITH TIME ZONE '2022-10-25T03:00:00Z', 1);
INSERT INTO tb_offer(edition, star_moment, end_moment, course_id) VALUES('2.0', TIMESTAMP WITH TIME ZONE '2021-12-25T03:00:00Z', TIMESTAMP WITH TIME ZONE '2022-12-25T03:00:00Z', 1);

INSERT INTO tb_resource(title, description, img_uri, type, position, offer_id) VALUES('Trilha HTML', 'Trilha principal do curso', 'https://images.app.goo.gl/NWXDyrkZCGybcW4B6', 1, 1, 1);
INSERT INTO tb_resource(title, description, img_uri, type, position, offer_id) VALUES('Forum', 'Tira suas dúvidas', 'https://images.app.goo.gl/NWXDyrkZCGybcW4B6', 2, 2, 1);
INSERT INTO tb_resource(title, description, img_uri, type, position, offer_id) VALUES('Live', 'Lives exclusivas para a turma', 'https://images.app.goo.gl/NWXDyrkZCGybcW4B6', 0, 3, 1);

INSERT INTO tb_section(title, description, img_uri, position, resource_id, prerequisite_id) VALUES('Capítulo 1', 'Neste capítulo vamos começar', 'https://images.app.goo.gl/NWXDyrkZCGybcW4B6', 1, 1, null);
INSERT INTO tb_section(title, description, img_uri, position, resource_id, prerequisite_id) VALUES('Capítulo 2', 'Neste capítulo vamos continuar', 'https://images.app.goo.gl/NWXDyrkZCGybcW4B6', 2, 1, 1);
INSERT INTO tb_section(title, description, img_uri, position, resource_id, prerequisite_id) VALUES('Capítulo 3', 'Neste capítulo vamos finalizar', 'https://images.app.goo.gl/NWXDyrkZCGybcW4B6', 3, 1, 2);

INSERT INTO tb_enrollment(user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES(1, 1, TIMESTAMP WITH TIME ZONE '2021-10-25T13:00:00Z', NULL, TRUE, FALSE);
INSERT INTO tb_enrollment(user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES(2, 1, TIMESTAMP WITH TIME ZONE '2021-10-25T13:00:00Z', NULL, TRUE, FALSE);