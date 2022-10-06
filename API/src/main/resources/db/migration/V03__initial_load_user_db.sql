ALTER TABLE users ALTER COLUMN user_id_1 DROP NOT NULL;

INSERT INTO users (name, password, isactive, permission, created_at, updated_at, username)
VALUES ('admin', 'psw123', true, 'administrador', current_timestamp, current_timestamp, 'root');

-- após a criação do usuário root, é necessário alterar o valor de user_id_1 para 1