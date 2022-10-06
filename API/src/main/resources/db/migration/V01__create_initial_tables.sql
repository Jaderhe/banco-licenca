CREATE SEQUENCE public.users_user_id_seq;

CREATE TABLE public.users (
                user_id INTEGER NOT NULL DEFAULT nextval('public.users_user_id_seq'),
                name VARCHAR(50) NOT NULL,
                email VARCHAR(200),
                password VARCHAR(200) NOT NULL,
                isactive BOOLEAN NOT NULL,
                permission VARCHAR(20) NOT NULL,
                lastlogin TIMESTAMP,
                created_at TIMESTAMP NOT NULL,
                updated_at TIMESTAMP NOT NULL,
                user_id_1 INTEGER NOT NULL,
                CONSTRAINT users_pk PRIMARY KEY (user_id)
);
COMMENT ON COLUMN public.users.permission IS 'administrador operador';


ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;

CREATE SEQUENCE public.organ_organ_id_seq;

CREATE TABLE public.organ (
                organ_id INTEGER NOT NULL DEFAULT nextval('public.organ_organ_id_seq'),
                name VARCHAR(90) NOT NULL,
                created_at TIMESTAMP NOT NULL,
                updated_at TIMESTAMP NOT NULL,
                user_id INTEGER NOT NULL,
                CONSTRAINT organ_pk PRIMARY KEY (organ_id)
);
COMMENT ON TABLE public.organ IS 'secretaria';


ALTER SEQUENCE public.organ_organ_id_seq OWNED BY public.organ.organ_id;

CREATE SEQUENCE public.software_software_id_seq;

CREATE TABLE public.software (
                software_id INTEGER NOT NULL DEFAULT nextval('public.software_software_id_seq'),
                name VARCHAR(90) NOT NULL,
                created_at TIMESTAMP NOT NULL,
                updated_at TIMESTAMP NOT NULL,
                user_id INTEGER NOT NULL,
                CONSTRAINT software_pk PRIMARY KEY (software_id)
);


ALTER SEQUENCE public.software_software_id_seq OWNED BY public.software.software_id;

CREATE SEQUENCE public.provider_provider_id_seq;

CREATE TABLE public.provider (
                provider_id INTEGER NOT NULL DEFAULT nextval('public.provider_provider_id_seq'),
                company_name VARCHAR(90) NOT NULL,
                cnpj VARCHAR(14) NOT NULL,
                contact VARCHAR(90),
                created_at TIMESTAMP NOT NULL,
                updated_at TIMESTAMP NOT NULL,
                user_id INTEGER NOT NULL,
                CONSTRAINT provider_pk PRIMARY KEY (provider_id)
);


ALTER SEQUENCE public.provider_provider_id_seq OWNED BY public.provider.provider_id;

CREATE SEQUENCE public.license_license_id_seq;

CREATE TYPE situation AS ENUM ('free', 'used');

CREATE TYPE type AS ENUM ('lifetime', 'subscription');

CREATE TABLE public.license (
                license_id INTEGER NOT NULL DEFAULT nextval('public.license_license_id_seq'),
                serial_key VARCHAR(90) NOT NULL,
                linked VARCHAR(90) NOT NULL,
                purchase DATE NOT NULL,
                expiration DATE NOT NULL,
                invoice VARCHAR(15) NOT NULL,
                commit_note VARCHAR(20) NOT NULL,
                note VARCHAR(120),
                situation situation NOT NULL,
                type type NOT NULL,
                created_at TIMESTAMP NOT NULL,
                updated_at TIMESTAMP NOT NULL,
                provider_id INTEGER NOT NULL,
                software_id INTEGER NOT NULL,
                organ_id INTEGER NOT NULL,
                user_id INTEGER NOT NULL,
                CONSTRAINT license_pk PRIMARY KEY (license_id)
);
COMMENT ON COLUMN public.license.linked IS 'VINCULAÇÃO À UM USER (USUÁRIO, PC)';
COMMENT ON COLUMN public.license.note IS 'OBSERVAÇÃO';


ALTER SEQUENCE public.license_license_id_seq OWNED BY public.license.license_id;

ALTER TABLE public.users ADD CONSTRAINT user_user_fk
FOREIGN KEY (user_id_1)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.license ADD CONSTRAINT user_license_fk
FOREIGN KEY (user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.provider ADD CONSTRAINT user_provider_fk
FOREIGN KEY (user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.software ADD CONSTRAINT user_software_fk
FOREIGN KEY (user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.organ ADD CONSTRAINT user_organ_fk
FOREIGN KEY (user_id)
REFERENCES public.users (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.license ADD CONSTRAINT secretary_license_fk
FOREIGN KEY (organ_id)
REFERENCES public.organ (organ_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.license ADD CONSTRAINT software_license_fk
FOREIGN KEY (software_id)
REFERENCES public.software (software_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.license ADD CONSTRAINT provider_license_fk
FOREIGN KEY (provider_id)
REFERENCES public.provider (provider_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;