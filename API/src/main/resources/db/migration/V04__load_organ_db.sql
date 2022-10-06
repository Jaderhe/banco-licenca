ALTER TABLE users ALTER COLUMN user_id_1 SET NOT NULL;

INSERT INTO organ (name, created_at, updated_at, user_id)
    VALUES  ('Administração', current_timestamp, current_timestamp, 1),
            ('Agronegócio, de Inovação, Turismo e Desenvolvimento Econômico', current_timestamp, current_timestamp, 1),
            ('Assistência Social', current_timestamp, current_timestamp, 1),
            ('Controle Interno', current_timestamp, current_timestamp, 1),
            ('Cultura', current_timestamp, current_timestamp, 1),
            ('Desenvolvimento Ambiental e Saneamento', current_timestamp, current_timestamp, 1),
            ('Educação', current_timestamp, current_timestamp, 1),
            ('Esportes e Lazer', current_timestamp, current_timestamp, 1),
            ('Fazenda e Captação de Recursos', current_timestamp, current_timestamp, 1),
            ('Gabinete do Prefeito', current_timestamp, current_timestamp, 1),
            ('Gabinete do Vice-Prefeito', current_timestamp, current_timestamp, 1),
            ('Infraestrutura Rural e Urbana e de Serviços Públicos', current_timestamp, current_timestamp, 1),
            ('Ouvidoria Geral', current_timestamp, current_timestamp, 1),
            ('Planejamento, Habitação e Urbanismo', current_timestamp, current_timestamp, 1),
            ('Políticas para Infância, Juventude, Mulher, Família e Desenvolvimento Humano', current_timestamp, current_timestamp, 1),
            ('Procuradoria', current_timestamp, current_timestamp, 1),
            ('Recursos Humanos', current_timestamp, current_timestamp, 1),
            ('Saúde', current_timestamp, current_timestamp, 1),
            ('Segurança e Trânsito', current_timestamp, current_timestamp, 1)
