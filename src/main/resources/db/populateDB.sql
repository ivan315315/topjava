DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
('User', 'user@yandex.ru', 'password'),
('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
('ROLE_USER', 100000),
('ROLE_ADMIN', 100001);

INSERT INTO meals (LocalDateTime, description, calories) VALUES
('2015-06-06 01:14:00', 'Админ ланч', 510),
('2015-06-06 01:14:00', 'Админ ужин', 1500),
('2015-06-06 01:14:00', 'user ланч', 510),
('2015-06-06 01:14:00', 'user ужин', 1500);