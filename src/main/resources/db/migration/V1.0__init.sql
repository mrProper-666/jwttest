CREATE TABLE role
(
    id bigint NOT NULL,
    name character varying(100) NOT NULL,
    created timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status character varying(25) NOT NULL DEFAULT 'ACTIVE'::character varying,
    CONSTRAINT role_pkey PRIMARY KEY (id),
    CONSTRAINT unq_role_name UNIQUE (name)

);

CREATE TABLE users
(
    id bigint NOT NULL,
    username character varying(100) NOT NULL,
    email character varying(255) NOT NULL,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    password character varying(255) NOT NULL,
    status character varying(255) NOT NULL DEFAULT 'ACTIVE'::character varying,
    created timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT unq_user_email UNIQUE (email),
    CONSTRAINT unq_user_username UNIQUE (username)
);

CREATE TABLE user_role
(
    user_id bigint,
    role_id bigint,
    CONSTRAINT fk_user_role_role FOREIGN KEY (role_id)
        REFERENCES role (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE CASCADE,
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE CASCADE
);

INSERT INTO role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (2, 'ROLE_ADMIN');
